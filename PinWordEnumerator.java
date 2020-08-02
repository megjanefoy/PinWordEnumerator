import java.util.Scanner;

/** 
 * Title: Assignment 8 
 * Semester: COP3337 – Fall 2019
 * @author Megan Jane Thompson
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 * 
 * This program converts a numeric pin to an equivalent word using the digit to 
 * letter mapping on a standard telephone keypad.
 */
public class PinWordEnumerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a pin number-> "); //prompts user for input
        String num = scan.nextLine();              //obtains user's input
        System.out.println();
        System.out.printf("The keypad encodings for %s are:%n",num);        
        enumerateWords(num);
    }
    
    /**
       A wrapper for a recursive method that enumerates all the 
       phone keypad encodings for a number.
       @param n a string representing the number
     */
    public static void enumerateWords(String n){
    	enumerateWords(n, new String());
    }
    
    /**
     * This method is the recursive method called by enumberWords(String n).
     * @param n, a String representing the number.
     * @param s, a String representing the word built based on user's number.
     * @return result, being a String of the built upon permutation.
     */
    public static String enumerateWords(String n, String s) {
    	//String of letter groups corresponding to numbers on a phone
    	String[] letterGroups = {"", "", "ABC", "DEF", "GHI", 
    			                 "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    	String result = s;                                    // builds on s to obtain the full string
    	try {
    		int digit = Integer.parseInt(n.substring(0, 1));  //obtains first digit of string
        	String letterGroup = letterGroups[digit];         //obtains letter grouping of digit
    		for (int j = 0; j < letterGroup.length(); ++j) {
    			char letter = letterGroup.charAt(j);          //obtains letter from letter grouping
    			if (n.length() <= 1) {
    				result = s + letter;
    				System.out.println(result);               //prints out all possible permutations  
    			}
    			else {
    				result = enumerateWords(n.substring(1), s + letter);  //recursion call to build on string
    			}
    		}
    	}
    	catch (NumberFormatException except) {                //catches if user does not enter a numerical value
    		System.out.println("Invalid Entry. Please Enter Digit Values Only.");
    	}
    	catch (NullPointerException except) {                 //catches if user's input is blank
    		System.out.println("Invalid Entry. Please Enter A Number.");
    	}
    	catch (Exception except) {                            //catches all other errors
    		System.out.println("Invalid Entry. Please Enter A Numerical Value");
    	}
    		
    return result; 
    }
    
}
