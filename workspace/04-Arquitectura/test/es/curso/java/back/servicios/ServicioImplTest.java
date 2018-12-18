package es.curso.java.back.servicios;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;

import es.curso.java.back.negocios.Negocio;
import es.curso.java.back.persistencias.ClientesDao;
import es.curso.java.back.persistencias.MapClientesDao;
import es.curso.java.front.modelos.ClienteDto;

public class ServicioImplTest {

	@Test
	public void test() {
		
		ClientesDao persistencia = new MapClientesDao();
		Negocio negocio = new Negocio();
		ServicioImpl sut = new ServicioImpl(negocio, persistencia);
		
		sut.altaCliente(new ClienteDto("Victor", new Date()));
		sut.altaCliente(new ClienteDto("Juan", new Date()));
		sut.altaCliente(new ClienteDto("Maria", new Date()));
		sut.altaCliente(new ClienteDto("Pedro", new Date()));
		sut.altaCliente(new ClienteDto("Laura", new Date()));
		
		Collection<ClienteDto> clientes 
					= sut.obtenerTodosLosClientes();
		
		System.out.println(clientes);
		
		assertEquals(5, clientes.size());
		
		//fail("Not yet implemented");
	}

}
