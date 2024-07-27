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
    <input type="text" name="categoria" required><br>

    <input type="submit" value="Guardar Libro">
</form>

</body>
</html>

