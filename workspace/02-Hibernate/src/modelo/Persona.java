package modelo;

public class Persona {

	private int idPersona;
	private String nombre;
	private String direccion;
	private float altura;
	private long telefono;
		
	public Persona() {
		super();
	}
	
	public Persona(int idPersona, String nombre, String direccion,
			float altura, long telefono) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.direccion = direccion;
		this.altura = altura;
		this.telefono = telefono;
	}



	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	
}
