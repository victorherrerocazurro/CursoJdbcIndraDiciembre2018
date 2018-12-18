package es.curso.java.back.persistencias;

import java.util.Collection;

import es.curso.java.back.entidades.Cliente;

public interface ClientesDao {

	/**
	 * Este metodo no genera el ID, el Id debera 
	 * venir establecido previamente
	 */
	void insertar(Cliente cliente);
	void actualizar(Cliente cliente);
	void borrar(Long id);
	void borrar(Cliente cliente);
	Cliente consulta(Long id);
	Collection<Cliente> consulta();
	
}
