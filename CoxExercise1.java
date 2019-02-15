

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


