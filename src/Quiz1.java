import java.util.*;
import java.util.Scanner;

public class Quiz1 {
	
	public Quiz1() {
		String userChoice;
		System.out.println("What do you want to check for: Check for digit, Check for string");
		switch(userChoice = getUserInput().toLowerCase()) {
			case("check for digit"):
				System.out.println("Enter some words and numbers");
				checkUserInputForString(getUserInput());
				break;
			case("check for string"): 
				System.out.println("Enter some words and numbers");
				checkUserInputForDigit(getUserInput());
				break;
			default: ;
		}
	}

	public String getUserInput() {
		String userInput;
		Scanner userInputScanner = new Scanner(System.in);
		userInput = userInputScanner.nextLine().toLowerCase();
		return userInput;
	}
	
	public void checkUserInputForDigit(String word) {
		int length = word.length();
		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(word.charAt(i))) {
				System.out.println("The word contains a leter at index: " + i);
			}
		}
	}
	
	public void checkUserInputForString(String word) {
		int length = word.length();
		for (int i = 0; i < length; i++) {
			if (Character.isDigit(word.charAt(i))) {
				System.out.println("The word contains a digit at index: " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		Quiz1 quiz1 = new Quiz1();
	}
}
