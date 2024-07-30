package de.personal.coding_interview_prep;

public class PermutationFinder {
	private int numOfPermutations;
	
	public PermutationFinder() { }
	
	public void findPermutationsOfWord(String word) {
		findPermutationsOfWord("", word);
	}
	
	public void findPermutationsOfWord(String permutation, String word) {
		if (word.length() == 0) {
			System.out.println(permutation);
			this.numOfPermutations++;
		} else {
			for (int i = 0; i < word.length(); i++) {
				findPermutationsOfWord(permutation + word.charAt(i),
						word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
	
	public int getNumOfPermutations() {
		return this.numOfPermutations;
	}
}
