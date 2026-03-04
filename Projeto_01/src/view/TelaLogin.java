package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfCPF;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[grow][grow 50][grow][grow]", "[grow][][grow 80][][][][grow 70][grow 10][grow]"));
		
		JLabel lblNewLabel = new JLabel("MERCADINHO");
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "cell 1 3,alignx center");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfNome, "cell 2 3,growx");
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_2, "cell 1 5,alignx center");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfCPF, "cell 2 5,growx");
		tfCPF.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 7 2 1,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Ainda não tem cadastro?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar-se");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton);

	}

}
