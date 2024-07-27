<%@ page import="java.sql.*"%>
<%@ page import="com.arquitecturajava.helpers.DatabaseHelper"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Libros</title>
</head>
<body>

	<%
	// Obtener el listado de libros desde la base de datos
			String consulta = "SELECT * FROM libros";
			ResultSet resultSet = null;
			try {

		resultSet = DatabaseHelper.executeQuery(consulta);

		// Mostrar el listado de libros en una tabla

		out.println("<h2>Listado de Libros</h2>");
		out.println("<table border='1'>");
		out.println("<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");

		while (resultSet.next()) {
			String isbn = resultSet.getString("isbn");
			String titulo = resultSet.getString("titulo");
			String categoria = resultSet.getString("categoria");

			out.println("<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria + "</td></tr>");
		}

		out.println("</table>");

			} catch (Exception e) {
		out.println("<p>Error al obtener el listado de libros.</p>");
		e.printStackTrace();
			} finally {
		// Cerrar la conexión y el PreparedStatement
		DatabaseHelper.close(resultSet.getStatement().getConnection(), resultSet.getStatement(), resultSet);

			}
	%>
	<a href="formularionuevolibro.jsp">Nuevo</a>
</body>
</html>