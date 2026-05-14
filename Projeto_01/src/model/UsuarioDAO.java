package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	public void adicionarUsuario(Usuario usuario) {
	    String sql = "INSERT INTO usuarios (nome, cpf, ind) VALUES (?, ?, ?)";

	    try (Connection conexao = BancoDeDados.conectar();
	         PreparedStatement pstm = conexao.prepareStatement(sql)) {

	        if (conexao == null) {
	            System.err.println("Erro: Conexão nula no adicionarUsuario!");
	            return;
	        }
	        pstm.setString(1, usuario.getNome());
	        pstm.setString(2, usuario.getCPF());
	        pstm.setBoolean(3, usuario.isInd());
	        pstm.executeUpdate();
	        
	        System.out.println("Usuário salvo no banco com sucesso!");

	    } catch (SQLException e) {
	        System.err.println("Erro ao inserir usuário: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public Usuario validarLogin(String nome, String cpf) {
        String sql = "SELECT * FROM usuarios WHERE nome = ? AND cpf = ?";
        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {
            
            pstm.setString(1, nome);
            pstm.setString(2, cpf);
            
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rset.getInt("id"));
                    usuario.setNome(rset.getString("nome"));
                    usuario.setCPF(rset.getString("cpf"));
                    usuario.setInd(rset.getBoolean("ind"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public boolean existeCPF(String cpf) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE cpf = ?";
        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {
            pstm.setString(1, cpf);
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    return rset.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conexao = BancoDeDados.conectar();
                PreparedStatement pstm = conexao.prepareStatement(sql);
                ResultSet rset = pstm.executeQuery()) {

               while (rset.next()) {
                   Usuario usuario = new Usuario();
                   usuario.setId(rset.getInt("id"));
                   usuario.setNome(rset.getString("nome"));
                   usuario.setCPF(rset.getString("cpf"));
                   usuario.setInd(rset.getBoolean("ind"));
                   usuarios.add(usuario);
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return usuarios;
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCPF());
            pstm.setInt(3, usuario.getId());
            pstm.setInt(4, usuario.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }

    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    }
