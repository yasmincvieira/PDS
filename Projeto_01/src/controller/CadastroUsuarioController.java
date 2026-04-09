package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuario;

public class CadastroUsuarioController {
	
	private Database db;
	private TelaCadastroUsuario cadastro;
	private UsuarioDAO user;
	private Navegador navegador;
	
	
	public CadastroUsuarioController (TelaCadastroUsuario cadastro, UsuarioDAO user, Navegador navegador) {
		super();
		this.cadastro = cadastro;
		this.user = user;
		this.navegador = navegador;
		
		this.cadastro.cadastrar(e -> {
		    verificarCadastroUsuario();
		});
		
	}
	
	private void verificarCadastroUsuario() {
		
		String nome = cadastro.gettfNomeC().getText();
		String cpf = cadastro.gettfCPFC().getText();
		
		if(nome.isEmpty() || cpf.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			return; 
		}
		
		Usuario novoUsuario = new Usuario();
	    novoUsuario.setNome(nome);
	    novoUsuario.setCPF(cpf);
	  
	    user.adicionarUsuario(novoUsuario); 
	    
	    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
	    
	    this.navegador.navegarPara("LOGIN");
	    
	    limparCamposCadastro();
	}
	
	public void limparCamposCadastro() {
		cadastro.gettfNomeC().setText("");
		cadastro.gettfCPFC().setText("");
	}

		
	}


