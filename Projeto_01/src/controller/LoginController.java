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
			JOptionPane.showMessageDialog(login, "Preencha todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
		}
			
			Usuario usuario = user.validarLogin(nomeDigitado, cpfDigitado);
	        
	        if(usuario != null) {
	            JOptionPane.showMessageDialog(login, "Login realizado com sucesso! Bem-vindo, " + usuario.getNome(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	            
	            if (usuario.isInd()) {
	                this.navegador.navegarPara("CADASTRO_PRODUTOS");
	            } else {
	                this.navegador.navegarPara("COMPRA");
	            }
	            
	            limparCamposLogin();
	        }
	        else {
	            JOptionPane.showMessageDialog(login, "Usuário ou CPF não encontrados", "Falha", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	public void limparCamposLogin() {
		login.gettfNome().setText("");
		login.gettfCPF().setText("");
	}
}