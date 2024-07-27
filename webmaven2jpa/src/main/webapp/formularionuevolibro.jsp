<%@ page import="java.sql.*" %>
<%@ page import="com.arquitecturajava.repositories.LibroRepositoryJDBC" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Libro</title>
</head>
<body>

<h2>Formulario de Libro</h2>
<form method="post" action="controlador">
    <label for="isbn">ISBN:</label>
    <input type="text" name="isbn" required><br/>

    <label for="titulo">Titulo:</label>
    <input type="text" name="titulo" required><br/>

    <label for="categoria">Categoria:</label>
    <select name='categoria'>
		<c:forEach var="categoria" items="${listaCategorias}">
			<option value="${categoria}">${categoria}</option>
		</c:forEach>
	</select>
	<input type="hidden" name="accion" value="insertarlibro"/>
    <input type="submit" value="Guardar Libro">
</form>

</body>
</html>

