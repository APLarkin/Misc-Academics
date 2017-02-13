//HW7
//Importing...
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



public class Exam
{
	public static void main(String args[]) throws FileNotFoundException
	{
		//Part 1
		//Vars
		Scanner user_input = new Scanner(System.in);
		String DMS = "";
		String Etc = "";
		String TempDeg = "";
		String TempMin = "";
		String TempSec = "";
		int D = 0;
		int M = 0;
		int S = 0;
		double d = 0.0;
		double m = 0.0;
		double s = 0.0;
		double FinalDec = 0.0;
		
		//Takes input
		System.out.println("Input angle: ");
		DMS = user_input.next();
		
		//splits and divides up
		String[] Segments = DMS.split("d");
		TempDeg = Segments[0];
		Etc = Segments[1];
		
		String[] Segments2 = Etc.split("'");
		TempMin = Segments2[0];
		TempSec = Segments2[1];
		
		String[] Segments3 = TempSec.split("''");
		
		TempSec = Segments3[0];
		
		//convert to int
		D = Integer.parseInt(TempDeg);
		M = Integer.parseInt(TempMin);
		S = Integer.parseInt(TempSec);
		//convert to double
		d = (double)D;
		m = (double)M;
		s = (double)S;
		
		//debug
		System.out.println(D);
		System.out.println(M);
		System.out.println(S);
		
		//calculate final number
		FinalDec = d + (m/60) + (s/3600);
		
		System.out.println(FinalDec);
		
		//Part 2
		//Vars
		List<Integer> NosList = new ArrayList();
		boolean end = false;
		int UserNo = 0;
		int No1 = 0;
		
		while(end != true)
		{
			System.out.println("Enter a positive number: ");
			UserNo = user_input.nextInt();
			NosList.add(UserNo);
			if(UserNo == 0)
			{
				end = true;
			}
		
		}
		
		//Arrange by size
		Collections.sort(NosList);
		No1 = NosList.size();
		//find second-largest
		No1 = No1 - 2;
		
		System.out.println(NosList.get(No1));
		
		//Part 3
		//vars
		int RandomNo = 0;
		int UserNo1 = 0;
		int UserNo2 = 0;
		int UserNo3 = 0;
		int UserNo4 = 0;
		int Sum = 0;
		int[][] SixBySix = new int[6][6];
		
		//Assign values
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				RandomNo = 1 + (int)(Math.random() * ((3 - 1) + 1));
				SixBySix[i][j] += RandomNo;
			}
		}
		//test
		System.out.println(Arrays.deepToString(SixBySix));
		
		//Get rows + columns
		System.out.println("Enter start row: ");
		UserNo1 = user_input.nextInt();
		System.out.println("Enter end row: ");
		UserNo2 = user_input.nextInt();
		System.out.println("Enter start column: ");
		UserNo3 = user_input.nextInt();
		System.out.println("Enter end column: ");
		UserNo4 = user_input.nextInt();
		
		for(int i = (UserNo1 - 1); i < (UserNo2+1); i++)
		{
			for(int j = (UserNo3 - 1); j < (UserNo4 + 1); j++)
			{
				Sum += SixBySix[i][j];
			}
		}
		System.out.println(Sum);
		//I may have accidentally flip-flopped the rows and columns, but it appears to work correctly.
		
		//Part 4
		//Vars
		int count = 0;
		int temp = 0;
		int RandomNo2 = 0 + (int)(Math.random()*((4 - 0)+1));
		
		Scanner MultiChoice1 = new Scanner(new File("multiple_choice.txt"));
		Scanner MultiChoice2 = new Scanner(new File("multiple_choice2.txt"));
		PrintWriter Reorder = new PrintWriter("Reorder.txt");
		ArrayList<String> List = new ArrayList<String>();
		
		//Write file to list
		while(MultiChoice1.hasNext())
		{
			List.add(MultiChoice1.nextLine());
		}
		
		//Separate questions from whole list
		System.out.println(List);
		List<String> Q1 = List.subList(0, 5);
		List<String> Q2 = List.subList(6, 10);
		List<String> Q3 = List.subList(11, 16);
		List<String> Q4 = List.subList(17, 23);
		
		//test
		System.out.println(Q1);
		System.out.println(Q2);
		System.out.println(Q3);
		System.out.println(Q4);
		
		//Separate answers from question, shuffle, and rewrite question
		List<String> TempQ1 = Q1.subList(1,5);
		
		Collections.shuffle(TempQ1);
		
		System.out.println(TempQ1);
		for(int i = 1; i < 5; i++)
		{
			Q1.set(i, TempQ1.get(i));
		}
		List<String> TempQ2 = Q2.subList(1,5);
		
		Collections.shuffle(TempQ2);
		
		for(int i = 1; i < 5; i++)
		{
			Q2.set(i, TempQ2.get(i));
		}
		List<String> TempQ3 = Q3.subList(1,5);
		
		Collections.shuffle(TempQ3);
		for(int i = 1; i < 5; i++)
		{
			Q3.set(i, TempQ3.get(i));
		}
		List<String> TempQ4 = Q4.subList(1,5);
		
		Collections.shuffle(TempQ4);
		for(int i = 1; i < 5; i++)
		{
			Q4.set(i, TempQ4.get(i));
		}
		//test
		System.out.println(Q1);
		System.out.println(Q2);
		System.out.println(Q3);
		System.out.println(Q4);
		
		//Write to file.
		Reorder.println(Q1);
		Reorder.println(Q2);
		Reorder.println(Q3);
		Reorder.println(Q4);
		
		//This seems quite rigid, but it should do everything asked.
		//It causes an out-of-bounds error beyond the shuffling of the answers on the first question
		//which I assume is related to re-writing of the original question list.
		//Does sublist actually break the original list apart? I have a hunch that there lies the problem.
		
		
	}

}