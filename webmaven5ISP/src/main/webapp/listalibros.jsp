

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Libros</title>
</head>
<body>
	<form>
	<select name='categoria'>
		<c:forEach var="categoria" items="${listaCategorias}">
			<option value="${categoria.id}">${categoria.nombre}</option>
		</c:forEach>
	</select>
	<input type="submit" value="filtrar"/>
	<input type="hidden" name="accion" value="filtrocategorialibro"/>
	</form>
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
				<td>${libro.categoria.nombre}</td>
				<td><a href="?accion=borrarlibro&isbn=${libro.isbn}">borrar</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="?accion=formularionuevolibro">Nuevo</a>
</body>
</html>