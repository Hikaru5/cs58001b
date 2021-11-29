package problem1b;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			Product produce = new Product("Potato");
			
			session.save(produce);
			

			Order order1 = new Order(new Date(12/21/21),"John Smith");
			Order order2 = new Order(new Date(11/24/21),"Tom Pilgrim");
			
			produce.addOrder(order1);
			produce.addOrder(order1);
			
			session.save(order1);
			session.save(order2);
		}catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }finally {
			session.close();
			factory.close();
		}
		
	}

}
