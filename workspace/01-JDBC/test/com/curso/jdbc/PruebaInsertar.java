package com.curso.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class PruebaInsertar {

	// Datos de prueba de entorno de ejecucion
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
		gt.commit();
	}
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		// Datos de prueba de entorno de ejecucion
		GestorTransaccional gt = new GestorTransaccional(jdbcDriver, dbUrl, user, password);
		
		//Datos de prueba de entrada
		Cliente cliente = new Cliente(1l, "Victor");
		
		//Datos esperados
		int registrosAfectadosEsperados = 1;
		
		//SUT		
		ClienteDao sut = new JdbcClienteDao(gt);
		
		//Agitabamos el SUT
		
		gt.openTransaction();
		
		int numeroDeRegistrosAfectados = sut.insertar(cliente);
		
		gt.commit();
		
		//Verificabamos
		assertEquals(registrosAfectadosEsperados, numeroDeRegistrosAfectados);
		//fail("Not yet implemented");
	}

}
