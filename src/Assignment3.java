import java.util.*;

public class Assignment3 {
	
	public Assignment3() {
		convertString();
	}
	
	StringBuilder startString = new StringBuilder("$$$$$$$$$");

	void convertString() {
		for (int i = 0; i < startString.length(); i++) {
			startString.setCharAt(i, '*');
			switch (i) {
			case 2:
				System.out.println("Mahmud");
				break;
			case 6:
				System.out.println("Ahmad");
				break;
			default:
				System.out.println(startString);
			}
		}
	}

	public static void main(String[] args) {
		Assignment3 test = new Assignment3();
	}

}