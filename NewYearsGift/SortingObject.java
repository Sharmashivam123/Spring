package Gift;

import java.util.*;

public class SortingObject{
	public void sortByQuantity(HashMap<String,Double> unsorted)
	{
		List<Map.Entry<String,Double>> list=new ArrayList(unsorted.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String,Double>>()
				{
			public int compare(Map.Entry<String, Double> m1, Map.Entry<String, Double> m2)
			{
				if(m2.getValue().compareTo(m1.getValue())==0)
					return m1.getKey().compareTo(m2.getKey());
				return m2.getValue().compareTo(m1.getValue());
			}
				});
		
		HashMap<String,Double> sorted=new LinkedHashMap();
		System.out.println("Name Quantity");
		for(Map.Entry<String,Double> m: list)
			if(m.getValue()!=0)System.out.println(m.getKey()+" "+m.getValue());
	
	}

	public int getTotal(List<Chocolates> chocoList) {
		int total=0;
		for(Chocolates l:chocoList)
			total+=l.getQuantity();
		return total;
	}

	public double getTotalWeight(HashMap<String, Double> mapSweet) {
		// TODO Auto-generated method stub
		double total=0;
		for(Map.Entry<String,Double> m:mapSweet.entrySet())total+=(double)m.getValue();
		return total;
	}

	
	public void printRange(List<Chocolates> chocoList, int min, int max) {
		// TODO Auto-generated method stub

		System.out.println("Name Quantity");
		for(Chocolates c: chocoList)
		{
			if(c.getQuantity() >= min && c.getQuantity() <= max)
				System.out.println(c.getName()+" "+c.getQuantity());
		}
	}
}
