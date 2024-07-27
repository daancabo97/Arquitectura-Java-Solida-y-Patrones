package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.helpers.Libro;
import com.arquitecturajava.helpers.LibroRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroLibroCategoriaCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LibroRepository repositorio=new LibroRepository();
		List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
		List<Libro> listaLibros = repositorio.buscarTodosPorCategoria(request.getParameter("categoria"));
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
		despachador.forward(request, response);

		
	}

}
