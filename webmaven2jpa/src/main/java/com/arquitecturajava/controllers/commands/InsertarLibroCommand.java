package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.models.Libro;
import com.arquitecturajava.repositories.LibroRepository;
import com.arquitecturajava.repositories.LibroRepositoryJDBC;
import com.arquitecturajava.repositories.LibroRepositoryJPA;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertarLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		LibroRepository repositorio=new LibroRepositoryJPA();		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Libro libroAR = new Libro(isbn, titulo, categoria);
		repositorio.insertar(libroAR);
		List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
		List<Libro> listaLibros = repositorio.buscarTodos();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher despachador = request.getRequestDispatcher("listalibros.jsp");
		despachador.forward(request, response);
	
		
	}

}
