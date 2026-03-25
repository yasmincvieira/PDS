package controller;

import java.util.List;

import model.UsuarioDAO;
import model.Usuario;
import view.TelaLogin;

public class LoginController {
	
	private Database db;
	//private Object view;
	private final TelaLogin view;
	private final UsuarioDAO model;
	private final Navegador navegador;
	
	// Construtor da classe
	public LoginController (TelaLogin view, UsuarioDAO model, Navegador navegador) {
		db = new Database();
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		this.view.entrar(e -> {
			this.navegador.navegarPara("COMPRA");
		});;
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