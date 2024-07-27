package com.arquitecturajava.helpers;

import java.sql.ResultSet;

public class LibroAR {

	private String isbn;
	private String titulo;
	private String categoria;
	
	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public LibroAR(String isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}


	public static ResultSet buscarTodasLasCategorias() throws Exception {

		String consultaCategoria = "SELECT distinct(categoria) FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
		return resultSet;

	}
	
	
	public void insertar() throws Exception {

		String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
	    DatabaseHelper.executeUpdate(consultaInsercion, getIsbn(), getTitulo(), getCategoria());
		

	}
	
	public static ResultSet buscarTodos() throws Exception {

		String consulta = "SELECT * FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
		return resultSet;

	}
}
