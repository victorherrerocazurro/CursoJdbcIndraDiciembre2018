package es.curso.java.back.persistencias;

import java.util.HashMap;
import java.util.Map;

import es.curso.java.back.entidades.Cliente;

public class ClientesHashMap extends HashMap<Long, Cliente> {
	
	private static Map<Long, Cliente> instance 
						= new ClientesHashMap();

	private ClientesHashMap() {
		super();
	}

	public static Map<Long, Cliente> getInstance() {
		return instance ;
	}

	@Override
	public Cliente put(Long key, Cliente value) {
		
		System.out.println("Antes de invocar al padre");
		
		Cliente resultado = super.put(key, value);
		
		System.out.println("Despues de invocar al padre");
		
		System.out.println("Cliente: " + value);
//		System.out.println("Cliente: " + resultado.toString());
		
		return resultado;
	}
	
	
}
