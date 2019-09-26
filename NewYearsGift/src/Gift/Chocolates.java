package Gift;

public class Chocolates implements GiftInterface{

	private double price;
	private String name;
	private int quantity;

	@Override
	public double getPrice() {
		return price;
	}
	
	
	@Override
	public void setName(String Name) {
		
	}	

	@Override
	public String getName() {
		return name;
	}
	
	public void setQuantity(int quantity)
	{
		
	}
	
	public int getQuantity()
	{
		return quantity;
	}

}
