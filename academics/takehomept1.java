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

public class takehomept1
{
	public static void main(String args[])
	{
		boolean win = false;
		boolean lose = false;
		boolean quit = false;
		
		int playerscore = 100;
		int guess = 0;
		String quituser = "";
		
		Scanner user_input = new Scanner(System.in);
		do
		{
			int randomnumber = 1 + (int)(Math.random() * ((10 - 1) + 1));
			System.out.println("Enter guess: ");
			guess = user_input.nextInt();
			
			if(guess < randomnumber)
			{
				playerscore = playerscore - 10;
				System.out.println("Sorry! Incorrect. Correct answer: " + randomnumber + " Current points: " + playerscore + " Continue? ");
				quituser = user_input.next();
				if(quituser == "y")
				{
					quit = true;
				}
				if(playerscore >= 200)
				{
					win = true;
				}
				if(playerscore <= 0)
				{
					lose = true;
				}

			}
			
			if(guess > randomnumber)
			{
				playerscore = playerscore - 20;
				System.out.println("Sorry! Incorrect. Correct answer: " + randomnumber + " Current points: " + playerscore + " Continue? ");
				quituser = user_input.next();
				if(quituser == "y")
				{
					quit = true;
				}
				if(playerscore >= 200)
				{
					win = true;
				}
				if(playerscore <= 0)
				{
					lose = true;
				}
			}
			if(guess == randomnumber)
			{
				playerscore = playerscore + 100;
				System.out.println("Correct! Current score: " + playerscore + " Continue? ");
				quituser = user_input.next();
				if(quituser == "y")
				{
					quit = true;
				}
				if(playerscore >= 200)
				{
					win = true;
				}
				if(playerscore <= 0)
				{
					lose = true;
				}
			}
		
		}while(win == false && lose == false && quit == false);
		if(win == true)
		{
			System.out.println("You win!");
		}
		if(lose == true)
		{
			System.out.println("You lose!");
		}
		
	}


}