package es.curso.java.back.entidades;

import java.util.Date;

public class Cliente {

	//Atributos
	private Long id;
	private String nombre;
	private Date fechaAlta;

	//Constructores
	public Cliente() {
		super();
	}

	public Cliente(Long id, String nombre, Date fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + "]";
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
