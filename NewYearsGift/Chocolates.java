package Gift;

public class Chocolates implements GiftInterface, Comparable<Chocolates>{

	private String name;
	private int quantity;
	
	@Override
	public void setName(String name) {
		this.name=name;
	}	

	@Override
	public String getName() {
		return name;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public int getQuantity()
	{
		return quantity;
	}

	@Override
	public int compareTo(Chocolates c) {
		return c.quantity-this.quantity;
	}

	@Override
	public String toString() {
		return "Chocolates [name=" + name + ", quantity=" + quantity + "]";
	}

}