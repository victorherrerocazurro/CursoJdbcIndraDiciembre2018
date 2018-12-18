package com.curso.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaInsertar {

	// Datos de prueba de entorno de ejecucion
	private String jdbcDriver = "org.apache.derby.jdbc.ClientDriver";
	private String dbUrl = "jdbc:derby://localhost:1527/sample;create=true";
	private String user = "user";
	private String password = "user";

	@Test
	public void test() {
		//Datos de prueba de entrada
		Cliente cliente = new Cliente(1l, "Victor");
		//Datos esperados
		int registrosAfectadosEsperados = 1;
		//SUT
		ClienteDao sut = new JdbcClienteDao(jdbcDriver, dbUrl, user, password);
		//Agitabamos el SUT
		int numeroDeRegistrosAfectados = sut.insertar(cliente);
		//Verificabamos
		assertEquals(registrosAfectadosEsperados, numeroDeRegistrosAfectados);
		//fail("Not yet implemented");
	}

}
