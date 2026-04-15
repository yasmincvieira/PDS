package controller;
import model.Produto;
import model.ProdutoDAO;
import view.TelaCadastroProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastroProdutoController {

    private TelaCadastroProduto telaCadastroProduto;
    private ProdutoDAO produtoDAO;
    private Navegador navegador;
    private List<Produto> listaProdutos;
    private Produto produtoEmEdicao = null;

    public CadastroProdutoController(TelaCadastroProduto telaCadastroProduto, ProdutoDAO produtoDAO, Navegador navegador) {
        this.telaCadastroProduto = telaCadastroProduto;
        this.produtoDAO = produtoDAO;
        this.navegador = navegador;
        initController();
        atualizarTabela();
    }

    private void initController() {
        telaCadastroProduto.cadastrarProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (produtoEmEdicao == null) {
                    cadastrarProduto();
                } else {
                    salvarEdicao();
                }
            }
        });

        telaCadastroProduto.removerProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProduto();
            }
        });

        telaCadastroProduto.editarProduto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepararEdicao();
            }
        });
        
        telaCadastroProduto.voltar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	navegador.navegarPara("LOGIN");
            }
        });
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
            
            atualizarTabela();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Preço e Quantidade devem ser números válidos!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerProduto() {
        int linhaSelecionada = telaCadastroProduto.getTable().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Selecione um produto na tabela para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(telaCadastroProduto, "Tem certeza que deseja remover este produto?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            Produto produto = listaProdutos.get(linhaSelecionada);
            produtoDAO.excluirProduto(produto.getId());
            JOptionPane.showMessageDialog(telaCadastroProduto, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
            cancelarEdicao();
        }
    }

    private void prepararEdicao() {
        int linhaSelecionada = telaCadastroProduto.getTable().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Selecione um produto na tabela para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        produtoEmEdicao = listaProdutos.get(linhaSelecionada);
        
        telaCadastroProduto.gettfProduto().setText(produtoEmEdicao.getNome());
        telaCadastroProduto.gettfPreco().setText(String.valueOf(produtoEmEdicao.getPreco()));
        telaCadastroProduto.gettfQtd().setText(String.valueOf(produtoEmEdicao.getQuantidade()));
        
        JOptionPane.showMessageDialog(telaCadastroProduto, "Altere os dados nos campos acima e clique em 'Cadastrar' para salvar as alterações.");
    }

    private void salvarEdicao() {
        String nome = telaCadastroProduto.gettfProduto().getText();
        String precoStr = telaCadastroProduto.gettfPreco().getText();
        String qtdStr = telaCadastroProduto.gettfQtd().getText();

        if (nome.isEmpty() || precoStr.isEmpty() || qtdStr.isEmpty()) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Todos os campos devem ser preenchidos!", "Erro de Edição", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            produtoEmEdicao.setNome(nome);
            produtoEmEdicao.setPreco(Double.parseDouble(precoStr));
            produtoEmEdicao.setQuantidade(Integer.parseInt(qtdStr));

            produtoDAO.atualizarProduto(produtoEmEdicao);
            JOptionPane.showMessageDialog(telaCadastroProduto, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            cancelarEdicao();
            atualizarTabela();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Preço e Quantidade devem ser números válidos!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarEdicao() {
        produtoEmEdicao = null;
        telaCadastroProduto.limparFormulario();
    }
    

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) telaCadastroProduto.getTable().getModel();
        model.setRowCount(0);

        listaProdutos = produtoDAO.listarProdutos();
        for (Produto p : listaProdutos) {
            model.addRow(new Object[]{
                p.getNome(),
                p.getPreco(),
                p.getQuantidade()
            });
        }
    }
}
