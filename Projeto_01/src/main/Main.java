package main;

import controller.CadastroUsuarioController;
import controller.LoginController;
import controller.Navegador;
import model.UsuarioDAO;
import view.Janela;
import view.TelaCadastroUsuario;
import view.TelaCompra;
import view.TelaLogin;

public class Main {
	
	public static void main(String[] args) {
		
		Janela janela = new Janela();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		//View
		TelaLogin telaLogin = new TelaLogin();
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		TelaCompra telaCompra = new TelaCompra();
		
		
		Navegador navegador = new Navegador(janela);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(telaCadastroUsuario, usuarioDAO, navegador);
		
		
		navegador.adicionarPainel("CADASTRO", telaCadastroUsuario);
		navegador.adicionarPainel("COMPRA", telaCompra);
		navegador.adicionarPainel("LOGIN", telaLogin);
		
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		navegador.navegarPara("LOGIN");
		
		
	}

}
