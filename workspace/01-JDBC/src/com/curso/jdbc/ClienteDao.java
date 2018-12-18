package com.curso.jdbc;

import java.sql.SQLException;

public interface ClienteDao {

	int insertar(Cliente cliente) throws SQLException;

	int actualizar(Cliente cliente) throws SQLException;

}