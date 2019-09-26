package Gift;

import java.util.*;

public class SortingObject{
	public HashMap<String,Integer> sortByQuantity(HashMap<String,Integer> unsorted)
	{
		List<Map.Entry<String,Integer>> list=new ArrayList();
		
		for(Map.Entry<String,Integer> m:unsorted.entrySet())
			list.add(m);
		
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>()
				{
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2)
			{
				
			}
				});
		
	}
}
