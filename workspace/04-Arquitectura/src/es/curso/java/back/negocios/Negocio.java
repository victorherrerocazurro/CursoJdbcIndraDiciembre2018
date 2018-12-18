package es.curso.java.back.negocios;

import java.util.ArrayList;
import java.util.Collection;

import es.curso.java.back.entidades.Cliente;
import es.curso.java.front.modelos.ClienteDto;

public class Negocio {

	private Long id = 1l;
	
	/**
	 * Este metodo no genera el ID, el Id debera 
	 * venir establecido previamente
	 * @param cliente
	 * @return
	 */
	public Cliente transformarUnDtoEnCliente(ClienteDto cliente) {

		return new Cliente(null, cliente.getNombre(), cliente.getFechaAlta());
	}

	public ClienteDto transformarUnClienteEnDto(Cliente cliente) {

		return new ClienteDto(cliente.getNombre(), cliente.getFechaAlta());
	}

	public Long generarSiguienteId() {
		
		/*id = id + 1;
		id += 1;
		id++;
		++id;*/
		
		return id++;
	}

	public Collection<ClienteDto> transformarUnaColeccionDeClienteEnColeccionDeDto(Collection<Cliente> consulta) {

		ArrayList<ClienteDto> resultado = new ArrayList<>();
		
		for (Cliente cliente : consulta) {
			resultado.add(transformarUnClienteEnDto(cliente));
		}
		
		return resultado;
	}

}
