package es.curso.java.front.modelos;

import java.util.Date;

public class ClienteDto {

	private String nombre;
	private Date fechaAlta;
	
	public ClienteDto() {
		super();
	}

	public ClienteDto(String nombre, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
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

	@Override
	public String toString() {
		return "ClienteDto [nombre=" + nombre + ", fechaAlta=" + fechaAlta + "]";
	}

}
