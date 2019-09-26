package Bouquet;

import java.util.Arrays;
import java.util.HashMap;

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
	
	double getCostOfBouquet(HashMap<String,Integer> count_Flowers)
	{
		double croses=count_Flowers.get("rose")==null?0:(double)count_Flowers.get("rose")*rose.getCost();
		double clilly=count_Flowers.get("lilly")==null?0:(double)count_Flowers.get("lilly")*lilly.getCost();
		double clarkspur=count_Flowers.get("larkspur")==null?0:(double)count_Flowers.get("larkspur")*larkspur.getCost();
		double cbuttercup=count_Flowers.get("buttercup")==null?0:(double)count_Flowers.get("buttercup")*buttercup.getCost();
		double cdaffodill=count_Flowers.get("daffodill")==null?0:(double)count_Flowers.get("daffodill")*daffodill.getCost();
		double total=croses+clilly+clarkspur+cbuttercup+cdaffodill;
		return total;
		
	}
}
