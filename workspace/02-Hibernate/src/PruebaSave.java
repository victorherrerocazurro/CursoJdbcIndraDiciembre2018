import modelo.Persona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class PruebaSave {

	public static void main(String[] args) {
		
		SessionFactory sf = HibUtil.getSessionFactory();

		Persona p = new Persona(0,"Nombre","C/Barquillo",10,12345);
		
		Session s = sf.openSession();
		//s.beginTransaction();
		Transaction tx = s.getTransaction();
		tx.begin();
		
		Integer id = (Integer) s.save(p);
		
		p.setNombre("Jacinto");
		//s.update(p);	
		
		//s.getTransaction().commit();
		tx.commit();
		s.close();
		sf.close();
		
		
	}
	
	
}

















