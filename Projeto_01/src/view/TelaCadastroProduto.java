package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

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
	private JButton btnVoltarP;


	public TelaCadastroProduto() {
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[grow 80][grow 50][grow][grow 80]", "[grow][][][][][][43.00,grow][100px:n:200px][grow]"));
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE PRODUTOS");
		lblNewLabel.setForeground(new Color(2, 68, 87));
		lblNewLabel.setBackground(new Color(2, 68, 87));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 45));
		add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setForeground(new Color(2, 68, 87));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "cell 1 3,alignx center");
		
		tfProduto = new JTextField();
		tfProduto.setBackground(new Color(85, 170, 170));
		tfProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfProduto, "cell 2 3,growx");
		tfProduto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Preço:");
		lblNewLabel_2.setForeground(new Color(2, 68, 87));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_2, "cell 1 4,alignx center");
		
		tfPreco = new JTextField();
		tfPreco.setBackground(new Color(85, 170, 170));
		tfPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfPreco, "cell 2 4,growx");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setForeground(new Color(2, 68, 87));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_3, "cell 1 5,alignx center");
		
		tfQtd = new JTextField();
		tfQtd.setBackground(new Color(85, 170, 170));
		tfQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(tfQtd, "cell 2 5,growx");
		tfQtd.setColumns(10);
		
		panel = new JPanel();
		add(panel, "cell 1 6 2 1,alignx center,aligny center");
		
		btnCadastrarP = new JButton("Cadastrar");
		btnCadastrarP.setBackground(new Color(64, 128, 128));
		btnCadastrarP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnCadastrarP);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(2, 68, 87));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnEditar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(2, 68, 87));
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnRemover);
		
		btnVoltarP = new JButton("Voltar");
		btnVoltarP.setBackground(new Color(85, 170, 170));
		btnVoltarP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnVoltarP);
		
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
	public JTextField gettfProduto() {
		return tfProduto;
	}
	
	 public void settfProduto(JTextField tfProduto) {
		this.tfProduto = tfProduto;
	}

	public JTextField gettfPreco() {
		return tfPreco;
	}
	
	public void settfPreco(JTextField tfPreco) {
		this.tfPreco = tfPreco;
	}

	public JTextField gettfQtd() {
		return tfQtd;
	}
	
	public void settfQtd(JTextField tfQtd) {
		this.tfQtd = tfQtd;
	}

	public void cadastrarProduto(ActionListener actionListener) {
		this.btnCadastrarP.addActionListener(actionListener);
	}
	
	public void editarProduto(ActionListener actionListener) {
		this.btnEditar.addActionListener(actionListener);
	}
	
	public void removerProduto(ActionListener actionListener) {
		this.btnRemover.addActionListener(actionListener);
	}
	
	public void voltar(ActionListener actionListener) {
		this.btnVoltarP.addActionListener(actionListener);
	}
	
	public JTable getTable() {
		return table;
	}

	public void limparFormulario() {
		tfProduto.setText("");
		tfPreco.setText("");
		tfQtd.setText("");
	}

}
