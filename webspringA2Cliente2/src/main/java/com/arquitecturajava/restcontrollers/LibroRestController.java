package com.arquitecturajava.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.arquitecturajava.dto.LibroDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/webapi/libros")
public class LibroRestController {

	@GetMapping
	public Flux<LibroDto[]> buscarTodos() {
		
	
		WebClient cliente1 = WebClient.create("http://localhost:8081/webapi/libros");
	    Mono<LibroDto[]> libros1=cliente1.get().retrieve().bodyToMono(LibroDto[].class);
		WebClient cliente2 = WebClient.create("http://localhost:8082/webapi/libros");
	    Mono<LibroDto[]> libros2=cliente2.get().retrieve().bodyToMono(LibroDto[].class);
	
	    
	    Flux<LibroDto[]> todosLosLibros=Flux.merge(libros1,libros2);
	  
	    return todosLosLibros;
		
	}
	
	
}
