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


public class homework7
{
	public static void main(String args[]) throws FileNotFoundException
	{
		//Part 1 - weights
		//Scanner
		Scanner user_input = new Scanner(System.in);
		//Vars
		int EnterWeight = 0; //ounces
		int WeightLbs = 0; //divide weight in ounces by oz/lb
		int WeightOz = 0; //Get mod

		//Get weight.
		System.out.println("Enter weight in ounces: ");
		EnterWeight = user_input.nextInt();
		
		//Oz -> lbs
		WeightLbs = EnterWeight/16;
		//Remainder = oz
		WeightOz = EnterWeight%16;
		
		System.out.print("Weight: ");
		System.out.print(WeightLbs);
		System.out.print("lbs");
		System.out.print(" ");
		System.out.print(WeightOz);
		System.out.print("oz");
		System.out.println(" ");
		
		//Part 2
		//Vars
		int PerfectNumber = 0;
		int Factor = 0;
		int TempNumber = 0;
		List<Integer> DivisorsList = new ArrayList();
		List<Integer> PerfectNumbersList = new ArrayList();
		
		
		
		for(int i = 0; i < 10000; i++)
		{
			DivisorsList = new ArrayList();
			TempNumber = 0;
			Factor = i;
			for(int j = 1; j < Factor; j++)
			{
				if(Factor%j == 0)
				{
					DivisorsList.add(j);
				
				}
			}
			for(int k = 0; k < DivisorsList.size(); k++)
			{
				TempNumber = TempNumber + DivisorsList.get(k);
			}
			if(TempNumber == Factor)
			{
				PerfectNumbersList.add(Factor);
				System.out.println(Factor);
			}
		}
		System.out.println(PerfectNumbersList);
		//This doesn't loop correctly. It only seems to increase i by 1, and then stops, instead of going up to the full 1000
		//the way it's supposed to.
		
		//Part 3 - multiplication tables
		//Vars
		int UserNumber = 0;
		
		System.out.print("Enter a number: ");
		UserNumber = user_input.nextInt();
		
		for(int i = 1; i < UserNumber; i++)
		{
			
			for(int j = 1; j < UserNumber; j++)
			{
				System.out.print(i*j+" ");
			}
			System.out.println();
		}
		//I know it isn't fully aligned, but this works.
		//Part 4
		
		List<Integer> FlatArray = new ArrayList();
		int RandomNo = 0;
		int Xcoord = 0;
		int Ycoord = 0;
		int FinalNo = 0;
		int EndNo = 0;
		for(int i = 0; i < 100; i++)
		{
			RandomNo = 1+(int )(Math.random()*((100 - 1)+1));
			FlatArray.add(RandomNo);
		}
		System.out.println(FlatArray);
		
		System.out.println("Enter the Y coordinate: ");
		Ycoord = user_input.nextInt();
		System.out.println("Enter the X coordinate: ");
		Xcoord = user_input.nextInt();
		Xcoord = Xcoord-1;
		
		switch(Ycoord)
		{
			case 1: FinalNo = Xcoord;
			case 2: FinalNo = 10 + Xcoord;
			case 3: FinalNo = 20 + Xcoord;
			case 4: FinalNo = 30 + Xcoord;
			case 5: FinalNo = 40 + Xcoord;
			case 6: FinalNo = 50 + Xcoord;
			case 7: FinalNo = 60 + Xcoord;
			case 8: FinalNo = 70 + Xcoord;
			case 9: FinalNo = 80 + Xcoord;
			case 10: FinalNo = 90 + Xcoord;
		}
		EndNo = FlatArray.get(FinalNo);
		System.out.println("Number: "+EndNo);
		//I can't tell if this is right or not. Basically, I know that every 10
		//integers leads to the next row. With this, it treats each y coordinate
		//like units of 10, in order to get them onto the correct row.
		//1 = 0, because the list goes from 0 - 9 instead of 1 - 10
		//so 2 = 10, 3 = 20, etc.
		//When I ran it and tried to check, it seemed like the number landed
		//farther down the list than intended. It's possible I miscounted
		//because I was counting the numbers by hand.
		
		//Part 5
		Set<String> Wortliste = new LinkedHashSet<String>();
		List<String> WordHalves = new ArrayList();
		List<String> Words = new ArrayList();
		Scanner Wordlist = new Scanner(new File("wordlist.txt"));
		
		int WortlisteSize = 0;
		int WordHalf = 0;
		
		String Temp = "";
		String Temp2 = "";
		String Temp3 = "";
		
		while(Wordlist.hasNext())
		{
			Wortliste.add(Wordlist.nextLine());
			Words.add(Wordlist.nextLine());
		}
		Wordlist.close();
		
		WortlisteSize = Wortliste.size();
		for(int i = 0; i < WortlisteSize; i++)
		{
			Temp = Words.get(i); //This is the only way to get this to compile, even if it kinda defeats the purpose of using the set.
			WordHalf = Temp.length()/2;
			String[] TempParts = {
					Temp.substring(0, WordHalf),
					Temp.substring(WordHalf),
			};
			for(int j = 0; j < 2; j++)
			{
				Temp2 = TempParts[j];
			
				if(Wortliste.contains(Temp2))
				{
					WordHalves.add(Temp2);		
				}
			}
		}
		System.out.println(WordHalves);
		//This last part gives off an error, which I assume is an overflow because it's trying to read a line beyond
		//The end of the file.
	}

}