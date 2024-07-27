<%@ page import="java.sql.*" %>
<%@ page import="com.arquitecturajava.helpers.DatabaseHelper" %>
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
    // Obtener el listado de libros desde la base de datos
            String consultaCategoria = "SELECT distinct(categoria) FROM libros";
        	ResultSet resultSet=null;
            try {
                resultSet = DatabaseHelper.executeQuery(consultaCategoria);

                // Mostrar el listado de libros en una tabla
                
                    out.println("<select name='categoria'>");
                    out.println("<table border='1'>");
                

                    while (resultSet.next()) {
                        String categoria = resultSet.getString("categoria");

                        out.println("<option>" + categoria + "</option>");
                    }

                    out.println("</select><br/>");

              
            } catch (Exception e) {
                out.println("<p>Error al obtener las categorias</p>");
                e.printStackTrace();
            }  finally {
        		// Cerrar la conexión y el PreparedStatement
        		DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);

        	}
    %>

    <input type="submit" value="Guardar Libro">
</form>

</body>
</html>

