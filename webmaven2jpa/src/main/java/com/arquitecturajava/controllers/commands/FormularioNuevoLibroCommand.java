package com.arquitecturajava.controllers.commands;

import java.util.List;

import com.arquitecturajava.models.Libro;
import com.arquitecturajava.repositories.LibroRepository;
import com.arquitecturajava.repositories.LibroRepositoryJDBC;
import com.arquitecturajava.repositories.LibroRepositoryJPA;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormularioNuevoLibroCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		LibroRepository repositorio=new LibroRepositoryJPA();	List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher despachador = request.getRequestDispatcher("formularionuevolibro.jsp");
		despachador.forward(request, response);
	}

}
