package com.arquitecturajava.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.helpers.DatabaseHelper;
import com.arquitecturajava.models.Libro;

public class LibroRepositoryJDBC implements LibroRepository {

	
	@Override
	public  List<String> buscarTodasLasCategorias()  {
		List<String> lista = new ArrayList<String>();
		String consultaCategoria = "SELECT distinct(categoria) FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consultaCategoria);
		try {
			while (resultSet.next()) {

				lista.add(resultSet.getString("categoria"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			
			try {
				DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
		return lista;

	}

	@Override
	public void insertar(Libro libro)  {

		String consultaInsercion = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
		DatabaseHelper.executeUpdate(consultaInsercion, libro.getIsbn(), libro.getTitulo(), libro.getCategoria());

	}

	@Override
	public  List<Libro> buscarTodos() {

		List<Libro> lista = new ArrayList<Libro>();
		String consulta = "SELECT * FROM libros";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta);
		try {
			while (resultSet.next()) {

				lista.add(new Libro(resultSet.getString("isbn"), resultSet.getString("titulo"),
						resultSet.getString("categoria")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			try {
				DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		return lista;

	}
	
	
	@Override
	public  List<Libro> buscarTodosPorCategoria(String categoria) {

		List<Libro> lista = new ArrayList<Libro>();
		String consulta = "SELECT * FROM libros where categoria=?";
		ResultSet resultSet = DatabaseHelper.executeQuery(consulta,categoria);
		try {
			while (resultSet.next()) {

				lista.add(new Libro(resultSet.getString("isbn"), resultSet.getString("titulo"),
						resultSet.getString("categoria")));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
		
			try {
				DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
			
		}
	
		return lista;

	}
	@Override
	public void borrar(String isbn)  {

		String consultaInsercion = "delete from libros where isbn= ?";
		DatabaseHelper.executeUpdate(consultaInsercion,isbn);

	}
	
}
