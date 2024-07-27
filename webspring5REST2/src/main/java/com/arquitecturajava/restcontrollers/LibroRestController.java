package com.arquitecturajava.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Libro> libros() {
		return servicio.buscarTodos();

	}
	@PostMapping("/filtrocategoria")
	public List<Libro> filtrocategoria(@RequestParam int idCategoria) {

		List<Libro> listaFiltrada = servicio.buscarTodosPorCategoria(idCategoria);
		return listaFiltrada;
	}
	@PostMapping
	public void insertarLibro(@RequestBody Libro libro) {
	
			 servicio.insertar(libro);
	}

	@DeleteMapping
	public void borrarlibro(@RequestParam String isbn) {

		servicio.borrar(isbn);
	

	}
}
