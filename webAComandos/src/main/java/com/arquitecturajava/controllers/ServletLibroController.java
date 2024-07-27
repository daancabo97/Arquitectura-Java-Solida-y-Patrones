package com.arquitecturajava.controllers;

import java.io.IOException;
import java.util.List;

import com.arquitecturajava.controllers.commands.BorrarLibroCommand;
import com.arquitecturajava.controllers.commands.Command;
import com.arquitecturajava.controllers.commands.FiltroLibroCategoriaCommand;
import com.arquitecturajava.controllers.commands.FormularioNuevoLibroCommand;
import com.arquitecturajava.controllers.commands.InsertarLibroCommand;
import com.arquitecturajava.controllers.commands.ListaLibrosCommand;
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

	
		Command comando = null;
		System.out.println(request.getParameter("accion"));
		try {
			if (request.getParameter("accion") == null) {

			comando= new ListaLibrosCommand();
		

			} else if (request.getParameter("accion").equals("filtrocategorialibro")) {

				
				comando= new FiltroLibroCategoriaCommand();
				
				
				
			} else if (request.getParameter("accion").equals("formularionuevolibro")) {

			
				comando= new FormularioNuevoLibroCommand();
				
			} else if (request.getParameter("accion").equals("insertarlibro")) {

				
				comando= new InsertarLibroCommand();
				
			} else if (request.getParameter("accion").equals("borrar")) {

				comando= new BorrarLibroCommand();
			}
			comando.execute(request, response);

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	private void listaLibros(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException, IOException {
		RequestDispatcher despachador;
		LibroRepository repositorio = new LibroRepository();
		List<String> listaCategorias = repositorio.buscarTodasLasCategorias();
		List<Libro> listaLibros = repositorio.buscarTodos();
		request.setAttribute("listaCategorias", listaCategorias);
		request.setAttribute("listaLibros", listaLibros);
		despachador = request.getRequestDispatcher("listalibros.jsp");
		despachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
