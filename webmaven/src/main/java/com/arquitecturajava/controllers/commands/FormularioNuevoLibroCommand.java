package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.helpers.Libro;
import com.arquitecturajava.helpers.LibroRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormularioNuevoLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		LibroRepository repositorio=new LibroRepository();
		List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher despachador = request.getRequestDispatcher("formularionuevolibro.jsp");
		despachador.forward(request, response);
	}

}
