package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;


	


	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		this.cardLayout = new CardLayout();
		
		setTitle("Tela de Login");
		contentPane = new JPanel(this.cardLayout);
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
	}
	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(nome, tela);               
	}

	public void mostrarTela(String nome) {
		this.cardLayout.show(this.contentPane, nome);
		this.pack();
	}

}
