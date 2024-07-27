<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Guardar Libro</title>
</head>
<body>

<%
    // Obtener parámetros del formulario
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");
    Class.forName("com.mysql.cj.jdbc.Driver");
    try {
        // Configuración de la conexión JDBC
        String jdbcUrl = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contraseña = "";
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Utilizando try-with-resources para garantizar el cierre de recursos
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)")) {

            // Establecer los parámetros de la consulta
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, titulo);
            preparedStatement.setString(3, categoria);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();
            //out.println("<p>Libro insertado exitosamente.</p>");
            response.sendRedirect("listalibros.jsp");

        } catch (SQLException e) {
            out.println("<p>Error al insertar el libro.</p>");
            e.printStackTrace();
        }

    } catch (Exception e) {
        out.println("<p>Error al procesar el formulario.</p>");
        e.printStackTrace();
    }
%>

</body>
</html>
