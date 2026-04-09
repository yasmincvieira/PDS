package controller;
import model.Produto;
import model.ProdutoDAO;
import view.TelaCadastroProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CadastroProdutoController {

    private TelaCadastroProduto telaCadastroProduto;
    private ProdutoDAO produtoDAO;
    private Navegador navegador;

    public CadastroProdutoController(TelaCadastroProduto telaCadastroProduto, ProdutoDAO produtoDAO, Navegador navegador) {
        this.telaCadastroProduto = telaCadastroProduto;
        this.produtoDAO = produtoDAO;
        this.navegador = navegador;
        initController();
    }

    private void initController() {
        telaCadastroProduto.cadastrarProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });
        // Adicionar listeners para os outros botões (editar, remover, visualizar) conforme necessário
    }

    private void cadastrarProduto() {
        String nome = telaCadastroProduto.gettfProduto().getText();
        String precoStr = telaCadastroProduto.gettfPreco().getText();
        String qtdStr = telaCadastroProduto.gettfQtd().getText();

        if (nome.isEmpty() || precoStr.isEmpty() || qtdStr.isEmpty()) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Todos os campos devem ser preenchidos!", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double preco = Double.parseDouble(precoStr);
            int quantidade = Integer.parseInt(qtdStr);

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);

            produtoDAO.adicionarProduto(produto);
            JOptionPane.showMessageDialog(telaCadastroProduto, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            telaCadastroProduto.limparFormulario();
            // Atualizar a tabela de produtos, se houver

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Preço e Quantidade devem ser números válidos!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Métodos para editar, remover e visualizar produtos podem ser adicionados aqui
}
