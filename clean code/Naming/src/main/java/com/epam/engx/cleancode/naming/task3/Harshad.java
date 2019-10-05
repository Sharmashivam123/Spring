package com.epam.engx.cleancode.naming.task3;

public class Harshad {

	// print some Harshad numbers
	public static void main(String[] args) {
		long number = 1000; // limit the seq of Harshad numbers
		for (int seq = 1; seq <= L; seq++) {
			if (seq % loop(seq) == 0) {
				System.out.println(seq);
			}
		}
	}

	private static int loop(int number) {
		int sum = 0;
		while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
		return number;
	}

}
