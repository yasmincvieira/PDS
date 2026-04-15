package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import view.TelaCompra;

public class CompraController {
	
	private TelaCompra telaCompra;
	private ProdutoDAO produtoDAO;
	private Navegador navegador;
	private List<Produto> listaProdutos;
	private Map<Produto, Integer> carrinho;
	private double totalCompra;

	public CompraController(TelaCompra telaCompra, ProdutoDAO produtoDAO, Navegador navegador) {
		this.telaCompra = telaCompra;
		this.produtoDAO = produtoDAO;
		this.navegador = navegador;
		this.carrinho = new LinkedHashMap<>();
		this.totalCompra = 0.0;
		initController();
		carregarProdutos();
	}

	private void initController() {
		telaCompra.adicionarCarrinho(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarAoCarrinho();
			}
		});

		telaCompra.emitirNota(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emitirNota();
			}
		});

		telaCompra.voltar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegador.navegarPara("LOGIN");
			}
		});
	}

	public void carregarProdutos() {
		listaProdutos = produtoDAO.listarProdutos();
		atualizarTabela();
	}

	private void atualizarTabela() {
		DefaultTableModel model = (DefaultTableModel) telaCompra.getTable().getModel();
		model.setRowCount(0);
		for (Produto p : listaProdutos) {
			// Calcula quantos já foram colocados no carrinho
			int noCarrinho = carrinho.getOrDefault(p, 0);
			int qtdDisponivel = p.getQuantidade() - noCarrinho;
			model.addRow(new Object[]{
				p.getNome(),
				String.format("R$ %.2f", p.getPreco()),
				qtdDisponivel
			});
		}
	}

	private void adicionarAoCarrinho() {
		int linhaSelecionada = telaCompra.getTable().getSelectedRow();
		if (linhaSelecionada == -1) {
			JOptionPane.showMessageDialog(telaCompra,
				"Selecione um produto na tabela antes de adicionar ao carrinho.",
				"Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Produto produtoSelecionado = listaProdutos.get(linhaSelecionada);

		// Verifica se ainda tem estoque disponível
		int noCarrinho = carrinho.getOrDefault(produtoSelecionado, 0);
		if (noCarrinho >= produtoSelecionado.getQuantidade()) {
			JOptionPane.showMessageDialog(telaCompra,
				"Estoque insuficiente para \"" + produtoSelecionado.getNome() + "\"!",
				"Estoque Esgotado", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Incrementa no carrinho
		carrinho.put(produtoSelecionado, noCarrinho + 1);
		totalCompra += produtoSelecionado.getPreco();

		// Atualiza a tabela refletindo a nova quantidade disponível
		atualizarTabela();

		// Restaura a seleção na mesma linha
		telaCompra.getTable().setRowSelectionInterval(linhaSelecionada, linhaSelecionada);

		// Atualiza taDetalhes
		int qtdNoCarrinho = carrinho.get(produtoSelecionado);
		int qtdRestante = produtoSelecionado.getQuantidade() - qtdNoCarrinho;
		telaCompra.getTaDetalhes().setText(
			"Produto: " + produtoSelecionado.getNome() + "\n" +
			"Preco unitario: R$ " + String.format("%.2f", produtoSelecionado.getPreco()) + "\n" +
			"Quantidade no carrinho: " + qtdNoCarrinho + "\n" +
			"Estoque restante: " + qtdRestante
		);

		// Atualiza taTotal
		telaCompra.getTaTotal().setText("Total a pagar: R$ " + String.format("%.2f", totalCompra));
	}

	private void emitirNota() {
		if (carrinho.isEmpty()) {
			JOptionPane.showMessageDialog(telaCompra,
				"O carrinho esta vazio! Adicione produtos antes de emitir a nota.",
				"Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		StringBuilder nota = new StringBuilder();
		nota.append("========== NOTA FISCAL ==========\n\n");
		nota.append(String.format("%-20s %5s  %10s%n", "PRODUTO", "QTD", "SUBTOTAL"));
		nota.append("---------------------------------\n");

		for (Map.Entry<Produto, Integer> entry : carrinho.entrySet()) {
			Produto p = entry.getKey();
			int qtd = entry.getValue();
			double subtotal = p.getPreco() * qtd;
			nota.append(String.format("%-20s  x%-3d  R$ %7.2f%n",
				p.getNome(), qtd, subtotal));
		}

		nota.append("---------------------------------\n");
		nota.append(String.format("TOTAL:               R$ %7.2f%n", totalCompra));
		nota.append("=================================\n");
		nota.append("Obrigado pela compra!");

		JOptionPane.showMessageDialog(telaCompra, nota.toString(),
			"Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
	}
}