package com.epam.TDD;

public class RemoveCharacter {
	public String removeCharacter(String string)
	{
		String res="";
		int length = string.length();
		if(length==0) 
			return res;
		else if(length == 1)
			if(string.charAt(0) == 'A' || string.charAt(0) == 'a')return res;
			else return string;
		else {
		if(string.charAt(0) == 'A' || string.charAt(0) == 'a')
			if(string.charAt(1) == 'A' || string.charAt(1) == 'a')
				if(length==2)res = "";
				else
					res += string.substring(2, length);
			else
				res += string.substring(1, length);
		else 
			if(string.charAt(1) == 'A' || string.charAt(1) == 'a')
				res += string.substring(0,1)+string.substring(2, length);
			else
				res += string.substring(0, length);
		}
		return res;
		
	}
}
