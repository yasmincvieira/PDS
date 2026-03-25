package controller;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	
	private static final String URL = "jdbc:mysql://localhost:3306/banco";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
	
	public List<Usuario> executarSQL(String sql) {
	    List<Usuario> usuarios = new ArrayList<Usuario>();

	    try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
	         Statement statement = conexao.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {

	        while (resultSet.next()) {
	            Usuario usuario = new Usuario();

	            usuarios.add(usuario);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return usuarios;
	}}
