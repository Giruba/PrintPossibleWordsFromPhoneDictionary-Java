package Application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Possible Words from given phone digits");
		System.out.println("--------------------------------------");
		
		try {
			System.out.println("Enter the number of digits for which the possible words"
					+ " have to be printed");
			Scanner scanner = new Scanner(System.in); 
			int numberOfDigits = scanner.nextInt();
			int[] arrayOfDigits = new int[numberOfDigits];
			for(int index = 0; index < numberOfDigits; index++) {
				System.out.println("Enter the digit");
				arrayOfDigits[index] = scanner.nextInt();
			}
			PrintWordsFromPhoneDigits(arrayOfDigits);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}		
	}
	
	public static void PrintWordsFromPhoneDigits(int[] arrayOfDigits) {
		
		//We do not have 0 as the starting number in the phone case
		//1 does not have any alphabets, so that corresponding entry will be empty
		String[] phoneStringArray = {"", "", "abc", "def", "ghi", "ijk", "lmn", "opq",
				"rst", "uvw", "xyz"};
		
		//Word Length is equal to the number of digits
		char []result = new char[arrayOfDigits.length+1];
		_PrintWordsFromPhoneDigits(phoneStringArray, arrayOfDigits, 0, result, arrayOfDigits.length);
	}
	
	private static void _PrintWordsFromPhoneDigits(String[] phoneStringArray, int[] arrayOfDigits, int currentDigitIndex, char[] result, int numberOfDigits) {
		
		if(currentDigitIndex == numberOfDigits) {
			System.out.println(new String(result));
			return;
		}
		
		for(int index = 0; index <arrayOfDigits.length; index++) {
			result[currentDigitIndex] = phoneStringArray[arrayOfDigits[currentDigitIndex]].charAt(index);
			_PrintWordsFromPhoneDigits(phoneStringArray, arrayOfDigits, currentDigitIndex+1, result, numberOfDigits);
			if(arrayOfDigits[currentDigitIndex] == 0 || arrayOfDigits[currentDigitIndex] == 1) {
				return;
			}
		}
	}
}
