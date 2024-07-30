package de.personal.coding_interview_prep;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemover {
	private String[] inputArray;
	
	public DuplicateRemover(String[] inputArray) {
		this.inputArray = inputArray;
	}
	
	public String[] removeDuplicates() {
		Set<String> tempSet = new LinkedHashSet<>();
		
		for (int i = 0; i < this.inputArray.length; i++) {
			tempSet.add(this.inputArray[i]);
		}
		
		return tempSet.toArray(new String[tempSet.size()]);
	}
}
