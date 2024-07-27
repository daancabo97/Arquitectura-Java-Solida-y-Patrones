package com.arquitecturajava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arquitecturajava.forms.LibroForm;
import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.services.LibroService;

@Controller
@RequestMapping("/controlador")
public class LibroController {

	@Autowired
	private LibroService servicio;
	
	public LibroController() {
		
	}
	@GetMapping("/listalibros")
	public String listaLibros(Model model) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("listaLibros",servicio.buscarTodos());
		model.addAttribute("listaCategorias",servicio.buscarTodasLasCategorias());
		return "listalibros";
		
		
	}
	
	@GetMapping("/filtrocategoria")
	public String filtrocategoria(Model model, @RequestParam int idCategoria) {
		
		List<Libro> listaFiltrada=servicio.buscarTodosPorCategoria(new Categoria(idCategoria));
		System.out.println(listaFiltrada.size());
		model.addAttribute("listaLibros",listaFiltrada);
		model.addAttribute("listaCategorias",servicio.buscarTodasLasCategorias());
		return "listalibros";
		
		
	}
	@GetMapping("/formularionuevolibro")
	public String formularioNuevoLibro (Model model) {
		model.addAttribute("listaCategorias",servicio.buscarTodasLasCategorias());
		return "formularionuevolibro";
		
	}
	
	
	@PostMapping("/insertarlibro")
	public String insertarLibro (Model model, @ModelAttribute LibroForm libroForm) {
	   
		Optional<Categoria> categoria=servicio.buscarUnaCategoria(libroForm.getCategoria());
		
			if (categoria.isPresent()) {
				
			
		    Libro libro= new Libro(libroForm.getIsbn(),libroForm.getTitulo(),categoria.get());
		    servicio.insertar(libro);
			}
	
			
		model.addAttribute("listaLibros",servicio.buscarTodos());
		model.addAttribute("listaCategorias",servicio.buscarTodasLasCategorias());
		return "listalibros";
		
	}
	
	@GetMapping("/borrarlibro")
	public String borrarlibro (Model model, @RequestParam String isbn) {
	
		servicio.borrar(isbn);
		model.addAttribute("listaLibros",servicio.buscarTodos());
		model.addAttribute("listaCategorias",servicio.buscarTodasLasCategorias());
		
		return "listalibros";
		
	}
}
