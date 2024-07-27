window.onload = function() {

cargarlibros();

}

async function cargarlibros() {

	const respuesta = await fetch("/webapi/libros");
	const libros = await respuesta.json();
	console.log(respuesta);
}