import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {

	public Assignment2() {
		File test1 = new File("test-1.txt");
		File test2 = new File("test-2.txt");
		File test3 = new File("test-3.txt");
		if (test1.exists() == false && test2.exists() == false && test3.exists() == false) {
			createFile();
		}
	}
	
	public Assignment2(String fileName) {
		this();
		String methodChosen;
		if (fileName == null) {
			System.out.println("Input a file name: test-1.txt, test-2.txt, or test-3.txt.");
			fileName = getUserInput();
		}
		System.out.println("Pick a method: method1, method2, method3");
		switch (methodChosen = getUserInput()) {
			case "method1":
				System.out.println("Search for a word");
				readAndSearchFile(setUpReader(fileName));
				printOutSpeed();
			break;
			case "method2":
				System.out.println("Search for a word");
				readFileMethod2(fileName);
				printOutSpeed();
			break;
			case "method3":
				System.out.println("Search for a word");
				readFileMethod3(fileName);
				printOutSpeed();
			break;
			default:
				System.out.println("Choose a valid method.");
		}
	}
	
	ArrayList<String> words = new ArrayList<String>();
	long startTime;
	long endTime;
	
	public void printOutSpeed() {
		System.out.println("Time to complete: " + ((endTime - startTime) / 1000000) + " miliseconds");
	}

	public void initWords() {
		words.add("apple ");
		words.add("orages ");
		words.add("books ");
		words.add("house ");
		words.add("this ");
		words.add("this ");
		words.add("ape ");
		words.add("phone ");
		words.add("car ");
		words.add("cat ");
	}

	public int getIndexOfWord(int multiplier) {
		int index = (int) (Math.random() * multiplier);
		return index;
	}

	/*
	 * public BufferedWriter setUpWriter(int fileNumber) { BufferedWriter
	 * bufferedWriter = null; FileWriter fileWriter; try { fileWriter = new
	 * FileWriter("test" + "-" + fileNumber + ".txt"); bufferedWriter = new
	 * BufferedWriter(fileWriter); } catch (IOException e) {
	 * e.printStackTrace(); } return bufferedWriter; }
	 * 
	 * public int getFileNumber(int increment) { int fileNumber = 0;
	 * //fileNumber += increment; return fileNumber++; }
	 * 
	 * public void createFile(BufferedWriter bufferedWriter) { initWords(); int
	 * numberOfFilesNeeded = 3; int numberOfWords = 3000; int wordsSize =
	 * words.size(); int numberOfWordsWritten = 0; try { for (int i = 0; i <
	 * numberOfFilesNeeded; i++) { for (int j = 0; j < numberOfWords; j++) { if
	 * (numberOfWordsWritten < 14) {
	 * bufferedWriter.write(words.get(getIndexOfWord(wordsSize)));
	 * numberOfWordsWritten++; } else {
	 * bufferedWriter.write(words.get(getIndexOfWord(wordsSize)));
	 * bufferedWriter.newLine(); numberOfWordsWritten = 0; } } }
	 * bufferedWriter.close(); } catch(IOException e) { e.printStackTrace(); }
	 * numberOfWordsWritten = 0; }
	 */

	public void createFile() {
		initWords();
		int fileNumber = 1;
		int numberOfWords = 3000;
		int wordsSize = words.size();
		int numberOfWordsWritten = 0;
		for (int i = 0; i < 3; i++) {
			try {
				FileWriter fileWriter = new FileWriter("test" + "-" + fileNumber + ".txt");
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for (int j = 0; j < numberOfWords; j++) {
					if (numberOfWordsWritten < 14) {
						bufferedWriter.write(words.get(getIndexOfWord(wordsSize)));
						numberOfWordsWritten++;
					} else {
						bufferedWriter.write(words.get(getIndexOfWord(wordsSize)));
						bufferedWriter.newLine();
						numberOfWordsWritten = 0;
					}
				}
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileNumber++;
			numberOfWordsWritten = 0;
		}
	}

	public String getUserInput() {
		String userInput;
		Scanner userInputScanner = new Scanner(System.in);
		userInput = userInputScanner.nextLine().toLowerCase();
		return userInput;
	}

	// Uses truncation, and BufferedReader(); to read. (Fastest method by
	// ~15miliseconds).
	public void readAndSearchFile(BufferedReader bufferedReader) {
		String word = getUserInput();
		String line = null;
		int wordLength = word.length();
		int counter = 0;
		try {
			startTime = System.nanoTime();
			while ((line = bufferedReader.readLine()) != null) {
				line = line.toLowerCase();
				while (line.length() >= wordLength) {
					if (line.startsWith(word)) {
						counter++;
					}
					line = line.substring(1);
				}
			}

			bufferedReader.close();
			endTime = System.nanoTime();
			System.out.println(counter);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Uses iteration by indexOf();, and Scanner(); to read. (Slowest method).
	public void readFileMethod2(String fileName) {
		String word = getUserInput().toLowerCase();
		String line = null;
		File file = new File(fileName);
		int wordLength = word.length();
		int counter = 0;
		try {
			startTime = System.nanoTime();
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNext()) {
				line = fileScanner.next().toLowerCase();
				if (line.length() >= wordLength) {
					if (line.startsWith(word)) {
						counter++;
					}
					line = line.substring(1);
				}
			}
			endTime = System.nanoTime();
			System.out.println(counter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// Uses truncation and BufferedReader(); to read. (Second fastest method,
	// beats method two by ~2miliseconds).
	public void readFileMethod3(String fileName) {
		String word = getUserInput().toLowerCase();
		String line = null;
		File file = new File(fileName);
		int wordLength = word.length();
		int counter = 0;
		try {
			startTime = System.nanoTime();
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNext()) {
				line = fileScanner.next().toLowerCase();
				if (line.length() >= wordLength) {
					for (int i = 0; (i = line.indexOf(word, i)) != -1; i += word.length()) {
						counter++;
					}
				}
			}
			endTime = System.nanoTime();
			System.out.println(counter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public BufferedReader setUpReader(String fileName) {
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return bufferedReader;
	}

	public static void main(String[] args) {
		Assignment2 readFile = new Assignment2(null);

	}
}