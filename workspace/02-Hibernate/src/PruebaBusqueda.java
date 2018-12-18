import java.util.Scanner;

import modelo.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class PruebaBusqueda {

	public static void main(String[] args) {
		
		SessionFactory sf = HibUtil.getSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();

		Persona p = (Persona) s.get(Persona.class, 2);
		p.setNombre("BENDER BENDING RODRIGUEZ");
		
		Persona p2 = (Persona) s.get(Persona.class, 2);
		System.out.println(p2.getNombre());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Pulse intro.");
		String linea = sc.nextLine();
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
		
	}
	
	
}

















