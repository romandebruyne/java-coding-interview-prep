package de.personal.coding_interview_prep;

import java.util.List;

public class PrimeNumChecker {
	private PrimeNumChecker() { }
	
	public static boolean isPrimeNumber(int numberToCheck) {
		if (numberToCheck == 0 || numberToCheck == 1) {
			return false;
		}
		
		if (numberToCheck == 2) {
			return true;
		}
		
		for (int i = 2; i <= numberToCheck / 2; i++) {
			if (numberToCheck % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void printPrimeNumbers(List<Integer> numbersToCheck) {
		int number;
		
		for (int i = 0; i < numbersToCheck.size(); i++) {
			number = numbersToCheck.get(i);
			if (isPrimeNumber(number)) {
				System.out.println(number + " is a prime number!");
			} else {
				System.out.println(number + " is NOT a prime number!");
			}
		}
	}
}
