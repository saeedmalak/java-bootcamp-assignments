package com.codercampus;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		
		// instantiate a new random instance using Random Class
		Random random = new Random();
		
		// initialize variables
		int randomNumberGenerator = random.nextInt(100) + 1;

		int numberOfGuesses = 5;
		
		// instantiate a new scanner instance using Scanner Class
		Scanner scanner = new Scanner(System.in);
		System.out.print("Pick a number between 1 and 100 (inclusively): ");
		
		// store the user's integer value to a variable
		int userGuess = scanner.nextInt();
		
		// call the gameLogic function and pass in relevant parameters 
		gameLogic(userGuess, randomNumberGenerator, scanner, numberOfGuesses);
		scanner.close();
	}
	
	static void gameLogic (int userGuess, int randomNumberGenerator, Scanner scanner, int numberOfGuesses) {
		
		while (numberOfGuesses > 0) {
			// check for winner, wrong guesses and wrong inputs
			if (userGuess > 100 || userGuess < 1) {
				System.out.println();
				System.out.println("Your guess is not between 1 and 100, please try again");
			}
			else if (userGuess > randomNumberGenerator) {
				System.out.println();
				System.out.println("Please pick a lower number");
				numberOfGuesses--;
			}
			else if (userGuess < randomNumberGenerator) {
				System.out.println();
				System.out.println("Please pick a higher number");
				numberOfGuesses--;
			}
			else {
				System.out.println();
				System.out.println("You win!");
				System.out.println("The number to guess was: " + randomNumberGenerator);
				break;
			}
			
			// end the game if the user used all of their guesses 
			if (numberOfGuesses <= 0) {
				System.out.println();
				System.out.println("You lose!");
				System.out.println("The number to guess was: " + randomNumberGenerator);
				break;
			}
			System.out.println();
			System.out.print("Pick a number between 1 and 100: ");
			userGuess = scanner.nextInt(); 
		}
	}
}
