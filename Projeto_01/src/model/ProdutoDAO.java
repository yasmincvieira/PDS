package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, qtd) VALUES (?, ?, ?)";
        try (Connection conn = BancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, preco, qtd FROM produtos";

        try (Connection conn = BancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("qtd"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, qtd = ? WHERE id = ?";
        try (Connection conn = BancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId());
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public void excluirProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = BancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto excluído com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao excluir produto: " + e.getMessage());
        }
    }
}
