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
		
	LibroAR libroAR = new LibroAR(isbn);
	libroAR.borrar();
	response.sendRedirect("listalibros.jsp");
	%>

</body>
</html>
