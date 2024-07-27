package com.arquitecturajava.repositories;

import java.util.List;

import com.arquitecturajava.models.Libro;

public interface LibroRepository {

	List<String> buscarTodasLasCategorias(); 

	void insertar(Libro libro); 

	List<Libro> buscarTodos(); 

	List<Libro> buscarTodosPorCategoria(String categoria); 

	void borrar(String isbn); 

}