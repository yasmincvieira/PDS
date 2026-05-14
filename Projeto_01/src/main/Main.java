package main;

import controller.CadastroProdutoController;
import controller.CadastroUsuarioController;
import controller.CompraController;
import controller.LoginController;
import controller.Navegador;
import model.ProdutoDAO;
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
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		TelaLogin telaLogin = new TelaLogin();
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		TelaCompra telaCompra = new TelaCompra();
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		
		
		Navegador navegador = new Navegador(janela);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		CadastroProdutoController cadastroProdutoController = new CadastroProdutoController(telaCadastroProduto, new model.ProdutoDAO(), navegador);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(telaCadastroUsuario, usuarioDAO, navegador);
		CompraController compraController = new CompraController(telaCompra, produtoDAO, navegador);
		
		navegador.setCompraController(compraController);
		
		navegador.adicionarPainel("CADASTRO", telaCadastroUsuario);
		navegador.adicionarPainel("COMPRA", telaCompra);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("CADASTRO_PRODUTOS", telaCadastroProduto);
		
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		navegador.navegarPara("LOGIN");
		
		
	}

}
