package cipher;

import java.util.Scanner;

public class EncryptionMachine {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static int SHIFT;

	/**
	 * Encrypts a single character using a Caesar cipher.
	 *
	 * @param letter, The character to be encrypted. This should be a lowercase letter from the alphabet.
	 * If the character is a space (' '), it is returned unchanged.
	 * @param shift, The number of positions to shift the character forward in the alphabet.
	 * If the shift moves past the end of the alphabet, it wraps around to the beginning.
	 * @return The encrypted character after applying the Caesar cipher with the given shift.
	 * If the input is a space, the space is returned as is.
	 */
	public static char encryptChar(char letter, int shift) {
		
		//if input letter is found to be a space character, return that character instead of shifting
		if(letter == ' ') {
			return ' ';
		}
		
		SHIFT = shift;
		int currentPos = ALPHABET.indexOf(letter);
		int newPos = (currentPos + SHIFT) % ALPHABET.length();
		return ALPHABET.charAt(newPos);
	}
	
	/**
	 * Encrypts a single character using a Caesar cipher with a default shift of 3.
	 * @param letter, The character to be encrypted. This should be a lowercase letter from the alphabet.
	 * If the character is a space (' '), it is returned unchanged.
	 * @return The encrypted character after applying the Caesar cipher with a shift of 3.
	 * If the input is a space, the space is returned as is.
	 */
	public static char encryptChar(char letter) {
		SHIFT = 3;
		return encryptChar(letter, SHIFT);
	}
	
	/**
	 * Encrypted word by calling the encryptChar method which shifts characters in alphabetical order, then prints it
	 * @param word to process
	 */
	public static void encryptWord(String word) {
		StringBuilder encryptedWord = new StringBuilder();
		for(int i = 0; i < word.length(); i++) {
			encryptedWord.append(encryptChar(word.charAt(i)));
		}
		System.out.println("\"" + word + "\"" + " has been encrypted to: " + encryptedWord.toString() + "\n");
	}
	
	/**
	 * Method that prompts user for input and returns user input
	 * @param promptText that will be printed giving the user instructions on what to input
	 * @return user input as a string
	 */
	public static String getUserInput(String promptText) {
		Scanner scan = new Scanner(System.in);
		System.out.println(promptText);
		return scan.next();
	}
	
	/**
	 * Method that prints introduction text
	 */
	public static void printIntroText() {
		System.out.println("Welcome to the CSCI717 Encryption Machine Construction\n"
				+ "The program lets you encrypt a message\n"
				+ "with a key for your recipient to decrypt!");
	}
	
	/**
	 *  Gets user input on number of loops and encrypts each word through the loop
	 * @param noOfWords, Number of loops to process each word
	 */
	public static void loopHandler(int noOfWords) {
		for(int i = 0; i < noOfWords; i++)
		{
			encryptWord(getUserInput("Next word:"));
		}
		System.out.println("Message fully encrypted. Happy secret messaging!");
	}
	
	public static void main(String[] args) {
		printIntroText();
		String keyInput = getUserInput("Enter key:");
		encryptWord(keyInput);
		int noOfWords = Integer.parseInt(getUserInput("How many words is your message?"));
		loopHandler(noOfWords);
	}

}
