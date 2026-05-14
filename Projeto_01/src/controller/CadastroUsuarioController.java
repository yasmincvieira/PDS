package controller;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuario;

public class CadastroUsuarioController {
	
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
		boolean isAdm = cadastro.getrbAdm().isSelected();
		boolean isUser = cadastro.getrbUsuario().isSelected();
		
		if(nome.isEmpty() || cpf.isEmpty() || (!isAdm && !isUser)) {
			JOptionPane.showMessageDialog(cadastro, "Preencha todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
			return; 
		}
		if (user.existeCPF(cpf)) {
			JOptionPane.showMessageDialog(cadastro, "O CPF informado já está cadastrado!", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Usuario novoUsuario = new Usuario();
	    novoUsuario.setNome(nome);
	    novoUsuario.setCPF(cpf);
	    novoUsuario.setInd(isAdm);
	  
	    user.adicionarUsuario(novoUsuario); 
	    
	    JOptionPane.showMessageDialog(cadastro, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	    
	    this.navegador.navegarPara("LOGIN");
	    
	    limparCamposCadastro();
	}
	
	public void limparCamposCadastro() {
		cadastro.gettfNomeC().setText("");
		cadastro.gettfCPFC().setText("");
	}
	
		
}


