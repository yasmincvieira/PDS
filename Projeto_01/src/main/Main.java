package main;

import controller.CadastroProdutoController;
import controller.CadastroUsuarioController;
import controller.LoginController;
import controller.Navegador;
import model.UsuarioDAO;
import view.Janela;
import view.TelaCadastroProduto;
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
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		
		
		Navegador navegador = new Navegador(janela);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		CadastroProdutoController cadastroProdutoController = new CadastroProdutoController(telaCadastroProduto, new model.ProdutoDAO(), navegador);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(telaCadastroUsuario, usuarioDAO, navegador);
		
		
		navegador.adicionarPainel("CADASTRO", telaCadastroUsuario);
		navegador.adicionarPainel("COMPRA", telaCompra);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("CADASTRO_PRODUTOS", telaCadastroProduto);
		
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		navegador.navegarPara("LOGIN");
		
		
	}

}
