package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.LoginController;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfCPF;
	private LoginController loginController;
	private Object btnEntrar;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		
		loginController = new LoginController(null, null, null);
		
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[grow][grow 50][grow][grow]", "[grow][][grow 80][][][][grow 70][grow 10][grow]"));
		
		JLabel lblNewLabel = new JLabel("MERCADINHO");
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		
		JLabel tfNomeL = new JLabel("Nome:");
		tfNomeL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNomeL, "cell 1 3,alignx center");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNome, "cell 2 3,growx");
		tfNome.setColumns(10);
		
		JLabel tfCPFL = new JLabel("CPF:");
		tfCPFL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfCPFL, "cell 1 5,alignx center");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfCPF, "cell 2 5,growx");
		tfCPF.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginController.FazLogin(tfNomeL.getText(), tfCPFL.getText());
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnEntrar, "cell 1 6 2 1,alignx center");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 7 2 1,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Ainda não tem cadastro?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar-se");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton);

	}
	
	/**
	 * Método responsável por recuperar o texto digitado no campo de texto 'nome'.
	 * @return Texto digitado no campo de texto 'nome'.
	 */
	public String getNome() {
		return this.tfNome.getText();
	}
	
	/**
	 * Método responsável por recuperar o texto digitado no campo de texto 'nome'.
	 * @return Texto digitado no campo de texto 'nome'.
	 */
	public String getCPF() {
		return this.tfCPF.getText();
	}
	
	/**
	 * Método responsável por 'registrar' a ação do botão 'próximo'.
	 * @param actionListener Ação que será realizada ao clicar no botão 'próximo'.
	 */
	public void entrar(ActionListener actionListener) {
		((JTextField) this.btnEntrar).addActionListener(actionListener);
	}
	
	/**
	 * Método responsável por limpar os campos de texto do formulário.
	 */
	public void limparFormulario(){
		this.tfNome.setText("");
		this.tfCPF.setText("");
	}

}
