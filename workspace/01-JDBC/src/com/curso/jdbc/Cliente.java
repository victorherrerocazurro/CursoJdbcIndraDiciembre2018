package com.curso.jdbc;

public class Cliente {
	private Long id;
	private String nombre;
	public Cliente(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Cliente() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + "]";
	}
}
