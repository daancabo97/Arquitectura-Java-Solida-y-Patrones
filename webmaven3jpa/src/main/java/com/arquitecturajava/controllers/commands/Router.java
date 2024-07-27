package com.arquitecturajava.controllers.commands;

import java.util.HashMap;
import java.util.Map;

public class Router {

	private static Map<String,Command> mapa= new HashMap<String,Command>();
	static {
		mapa.put("inicio",  new ListaLibrosCommand());
		mapa.put("listalibro", new ListaLibrosCommand());
		mapa.put("formularionuevolibro", new FormularioNuevoLibroCommand());
		mapa.put("insertarlibro", new InsertarLibroCommand());
		mapa.put("borrarlibro", new BorrarLibroCommand());
		mapa.put("filtrocategorialibro", new FiltroLibroCategoriaCommand());
		
	}
	
	public static Command getCommand(String nombreComando) {
		
		if (nombreComando==null) {
			
			return mapa.get("inicio");
		}else {
		
			return mapa.get(nombreComando);
		}
	}
}
