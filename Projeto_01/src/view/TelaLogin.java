package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.LoginController;
import controller.Navegador;
import model.UsuarioDAO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome, tfCPF;
	private JButton btnEntrar, btnCadastrarSe;
	
	
	public TelaLogin() {
		getComponents();
		
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[grow][grow 50][grow][grow]", "[grow][][grow 80][][][][grow 70][grow 10][grow]"));
		
		JLabel lblNewLabel = new JLabel("MERCADINHO");
		lblNewLabel.setForeground(new Color(2, 68, 87));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		
		JLabel tfNomeL = new JLabel("Nome:");
		tfNomeL.setForeground(new Color(2, 68, 87));
		tfNomeL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNomeL, "cell 1 3,alignx center");
		
		this.tfNome = new JTextField();
		tfNome.setBackground(new Color(85, 170, 170));
		tfNome.setForeground(new Color(0, 0, 0));
		this.tfNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNome, "cell 2 3,growx");
		this.tfNome.setColumns(10);
		
		JLabel tfCPFL = new JLabel("CPF:");
		tfCPFL.setForeground(new Color(2, 68, 87));
		tfCPFL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfCPFL, "cell 1 5,alignx center");
		
		this.tfCPF = new JTextField();
		tfCPF.setBackground(new Color(85, 170, 170));
		tfCPF.setForeground(new Color(0, 0, 0));
		this.tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfCPF, "cell 2 5,growx");
		this.tfCPF.setColumns(10);
		
		
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(64, 128, 128));
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnEntrar, "cell 1 6 2 1,alignx center");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 7 2 1,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Ainda não tem cadastro?");
		lblNewLabel_3.setForeground(new Color(2, 68, 87));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		btnCadastrarSe = new JButton("Cadastrar-Se");
		btnCadastrarSe.setBackground(new Color(64, 128, 128));
		btnCadastrarSe.setForeground(new Color(0, 0, 0));
		btnCadastrarSe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnCadastrarSe);
		
	}
	
	public JTextField gettfNome() {
		return tfNome;
	}
    
    public void settfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}
    
    public JTextField gettfCPF() {
		return tfCPF;
	}
    
    public void settfCPF(JTextField tfCPF) {
		this.tfCPF = tfCPF;
	}
	
	public void entrar(ActionListener actionListener) {
		this.btnEntrar.addActionListener(actionListener);
	}
	
	public void cadastrarse(ActionListener actionListener) {
		this.btnCadastrarSe.addActionListener(actionListener);
	}
	
	public void limparFormulario(){
		this.tfNome.setText("");
		this.tfCPF.setText("");
	}
	

}
