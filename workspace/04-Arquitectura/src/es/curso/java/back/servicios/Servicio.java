package es.curso.java.back.servicios;

import java.util.Collection;

import es.curso.java.back.negocios.Negocio;
import es.curso.java.back.persistencias.ClientesDao;
import es.curso.java.front.modelos.ClienteDto;

public interface Servicio {

	void setNegocio(Negocio negocio);

	void setPersistencia(ClientesDao persistencia);

	void altaCliente(ClienteDto cliente);
	
	void modificarCliente(ClienteDto cliente);
	
	void borrarClientePorId(Long id);
	
	ClienteDto obtenerClientePorId(Long id);
	
	Collection<ClienteDto> obtenerTodosLosClientes();
}