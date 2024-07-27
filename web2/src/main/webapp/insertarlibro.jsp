<%@ page import="com.arquitecturajava.helpers.DatabaseHelper"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar Libro</title>
</head>
<body>

	<%
	String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");

			String consulta = "INSERT INTO libros (isbn, titulo, categoria) VALUES (?, ?, ?)";
		    DatabaseHelper.executeUpdate(consulta, isbn, titulo, categoria);
		    response.sendRedirect("listalibros.jsp");
	%>

</body>
</html>
