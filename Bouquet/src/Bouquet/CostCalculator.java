package Bouquet;

import java.util.Arrays;

public class CostCalculator {
	
	int single=1;
	int tiny=4;
	int medium=8;
	int big=12;
	
	int getFlowersCount(int size)
	{
		if(size==0)return single;
		else if(size==1)return tiny;
		else if(size==2)return medium;
		else if(size==3)return big;
		else return 0;
	}
	
	Rose rose=new Rose();
	Lilly lilly=new Lilly();
	Larkspur larkspur=new Larkspur();
	Buttercup buttercup=new Buttercup();
	Daffodill daffodill=new Daffodill();
	
	double getCostOfBouquet(int count_Flowers[])
	{
		double croses=(double)(count_Flowers[0]*rose.getCost());
		double clilly=(double)(count_Flowers[1]*lilly.getCost());
		double clarkspur=(double)(count_Flowers[2]*larkspur.getCost());
		double cbuttercup=(double)(count_Flowers[3]*buttercup.getCost());
		double cdaffodill=(double)(count_Flowers[4]*daffodill.getCost());
		//System.out.println(Arrays.toString(count_Flowers));
		double total=croses+clilly+clarkspur+cbuttercup+cdaffodill;
		
		return total;
		
	}
}
