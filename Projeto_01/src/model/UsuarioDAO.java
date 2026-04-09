package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	public void adicionarUsuario(Usuario usuario) {
	    String sql = "INSERT INTO usuarios (nome, cpf) VALUES (?, ?)";

	    try (Connection conexao = BancoDeDados.conectar();
	         PreparedStatement pstm = conexao.prepareStatement(sql)) {

	        if (conexao == null) {
	            System.err.println("Erro: Conexão nula no adicionarUsuario!");
	            return;
	        }
	        pstm.setString(1, usuario.getNome());
	        pstm.setString(2, usuario.getCPF());
	        pstm.executeUpdate();
	        
	        System.out.println("Usuário salvo no banco com sucesso!");

	    } catch (SQLException e) {
	        System.err.println("Erro ao inserir usuário: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            if (conexao == null) {
                System.err.println("Falha na conexão! Verifique o Driver e as credenciais.");
                return usuarios; 
            }
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setCPF(rset.getString("cpf"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
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
