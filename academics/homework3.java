//HW3

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class homework3
{
	public static void main(String args[])
	{
		//Part 1
		
		//Vars
		int No1 = 0;
		int EndNo = 0;
		
		Scanner user_input = new Scanner(System.in);
		
		//Start
		System.out.println("Input starting number: ");
		No1 = user_input.nextInt();
		
		//Body
		do
		{
			if((No1 & 1) == 0)
			{
				EndNo = No1/2;
			}
			else
			{
				EndNo = (3 * No1) + 1;
			}
			
			No1 = EndNo;
			System.out.print(No1 + " ");
		
		}while(EndNo != 1);
		//End
		
		//Part 2
		//Vars
		String YesNo = "";
		int TestScore = 0;
		int NoOfScores = 0;
		int SumOfScores = 0;
		int AvgOfScores = 0;
		int NumOfA = 0;
		int LocalScore = 0;
		
		List<Integer> TestScores = new ArrayList<Integer>();
		
		//Body
		do
		{
			System.out.print("Input next score: ");
			TestScore = user_input.nextInt();
			
			TestScores.add(TestScore);
			
			System.out.println("Continue?");
			YesNo = user_input.next();
			
			NoOfScores = NoOfScores+1;
		
		}while(!"No".equals(YesNo));
		TestScores.set(0, NoOfScores);
		System.out.println(TestScores);
		
		for(int i = 0; i < TestScores.size(); i++)
		{
			SumOfScores = SumOfScores + TestScores.get(i);
			LocalScore = TestScores.get(i);
			if(LocalScore > 89)
			{
				NumOfA = NumOfA + 1;
			}
		}
		AvgOfScores = SumOfScores / NoOfScores;
		System.out.println("Average: " + AvgOfScores);
		System.out.println("As: " + NumOfA);
		//End
		
		/*
		//Part 3
		//Vars
		String OriginalStatement = "";
		String NewStatement = "";
		int HalfLength = 0;
		
		System.out.println("Enter a message: ");
		OriginalStatement = user_input.next();
		
		int OrigStateLength = OriginalStatement.length();
		HalfLength = OrigStateLength/2;
		
		
		List Odds = new ArrayList();
		List Evens = new ArrayList();
		//Body
		for(int i = 0; i < OrigStateLength; i++)
		{
			if((i & 1) == 0)
			{
				Evens.add(OriginalStatement.charAt(i));
			}
			else
			{
				Odds.add(OriginalStatement.charAt(i));
			}
		
		}
		for(int i = 0; i < OrigStateLength; i++)
		{
			if(i < HalfLength)
			{
				NewStatement = NewStatement + Evens.get(i);
			}
			else
			{
				NewStatement = NewStatement + Odds.get(i);
			}
		
		}
		System.out.println(NewStatement);
		*/
		
		//Part 5
		//Vars
		
		String StartTime = "";
		String EndTime = "";
		
		String TimeZone = "";
		
		System.out.println("Enter time: ");
		StartTime = user_input.next();
		
	
	}

}