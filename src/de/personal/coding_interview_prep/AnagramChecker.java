package de.personal.coding_interview_prep;

import java.util.Arrays;

public class AnagramChecker {
	private AnagramChecker() { }
	
	public static boolean isPalindrome(String stringToCheck) {
		char firstLetterToCompare, secondLetterToCompare;
		
		for (int i = 0; i < stringToCheck.length(); i++) {
			firstLetterToCompare = stringToCheck.toLowerCase().charAt(i);
			secondLetterToCompare = stringToCheck.toLowerCase().charAt(stringToCheck.length() - 1 - i);
			
			if (firstLetterToCompare != secondLetterToCompare) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isAnagram(String firstString, String secondString) {
		if (firstString.length() != secondString.length()) {
			return false;
		}
		
		char[] firstStringAsCharArray = firstString.toLowerCase().toCharArray(),
				secondStringAsCharArray = secondString.toLowerCase().toCharArray();
		
		Arrays.sort(firstStringAsCharArray);
		Arrays.sort(secondStringAsCharArray);

		if (!Arrays.equals(firstStringAsCharArray, secondStringAsCharArray)) {
			return false;
		}
		
		return true;
	}
}