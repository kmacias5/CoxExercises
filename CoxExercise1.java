
/**In the language of your choice, write a method that modifies a string using the following rules:

1. Each word in the input string is replaced with the following: the first letter of the word, the count of distinct letters between the first and last letter, and the last letter of the word. For example, “Automotive parts" would be replaced by "A6e p3s".
2. A "word" is defined as a sequence of alphabetic characters, delimited by any non-alphabetic characters.
3. Any non-alphabetic character in the input string should appear in the output string in its original relative location.**/
import java.util.Scanner;

public class CoxExercise1 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);



		System.out.print("Enter input:");

		String s1 = input.nextLine();



		String modifiedString = modifyInput(s1);

		System.out.println(modifiedString);



		input.close();

	}



	public static String modifyInput(String inputString) {

		StringBuilder outputString = new StringBuilder();

		String[] stringArray = inputString.split(" ");



		for (String word : stringArray) {

			int start = 0;

			int end = word.length() - 1;



			// find index of first alphabetic letter

			for (int i = start; i < word.length(); i++) {

				if (Character.isLetter(word.charAt(i))) {

					start = i;

					break;

				}

			}

			// find last index of last alphabetic letter

			for (int i = end; i >= start; i--) {

				if (Character.isLetter(word.charAt(i))) {

					end = i;

					break;

				}

			}

			// find number of occurrences in word

			String temp = "";

			for (int i = start + 1; i < end; i++) {

				if (temp.indexOf(word.charAt(i)) == -1) {

					temp = temp + word.charAt(i);

				}

			}



			// append every non-alphabetic character in correct order and

			// modified string

			for (int i = 0; i < word.length(); i++) {

				if (!Character.isLetter(word.charAt(i)) && i < start) {

					outputString.append(word.charAt(i));

				} else if (!Character.isLetter(word.charAt(i)) && i > end) {

					outputString.append(word.charAt(i));

				} else if (i == start) {

					outputString.append(word.charAt(start));

					outputString.append(temp.length());

					outputString.append(word.charAt(end));



				}

			}

			outputString.append(" ");

		}



		return outputString.toString();



	}



}


