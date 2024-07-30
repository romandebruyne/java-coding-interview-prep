package de.personal.coding_interview_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearcher {
	private BinarySearcher() { }
	
	public static int findValueIndexInArray(int[] array, int value) {
		int low = 0, high = array.length - 1, mid = (low + high) / 2;
		int[] sortedArray = array;
		
		Arrays.sort(sortedArray);
		
		while (low <= high) {
			if (value < sortedArray[mid]) {
				high = mid - 1;
			} else if (sortedArray[mid] == value) {
				return mid;
			} else {
				low = mid + 1;
			}
			
			mid = (low + high) / 2;
		}
		
		return -1;
	}
	
	public static int findValueIndexInList(List<Integer> list, int value) {
		int low = 0, high = list.size(), mid = (low + high) / 2;
		
		List<Integer> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList);
		
		while (low <= high) {
			if (value < sortedList.get(mid)) {
				high = mid - 1;
			} else if (value > sortedList.get(mid)) {
				low = mid + 1;
			} else {
				return mid;
			}
			
			mid = (low + high) / 2;
		}
		
		return -1;
	}
}