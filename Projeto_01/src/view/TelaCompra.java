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
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import java.awt.Color;

public class TelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnCarrinho, btnNota, btnVoltar;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextArea taDetalhes, taTotal; 

	
	public TelaCompra() {
		setBounds(100, 100, 900, 600);
		setLayout(new MigLayout("", "[][grow][grow][]", "[][][][grow][][grow][grow][grow][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("COMPRAS");
		lblNewLabel.setForeground(new Color(2, 68, 87));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 3 2 1,grow");
		
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
			},
			new String[] {
				"Produto", "Preço", "Quantidade"
			}
		));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		add(panel, "cell 1 5 2 1,grow");
		
		btnCarrinho = new JButton("Adicionar ao Carrinho");
		btnCarrinho.setBackground(new Color(85, 170, 170));
		btnCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnCarrinho);
		
		btnNota = new JButton("Emitir Nota");
		btnNota.setBackground(new Color(85, 170, 170));
		btnNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnNota);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(207, 243, 254));
		btnVoltar.setBackground(new Color(2, 68, 87));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("Detalhes do Produto:");
		lblNewLabel_1.setForeground(new Color(2, 68, 87));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1, "cell 1 7");
		
		taTotal = new JTextArea();
		taTotal.setForeground(new Color(2, 68, 87));
		taTotal.setBackground(new Color(240, 240, 240));
		taTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taTotal.setText("Total a pagar:");
		add(taTotal, "cell 2 7,grow");
		
		taDetalhes = new JTextArea();
		taDetalhes.setBackground(new Color(85, 170, 170));
		taDetalhes.setForeground(new Color(0, 0, 0));
		taDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(taDetalhes, "cell 1 8 2 1,grow");

	}
	public void adicionarCarrinho(ActionListener actionListener) {
		this.btnCarrinho.addActionListener(actionListener);
	}
	
	public void emitirNota(ActionListener actionListener) {
		this.btnNota.addActionListener(actionListener);
	}
	
	public void voltar(ActionListener actionListener) {
		this.btnVoltar.addActionListener(actionListener);
	}
	
	public JTable getTable() {
		return table;
	}

	public JTextArea getTaDetalhes() {
		return taDetalhes;
	}

	public JTextArea getTaTotal() {
		return taTotal;
	}

}
