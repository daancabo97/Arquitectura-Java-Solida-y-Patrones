package com.arquitecturajava.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.services.LibroService;


@RestController
@RequestMapping("/webapi/libros")
public class LibroRestController {

	@Autowired
	private LibroService servicio;

	public LibroRestController() {

	}
	@GetMapping
	public List<Libro> buscarTodos() {
		return servicio.buscarTodos();

	}
	
	@GetMapping("/{isbn}")
	public Optional<Libro> buscarUno(@PathVariable ("isbn") String isbn) {
		System.out.println(isbn);
		return servicio.buscarUnLibro(isbn);

	}
	
	@GetMapping(params="categoria")
	public List<Libro> filtroCategoria(@RequestParam int categoria) {
		
		List<Libro> listaFiltrada = servicio.buscarTodosPorCategoria(new Categoria(categoria));
		return listaFiltrada;
	}
	
	@DeleteMapping("/{isbn}")
	public void borrar(@PathVariable(value = "isbn") String isbn) {

		servicio.borrar(isbn);
	

	}
	
	@PostMapping
	public void insertar(@RequestBody Libro libro) {
		
			servicio.insertar(libro);
	}

	
}
