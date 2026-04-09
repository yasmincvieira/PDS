package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeC, tfCPFC;
	private JRadioButton rbAdm, rbUsuario;
	private JButton btnCadastrar;

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[grow][grow 50][grow][grow]", "[grow][][grow 40][][][][grow 50][grow 30][grow]"));
		
		JLabel lblNewLabel = new JLabel("MERCADINHO");
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "cell 1 3,alignx center");
		
		tfNomeC = new JTextField();
		tfNomeC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNomeC, "cell 2 3,growx");
		tfNomeC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_2, "cell 1 5,alignx center");
		
		tfCPFC = new JTextField();
		tfCPFC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfCPFC, "cell 2 5,growx");
		tfCPFC.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 6 2 1,growx,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Identifique-se:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		rbAdm = new JRadioButton("Administrador");
		rbAdm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(rbAdm);
		
		rbUsuario = new JRadioButton("Usuário");
		rbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(rbUsuario);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbAdm);
		grupo.add(rbUsuario);
		
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnCadastrar, "cell 1 7 2 1,alignx center");

	}

	public JTextField gettfNomeC() {
		return tfNomeC;
	}
    
    public void settfNomeC(JTextField tfNomeC) {
		this.tfNomeC = tfNomeC;
	}
    
    public JTextField gettfCPFC() {
		return tfCPFC;
	}
    
    public void settfCPFC(JTextField tfCPFC) {
		this.tfCPFC = tfCPFC;
	}
    
    public JRadioButton getrbAdm() {
		return rbAdm;
	}
    
    public void setrbAdm(JRadioButton rbAdm) {
    	this.rbAdm = rbAdm;
    }

	public JRadioButton getrbUsuario() {
		return rbUsuario;
	}
	
	public void setrbUsuario(JRadioButton rbUsuario) {
	    	this.rbUsuario = rbUsuario;
	    }

    
    public void cadastrar(ActionListener actionListener) {
		this.btnCadastrar.addActionListener(actionListener);
	}

}
