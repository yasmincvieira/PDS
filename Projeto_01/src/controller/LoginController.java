package controller;

import java.util.List;

import model.UsuarioDAO;
import model.Usuario;
import view.TelaLogin;

public class LoginController {
	
	private Database db;
	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	
	// Construtor da classe
	public LoginController (TelaLogin login, UsuarioDAO user, Navegador navegador) {
		db = new Database();
		this.login = login;
		this.user = user;
		this.navegador = navegador;
		
		this.login.entrar(e -> {
			this.navegador.navegarPara("COMPRA");
		});
		
		this.login.cadastrarse(e -> {
			navegador.navegarPara("CADASTRO");
		});
	}
	
	public void FazLogin (String Nome, String Cpf) {
		List<Usuario> retornoDoBanco = db.executarSQL("SELECT * FROM usuarios where nome = '" + Nome + "' and cpf = '" + Cpf + "'");
		// Se o retorno do banco não for vazio
		if(!retornoDoBanco.isEmpty()) {
			System.out.println(retornoDoBanco);
		}
		else {
			System.out.println("Usuario não encontrado");
		}
	}
	
	public void CriaUsuario(String Email, String Senha, String Nome) {
		System.out.println("Criando Usuário");
	}
	
	
}