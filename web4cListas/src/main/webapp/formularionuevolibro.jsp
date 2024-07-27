<%@ page import="java.sql.*" %>
<%@ page import="com.arquitecturajava.helpers.LibroAR" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Libro</title>
</head>
<body>

<h2>Formulario de Libro</h2>
<form method="post" action="insertarlibro.jsp">
    <label for="isbn">ISBN:</label>
    <input type="text" name="isbn" required><br>

    <label for="titulo">Titulo:</label>
    <input type="text" name="titulo" required><br>

    <label for="categoria">Categoria:</label>
   <%
   try {
           
           ArrayList<String> listaCategorias = LibroAR.buscarTodasLasCategorias();

           // Mostrar el listado de libros en una tabla
           
               out.println("<select name='categoria'>");
               out.println("<table border='1'>");
           
               for (String categoria: listaCategorias) {
               	
               	  out.println("<option>" + categoria + "</option>");
               }


               out.println("</select>");

           // Cerrar la conexión y el PreparedStatement
           //DatabaseHelper.close(connection, preparedStatement, resultSet);

       } catch (Exception e) {
           out.println("<p>Error al obtener las categorias</p>");
           e.printStackTrace();
       }
   %>

    <input type="submit" value="Guardar Libro">
</form>

</body>
</html>

