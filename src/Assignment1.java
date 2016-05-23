
public class Assignment1 {
	
	public void ahmad(String name) {
//		could also use this
//		int counter = 0;
//		int length = name.length();
//		for (int i = 0; i < length; i++) {
//			counter++;
//		}
//		System.out.println(counter);
		System.out.println(name.length());
		System.out.println(name);
	}
	
	public int performAction(int number) {
		int newNumber = number;
		
		for (int i = 0; i < number - 1; i++) {
			newNumber *= number;
		}
		
		
		return newNumber;
	}
	
	public static void main(String[] args) {
		
		Assignment1 test = new Assignment1();
		//Counts Spaces
		test.ahmad("Mahmud Ahmad");
		System.out.println(test.performAction(5));
	}
	
}
