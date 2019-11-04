package Bouquet;

import java.util.*;

public class Main_Program {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("Menu");
		System.out.println();
		System.out.println("Available Bouquet Sizes");
		System.out.println("0.Single 1.Tiny 2.Medium 3.Big");
		System.out.print("Choose your choice: ");
		int sizeOfBouquet=input.nextInt();

		CostCalculator costcalculator=new CostCalculator();
		int totalFlowers=costcalculator.getFlowersCount(sizeOfBouquet);
		
		System.out.println("Total Flowers In Bouquet Size: " + totalFlowers);
		List<String> flowers_List=new ArrayList();
		flowers_List.add("rose");
		flowers_List.add("lilly");
		flowers_List.add("daffodill");
		flowers_List.add("larkspur");
		flowers_List.add("buttercup");
		
		//String flowers_array[] = new String[] {"rose","lilly","daffodill","larkspur","buttercup"};
//		int [] countOfFlower = new int[5];
		HashMap<String, Integer> countOfFlower=new HashMap();
		for(String flowers:flowers_List)
			countOfFlower.put(flowers,0);
		
		boolean isPossible = true;
		
		while (totalFlowers > 0) {
			for (int fwr = 0; fwr < 5; fwr++) {
				final int flower=fwr;
				System.out.print("Flowers left "+ totalFlowers+".  ");
				System.out.print("Choose No. Of " + flowers_List.get(flower)+" ");
				int x = input.nextInt();
				countOfFlower.compute(flowers_List.get(flower),(key,value)->value==0?x:countOfFlower.get(flowers_List.get(flower))+x);
				if (x > totalFlowers) {
					System.out.println("Boquet Not Possible with selected no of flowers");
					isPossible = false;
					break;
				}
				totalFlowers -= x;
				
				if (totalFlowers == 0) {
					break;
				}
			}
			if (!isPossible) break;
			}
		if(isPossible)
			System.out.println("Total Cost is : "+costcalculator.getCostOfBouquet(countOfFlower));

		
		
		input.close();
		

	}

}
