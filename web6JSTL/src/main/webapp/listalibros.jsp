<%@ page import="java.sql.*"%>
<%@ page import="com.arquitecturajava.helpers.LibroAR"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
List<LibroAR> listaLibros = LibroAR.buscarTodos();
request.setAttribute("listaCategorias", listaCategorias);
request.setAttribute("listaLibros", listaLibros);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Libros</title>
</head>
<body>
	<select name='categoria'>
		<c:forEach var="categoria" items="${listaCategorias}">
			<option value="${categoria}">${categoria}</option>
		</c:forEach>
	</select>
	<h2>Listado de Libros</h2>
	<table border='1'>
		<tr>
			<th>ISBN</th>
			<th>Título</th>
			<th>Categoría</th>
		</tr>
		<c:forEach var="libro" items="${listaLibros}">
			<tr>
				<td>${libro.isbn}</td>
				<td>${libro.titulo}</td>
				<td>${libro.categoria}</td>
				<td><a href="borrarlibro.jsp?isbn=${libro.isbn}">borrar</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="formularionuevolibro.jsp">Nuevo</a>
</body>
</html>