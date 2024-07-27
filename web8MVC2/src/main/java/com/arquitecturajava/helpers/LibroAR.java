package com.arquitecturajava.helpers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public static List<String> buscarTodasLasCategorias() throws Exception {
		List<String> lista = new ArrayList<String>();
		String consultaCategoria = "SELECT distinct(categoria) FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
		while (resultSet.next()) {

			lista.add(resultSet.getString("categoria"));

		}
		DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);
		return lista;

	}

	public void insertar() throws Exception {

		String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
		DatabaseHelper.executeUpdate(consultaInsercion, getIsbn(), getTitulo(), getCategoria());

	}

	public static List<LibroAR> buscarTodos() throws Exception {

		List<LibroAR> lista = new ArrayList<LibroAR>();
		String consulta = "SELECT * FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
		while (resultSet.next()) {

			lista.add(new LibroAR(resultSet.getString("isbn"), resultSet.getString("titulo"),
					resultSet.getString("categoria")));

		}
		DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);

		return lista;

	}
	
	
	public LibroAR(String isbn) {
		super();
		this.isbn = isbn;
	}

	public void borrar() throws Exception {

		String consultaInsercion = "delete from libros where isbn= ?";
		DatabaseHelper.executeUpdate(consultaInsercion, getIsbn());

	}

}
