public class Quiz2 {

	public Quiz2() {
		StringBuilder toPrint = new StringBuilder();
		for (int i = 0; i < quiz2Array.length; i++) {
			toPrint.append(quiz2Array[i]);
		}
		System.out.println(toPrint);
	}
	
	String[] quiz2Array = {
		"Here is the summaray of my UNH academic histroy: \n",
		"------------------------------------------------ \n",
		"•Name: Mahmud Ahmad \n",
		"•Major: Electrical Engineering \n",
		"•Year: First \n",
		"•Courses Completed: 8 \n",
		"•Highest Grade: A \n",
		"•Lowest Grade: B \n",
		"------------------------------------------------ \n",
		"End of summary."
	};
	
	public static void main(String[] args) {
		Quiz2 test = new Quiz2();
	}
	
}
