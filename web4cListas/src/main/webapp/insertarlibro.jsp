<%@ page import="com.arquitecturajava.helpers.LibroAR"%>
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
		LibroAR libroAR= new LibroAR(isbn,titulo,categoria);
		libroAR.insertar();
		response.sendRedirect("listalibros.jsp");
	%>

</body>
</html>
