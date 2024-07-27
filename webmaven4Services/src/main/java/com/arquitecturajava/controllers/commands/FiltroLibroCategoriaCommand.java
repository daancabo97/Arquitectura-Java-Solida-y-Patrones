package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.repositories.CategoriaRepository;
import com.arquitecturajava.repositories.CategoriaRepositoryJPA;
import com.arquitecturajava.repositories.LibroRepository;
import com.arquitecturajava.repositories.LibroRepositoryJPA;
import com.arquitecturajava.services.LibroService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroLibroCategoriaCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		LibroService servicio= new LibroService();
		
		List<Categoria> listaCategorias = servicio.buscarTodasLasCategoriasLibros();
		List<Libro> listaLibros = servicio.buscarTodosLosLibrosPorCategoria(request.getParameter("categoria"));
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
		despachador.forward(request, response);

	}

}
