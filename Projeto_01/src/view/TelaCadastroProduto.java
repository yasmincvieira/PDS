package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;

public class TelaCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfProduto;
	private JTextField tfPreco;
	private JTextField tfQtd;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JButton btnCadastrarP;
	private JButton btnEditar;
	private JButton btnRemover;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto() {
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[grow 80][grow 50][grow][grow 80]", "[grow][][][][][][43.00,grow][100px:n:200px][grow]"));
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE PRODUTOS");
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 45));
		add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "cell 1 3,alignx center");
		
		tfProduto = new JTextField();
		tfProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfProduto, "cell 2 3,growx");
		tfProduto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Preço:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_2, "cell 1 4,alignx center");
		
		tfPreco = new JTextField();
		tfPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfPreco, "cell 2 4,growx");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_3, "cell 1 5,alignx center");
		
		tfQtd = new JTextField();
		tfQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfQtd, "cell 2 5,growx");
		tfQtd.setColumns(10);
		
		panel = new JPanel();
		add(panel, "cell 1 6 2 1,alignx center,aligny center");
		
		btnCadastrarP = new JButton("Cadastrar");
		btnCadastrarP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnCadastrarP);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnEditar);
		
		btnNewButton = new JButton("Visualizar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNewButton);
		
		btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnRemover);
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 7 2 1,grow");
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Produto", "Pre\u00E7o", "Quantidade"
			}
		));
		scrollPane.setViewportView(table);

	}

}
