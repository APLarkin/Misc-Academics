//Homework 4
  
import java.util.Scanner;
 
import java.util.ArrayList;
 
import java.util.List;
 
import java.util.Collections;

 
public class homework4 

{


 
	public static void main(String args[])

	{


 
		//Pt 1
 
		//Vars
 
		int[] RandomNumbers = new int[100];
 
		int Count = 0;
 
		int RandomNo = 0;
 
		Scanner user_input = new Scanner(System.in);
 
/*

do

{

RandomNo = (int )(Math.random()*1);





}while(Count < 100);

*/
 



 
		//Pt 2
 
		//Vars
 
		int NoOfNumbers = 0;
 
		int NextNumber = 0;
 
		List<Integer> ListOfNumbers = new ArrayList<Integer>();


 
	//Body
 
		do
		{
 
			System.out.println("Enter a number: ");
			NextNumber = user_input.nextInt();
			ListOfNumbers.add(NextNumber);
			NoOfNumbers = NoOfNumbers + 1;
		}while(NoOfNumbers != 10);



		Object MinNumber = Collections.min(ListOfNumbers);


 
		System.out.println(MinNumber);


 
//Pt 3
 
//I accidentally did 2 and 3 as the same program.
 
//That's why it's interactive.
 
//Vars
 
		List<String> NamesList = new ArrayList<String>();
 
		int NoOfNames = 0;
 
		int RandomName = 0;
 
		int UserNumber = 0;


 
		String NewName = "";
 
		List<String> SecondNamesList = new ArrayList<String>();



 
		do
		{
 
			System.out.println("Enter a name: ");
			NewName = user_input.next();
			NamesList.add(NewName);
			NoOfNames = NoOfNames + 1;
 
		}while(NoOfNames != 10);


 
		RandomName = (int )(Math.random()*10);
 
		System.out.println(NamesList.get(RandomName));



		Collections.sort(NamesList);


 
		System.out.println(NamesList);
 
		System.out.println("Enter a number: ");

		UserNumber = user_input.nextInt();

		for(int i = 0; i < UserNumber; i++)
		{
			SecondNamesList.add(NamesList.get(i));
		
		}

		Collections.reverse(SecondNamesList);
 
		for(int i = 0; i < UserNumber; i++)
		{
			NamesList.set(i, SecondNamesList.get(i));
		}
 
		System.out.println(NamesList);
 
//Part 4
 
//Vars
 
		String UserSentence = "";
		
//Body
		System.out.println("Enter a sentence: ");
		
		UserSentence = user_input.next();
		
		Byte.parseByte(UserSentence);


	}


}
 