window.onload = function() {

	$("#formulario").hide();
	
	$("#verformulario").click(function(e) {
		$("#formulario").show();
		$("#lista").hide();
		e.preventDefault();
	})
	$("#botonguardar").click(function(e) {
		insertarLibro().then(() => {

			return cargarlibros();
		}).then(function(libros) {
			$("tr").remove();
			libros
			.map(l => `<tr><td>${l.isbn}</td><td>${l.titulo}</td>`)
			.forEach(fila => $("#tablalibros").append(fila));
			
			$("#formulario").hide();
			$("#lista").show();
		});
		e.preventDefault();
	});
	cargarlibros().then(function(libros) {

		libros
			.map(l => `<tr><td>${l.isbn}</td><td>${l.titulo}</td>`)
			.forEach(fila => $("#tablalibros").append(fila));
	})

	cargarCategorias().then(function(categorias) {
		categorias
			.map(c => `<option value='${c.id}'>${c.nombre}</option>`)
			.forEach(option => $("#categoria").append(option));
	})
}

async function cargarlibros() {

	const respuesta = await fetch("/webapi/libros");
	const libros = await respuesta.json();
	return libros;

}
async function cargarCategorias() {

	const respuesta = await fetch("/webapi/libros/categorias");
	const categorias = await respuesta.json();
	return categorias;

}
async function insertarLibro() {
	const respuesta = await fetch("/webapi/libros", {
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		method: "POST",
		body: JSON.stringify({ isbn: $("#isbn").val(), titulo: $("#titulo").val(), categoria: $("#categoria").val() })
	});
}



