import java.util.Scanner;

import modelo.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PruebaDetached {

	public static void main(String[] args) {
		
		SessionFactory sf = HibUtil.getSessionFactory();

	
		sf.openStatelessSession();
		
		Session s = sf.openSession();
		s.beginTransaction();

		Persona p = (Persona) s.get(Persona.class, 1);
		Persona p2 = (Persona) s.get(Persona.class,2);
		p.setNombre("Ringo");
		
		s.evict(p);	
		
		s.getTransaction().commit();
		s.close();
		
		//Otra session
		s = sf.openSession();
		s.beginTransaction();

		Persona pAux = (Persona) s.get(Persona.class,2);
				
		p2.setNombre("FRY");
		
		//s.update(p2);
		p2 = (Persona) s.merge(p2);
		
		p2.setNombre("Atriquitraun");
		
		
		s.getTransaction().commit();		
		
		
		
		
		
		
		
		
		
		sf.close();
		
		
	}
	
	
}

















