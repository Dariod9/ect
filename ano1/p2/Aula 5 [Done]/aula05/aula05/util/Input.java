package util;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

/** This class contains methods for robust interactive input. */
public class Input {
  private static Scanner input = new Scanner(System.in);

  /** Get a double value from a line read from standard input.
   * Should repeat until a valid double value is actually read.
   * @param prompt the message to prompt for input.
   * @return the value read from input.
   */
  public static double getDouble(String prompt) {
    double r = 0;
    boolean frase=false;
    while(frase==false){
		try{
		err.print(prompt);
		String line = input.nextLine();
		r = Double.parseDouble(line.trim());
		frase=true;
		
		}catch(NumberFormatException a){
		out.println("Invalid input format!");
		frase=false;
		}
		
	}
    return r;
  }

  /** Get a double value within a given range, from standard input.
   * Should repeat until a valid double value is actually read.
   *
   * @param prompt the message to prompt for input.
   * @param min minimum value allowed.
   * @param max maximum value allowed.
   * Precondition: min<=max
   * @return the value read from input.
   * Postcondition: result in in [min, max].
   */
  public static double getDouble(String prompt, double min, double max) {
    
   // Add an assertion to test the precondition...
	try{
		assert (min<max);
		}
		catch(AssertionError a){
			out.println("Invalid range of numbers");
			while(min>=max){
				min=input.nextDouble();
				max=input.nextDouble();				
				}			
			
			}
    double r = 0;
	boolean number=true;
   while(number==true){
    try{
			while (true) {
		  err.print(prompt);
		  String line = input.nextLine();
		  r = Double.parseDouble(line.trim());
		  if (min <= r && r <= max) break;
		  err.printf("Value must be in range [%f, %f]\n", min, max);
				}
		
			assert min <= r && r <= max : "Postcondition";
			number=false;
			
	}catch(NumberFormatException b){
			out.println("Invalid input format!");
			number=true;				
		}
				
   	}
  return r;
  }

}
