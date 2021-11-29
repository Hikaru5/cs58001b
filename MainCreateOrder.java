package problem1b;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Order order = new Order(new Date(12/21/21),"John Smith");
			
			session.save(order);
			
			
			Product item1 = new Product("Potato");
			Product item2 = new Product("Tomato");
			
			order.addProduct(item1);
			order.addProduct(item2);
			
			session.save(item1);
			session.save(item2);
		}catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }finally {
			session.close();
			factory.close();
		}
		
	}

}
