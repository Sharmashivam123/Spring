package Gift;

public class Chocolates implements GiftInterface{

	private String name;
	private int quantity;
	
	@Override
	public void setName(String Name) {
		
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

}
