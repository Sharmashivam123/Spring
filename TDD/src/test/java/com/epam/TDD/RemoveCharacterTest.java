package com.epam.TDD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveCharacterTest {

	private RemoveCharacter remove;
	
	@BeforeEach
	private void initialiseObject()
	{
		remove = new RemoveCharacter();
	}
	
	@Test
	private void test1()
	{
		String expected = "";
		String actual = remove.removeCharacter("");
		assertEquals(expected, actual);
	}
	
	@Test
	private void test2()
	{
		String expected = "Aa";
		String actual = remove.removeCharacter("AbAa");
		assertEquals(expected, actual);;
	}
	
	@Test
	private void test3()
	{
		String expected = "asdfgb";
		String actual = remove.removeCharacter("aaasdfgb");
		assertEquals(expected, actual);;
	}
	
	@Test
	private void test4()
	{
		String expected = "Alkjhgfdsa";
		String actual = remove.removeCharacter("lkjhgfdsa");
		assertEquals(expected, actual);;
	}
	
	
}
