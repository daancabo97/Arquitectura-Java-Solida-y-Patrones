package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.services.LibroService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormularioNuevoLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		LibroService servicio= new LibroService();
		List<Categoria> listaCategorias = servicio.buscarTodasLasCategoriasLibros();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher despachador = request.getRequestDispatcher("formularionuevolibro.jsp");
		despachador.forward(request, response);
	}

}
