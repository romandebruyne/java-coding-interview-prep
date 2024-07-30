package de.personal.coding_interview_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		/**
		 * Digital Ocean; #1: How to reverse a String?
		 * Difficulty: Easy.
		 */
		System.out.println("### Reverse strings ###");
		StringReverser sr = new StringReverser("Hallo Welt");
		System.out.println(sr.reverseString());
		System.out.println(sr.reverseStringSimple());
		
		/**
		 * Digital Ocean; #4: Check for Prime Numbers.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Prime Numbers ###");
		List<Integer> numbersToCheck = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
		
		PrimeNumChecker.printPrimeNumbers(numbersToCheck);
		
		/**
		 * Digital Ocean; #6: Check whether number is odd.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Odd numbers ###");
		numbersToCheck
			.stream()
			.filter(num -> num % 2 == 0)
			.collect(Collectors.toList())
			.forEach(num -> System.out.print(num + ", "));
		
		/**
		 * Digital Ocean; #7: Check whether string is palindrome.
		 * Medium; #7: Check whether strings are anagrams.
		 * Difficulty: Easy.
		 */
		System.out.println("\n\n### Anagrams and Palindromes ###");
		System.out.println(AnagramChecker.isPalindrome("Reliefpfeiler"));
		System.out.println(AnagramChecker.isPalindrome("Sortierbeispiel"));
		
		System.out.println(AnagramChecker.isAnagram("Anna", "Anna"));
		System.out.println(AnagramChecker.isAnagram("Ananas", "Ansana"));
		System.out.println(AnagramChecker.isAnagram("Klo", "Flo"));
		
		/**
		 * Digital Ocean; #14: Binary Search.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Binary Search in Arrays. ###");
		int[] binarySearchArray = { 1, 2, 3, 7, 8, 44, 9 };
		System.out.println(BinarySearcher.findValueIndexInArray(binarySearchArray, 8));
		System.out.println(BinarySearcher.findValueIndexInArray(binarySearchArray, 22));
		
		/**
		 * Digital Ocean; #17: Compare two Arrays.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Compare Arrays. ###");
		Integer[] arrayNumberOne = { 1, 44, 431, 435, 77 };
		Integer[] arrayNumberTwo = { 1, 44, 431, 435, 77 };
		Integer[] arrayNumberThree = { 1, 44, 431, 757 };
		
		Set<Integer> setNumberOne = new HashSet<>(Arrays.asList(arrayNumberOne));
		Set<Integer> setNumberTwo = new HashSet<>(Arrays.asList(arrayNumberTwo));
		Set<Integer> setNumberThree = new HashSet<>(Arrays.asList(arrayNumberThree));
		
		System.out.println(setNumberOne.equals(setNumberTwo));
		System.out.println(setNumberThree.equals(setNumberOne));
		
		/**
		 * Digital Ocean; #19: find second largest value in Array.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Find second largest value in Arrays ###");
		int[] arrayWithNumbers = { 999, 888, 77, 3231, 1230, 3, 323, 1001 };
		int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
		
		for (int i = 0; i < arrayWithNumbers.length; i++) {
			if (arrayWithNumbers[i] > largest) {
				largest = arrayWithNumbers[i];
			}
			
			if (arrayWithNumbers[i] > secondLargest && arrayWithNumbers[i] < largest) {
				secondLargest = arrayWithNumbers[i];
			}
		}
		
		System.out.println("Largest value is: " + largest);
		System.out.println("Second largest value is: " + secondLargest);
		
		/**
		 * Digital Ocean; #24: sort a HashMap by values.
		 * Difficulty: Medium.
		 */
		System.out.println("\n### Sort HashMap by Values ###");
		Map<String, Integer> hashMapToSort = new HashMap<>();
		hashMapToSort.put("Haaland", 30);
		hashMapToSort.put("Schuerle", -3);
		hashMapToSort.put("Mueller", 15);
		hashMapToSort.put("De Bruyne", 11);
		
		Map<String, Integer> hashMapSorted = hashMapToSort
				.entrySet()
				.stream()
				.sorted(Entry.comparingByValue())
				// .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		
		hashMapSorted.entrySet().forEach(ent -> System.out.print(ent.getKey() + ": " + ent.getValue() + "; "));
		
		/**
		 * Digital Ocean; #26: get distinct Characters and their count.
		 * Difficulty: Easy.
		 */
		System.out.println("\n\n### Distinct Chars and Counts ###");
		String characters = "abcdABCDabcd";
		Map<Character, Integer> charsAndCounts = new HashMap<>();
		for (char c : characters.toCharArray()) {
			if (!charsAndCounts.containsKey(c)) {
				charsAndCounts.put(c, 1);
			} else {
				charsAndCounts.put(c, charsAndCounts.get(c) + 1);
			}
		}
		
		charsAndCounts.entrySet().forEach(ent -> System.out.print(ent.getKey() + ": " + ent.getValue() + "; "));
		
		/**
		 * Digital Ocean; #38: create an Interface.
		 * Difficulty: Easy.
		 */
		System.out.println("\n\n### Interfaces ###");
		InterviewPrepInterfaceImpl interfaceImpl = new InterviewPrepInterfaceImpl();
		interfaceImpl.shoutSomething("HELLO");
		interfaceImpl.printNumberNine();
		System.out.println(InterviewPrepInterface.isNumberNine(9));
		
		/**
		 * Medium; #5: remove duplicates from Array.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Remove duplicates ###");
		String[] stringArray = { "Eins", "Eins", "Zwei", "Zwei", "Drei" }, stringArrayWithoutDuplicates;
		stringArrayWithoutDuplicates = new DuplicateRemover(stringArray).removeDuplicates();
		
		for (String input : stringArrayWithoutDuplicates) {
			System.out.println(input);
		}
		
		/**
		 * Medium; #14: Fibonacci sequence.
		 * Difficulty: Medium.
		 */
		System.out.println("\n### Fibonacci Sequence ###");
		List<Integer> fiboSeq = FibonacciCalc.createFibonacciSequence(60);
		fiboSeq.forEach(num -> System.out.print(num + " "));
		System.out.println();
		List<Integer> fiboSeqWithRecursion = FibonacciCalc.createFibonacciSequenceWithRecursion(10);
		fiboSeqWithRecursion.forEach(num -> System.out.print(num + " "));
		
		/**
		 * Simplilearn; #30: how to swap to numbers without using a third variable?
		 * Difficulty: Easy.
		 */
		System.out.println("\n\n### Swap Numbers w/o a Third Variable ###");
		int a = 12, b = 5;
		b = a + b; // b = 12 + 5 = 17
		a = b - a; // a = 17 - 12 = 5
		b = b - a; // b = 17 - 5 = 12
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		/**
		 * Java Concept of the day; #2: print a pyramid.
		 * Difficulty: Medium.
		 * 
		 */
		System.out.println("\n### Print a Pyramid ###");
		int height = 10, rowCount = 1;
		for (int i = height; i > 0; i--) {
			
			for (int j = 0; j < i - 1; j++) {
				System.out.print(" ");
			}
			
			for (int k = 1; k < rowCount * 2; k++) {
				System.out.print("#");
			}
			
			System.out.println();
			rowCount++;
		}
		
		/**
		 * Java Concept of the day; #57: Find all permutations of String.
		 * Difficulty: Heavy.
		 */
		System.out.println("\n### Find all Permutations of String ###");
		String word = "JAP";
		PermutationFinder pf = new PermutationFinder();
		pf.findPermutationsOfWord(word);
		System.out.println(pf.getNumOfPermutations());
		
		/**
		 * Java Concept of the day; #70: Reverse Sentence word by word.
		 * Difficulty: Easy.
		 */
		System.out.println("\n### Reverse Sentence ###");
		String sentence = "Hello, my name is Roman";
		System.out.println(sr.reverseSentence(sentence));
		
		/**
		 * Java Concept of the day; #102 & #103: Sort hash map by keys or values.
		 */
		System.out.println("\n### Sort HashMap by Keys or Values ###");
		Map<String, Integer> hashymappy = new HashMap<>();
		hashymappy.put("Hannibal", 300);
		hashymappy.put("Panzram", 400);
		hashymappy.put("SCF", 100);
		hashymappy.put("Art of War", 50);
		
		Map<String, Integer> mapSortedByKeys = hashymappy
				.entrySet()
				.stream()
				.sorted(Entry.comparingByKey())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		mapSortedByKeys.entrySet().forEach(ent -> System.out.print(ent.getKey() + ", "));
		
		Map<String, Integer> mapSortedByValues = hashymappy
				.entrySet()
				.stream()
				.sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		mapSortedByValues.entrySet().forEach(ent -> System.out.print(ent.getValue() + ","));
			
		/**
		 * Create an Abstract class.
		 * Difficulty: Easy.
		 */
		System.out.println("\n\n### Abstract Class ###");
		Bicycle bike = new Bicycle();
		bike.honk();
		
		/**
		 * Sorting Algorithms
		 */
		
		// Bubble Sort. Difficulty: Easy.
		System.out.println("\n### Sorting Algorithms: Bubble Sort ###");
		int[] unsortedArray = SortingRoboter.generateUnsortedArray();
		SortingRoboter.printArray(unsortedArray);
		SortingRoboter.bubbleSortArray(unsortedArray);
		SortingRoboter.printArray(unsortedArray);
		
		List<Integer> unsortedList = SortingRoboter.generateUnsortedList();
		SortingRoboter.printList(unsortedList);
		SortingRoboter.bubbleSortList(unsortedList);
		SortingRoboter.printList(unsortedList);
		
		// Insertion Sort. Difficulty: Easy.
		System.out.println("\n### Sorting Algorithms: Insertion Sort ###");
		unsortedArray = SortingRoboter.generateUnsortedArray();
		SortingRoboter.printArray(unsortedArray);
		SortingRoboter.insertionSortArray(unsortedArray);
		SortingRoboter.printArray(unsortedArray);
		
		unsortedList = SortingRoboter.generateUnsortedList();
		SortingRoboter.printList(unsortedList);
		SortingRoboter.insertionSortList(unsortedList);
		SortingRoboter.printList(unsortedList);
		
		// Merge Sort. Difficulty: Medium.
		System.out.println("\n### Sorting Algorithms: Merge Sort ###");
		unsortedArray = SortingRoboter.generateUnsortedArray();
		SortingRoboter.printArray(unsortedArray);
		int[] mergeSortedArray = SortingRoboter.mergeSortArray(unsortedArray);
		SortingRoboter.printArray(mergeSortedArray);
		
		unsortedList = SortingRoboter.generateUnsortedList();
		SortingRoboter.printList(unsortedList);
		List<Integer> mergeSortedList = SortingRoboter.mergeSortList(unsortedList);
		mergeSortedList.forEach(num -> System.out.print(num + " "));
	}
}