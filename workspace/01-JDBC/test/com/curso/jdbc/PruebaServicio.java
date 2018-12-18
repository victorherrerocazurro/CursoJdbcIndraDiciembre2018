package com.curso.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class PruebaServicio {

	private String jdbcDriver = "org.apache.derby.jdbc.ClientDriver";
	private String dbUrl = "jdbc:derby://localhost:1527/sample;create=true";
	private String user = "user";
	private String password = "user";
	
	@Before
	public void init() throws ClassNotFoundException, SQLException {
		//Preparar el entorno de ejecucion del test
		
		//En este caso significa borrar el registro con id 1
		GestorTransaccional gt = new GestorTransaccional(jdbcDriver, dbUrl, user, password);
		JdbcClienteDao dao = new JdbcClienteDao(gt);
		gt.openTransaction();
		dao.borrar(1l);
		dao.borrar(2l);
		gt.commit();
	}
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		// Datos de prueba de entorno de ejecucion
		GestorTransaccional gt = new GestorTransaccional(jdbcDriver, dbUrl, user, password);
		ClienteDao clienteDao = new JdbcClienteDao(gt);
		// Datos de prueba de entrada
		Cliente cliente1 = new Cliente(1l, "Victor");
		Cliente cliente2 = new Cliente(2l, "Juan");
		// Datos esperados
		String nombreCliente1Esperado = "Pepe";
		// SUT
		Servicio sut = new Servicio(gt, clienteDao);
		// Agitabamos el SUT
		sut.realizarDosInsercionesYUnaActualizacionEnUnaUnicaTx(cliente1, cliente2, nombreCliente1Esperado);
		// Verificabamos
		GestorTransaccional gt1 = new GestorTransaccional(jdbcDriver, dbUrl, user, password);
		JdbcClienteDao dao = new JdbcClienteDao(gt1);
		gt1.openTransaction();
		Cliente cliente1Obtenido = dao.consulta(1l);
		Cliente cliente2Obtenido = dao.consulta(2l);
		gt1.commit();
		
		assertEquals(nombreCliente1Esperado,cliente1Obtenido.getNombre());
		assertEquals("Juan",cliente2Obtenido.getNombre());
	}

}
