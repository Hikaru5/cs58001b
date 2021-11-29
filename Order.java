package problem1b;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="date")
	private Date date;
	
	@Id
	@Column(name="consumer_name")
	private String name;
	
	@ManyToMany(cascade= CascadeType.PERSIST)
	@JoinTable(
			name="order_detail",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private List<Product> products;
	
	public Order()
	{
		
	}
	
	public Order(Date date, String name)
	{
		this.date = date;
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
	
	public List<Product> getProducts()
	{
		return products;
	}
	
	public void addProduct(Product product)
	{
		products.add(product);
	}

}
