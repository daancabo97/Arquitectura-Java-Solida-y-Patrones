package com.arquitecturajava.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.models.Categoria;
import com.arquitecturajava.models.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class LibroRepositoryJPA implements LibroRepository {

	@PersistenceContext
	EntityManager em;

	public LibroRepositoryJPA() {

	}

	public Libro buscarUno(String isbn) {
		
		return em.find(Libro.class, isbn);
	}
	
	
	@Transactional
	public void insertar(Libro libro) {
		
		em.persist(libro);
	
	}

	
	public List<Libro> buscarTodos() {
		// TODO Auto-generated method stub
		return em.createQuery("select l from Libro l", Libro.class).getResultList();
	}

	@Override
	public List<Libro> buscarTodosPorCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.categoria.id=:idCategoria",
				Libro.class);
		query.setParameter("idCategoria", idCategoria);
		return query.getResultList();
	}

	@Transactional
	public void borrar(String isbn) {
	
		em.remove(em.merge(new Libro(isbn)));
	

	}

}
