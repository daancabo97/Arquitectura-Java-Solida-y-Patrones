package com.arquitecturajava.helpers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {

	
	public  List<String> buscarTodasLasCategorias() throws Exception {
		List<String> lista = new ArrayList<String>();
		String consultaCategoria = "SELECT distinct(categoria) FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
		while (resultSet.next()) {

			lista.add(resultSet.getString("categoria"));

		}
		DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);
		return lista;

	}

	public void insertar(Libro libro) throws Exception {

		String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
		DatabaseHelper.executeUpdate(consultaInsercion, libro.getIsbn(), libro.getTitulo(), libro.getCategoria());

	}

	public  List<Libro> buscarTodos() throws Exception {

		List<Libro> lista = new ArrayList<Libro>();
		String consulta = "SELECT * FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
		while (resultSet.next()) {

			lista.add(new Libro(resultSet.getString("isbn"), resultSet.getString("titulo"),
					resultSet.getString("categoria")));

		}
		DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);

		return lista;

	}
	public void borrar(String isbn) throws Exception {

		String consultaInsercion = "delete from libros where isbn= ?";
		DatabaseHelper.executeUpdate(consultaInsercion,isbn);

	}
	
}
