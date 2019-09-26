package Gift;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		String []availableChocolates= {"Eclairs","CoffeeBite","DairyMilk","Alpenlibe","Pulse","CenterFruit","CenterFresh","DarkFantasy","Perk","Munch"};
		String []availableSweets= {"Pie","Oreo","Jellybean","Rasgulla","noughat"};
		
		List<Chocolates> chocoList=new ArrayList();
		HashMap<String, Chocolates> chocosQuantity=new HashMap();
		HashMap<String,Integer> map=new HashMap();

		for(int chocolates=0; chocolates<availableChocolates.length; chocolates++)
		{
			Chocolates c=new Chocolates();
			c.setName(availableChocolates[chocolates]);
			c.setQuantity(0);
			chocoList.add(c);
			chocosQuantity.put(availableChocolates[chocolates], c);
			map.put(c.getName(), 0);
		}
		
		System.out.println("Opening a Gift ");
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
				map.compute(name, (key, value)->value==null?quantity:quantity+value);
				Chocolates updated=chocosQuantity.get(name);
				updated.setQuantity(updated.getQuantity()+quantity);
				chocosQuantity.put(name,updated);
			}
			catch(Exception e)
			{
				System.out.println("Please type from above ");
			}
				
		}
		SortingObject so=new SortingObject();
		
		System.out.println("Total no of choclates are :"+ so.getTotal(chocoList));
		
		
		
		System.out.println("Please choose the Sweets from below and type DONE when you are done : ");
		System.out.println(Arrays.toString(availableSweets));
		System.out.println("Name Quantity");
		HashMap<String, Integer> mapSweet=new HashMap();
		for(String s:availableSweets)mapSweet.put(s, 0);
		while(true)
		{
			try {
				String input = reader.readLine();
				if(input.equalsIgnoreCase("done"))
				break;
				
				String inputarr[]=input.split(" ");
				String name=inputarr[0];
				if(!mapSweet.containsKey(name)) {
					System.out.println("Please select from above Sweets or type done.");
					continue;
				}
				int quantity=Integer.parseInt(inputarr[1]);
				mapSweet.compute(name, (key, value)->value==null?quantity:quantity+value);
			}
			catch(Exception e)
			{
				System.out.println("Please type from above ");
			}
				
		}
		System.out.println("Total Kg of Sweet are :"+ so.getTotalWeight(mapSweet));
		
		
		
		System.out.println("Enter the criteria to sort the chocolates");
		System.out.println("1 for price OR 2 for quantity OR DONE to countinue.");
		System.out.println();
		
		while(true)
		{
			String sortingType=reader.readLine();
			int sortingtype=Integer.parseInt(sortingType);
			if(sortingType.equalsIgnoreCase("done"))
				break;
			else if(sortingtype==1) {
				
				break;
			}
			else if(sortingtype==2)
			{
				so.sortByQuantity(map);
				break;
			}
			else
			{
				System.out.println("Please type the correct option");
				continue;
			}
		}
	
		System.out.println("Enter the criteria to sort the chocolates");
		System.out.println("1 for price OR 2 for quantity OR DONE to countinue.");
		System.out.println();
		while(true)
		{
			String sortingType=reader.readLine();
			int sortingtype=Integer.parseInt(sortingType);
			if(sortingType.equalsIgnoreCase("done"))
				break;
			else if(sortingtype==1) {
				
				break;
			}
			else if(sortingtype==2)
			{
				so.sortByQuantity(mapSweet);
				break;
			}
			else
			{
				System.out.println("Please type the correct option");
				continue;
			}
		}
		
	}
}
