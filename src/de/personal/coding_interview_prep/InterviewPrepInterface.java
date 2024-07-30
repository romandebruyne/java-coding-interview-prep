package de.personal.coding_interview_prep;

public interface InterviewPrepInterface {
	// Regular abstract method
	void shoutSomething(String something);
	
	// Default
	default void printNumberNine() {
		System.out.println("Number nine");
	}
	
	// Static
	static boolean isNumberNine(int number) {
		return number == 9;
	}

}
