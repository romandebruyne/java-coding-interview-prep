package de.personal.coding_interview_prep;

public class StringReverser {
	private String stringToReverse;
	
	public StringReverser(String stringToReverse) {
		this.stringToReverse = stringToReverse;
	}
	
	public String reverseString() {
		char[] stringAsCharArray = this.stringToReverse.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (int i = stringAsCharArray.length - 1; i >= 0; i--) {
			sb.append(stringAsCharArray[i]);
		}
		
		return sb.toString();
	}
	
	public String reverseStringSimple() {
		String reversedString = "";
		int stringLength = this.stringToReverse.length();
		
		for (int i = 0; i < stringLength; i++) {
			reversedString = this.stringToReverse.charAt(i) + reversedString;
		}
		
		return reversedString;
	}
	
	public String reverseSentence(String sentence) {
		String[] sentenceArray = sentence.split(" ");
		String reversedSentence = "";
		
		for (int i = sentenceArray.length - 1; i >= 0; i--) {
			reversedSentence += sentenceArray[i] + " ";
		}
		
		return reversedSentence;
	}
	
	public String getStringToReverse() {
		return this.stringToReverse;
	}

}
