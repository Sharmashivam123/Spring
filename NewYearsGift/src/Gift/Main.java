package Gift;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		String []availableChocolates= {"Eclairs","CoffeeBite","DairyMilk","Alpenlibe","Pulse","CenterFruit","CenterFresh","DarkFantasy","Perk","Munch"};
		String []availableSweets= {"Pie","Oreo","Jellybean","Rasgulla","noughat"};
		
		HashMap<String, Integer> chocosQuantity=new HashMap();
		for(String chocolates:availableChocolates)
			chocosQuantity.put(chocolates,0);
		
//		for(Map.Entry<String, Integer> m: chocosQuantity.entrySet())System.out.println(m.getKey()+" "+m.getValue());
//		
		List<Chocolates> list=new ArrayList();
		
		System.out.println("Opening a Gift");
		System.out.println();
		
		System.out.println("Please choose the Chocolates from below and type DONE when you are done : ");
		System.out.println(Arrays.toString(availableChocolates));
		System.out.println("Name Quantity");
		
		
		
			
		while(true)
		{
			try {
				String input = reader.readLine();
				if(input.equalsIgnoreCase("done"))
				break;
				
				String inputarr[]=input.split(" ");
				String name=inputarr[0];
				if(!chocosQuantity.containsKey(name)) {
					System.out.println("Please select from above chocolates  or type done.");
					continue;
				}
				int quantity=Integer.parseInt(inputarr[1]);
				chocosQuantity.compute(name, (key,value)->value==0?quantity:value+quantity);
				
			}
			catch(Exception e)
			{
				System.out.println("Please type from above");
			}
				
		}
		System.out.println("Enter the criteria to sort ");
		System.out.println("1 for price OR 2 for quantity");
		
		SortingObject so=new SortingObject();
		
		HashMap<String,Integer> sortedMap = so.sortByQuantity(chocosQuantity);
	}
}
