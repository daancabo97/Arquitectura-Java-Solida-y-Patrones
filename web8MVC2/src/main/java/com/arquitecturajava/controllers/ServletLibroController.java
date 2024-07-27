package com.arquitecturajava.controllers;

import java.io.IOException;
import java.util.List;

import com.arquitecturajava.helpers.LibroAR;

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

		RequestDispatcher despachador = null;

		System.out.println(request.getParameter("accion"));
		try {
			if (request.getParameter("accion") == null) {

				listaLibros(request, response);

			} else if (request.getParameter("accion").equals("formularionuevolibro")) {

				List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();

				request.setAttribute("listaCategorias", listaCategorias);
				despachador = request.getRequestDispatcher("formularionuevolibro.jsp");
				despachador.forward(request, response);
			} else if (request.getParameter("accion").equals("insertarlibro")) {

				String isbn = request.getParameter("isbn");
				String titulo = request.getParameter("titulo");
				String categoria = request.getParameter("categoria");
				LibroAR libroAR = new LibroAR(isbn, titulo, categoria);
				libroAR.insertar();
				listaLibros(request, response);
			} else if (request.getParameter("accion").equals("borrarlibro")) {

				String isbn = request.getParameter("isbn");

				LibroAR libroAR = new LibroAR(isbn);
				libroAR.borrar();
				listaLibros(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	private void listaLibros(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException, IOException {
		RequestDispatcher despachador;
		List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
		List<LibroAR> listaLibros = LibroAR.buscarTodos();
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
