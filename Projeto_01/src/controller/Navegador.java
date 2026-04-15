package controller;

import javax.swing.JPanel;
import view.Janela;
import view.TelaCadastroUsuario;
import view.TelaLogin;

public class Navegador {
	
	private Janela janela;
	private TelaLogin login;
	private LoginController loginController;
	private TelaCadastroUsuario cadastro;
	private CadastroUsuarioController cadastroController;
	private CompraController compraController;
	

	public Navegador(Janela janela) {
		this.janela = janela;
		this.login = login;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}
	
	public void navegarPara(String nome) {
		if (nome.equals("COMPRA") && compraController != null) {
			compraController.carregarProdutos();
		}
		this.janela.mostrarTela(nome);
	}
	
	public void sair() {
		this.janela.dispose();
	}

	public LoginController getloginController() {
		return loginController;
	}
	
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public CadastroUsuarioController getCadastroController() {
		return cadastroController;
	}
	
	public void setCadastroController(CadastroUsuarioController cadastroController) {
		this.cadastroController = cadastroController;	
	}
	
	public void setCompraController(CompraController compraController) {
		this.compraController = compraController;
	}


}
