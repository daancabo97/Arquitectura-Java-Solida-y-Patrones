<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Libros</title>
</head>
<body>

<%
    try {
        // Configuración de la conexión JDBC
        String jdbcUrl = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contraseña = "";
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        // Utilizando try-with-resources para garantizar el cierre de recursos
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM libros")) {

            out.println("<h2>Lista de Libros</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");

            // Recorrer los resultados y mostrar en la tabla
            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String titulo = resultSet.getString("titulo");
                String categoria = resultSet.getString("categoria");

                out.println("<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria + "</td></tr>");
            }

            out.println("</table>");

        } catch (SQLException e) {
            out.println("<p>Error al obtener la lista de libros.</p>");
            e.printStackTrace();
        }

    } catch (Exception e) {
        out.println("<p>Error al procesar la solicitud.</p>");
        e.printStackTrace();
    }
%>
<a href="formularionuevolibro.jsp">Nuevo</a>
</body>
</html>
