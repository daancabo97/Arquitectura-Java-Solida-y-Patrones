package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;
import com.arquitecturajava.services.LibroService;
import com.arquitecturajava.services.WebFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String isbn = request.getParameter("isbn");
		LibroService servicio= WebFactory.getService();
		servicio.borrarLibro(isbn);
		List<Categoria> listaCategorias = servicio.buscarTodasLasCategoriasLibros();
		List<Libro> listaLibros = servicio.buscarTodosLosLibros();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
		despachador.forward(request, response);
	
	}

}
