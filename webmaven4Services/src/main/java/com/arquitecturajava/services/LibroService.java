package com.arquitecturajava.services;

import java.util.List;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.repositories.CategoriaRepository;
import com.arquitecturajava.repositories.CategoriaRepositoryJPA;
import com.arquitecturajava.repositories.LibroRepository;
import com.arquitecturajava.repositories.LibroRepositoryJPA;

public class LibroService {

	private LibroRepository repositorioLibro;
	private CategoriaRepository repositorioCategoria;

	public LibroService() {

		this.repositorioLibro = new LibroRepositoryJPA();
		this.repositorioCategoria = new CategoriaRepositoryJPA();
	}

	public void insertarLibro(Libro libro) {
		repositorioLibro.insertar(libro);
	}

	public List<Libro> buscarTodosLosLibros() {
		return repositorioLibro.buscarTodos();
	}

	public List<Libro> buscarTodosLosLibrosPorCategoria(String categoria) {
		return repositorioLibro.buscarTodosPorCategoria(categoria);
	}

	public void borrarLibro(String isbn) {
		repositorioLibro.borrar(isbn);
	}

	public List<Categoria> buscarTodasLasCategoriasLibros() {
		return repositorioCategoria.buscarTodasLasCategorias();
	}

}
