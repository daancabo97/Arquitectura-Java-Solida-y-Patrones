package com.arquitecturajava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.repositories.CategoriaRepository;
import com.arquitecturajava.repositories.LibroRepository;

import jakarta.transaction.Transactional;
@Service
public class LibroService {

	private LibroRepository libroRepository;
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria buscarUnaCategoria(int id) {
		return categoriaRepository.buscarUnaCategoria(id);
	}
	public LibroService(LibroRepository libroRepository, CategoriaRepository categoriaRepository) {
		super();
		this.libroRepository = libroRepository;
		this.categoriaRepository = categoriaRepository;
	}
	@Transactional
	public void insertar(Libro libro) {
		libroRepository.insertar(libro);
	}
	public List<Libro> buscarTodos() {
		return libroRepository.buscarTodos();
	}
	public List<Libro> buscarTodosPorCategoria(int idCategoria) {
		return libroRepository.buscarTodosPorCategoria(idCategoria);
	}
	@Transactional
	public void borrar(String isbn) {
		libroRepository.borrar(isbn);
	}
	public List<Categoria> buscarTodasLasCategorias() {
		return categoriaRepository.buscarTodasLasCategorias();
	}
	
	
}
