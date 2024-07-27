package com.arquitecturajava.repositories;

import java.util.List;

import com.arquitecturajava.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoriaRepositoryJPA implements CategoriaRepository {

	EntityManager em;

	public CategoriaRepositoryJPA() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		em = emf.createEntityManager();

	}

	@Override
	public List<Categoria> buscarTodasLasCategorias() {
		
		return em.createQuery("select c from Categoria c", Categoria.class).getResultList();

	}

}
