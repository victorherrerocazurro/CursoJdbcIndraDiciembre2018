package es.curso.java;

import es.curso.java.back.negocios.Negocio;
import es.curso.java.back.persistencias.ClientesDao;
import es.curso.java.back.persistencias.JdbcClientesDao;
import es.curso.java.back.persistencias.MapClientesDao;
import es.curso.java.back.servicios.Servicio;
import es.curso.java.back.servicios.ServicioImpl;
import es.curso.java.front.controladores.Controlador;
import es.curso.java.front.vistas.Vista;

public class ContenedorDeLosChinos {

	private Controlador controlador;

	//Cumplir el patron factoria
	//-TODO Seras el responsable de crear un 
	//objeto de tipo Servicio
	//-TODO Seras el responsable de crear un 
	//objeto de tipo Vista
	//-TODO Seras el responsable de crear un 
	//objeto de tipo Negocio
	//-TODO Seras el responsable de crear un 
	//objeto de tipo Persistencia
	//-TODO Seras el responsable de crear un 
	//objeto de tipo Controlador
	public ContenedorDeLosChinos() {
		super();
		
		Negocio negocio = new Negocio();
		
		//ClientesDao persistencia = new MapClientesDao();
		ClientesDao persistencia = new JdbcClientesDao();
		
		Vista vista = new Vista();
		
		Servicio servicio = new ServicioImpl();
		
		//Implementar el contexto (la preentacion de 
		//los componentes)
		servicio.setNegocio(negocio);
		
		servicio.setPersistencia(persistencia);

		controlador = new Controlador(servicio, vista);
	}
	
	public Controlador getControlador() {
		return controlador;
	}
}
