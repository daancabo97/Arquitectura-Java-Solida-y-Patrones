package com.arquitecturajava.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.arquitecturajava.dto.LibroDto;


@RestController
@RequestMapping("/webapi/libros")
public class LibroRestController {

	@GetMapping
	public List<LibroDto> buscarTodos() {
		
		RestTemplate plantilla= new RestTemplate();
		List<LibroDto> lista1=plantilla.getForObject("http://localhost:8081/webapi/libros", List.class);
		List<LibroDto> lista2=plantilla.getForObject("http://localhost:8082/webapi/libros",List.class);
		lista1.addAll(lista2);
		return lista1;
	}
	
	
}
