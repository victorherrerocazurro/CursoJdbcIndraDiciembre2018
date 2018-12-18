package es.curso.java;

import es.curso.java.front.controladores.Controlador;

public class Aplicacion {

	public static void main(String[] args) {
		
		ContenedorDeLosChinos contenedorDeLosChinos 
						= new ContenedorDeLosChinos();
		
		Controlador controlador 
			= contenedorDeLosChinos.getControlador();

		Controlador controlador2 
		= contenedorDeLosChinos.getControlador();
	
		
	}
	
	
	
	
	
	
}
