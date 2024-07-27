package com.arquitecturajava.repositories;

import java.util.List;

import com.arquitecturajava.models.Categoria;

public interface CategoriaRepository {

	List<Categoria> buscarTodasLasCategorias(); 
}
