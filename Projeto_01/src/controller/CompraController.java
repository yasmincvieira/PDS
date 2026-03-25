package controller;

import java.util.List;

import model.Usuario;

public class CompraController {
	
	private Database db;
	private Object view;
	
	// Construtor da classe
	public CompraController () {
		db = new Database();
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
	};

}