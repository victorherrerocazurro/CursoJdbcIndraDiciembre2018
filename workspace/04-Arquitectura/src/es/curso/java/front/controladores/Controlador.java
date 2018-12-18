package es.curso.java.front.controladores;

import es.curso.java.back.servicios.Servicio;
import es.curso.java.front.vistas.Vista;

public class Controlador {

	private Servicio servicio = null;
	private Vista vista;

	/*public Controlador() {
		super();
	}*/

	//Patron inyeccion de dependencias por constructor
	public Controlador(Servicio servicio, Vista vista) {
		super();
		this.servicio = servicio;
		this.vista = vista;
	}

	//Patron inyeccion de dependencias por setter
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}
	
	
	/*public void metodo() {
		servicio.hazAlgoPorMi();
	}*/
	
	
}
