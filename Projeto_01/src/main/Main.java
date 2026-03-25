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
		Navegador navegador = new Navegador(janela);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		TelaLogin telaLogin = new TelaLogin();
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController();
		
		TelaCompra telaCompra = new TelaCompra();
		
		navegador.adicionarPainel("CADASTRO", telaCadastroUsuario);
		navegador.adicionarPainel("COMPRA", telaCompra);
		
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		navegador.navegarPara("COMPRA");
		
		
	}

}
