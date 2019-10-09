package Gift;

public class Sweets implements GiftInterface {

	String name;
	double weight;
	
	@Override
	public void setName(String Name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setWeight(double weight) {
		this.weight=weight;
	}

	
	public double getWeight() {
		return weight;
	}

}
