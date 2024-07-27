package com.arquitecturajava.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroAR {

	public static ResultSet buscarTodasLasCategorias() throws Exception {

		String consultaCategoria = "SELECT distinct(categoria) FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
		return resultSet;

	}
	
	
	public static void insertar(String isbn,String titulo,String categoria) throws Exception {

		String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
	    DatabaseHelper.executeUpdate(consultaInsercion, isbn, titulo, categoria);
		

	}
	
	public static ResultSet buscarTodos() throws Exception {

		String consulta = "SELECT * FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
		return resultSet;

	}
}
