package com.curso.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class JdbcClienteDao implements ClienteDao {

	private static final String INSERT_CLIENTE = "INSERT INTO Cliente (id, nombre) VALUES (?, ?)";
	private static final String UPDATE_CLIENTE = "UPDATE Cliente SET nombre = ? WHERE id = ?";
	private static final String DELETE_CLIENTE = "DELETE FROM Cliente WHERE id = ?";
	private static final String SELECT_CLIENTE = "SELECT * FROM CLIENTE";
	private static final String SELECT_CLIENTE_BY_ID = "SELECT * FROM CLIENTE WHERE id = ?";

	private GestorTransaccional gt;

	public JdbcClienteDao(GestorTransaccional gt) {
		super();
		this.gt = gt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.curso.jdbc.ClienteDao#insertar(com.curso.jdbc.Cliente)
	 */
	@Override
	public int insertar(Cliente cliente) throws SQLException {
		// STEP 4: Define a query
		System.out.println("Inserting records into the table...");

		// Recuperamos la referencia al objeto connection,
		// que el servicio se ha encargado de crear
		Connection conn = gt.getCurrentConnection();

		PreparedStatement stmt = conn.prepareStatement(INSERT_CLIENTE);

		// STEP 5: Set Parameters
		stmt.setLong(1, cliente.getId());
		stmt.setString(2, cliente.getNombre());

		// STEP 6: Execute a query
		int numeroDeRegistrosAfectados = stmt.executeUpdate();

		if (numeroDeRegistrosAfectados <= 0) {
			throw new SQLException("Se deberia de haber obtenido al menos un registro");
		}

		System.out.println("Inserted records into the table...");

		return numeroDeRegistrosAfectados;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.curso.jdbc.ClienteDao#actualizar(com.curso.jdbc.Cliente)
	 */
	@Override
	public int actualizar(Cliente cliente) throws SQLException {
		// STEP 4: Define a query
		System.out.println("Updating records into the table...");

		Connection conn = gt.getCurrentConnection();

		PreparedStatement stmt = conn.prepareStatement(UPDATE_CLIENTE);

		// STEP 5: Set Parameters
		stmt.setString(1, cliente.getNombre());
		stmt.setLong(2, cliente.getId());

		// STEP 6: Execute a query
		int numeroDeRegistrosAfectados = stmt.executeUpdate();

		if (numeroDeRegistrosAfectados <= 0) {
			throw new SQLException("Se deberia de haber obtenido al menos un registro");
		}

		System.out.println("Updated records into the table...");

		return numeroDeRegistrosAfectados;
	}

	public int borrar(Long id) throws SQLException {
		// STEP 4: Define a query
		System.out.println("Deleting records into the table...");

		Connection conn = gt.getCurrentConnection();

		PreparedStatement stmt = conn.prepareStatement(DELETE_CLIENTE);

		// STEP 5: Set Parameters
		stmt.setLong(1, id);

		// STEP 6: Execute a query
		int numeroDeRegistrosAfectados = stmt.executeUpdate();

		if (numeroDeRegistrosAfectados <= 0) {
			throw new SQLException("Se deberia de haber obtenido al menos un registro");
		}

		System.out.println("Deleted records into the table...");

		return numeroDeRegistrosAfectados;
	}

	public Cliente consulta(Long id) throws SQLException {
		// STEP 4: Define a query
		System.out.println("Selecting records into the table...");

		Connection conn = gt.getCurrentConnection();

		PreparedStatement stmt = conn.prepareStatement(SELECT_CLIENTE_BY_ID);

		// STEP 5: Set Parameters
		stmt.setLong(1, id);

		// STEP 6: Execute a query
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			return new Cliente(rs.getLong("id"), rs.getString("nombre"));
		} else {
			return null;
		}
	}

	public Collection<Cliente> consulta() throws SQLException {
		
		Collection<Cliente> resultado = new LinkedList<>();
		
		// STEP 4: Define a query
		System.out.println("Selecting records into the table...");

		Connection conn = gt.getCurrentConnection();

		PreparedStatement stmt = conn.prepareStatement(SELECT_CLIENTE);

		// STEP 6: Execute a query
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			resultado.add(new Cliente(rs.getLong("id"), rs.getString("nombre")));
		}
		
		return resultado;
	}
}