//Homework 8

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.LinkedHashSet;

public class homework8
{
	static String UserWord;
	static String AcctName;
	static double AcctIntRate;
	static double AcctAmt;
	public static void main(String args[])
	{
		//Part 1
		Scanner user_input = new Scanner(System.in);
		String Word = "";
		Word = getRandomCapital();
		char NewChar;
		System.out.println(Word);
		
		System.out.println("Enter a word: ");
		UserWord = user_input.next();
		
		NewChar = getRandomChar(UserWord);
		
		System.out.println(NewChar);
		
		//Part 2
		System.out.println("Enter name: ");
		AcctName = user_input.next();
		
		System.out.println("Enter starting amount: ");
		AcctAmt = user_input.nextDouble();
		
		System.out.println("Enter interest rate: ");
		AcctIntRate = user_input.nextDouble();
		
	
	}
	//1A
	public static String getRandomCapital()
	{
			int RandomNo = 0 + (int)(Math.random() * ((25 - 0) + 0));
			String[] Caps = new String[]{"A","A","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			
			
			
			return Caps[RandomNo];
		
	}
	//1B
	public static char getRandomChar(String args)
	{
		int WordLength = UserWord.length();
		int RandomNo = 0 + (int)(Math.random() * ((WordLength - 0) + 0));
		
		return UserWord.charAt(RandomNo);
	}
	//2
	//I know this isn't exactly what was asked for, but I can't figure out for the life of my
	//how constructors/getters/setters all work without getting a ton of errors about them.
	//This works, though.
	public class BankAccount
	{
		//2A, 2B, 2C
		private double amount = applyInterest();
		private double interestRate = AcctIntRate;
		private String name = AcctName;
	}
	public static double applyInterest()
	{
		double amount = AcctAmt;
		double interestRate = AcctIntRate;
		double adjustedamt = amount + (amount * interestRate);
		
		return adjustedamt;
	}
	//3
	
	
}

