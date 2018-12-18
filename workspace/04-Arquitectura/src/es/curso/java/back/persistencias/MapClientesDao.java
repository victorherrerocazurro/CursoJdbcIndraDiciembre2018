package es.curso.java.back.persistencias;


import java.util.Collection;
import java.util.Map;

import es.curso.java.back.entidades.Cliente;

public class MapClientesDao implements ClientesDao {

	private Map<Long, Cliente> tablaClientes 
			= ClientesHashMap.getInstance();

	/**
	 * Este metodo no genera el ID, el Id debera 
	 * venir establecido previamente
	 */
	@Override
	public void insertar(Cliente cliente) {
		//Comentario de linea
		/*
		  
		  zxfgadgasdga
		  sgsdfg
		  adsfg
		  adfgadfg
		  
		  
		 */
		tablaClientes.put(cliente.getId(), cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		tablaClientes.replace(cliente.getId(), cliente);	
	}

	@Override
	public void borrar(Long id) {
		tablaClientes.remove(id);
	}

	@Override
	public void borrar(Cliente cliente) {
		tablaClientes.remove(cliente.getId());
	}

	@Override
	public Cliente consulta(Long id) {
		return tablaClientes.get(id);
	}

	@Override
	public Collection<Cliente> consulta() {
		return tablaClientes.values();
	}
	
	
	
	
}
