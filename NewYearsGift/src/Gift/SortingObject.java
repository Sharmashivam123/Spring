package Gift;

import java.util.*;

public class SortingObject{
	public void sortByQuantity(HashMap<String,Integer> unsorted)
	{
		List<Map.Entry<String,Integer>> list=new ArrayList(unsorted.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>()
				{
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2)
			{
				if(m2.getValue().compareTo(m1.getValue())==0)
					return m1.getKey().compareTo(m2.getKey());
				return m2.getValue().compareTo(m1.getValue());
			}
				});
		
		HashMap<String,Integer> sorted=new LinkedHashMap();
		System.out.println("Name Quantity");
		for(Map.Entry<String,Integer> m: list)
			if(m.getValue()!=0)System.out.println(m.getKey()+" "+m.getValue());
	
	}

	public int getTotal(List<Chocolates> chocoList) {
		int total=0;
		for(Chocolates l:chocoList)
			total+=l.getQuantity();
		return total;
	}

	public double getTotalWeight(HashMap<String, Integer> mapSweet) {
		// TODO Auto-generated method stub
		double total=0;
		for(Map.Entry<String,Integer> m:mapSweet.entrySet())total+=(int)m.getValue();
		return total;
	}
}
