window.onload = function() {

cargarlibros().then(function(libros) {
	
	libros
	.map(l=>`<tr><td>${l.isbn}</td><td>${l.titulo}</td>`)
	.forEach(fila=>$("#tablalibros").append(fila));
})

}

async function cargarlibros() {

	const respuesta = await fetch("/webapi/libros");
	const libros = await respuesta.json();
	return libros;
	
}

