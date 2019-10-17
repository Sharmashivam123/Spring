package com.epam.bms.services;

import java.util.Map;

import com.epam.bms.util.Data;
import com.epam.bms.util.DataImpl;

public class Calculation {
	private Data data = new DataImpl();
	
	public int calculatePrice( int price, int seats)
	{
		return price*seats;
	}
}
