package com.arquitecturajava.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.models.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class LibroRepositoryJPA implements LibroRepository {

	@PersistenceContext
	EntityManager em;

	public LibroRepositoryJPA() {

	}

	@Override
	public void insertar(Libro libro) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(libro);
		t.commit();
	}

	@Override
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

	@Override
	public void borrar(String isbn) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.merge(new Libro(isbn)));
		t.commit();

	}

}
