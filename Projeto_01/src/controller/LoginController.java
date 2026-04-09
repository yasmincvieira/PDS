package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.UsuarioDAO;
import model.Usuario;
import view.TelaLogin;

public class LoginController {
	
	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	
	public LoginController (TelaLogin login, UsuarioDAO user, Navegador navegador) {
		this.login = login;
		this.user = user;
		this.navegador = navegador;
		
		this.login.entrar(e -> {
			verificarCadastroUsuario();
		});
		
		this.login.cadastrarse(e -> {
			navegador.navegarPara("CADASTRO");
		});
	}
	
	private void verificarCadastroUsuario() {
		List<Usuario> usuarios = user.listarUsuarios();
		
		String nomeDigitado = login.gettfNome().getText();
		String cpfDigitado = login.gettfCPF().getText();
		if(nomeDigitado.isEmpty() || cpfDigitado.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
		}
		else {
			boolean usuarioEncontrado = false;
			
			for(Usuario u : usuarios) {
			    if(u.getNome().trim().equalsIgnoreCase(nomeDigitado.trim()) && 
			       u.getCPF().trim().equals(cpfDigitado.trim())){
			        usuarioEncontrado = true;
			        break;
			    }
			}
			
			if(usuarioEncontrado) {
				JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
				this.navegador.navegarPara("COMPRA");
				limparCamposLogin();
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuário ou CPF não encontrados");
			}
		}
	}
	
	public void limparCamposLogin() {
		login.gettfNome().setText("");
		login.gettfCPF().setText("");
	}
}