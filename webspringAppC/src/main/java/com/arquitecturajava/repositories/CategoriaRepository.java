package com.arquitecturajava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitecturajava.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

}
