package com.arquitecturajava.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class CategoriaRepositoryJPA implements CategoriaRepository {
	@PersistenceContext
	EntityManager em;

	public CategoriaRepositoryJPA() {

	
	}

	@Override
	public List<Categoria> buscarTodasLasCategorias() {

		return em.createQuery("select  c from Categoria c", Categoria.class).getResultList();

	}

	@Override
	public Categoria buscarUno(int id) {
		// TODO Auto-generated method stub
		return em.find(Categoria.class, id);
	}

}
