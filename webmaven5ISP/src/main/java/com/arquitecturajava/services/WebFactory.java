package com.arquitecturajava.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.arquitecturajava.repositories.jpa.CategoriaRepositoryJPA;
import com.arquitecturajava.repositories.jpa.LibroRepositoryJPA;

public class WebFactory {

	public static LibroService getService() throws IOException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("/database.properties");
		Properties propiedades = new Properties();

		propiedades.load(input);

		if (propiedades.get("persistencia").equals("JPA")) {

			return new LibroService(new LibroRepositoryJPA(), new CategoriaRepositoryJPA());

		} else {

			return null ;// new LibroService(new LibroRepositoryJDBC(), new CategoriaRepositoryJDBC());
		}

	}
}
