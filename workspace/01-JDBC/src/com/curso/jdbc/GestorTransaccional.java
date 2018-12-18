package com.curso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorTransaccional {

	// JDBC driver name and database URL
	private String dbUrl;

	// Database credentials
	private String user;
	private String password;

	private Connection conn;

	public GestorTransaccional(String jdbcDriver, String dbUrl, String user, String password)
			throws ClassNotFoundException {
		super();
		this.dbUrl = dbUrl;
		this.user = user;
		this.password = password;

		// STEP 2: Register JDBC driver
		Class.forName(jdbcDriver);
	}

	public void openTransaction() throws SQLException {
		// Abrir una tx
		// STEP 3: Open a connection
		System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(dbUrl, user, password);
		conn.setAutoCommit(false);
		System.out.println("Connected database successfully...");
	}

	public Connection getCurrentConnection() {
		return conn;
	}

	public void commit() throws SQLException {
		conn.commit();
		close();
	}

	public void rollback(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
	}

	private void close() {
		try {
			if(conn != null) {
				conn.close();
			} else {
				System.out.println("Se ha intentado cerrar una conexion nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
