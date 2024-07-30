package de.personal.coding_interview_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingRoboter {
	private SortingRoboter() { }
	
	public static void bubbleSortArray(int[] arrayToSort) {
		int temp;
		
		for (int i = 0; i < arrayToSort.length - 1; i++) {
			for (int j = 0; j < arrayToSort.length - i - 1; j++) {
				if (arrayToSort[j] > arrayToSort[j + 1]) {
					temp = arrayToSort[j];
					arrayToSort[j] = arrayToSort[j+ 1];
					arrayToSort[j + 1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSortList(List<Integer> listToSort) {
		for (int i = 0; i < listToSort.size() - 1; i++) {
			for (int j = 0; j < listToSort.size() - i - 1; j++) {
				if (listToSort.get(j) > listToSort.get(j + 1)) {
					Collections.swap(listToSort, j, j + 1);
				}
			}
		}
	}
	
	public static void insertionSortArray(int[] arrayToSort) {
		int temp, innerLoopCount;
		
		for (int i = 1; i < arrayToSort.length; i++) {
			temp = arrayToSort[i];
			innerLoopCount = i - 1;
			
			while (innerLoopCount >= 0 && arrayToSort[innerLoopCount] > temp) {
				arrayToSort[innerLoopCount + 1] = arrayToSort[innerLoopCount];
				innerLoopCount--;
			}
			
			arrayToSort[innerLoopCount + 1] = temp;
		}
	}
	
	public static void insertionSortList(List<Integer> sequenceToSort) {
		int key, innerLoopCount;
		
		for (int i = 1; i < sequenceToSort.size(); i++) {
			key = sequenceToSort.get(i);
			innerLoopCount = i - 1;
			
			while (innerLoopCount >= 0 && sequenceToSort.get(innerLoopCount) > key) {
				sequenceToSort.set(innerLoopCount + 1, sequenceToSort.get(innerLoopCount));
				innerLoopCount--;
			}
			
			sequenceToSort.set(innerLoopCount + 1, key);
		}
	}
	
	public static int[] mergeSortArray(int[] arrayToSort) {
		int[] leftPartOfArray, rightPartOfArray;
		
		if (arrayToSort.length <= 1) {
			return arrayToSort;
		} else {
			leftPartOfArray = Arrays.copyOfRange(arrayToSort, 0, arrayToSort.length / 2);
			rightPartOfArray = Arrays.copyOfRange(arrayToSort, arrayToSort.length / 2, arrayToSort.length);
			
			leftPartOfArray = mergeSortArray(leftPartOfArray);
			rightPartOfArray = mergeSortArray(rightPartOfArray);
			
			return mergeArrays(leftPartOfArray, rightPartOfArray);
		}
	}
	
	private static int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {
		int[] mergedArray = new int[arrayOne.length + arrayTwo.length];
		int arrayOneIndex = 0, arrayTwoIndex = 0, mergedArrayIndex = 0;
		
		while (arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length) {
			if (arrayOne[arrayOneIndex] < arrayTwo[arrayTwoIndex]) {
				mergedArray[mergedArrayIndex] = arrayOne[arrayOneIndex];
				arrayOneIndex++;
				mergedArrayIndex++;
			} else {
				mergedArray[mergedArrayIndex] = arrayTwo[arrayTwoIndex];
				arrayTwoIndex++;
				mergedArrayIndex++;
			}
		}
		
		while (arrayOneIndex < arrayOne.length) {
			mergedArray[mergedArrayIndex] = arrayOne[arrayOneIndex];
			arrayOneIndex++;
			mergedArrayIndex++;
		}
		
		while (arrayTwoIndex < arrayTwo.length) {
			mergedArray[mergedArrayIndex] = arrayTwo[arrayTwoIndex];
			arrayTwoIndex++;
			mergedArrayIndex++;
		}
		
		return mergedArray;
	}
	
	public static List<Integer> mergeSortList(List<Integer> listToSort) {
		List<Integer> leftPartOfList, rightPartOfList;
		
		if (listToSort.size() <= 1) {
			return listToSort;
		} else {
			leftPartOfList = listToSort.subList(0, listToSort.size() / 2);
			rightPartOfList = listToSort.subList(listToSort.size() / 2, listToSort.size());
			
			leftPartOfList = mergeSortList(leftPartOfList);
			rightPartOfList = mergeSortList(rightPartOfList);
			
			return mergeLists(leftPartOfList, rightPartOfList);
		}
	}
	
	private static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {
		List<Integer> mergedList = new ArrayList<>();
		int listOneIndex = 0, listTwoIndex = 0;
		
		while (listOneIndex < listOne.size() && listTwoIndex < listTwo.size()) {
			if (listOne.get(listOneIndex) < listTwo.get(listTwoIndex)) {
				mergedList.add(listOne.get(listOneIndex));
				listOneIndex++;
			} else {
				mergedList.add(listTwo.get(listTwoIndex));
				listTwoIndex++;
			}
		}
		
		while (listOneIndex < listOne.size()) {
			mergedList.add(listOne.get(listOneIndex));
			listOneIndex++;
		}
		
		while (listTwoIndex < listTwo.size()) {
			mergedList.add(listTwo.get(listTwoIndex));
			listTwoIndex++;
		}
		
		return mergedList;
	}
	
	public static int[] generateUnsortedArray() {
		int[] unsortedArray = { 444, 42, 11, 5005, -1, 22, 999 };
		return unsortedArray;
	}
	
	public static List<Integer> generateUnsortedList() {
		List<Integer> unsortedList = Arrays.asList(444, 42, 11, 5005, -1, 22, 999);
		return unsortedList;
	}
	
	public static void printArray(int[] arrayToPrint) {
		for (int i = 0; i < arrayToPrint.length; i++) {
			System.out.print(arrayToPrint[i] + " ");
		}
		System.out.println();
	}
	
	public static void printList(List<Integer> listToPrint) {
		listToPrint.forEach(num -> System.out.print(num + " "));
		System.out.println();
	}
}
