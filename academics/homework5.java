//Homework 5
  
import java.util.Scanner;
 
import java.util.ArrayList;
 
import java.util.List;
 
import java.util.Collections;

 
public class homework5

{


 
	public static void main(String args[])

	{
		//Part 1
		//Vars
		String Numbers = "";
		Scanner user_input = new Scanner(System.in);
		List<Integer> NumList = new ArrayList();
		String Temp = "";
		int TempInt = 0;
		int FinalCount = 0;
		
		//Start
		System.out.print("Enter a set of numbers divided by semicolons: ");
		Numbers = user_input.next();
		
		//split
		String[] SplitNumbers = Numbers.split("\\;");
		int Length = Numbers.length() - Numbers.replace(";","").length();
		Length = Length + 1;
		
		//Calc
		for(int i = 0; i < Length; i++)
		{
			Temp = SplitNumbers[i];
			TempInt = Integer.parseInt(Temp);
			FinalCount = FinalCount + TempInt;
			System.out.println(FinalCount);
		}
		//Part 2
		//Vars
		String UserSentence = "";
		
		UserSentence = user_input.next();
		
		/*I can't get the damn thing to split this string
		
		String[] SplitSentence = UserSentence.split("\\s*", ",");
		System.out.println(SplitSentence[0]);
		System.out.println(SplitSentence[1]);
		*/
		
		//Lists
		List<String> CussList = new ArrayList()
		{{
			add("darn"); 
			add("dang"); 
			add("frickin"); 
			add("heck"); 
			add("shoot"); 
			add("Darn"); 
			add("Dang"); 
			add("Frickin"); 
			add("Heck"); 
			add("Shoot");
		}};
		
		List<String> CensorList = new ArrayList()
		{{
			add("****"); 
			add("****"); 
			add("*******"); 
			add("****"); 
			add("*****"); 
			add("****"); 
			add("****"); 
			add("*******"); 
			add("****"); 
			add("*****");
		}};
		
		//The basic idea was to use a do-while loop and check each segment of a split string
		//against the list of cusswords, and then if there was a match, replace it with a
		//Corresponding censor "word" from the censor list
		
		//Part 3
		//Vars
		int[][] SixBySix = new int[6][6];
		int[] OneDimension = new int[36];
		int RandomNumber = 0;
		int Counter = 0;
		
		//Assigning vals to the array
		//Program seems to hit a snag here, can't figure out why. I get no errors or anything.		
		do
		{
			RandomNumber = (int )(Math.random()*10);
			
			Counter = Counter + 1;
			
			SixBySix[0][Counter] = RandomNumber;
			
		
		
		}while(Counter < 6);
		
		Counter = 0;
		do
		{
			RandomNumber = (int )(Math.random()*10);
			
			Counter = Counter + 1;
			
			SixBySix[1][Counter] = RandomNumber;
			
		
		
		}while(Counter < 6);
		Counter = 0;
		do
		{
			RandomNumber = (int )(Math.random()*10);
			
			Counter = Counter + 1;
			
			SixBySix[2][Counter] = RandomNumber;
			
		
		
		}while(Counter < 6);
		Counter = 0;
		do
		{
			RandomNumber = (int )(Math.random()*10);
			
			Counter = Counter + 1;
			
			SixBySix[3][Counter] = RandomNumber;
			
		
		
		}while(Counter < 6);
		Counter = 0;
		do
		{
			RandomNumber = (int )(Math.random()*10);
			
			Counter = Counter + 1;
			
			SixBySix[4][Counter] = RandomNumber;
			
		
		
		}while(Counter < 6);
		Counter = 0;
		do
		{
			RandomNumber = (int )(Math.random()*10);
			
			Counter = Counter + 1;
			
			SixBySix[5][Counter] = RandomNumber;
			
		
		
		}while(Counter < 6);
		
		System.out.println(SixBySix);
		
		//Sum of the final row
		int Temp = 0;
		int FinalAnswer = 0;
		for(int i = 0;i < 6;i++)
		{
			Temp = SixBySix[5][i];
			FinalAnswer = FinalAnswer + Temp;
			
			System.out.println(FinalAnswer);	
		}
		
		//1D Array
		
		
		
		
	}
	
}