package com.arquitecturajava.models;

import java.util.ArrayList;
import java.util.List;


public class Categoria {

	private int id;
	private String nombre;

	private List<Libro> libros= new ArrayList<Libro>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Categoria(int id) {
		super();
		this.id = id;
	}
	public Categoria() {
		super();
	}
	
	
}
