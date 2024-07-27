package com.arquitecturajava.repositories;

import java.util.List;

import com.arquitecturajava.models.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LibroRepositoryJPA implements LibroRepository {
	
	
	EntityManager em;
	

	
	
	public LibroRepositoryJPA() {
	
		
		 EntityManagerFactory emf =
		            Persistence.createEntityManagerFactory("biblioteca");
		         em = emf.createEntityManager();

	}

	@Override
	public void insertar(Libro libro) {
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(libro);
		t.commit();
	}

	@Override
	public List<Libro> buscarTodos() {
		// TODO Auto-generated method stub
		return em.createQuery("select l from Libro l join fetch l.categoria",Libro.class).getResultList();
	}


	@Override
	public List<Libro> buscarTodosPorCategoria(String idCategoria) {
		// TODO Auto-generated method stub
		 TypedQuery<Libro> query=em.createQuery("select l from Libro l where l.categoria.id=:id",Libro.class);
		 query.setParameter("id", idCategoria);
		 return query.getResultList();
		}

	@Override
	public void borrar(String isbn) {
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.remove(em.merge(new Libro(isbn)));
		t.commit();
		
	}

}
