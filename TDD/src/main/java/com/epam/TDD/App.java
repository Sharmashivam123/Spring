package com.epam.TDD;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RemoveCharacter remove = new RemoveCharacter();
        System.out.println(remove.removeCharacter("Aab"));	
        System.out.println(remove.removeCharacter("Aa"));
        System.out.println(remove.removeCharacter("b"));
        System.out.println(remove.removeCharacter("Aabadsffghvdsfbas"));
        System.out.println(remove.removeCharacter(""));
    }
}
