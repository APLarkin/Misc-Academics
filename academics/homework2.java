//HW2 pt1
import java.util.Scanner;

public class homework2
{
	public static void main(String args[]) //throw InterruptedException
	{
		//Part 1
		//Vars
		int StartHour = 0;
		int EndHour = 0;
		int TotalTime = 0;
		
		double FinalCost = 0.0;
		
		//Get hours
		Scanner user_input = new Scanner(System.in);
		System.out.print("Enter start hour: ");
		StartHour = user_input.nextInt();
		System.out.print("Enter end hour: ");
		EndHour = user_input.nextInt();
		
		//Final time
		TotalTime = EndHour - StartHour;
		
		FinalCost = TotalTime * 5.5;
		
		System.out.println("Final cost: " + FinalCost);
		
		
		//Part 2
		//Vars
		int Times = 0;
		
		//Calc
		while(Times < 100)
		{
			int No1 = (int )(Math.random() * 2);
			System.out.print(No1);
			Times = Times+1;
			
		}
		System.out.println(" ");
		
		/*
		//Part 3
		//I couldn't get this part to work, I'm not sure why.
		//Vars
		int again = 0;
		int RandomTime = 0;
		int RandomTimeCorrect = 0;
		String Ready = "";
		
		//Body
		do
		{
			RandomTime = (int )(Math.random() * 4);
			RandomTimeCorrect = RandomTime * 1000;
			System.out.println("Ready? (Y to start)");
			Ready = user_input.next();
			if(Ready == "Y")
			{
				Thread.sleep(RandomTimeCorrect);
			
			}
	
			
		}while(again != 1);
		*/
		
		//Part 4
		//Word of warning: I'm not sure I 100% understood what the question being asked was.
		
		//Vars
		int Score = 0;
		int RandomNo1 = 0;
		int RandomNo2 = 0;
		int FinalRand = 0;
		int UserNumber = 0;
		
		int Score2 = 0;
		
		String Again = "";
		
		do
		{
			RandomNo1 = (int )(Math.random() * 50+1);
			RandomNo2 = (int )(Math.random() * 50+1);
			FinalRand = RandomNo1 * RandomNo2;
			System.out.println(RandomNo1+"*"+RandomNo2);
			
			System.out.print("Answer?");
			UserNumber = user_input.nextInt();
			
			if(FinalRand != UserNumber)
			{
				Score2 = Score2 - 2;
			}
			if(FinalRand == UserNumber && FinalRand < 144)
			{
				Score2 = Score2 + 1;
			}
			if(FinalRand == UserNumber && FinalRand > 144 && FinalRand < 400)
			{
				Score2 = Score2 + 5;
			}
			if(FinalRand == UserNumber && FinalRand > 400)
			{
				Score2 = Score2 + 15;
			}
			
			System.out.print("Again? (Yes or no)");
			Again = user_input.next();
		
		}while(Again == "Yes");
		
	}

}