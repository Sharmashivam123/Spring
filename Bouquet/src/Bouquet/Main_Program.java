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
		
		String flowers_array[] = new String[] {"rose","lilly","daffodill","larkspur","buttercup"};
		int [] countOfFlower = new int[5];
		boolean isPossible = true;
		
		while (totalFlowers > 0) {
			for (int flower = 0; flower < 5; flower++) {
				System.out.print("Flowers left "+ totalFlowers+".  ");
				System.out.print("Choose No. Of " + flowers_array[flower]+" ");
				int x = input.nextInt();
				if (x > totalFlowers) {
					System.out.println("Boquet Not Possible with selected no of flowers");
					isPossible = false;
					break;
				}
				totalFlowers -= x;
				countOfFlower[flower] += x;
				if (totalFlowers == 0) {
					break;
				}
			}
			if (!isPossible) break;
		}
		
//		for (int i : countOfFlower)
//		System.out.println(i);
		
		System.out.println("Total Cost is : "+costcalculator.getCostOfBouquet(countOfFlower));
		
		input.close();
		

	}

}
