package de.personal.coding_interview_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciCalc {
	private FibonacciCalc() { }
	
	public static List<Integer> createFibonacciSequence(int threshold) {
		List<Integer> sequence = new ArrayList<>(Arrays.asList(0, 1));
		int firstNum = sequence.get(0), secondNum = sequence.get(1);
		
		while (firstNum + secondNum < threshold) {
			sequence.add(firstNum + secondNum);
			firstNum = sequence.get(sequence.size() - 2);
			secondNum = sequence.get(sequence.size() - 1);
		}
		
		return sequence;
	}
	
	public static List<Integer> createFibonacciSequenceWithRecursion(int n) {
		List<Integer> sequence = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			sequence.add(getNthFibonacciNumber(i));
		}
		
		return sequence;
	}
	
	private static int getNthFibonacciNumber(int n) {
		if (n <= 1) {
			return n;
		}
		
		return getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2); 
	}
}