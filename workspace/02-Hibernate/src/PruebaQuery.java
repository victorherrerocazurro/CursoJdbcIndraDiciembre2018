import java.util.List;

import modelo.Persona;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class PruebaQuery {

	public static void main(String[] args) {
		
		SessionFactory sf = HibUtil.getSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();

		Query q = s.createQuery("select p from Persona p");
		List<Persona> lista = q.list();
		
		for(Persona p: lista)
		{
			System.out.println(p.getNombre());
			p.setNombre("RINGO");
		}	
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
		
	}
	
	
}

















