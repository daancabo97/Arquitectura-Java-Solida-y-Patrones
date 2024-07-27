window.onload = function() {

	cargarCategorias().then(function(categorias) {

		categorias
			.map(c => `<option value='${c.id}'>${c.nombre}</option>`)
			.forEach(option => $("#categoria").append(option));
	})

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
		body: JSON.stringify({ isbn: $("#isbn").val(), titulo: $("#titulo").val(), categoria: $("#categoria").val()})
	});
	
}

function salvarLibro() {
	
	insertarLibro().then(()=>location.href = 'lista.html');
	
}

