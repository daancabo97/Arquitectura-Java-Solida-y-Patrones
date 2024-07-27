package com.arquitecturajava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;

public interface LibroRepository extends  JpaRepository<Libro, String>{

	public List<Libro> findByCategoria(Categoria Categoria);
	

}