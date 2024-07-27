<%@ page import="java.sql.*" %>

<%@ page import="com.arquitecturajava.helpers.LibroAR" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Libros</title>
</head>
<body>

<%
List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();

        // Mostrar el listado de libros en una tabla
        
            out.println("<select name='categoria'>");
            out.println("<table border='1'>");
        
            for (String categoria: listaCategorias) {
            	
            	  out.println("<option>" + categoria + "</option>");
            }


            out.println("</select>");


    // Obtener el listado de libros desde la base de datos
    String consulta = "SELECT * FROM libros";
       
     List<LibroAR> listaLibros = LibroAR.buscarTodos();

        // Mostrar el listado de libros en una tabla
        
            out.println("<h2>Listado de Libros</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");

            for (LibroAR libro: listaLibros) {
            	
                out.println("<tr><td>" + libro.getIsbn() 
                + "</td><td>" + libro.getTitulo() + 
                "</td><td>" + libro.getCategoria() +
                "</td></tr>");
                
          }
            

            out.println("</table>");
%>
<a href="formularionuevolibro.jsp">Nuevo</a>
</body>
</html>