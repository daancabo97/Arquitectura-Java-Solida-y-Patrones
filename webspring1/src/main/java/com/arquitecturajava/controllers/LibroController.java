package com.arquitecturajava.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

@Controller
@RequestMapping("/controlador")
public class LibroController {

	List<Libro> listaLibros= new ArrayList<Libro>();
	List<Categoria> listaCategorias= new ArrayList<Categoria>();
	
	public LibroController() {
		listaLibros.add(new Libro("1D","PHP",new Categoria(1,"programacion")));
		listaLibros.add(new Libro("2D","Java",new Categoria(2,"web")));
		listaCategorias.add(new Categoria(1,"programacion"));
		listaCategorias.add(new Categoria(2,"web"));
		
	}
	@GetMapping("/listalibros")
	public String listaLibros(Model model) {
		model.addAttribute("listaLibros",listaLibros);
		model.addAttribute("listaCategorias",listaCategorias);
		return "listalibros";
		
		
	}
	
	@PostMapping("/filtrocategoria")
	public String filtrocategoria(Model model, @RequestParam int idCategoria) {
		
		List<Libro> listaFiltrada=listaLibros.stream().filter((l)->l.getCategoria().getId()==idCategoria).toList();
		System.out.println(listaFiltrada.size());
		model.addAttribute("listaLibros",listaFiltrada);
		model.addAttribute("listaCategorias",listaCategorias);
		return "listalibros";
		
		
	}
	@GetMapping("/formularionuevolibro")
	public String formularioNuevoLibro (Model model) {
		model.addAttribute("listaCategorias",listaCategorias);
		return "formularionuevolibro";
		
	}
	
	
	@PostMapping("/insertarlibro")
	public String insertarLibro (Model model, @ModelAttribute LibroForm libroForm) {
	    Optional<Categoria> oCategoria=listaCategorias.stream().filter(c->c.getId()==libroForm.getCategoria()).findFirst();
		if(oCategoria.isPresent()) {
		    Libro libro= new Libro(libroForm.getIsbn(),libroForm.getTitulo(),oCategoria.get());
		    listaLibros.add(libro);
		}
			
		model.addAttribute("listaLibros",listaLibros);
		model.addAttribute("listaCategorias",listaCategorias);
		return "listalibros";
		
	}
	
	@GetMapping("/borrarlibro")
	public String borrarlibro (Model model, @RequestParam String isbn) {
	
		listaLibros.remove(new Libro(isbn));
		model.addAttribute("listaCategorias",listaCategorias);
		model.addAttribute("listaLibros",listaLibros);
		return "listalibros";
		
	}
}
