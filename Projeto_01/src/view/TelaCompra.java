package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TelaCompra() {
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[][100px:n:500px,grow][][][grow][]", "[][][grow][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("MERCADINHO COMPRAS");
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 30));
		add(lblNewLabel, "cell 1 1 3 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 3 1 5,grow");
		
		table = new JTable();
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
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Visualizar Produto");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNewButton_1, "cell 3 3 2 1,alignx center");
		
		JButton btnNewButton = new JButton("Adicionar ao Carrinho");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNewButton, "cell 3 5 2 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "flowx,cell 3 7,alignx trailing,aligny bottom");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textField, "cell 4 7,growx,aligny bottom");
		textField.setColumns(10);

	}

}
