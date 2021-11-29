package problem1b;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade= CascadeType.PERSIST)
	@JoinTable(
			name="order_detail",
			joinColumns=@JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="order_id")
			)
	private List<Order> orders;
	
	public Product()
	{
		
	}
	
	public Product(String name)
	{
		this.name = name;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<Order> getOrders()
	{
		return orders;
	}
	
	public void addOrder(Order order)
	{
		orders.add(order);
	}

}
