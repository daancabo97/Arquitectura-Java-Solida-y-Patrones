package com.arquitecturajava.mappers;

import com.arquitecturajava.dto.LibroDto;
import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;

public class LibroMapper {

	public static LibroDto toDto(Libro libro) {

		return new LibroDto(libro.getIsbn(), libro.getTitulo(), libro.getCategoria().getId());
	}
	
	public static Libro toEntity(LibroDto libroDto) {

		return new Libro(libroDto.getIsbn(), libroDto.getTitulo(), new Categoria(libroDto.getCategoria()));
	}
}
