package com.arquitecturajava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.repositories.CategoriaRepository;
import com.arquitecturajava.repositories.LibroRepository;
@Service
public class LibroService {

	private LibroRepository libroRepository;
	private CategoriaRepository categoriaRepository;
	
	
	public Optional<Categoria> buscarUnaCategoria(int id) {
		return categoriaRepository.findById(id);
	}
	public LibroService(LibroRepository libroRepository, CategoriaRepository categoriaRepository) {
		super();
		this.libroRepository = libroRepository;
		this.categoriaRepository = categoriaRepository;
	}
	public void insertar(Libro libro) {
		libroRepository.save(libro);
	}
	public List<Libro> buscarTodos() {
		return libroRepository.findAll();
	}
	public List<Libro> buscarTodosPorCategoria(int idCategoria) {
		return libroRepository.findByCategoria(new Categoria(idCategoria));
	}
	public void borrar(String isbn) {
		libroRepository.deleteById(isbn);
	}
	public List<Categoria> buscarTodasLasCategorias() {
		return categoriaRepository.findAll();
	}
	
	
}
