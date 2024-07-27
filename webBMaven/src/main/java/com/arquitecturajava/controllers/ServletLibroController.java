package com.arquitecturajava.controllers;

import java.io.IOException;
import java.util.List;

import com.arquitecturajava.controllers.commands.BorrarLibroCommand;
import com.arquitecturajava.controllers.commands.Command;
import com.arquitecturajava.controllers.commands.FiltroLibroCategoriaCommand;
import com.arquitecturajava.controllers.commands.FormularioNuevoLibroCommand;
import com.arquitecturajava.controllers.commands.InsertarLibroCommand;
import com.arquitecturajava.controllers.commands.ListaLibrosCommand;
import com.arquitecturajava.controllers.commands.Router;
import com.arquitecturajava.helpers.Libro;
import com.arquitecturajava.helpers.LibroRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controlador")
public class ServletLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLibroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("accion"));
		try {
			
				
		Router.getCommand(request.getParameter("accion")).execute(request, response);

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}


}
