<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class DFAChecker
{
	
	public static void main(String[] args)
	{
		//Scanner for user input
		Scanner user_input = new Scanner(System.in);
		//Scanner for running through text file
		Scanner FileScanner = null;
		
		//Strings
		String FileName = "";
		
		//Booleans
		boolean end = false;
		
		//Array to hold text file data
		List<String> TextFile = new ArrayList<String>();
		List<String> TempList = new ArrayList<String>();
		
		//Integer Q (# of states)
		String Temp ="";
		int Q = 0;
		
		//Integer A (# of symbols in alphabet)
		int A = 0;
		
		//Integer F (# final states)
		int F = 0;
		
		//Integer to check final states
		int CheckState = 0;
		
		//Array to hold final states
		String[] Finals = null;
		
		//Array to hold Epsilon (alphabet)
		String[] Epsilon = null;
		
		//Get file name
		System.out.print("Input filename: ");
		FileName = user_input.next();
		
		//Strip file by lines as strings in the array
		
		try{
			FileScanner = new Scanner(new File(FileName));
		}catch(Exception FileNotFoundException){}
		
		while(FileScanner.hasNext())
		{
			TextFile.add(FileScanner.nextLine());
		}
		
		//Line 1 - get Q
		Temp = TextFile.get(0).toString();
		Q = Integer.parseInt(Temp);
		
		//Line 2 - get A
		Temp = TextFile.get(1).toString();
		A = Integer.parseInt(Temp);
		
		//Line Q+4 - get F
		Temp = TextFile.get(Q+3).toString();
		F = Integer.parseInt(Temp);
		
		//Line 3 - split into array of strings
		Temp = TextFile.get(2).toString();
		
		//Copies items from temp  to epsilon array, splitting by spaces
		Epsilon = Temp.split(" ");
		
		//Line 4 - Q-1, split transitions into an array of strings
		TempList = TextFile.subList(3,3+Q);
		
		//Array for transitions
		String Transitions[] = new String[Q];		
		
		//Line Q+4 - split into array of final states.
		Temp = TextFile.get(Q+4).toString();
		
		Finals = Temp.split(" ");
		
		//Copying items from templist to transitions array
		boolean UnbalancedTransitions = false;
		for(int i = 0; i != TempList.size(); i++)
		{
			Transitions[i] = TempList.get(i);
			String test = Transitions[i].replaceAll("\\s","");
			//Ensures that every transition is of the correct size.
			if(test.length() != A)
			{
				NFA(Epsilon, Transitions, FileName);
				UnbalancedTransitions = true;
			}
		}
		//All the relevant information is now stripped from the text file.
		
		//Check for lambda -- if lambda exists in the alphabet, it is  an NFA and goes into the NFA class.
		boolean LambdaInAlphabet = false;
		if(UnbalancedTransitions != true)
		{
			for(int i = 0; i != Epsilon.length; i++)
			{
				if(Epsilon[i].equals("LAMBDA"))
				{
					NFA(Epsilon, Transitions, FileName);
					LambdaInAlphabet = true;
				}
			}
			//Prevents  the program from continuing onto DFA component
		}
		//Prevents  the program from continuing onto DFA component
		if(LambdaInAlphabet == true || UnbalancedTransitions == true)
		{
			System.exit(0);
		}
		//This loop is where most of the action happens
		//Command holder
		String Command = "";
		//Epsilon index holder
		int index = 0;
		//indicator if the string falls on a valid final state
		boolean finalState = false;
		//indicator of the current state
		int State = 0;
		//Current state's possible transitions
		String[] CurrentTransitions = new String[A];
		//Check if current item is not in epsilon
		boolean NotFound = true;
		//Check for lambda
		boolean Lambda = false;
		
		while(end == false)
		{
			
			//Reset final state to false from previous runs
			finalState = false;
			
			//Reset not found 
			NotFound = true;
			
			//Prompts for new string
			System.out.print("Please input a string: ");
			Command = user_input.next();
			
			//If command is STOP, terminates the loop and the program
			if(Command.equals("STOP"))
			{
				end = true;
			}
			//Runs through the command string, starting at state 0
			for(int j = 0; j < Command.length(); j++)
			{	
				//Reset lambda check
				Lambda = false;
			
				//Sets up current transitions to reflect current state
				CurrentTransitions = Transitions[State].split(" ");
				
				//check for uppercase
				if(Command.substring(j,j+1).equals(Command.substring(j,j+1).toUpperCase()) )
				{
				
					//Checks first uppercase character for L, if not found then fatal error
					if(!Command.substring(j,j+1).equals("L"))
					{
						System.out.println("ERROR: Upper-case character detected.");
						System.out.println("System will now exit.");
						System.exit(0);
					}
					//If it is uppercase and the next 6 letters combined equate to LAMBDA, set J forward and continue
					//Calls a default error out of bounds if it's an L but not LAMBDA anyway, so... that's ok by me, since it would still have exited the program.
					if(Command.substring(j,j+6).equals("LAMBDA"))
					{
						j = j+6;
						continue;	
					}
				}
				
				//runs through the alphabet to get the correct index for the current command letter.
				for(int k = 0; k < Epsilon.length; k++)
				{
					
					if(Command.substring(j,j+1).equals(Epsilon[k]))
					{
						index = k;
						NotFound = false;
						break;
					}
					
				}
				//Handles nonexistant characters
				if(NotFound == true)
				{
					System.out.println("ERROR: Character not in alphabet");
					continue;
				}
				
				System.out.println(index);
				
				//Transitions to the next state
				Temp = CurrentTransitions[index];
				State = Integer.parseInt(Temp);
			}
			
			//checks the ending state against the array of final states
			for(int l = 0; l < Finals.length; l++)
			{
				Temp = Finals[l];
				CheckState = Integer.parseInt(Temp);
				//If the state is found in the list,  finalstate is set to true.
				if(State == CheckState)
				{
					finalState = true;
				}
			}
			if(finalState == true)
			{
				System.out.println("YES");
			}
			if(finalState == false)
			{
				System.out.println("NO");
			}
		
		}
	}
	
	//Class specifically for NFAs since I have to go about this somewhat differently.
	public static void NFA(String[] E, String[] T, String FN)
	{
	
		//Scanner for user input
		Scanner user_input = new Scanner(System.in);
		//Scanner for running through text file
		Scanner FileScanner = null;
		
		//Booleans
		boolean end = false;
		
		//Array to hold text file data
		List<String> TextFile = new ArrayList<String>();
		List<String> TempList = new ArrayList<String>();
		
		//Integer Q (# of states)
		String Temp ="";
		int Q = 0;
		
		//Integer A (# of symbols in alphabet)
		int A = 0;
		
		//Integer F (# final states)
		int F = 0;
		
		//Integer to check final states
		int CheckState = 0;
		
		//Array to hold final states
		String[] Finals = null;
		
		//Array to hold Epsilon (alphabet)
		String[] Epsilon = null;
		String[] Epsilon2 = null;
		
		//Strip file by lines as strings in the array
		
		try{
			FileScanner = new Scanner(new File(FN));
		}catch(Exception FileNotFoundException){}
		
		while(FileScanner.hasNext())
		{
			TextFile.add(FileScanner.nextLine());
		}
		
		//Line 1 - get Q
		Temp = TextFile.get(0).toString();
		Q = Integer.parseInt(Temp);
		
		//Line 2 - get A
		Temp = TextFile.get(1).toString();
		A = Integer.parseInt(Temp);
		
		//Line Q+4 - get F
		Temp = TextFile.get(Q+3).toString();
		F = Integer.parseInt(Temp);
		
		//Line 3 - split into array of strings
		Temp = TextFile.get(2).toString() + " " + "^";
		
		//Copies items from temp  to epsilon array, splitting by spaces
		Epsilon = Temp.split(" ");
		
		System.out.println(Arrays.toString(Epsilon));
		//Line 4 - Q-1, split transitions into an array of strings
		TempList = TextFile.subList(3,3+Q);
		
		//Array for transitions
		String Transitions[] = new String[Q];
		
		//Copying items from templist to transitions array
		for(int i = 0; i != TempList.size(); i++)
		{
			Transitions[i] = TempList.get(i);
			String test = Transitions[i].replaceAll("\\s","");
		}
		
		
		//Line Q+4 - split into array of final states.
		Temp = TextFile.get(Q+4).toString();
		
		Finals = Temp.split(" ");
		
		//All the relevant information is now stripped from the text file.
		
		//Moving onto the actual checker part
		
		//Command holder
		String Command = "";
		//Epsilon index holder
		int index = 0;
		//indicator if the string falls on a valid final state
		boolean finalState = false;
		//indicator of the current state
		int State = 0;
		//Current state's possible transitions
		String[] CurrentTransitions = new String[A];
		//Check if current item is not in epsilon
		boolean NotFound = true;
		//Check for lambda
		boolean Lambda = false;
		
		while(end == false)
		{
			
			//Reset final state to false from previous runs
			finalState = false;
			
			//Reset not found 
			NotFound = true;
			
			//Prompts for new string
			System.out.print("Please input a string: ");
			Command = user_input.next();
			
			//If command is STOP, terminates the loop and the program
			if(Command.equals("STOP"))
			{
				break;
			}
			//Runs through the command string, starting at state 0
			for(int j = 0; j < Command.length(); j++)
			{	
				//Reset lambda check
				Lambda = false;
			
				//Sets up current transitions to reflect current state
				CurrentTransitions = Transitions[State].split(" ");
				
				//check for uppercase
				if(Command.substring(j,j+1).equals(Command.substring(j,j+1).toUpperCase()))
				{
				
					//Checks first uppercase character for L, if not found then fatal error
					if(!Command.substring(j,j+1).equals("L"))
					{
						System.out.println("ERROR: Upper-case character detected.");
						continue;
					}
					//If it is uppercase and the next 6 letters combined equate to LAMBDA, set J forward and continue
					//Calls a default error out of bounds if it's an L but not LAMBDA anyway, so... that's ok by me, since it would still have exited the program.
					if(Command.substring(j,j+6).equals("LAMBDA"))
					{
						j = j+6;
						continue;	
					}
				}
				
				//runs through the alphabet to get the correct index for the current command letter.
				for(int k = 0; k < Epsilon.length; k++)
				{
					
					if(Command.substring(j,j+1).equals(Epsilon[k]))
					{
						index = k;
						NotFound = false;
						break;
					}
					
				}
				//Handles nonexistant characters
				if(NotFound == true)
				{
					System.out.println("ERROR: Character not in alphabet");
					continue;
				}
				
				//Deals with blank transitions
				boolean done1 = false;
				boolean done2 = false;
				if(CurrentTransitions[index].equals("^") &&  done2 != true)
				{
					while(done1 != true)
					{
						//Scans through epsilon & the current transitions arrays simultaneously.
						for(int i = index; i < CurrentTransitions.length; i++)
						{
							for(int k = 0; k < Epsilon.length; k++)
							{
								//If the current transition is equal to epsilon k, set the index correctly.
								if(CurrentTransitions[i].equals(Epsilon[k]) && !Epsilon[k].equals("^"))
								{
									index = k;
									done1 = true;
									done2 = true;
									break;
								}
							}
						}
					
					}
				}
				//If currenttransitions is expended fully and the last index is still equal to ^, reject the string.
				if(CurrentTransitions[index].equals("^"))
				{
					System.out.println("NO");
					break;
				}
				System.out.println(index);
					
				//Transitions to the next state
				Temp = CurrentTransitions[index];
				State = Integer.parseInt(Temp);
				//Force loop to restart.
				if(j == Command.length())
				{
					j = 0;
					//Change all CurrentTransitions to be shifted left.
					for(int i = 0; i < CurrentTransitions.length; i++)
					{
						String tempstring1 = CurrentTransitions[i];
						for(int l = 0; l < tempstring1.length(); l++)
						{
							//Temp string to hold the new currenttransitions substring
							String tempstring = CurrentTransitions[l].substring(CurrentTransitions[i].length()-A, A);
							//Reassign current index to the new string.
							CurrentTransitions[l] = tempstring;
						}
					}
				}
				
			}
			//checks the ending state against the array of final states
			for(int l = 0; l < Finals.length; l++)
			{
				Temp = Finals[l];
				CheckState = Integer.parseInt(Temp);
				//If the state is found in the list,  finalstate is set to true.
				if(State == CheckState)
				{
					finalState = true;
				}
			}
			if(finalState == true)
			{
				System.out.println("YES");
			}
			if(finalState == false)
			{
				System.out.println("NO");
			}
		
		}
		System.out.println(Arrays.toString(Transitions));
	}

}
=======
import java.io.*;
import java.util.*;

public class DFAChecker
{
	
	public static void main(String[] args)
	{
		//Scanner for user input
		Scanner user_input = new Scanner(System.in);
		//Scanner for running through text file
		Scanner FileScanner = null;
		
		//Strings
		String FileName = "";
		
		//Booleans
		boolean end = false;
		
		//Array to hold text file data
		List<String> TextFile = new ArrayList<String>();
		List<String> TempList = new ArrayList<String>();
		
		//Integer Q (# of states)
		String Temp ="";
		int Q = 0;
		
		//Integer A (# of symbols in alphabet)
		int A = 0;
		
		//Integer F (# final states)
		int F = 0;
		
		//Integer to check final states
		int CheckState = 0;
		
		//Array to hold final states
		String[] Finals = null;
		
		//Array to hold Epsilon (alphabet)
		String[] Epsilon = null;
		
		//Get file name
		System.out.print("Input filename: ");
		FileName = user_input.next();
		
		//Strip file by lines as strings in the array
		
		try{
			FileScanner = new Scanner(new File(FileName));
		}catch(Exception FileNotFoundException){}
		
		while(FileScanner.hasNext())
		{
			TextFile.add(FileScanner.nextLine());
		}
		
		//Line 1 - get Q
		Temp = TextFile.get(0).toString();
		Q = Integer.parseInt(Temp);
		
		//Line 2 - get A
		Temp = TextFile.get(1).toString();
		A = Integer.parseInt(Temp);
		
		//Line Q+4 - get F
		Temp = TextFile.get(Q+3).toString();
		F = Integer.parseInt(Temp);
		
		//Line 3 - split into array of strings
		Temp = TextFile.get(2).toString();
		
		//Copies items from temp  to epsilon array, splitting by spaces
		Epsilon = Temp.split(" ");
		
		//Line 4 - Q-1, split transitions into an array of strings
		TempList = TextFile.subList(3,3+Q);
		
		//Array for transitions
		String Transitions[] = new String[Q];		
		
		//Line Q+4 - split into array of final states.
		Temp = TextFile.get(Q+4).toString();
		
		Finals = Temp.split(" ");
		
		//Copying items from templist to transitions array
		boolean UnbalancedTransitions = false;
		for(int i = 0; i != TempList.size(); i++)
		{
			Transitions[i] = TempList.get(i);
			String test = Transitions[i].replaceAll("\\s","");
			//Ensures that every transition is of the correct size.
			if(test.length() != A)
			{
				NFA(Epsilon, Transitions, FileName);
				UnbalancedTransitions = true;
			}
		}
		//All the relevant information is now stripped from the text file.
		
		//Check for lambda -- if lambda exists in the alphabet, it is  an NFA and goes into the NFA class.
		boolean LambdaInAlphabet = false;
		if(UnbalancedTransitions != true)
		{
			for(int i = 0; i != Epsilon.length; i++)
			{
				if(Epsilon[i].equals("LAMBDA"))
				{
					NFA(Epsilon, Transitions, FileName);
					LambdaInAlphabet = true;
				}
			}
			//Prevents  the program from continuing onto DFA component
		}
		//Prevents  the program from continuing onto DFA component
		if(LambdaInAlphabet == true || UnbalancedTransitions == true)
		{
			System.exit(0);
		}
		//This loop is where most of the action happens
		//Command holder
		String Command = "";
		//Epsilon index holder
		int index = 0;
		//indicator if the string falls on a valid final state
		boolean finalState = false;
		//indicator of the current state
		int State = 0;
		//Current state's possible transitions
		String[] CurrentTransitions = new String[A];
		//Check if current item is not in epsilon
		boolean NotFound = true;
		//Check for lambda
		boolean Lambda = false;
		
		while(end == false)
		{
			
			//Reset final state to false from previous runs
			finalState = false;
			
			//Reset not found 
			NotFound = true;
			
			//Prompts for new string
			System.out.print("Please input a string: ");
			Command = user_input.next();
			
			//If command is STOP, terminates the loop and the program
			if(Command.equals("STOP"))
			{
				end = true;
			}
			//Runs through the command string, starting at state 0
			for(int j = 0; j < Command.length(); j++)
			{	
				//Reset lambda check
				Lambda = false;
			
				//Sets up current transitions to reflect current state
				CurrentTransitions = Transitions[State].split(" ");
				
				//check for uppercase
				if(Command.substring(j,j+1).equals(Command.substring(j,j+1).toUpperCase()) )
				{
				
					//Checks first uppercase character for L, if not found then fatal error
					if(!Command.substring(j,j+1).equals("L"))
					{
						System.out.println("ERROR: Upper-case character detected.");
						System.out.println("System will now exit.");
						System.exit(0);
					}
					//If it is uppercase and the next 6 letters combined equate to LAMBDA, set J forward and continue
					//Calls a default error out of bounds if it's an L but not LAMBDA anyway, so... that's ok by me, since it would still have exited the program.
					if(Command.substring(j,j+6).equals("LAMBDA"))
					{
						j = j+6;
						continue;	
					}
				}
				
				//runs through the alphabet to get the correct index for the current command letter.
				for(int k = 0; k < Epsilon.length; k++)
				{
					
					if(Command.substring(j,j+1).equals(Epsilon[k]))
					{
						index = k;
						NotFound = false;
						break;
					}
					
				}
				//Handles nonexistant characters
				if(NotFound == true)
				{
					System.out.println("ERROR: Character not in alphabet");
					continue;
				}
				
				System.out.println(index);
				
				//Transitions to the next state
				Temp = CurrentTransitions[index];
				State = Integer.parseInt(Temp);
			}
			
			//checks the ending state against the array of final states
			for(int l = 0; l < Finals.length; l++)
			{
				Temp = Finals[l];
				CheckState = Integer.parseInt(Temp);
				//If the state is found in the list,  finalstate is set to true.
				if(State == CheckState)
				{
					finalState = true;
				}
			}
			if(finalState == true)
			{
				System.out.println("YES");
			}
			if(finalState == false)
			{
				System.out.println("NO");
			}
		
		}
	}
	
	//Class specifically for NFAs since I have to go about this somewhat differently.
	public static void NFA(String[] E, String[] T, String FN)
	{
	
		//Scanner for user input
		Scanner user_input = new Scanner(System.in);
		//Scanner for running through text file
		Scanner FileScanner = null;
		
		//Booleans
		boolean end = false;
		
		//Array to hold text file data
		List<String> TextFile = new ArrayList<String>();
		List<String> TempList = new ArrayList<String>();
		
		//Integer Q (# of states)
		String Temp ="";
		int Q = 0;
		
		//Integer A (# of symbols in alphabet)
		int A = 0;
		
		//Integer F (# final states)
		int F = 0;
		
		//Integer to check final states
		int CheckState = 0;
		
		//Array to hold final states
		String[] Finals = null;
		
		//Array to hold Epsilon (alphabet)
		String[] Epsilon = null;
		String[] Epsilon2 = null;
		
		//Strip file by lines as strings in the array
		
		try{
			FileScanner = new Scanner(new File(FN));
		}catch(Exception FileNotFoundException){}
		
		while(FileScanner.hasNext())
		{
			TextFile.add(FileScanner.nextLine());
		}
		
		//Line 1 - get Q
		Temp = TextFile.get(0).toString();
		Q = Integer.parseInt(Temp);
		
		//Line 2 - get A
		Temp = TextFile.get(1).toString();
		A = Integer.parseInt(Temp);
		
		//Line Q+4 - get F
		Temp = TextFile.get(Q+3).toString();
		F = Integer.parseInt(Temp);
		
		//Line 3 - split into array of strings
		Temp = TextFile.get(2).toString() + " " + "^";
		
		//Copies items from temp  to epsilon array, splitting by spaces
		Epsilon = Temp.split(" ");
		
		System.out.println(Arrays.toString(Epsilon));
		//Line 4 - Q-1, split transitions into an array of strings
		TempList = TextFile.subList(3,3+Q);
		
		//Array for transitions
		String Transitions[] = new String[Q];
		
		//Copying items from templist to transitions array
		for(int i = 0; i != TempList.size(); i++)
		{
			Transitions[i] = TempList.get(i);
			String test = Transitions[i].replaceAll("\\s","");
		}
		
		
		//Line Q+4 - split into array of final states.
		Temp = TextFile.get(Q+4).toString();
		
		Finals = Temp.split(" ");
		
		//All the relevant information is now stripped from the text file.
		
		//Moving onto the actual checker part
		
		//Command holder
		String Command = "";
		//Epsilon index holder
		int index = 0;
		//indicator if the string falls on a valid final state
		boolean finalState = false;
		//indicator of the current state
		int State = 0;
		//Current state's possible transitions
		String[] CurrentTransitions = new String[A];
		//Check if current item is not in epsilon
		boolean NotFound = true;
		//Check for lambda
		boolean Lambda = false;
		
		while(end == false)
		{
			
			//Reset final state to false from previous runs
			finalState = false;
			
			//Reset not found 
			NotFound = true;
			
			//Prompts for new string
			System.out.print("Please input a string: ");
			Command = user_input.next();
			
			//If command is STOP, terminates the loop and the program
			if(Command.equals("STOP"))
			{
				break;
			}
			//Runs through the command string, starting at state 0
			for(int j = 0; j < Command.length(); j++)
			{	
				//Reset lambda check
				Lambda = false;
			
				//Sets up current transitions to reflect current state
				CurrentTransitions = Transitions[State].split(" ");
				
				//check for uppercase
				if(Command.substring(j,j+1).equals(Command.substring(j,j+1).toUpperCase()))
				{
				
					//Checks first uppercase character for L, if not found then fatal error
					if(!Command.substring(j,j+1).equals("L"))
					{
						System.out.println("ERROR: Upper-case character detected.");
						continue;
					}
					//If it is uppercase and the next 6 letters combined equate to LAMBDA, set J forward and continue
					//Calls a default error out of bounds if it's an L but not LAMBDA anyway, so... that's ok by me, since it would still have exited the program.
					if(Command.substring(j,j+6).equals("LAMBDA"))
					{
						j = j+6;
						continue;	
					}
				}
				
				//runs through the alphabet to get the correct index for the current command letter.
				for(int k = 0; k < Epsilon.length; k++)
				{
					
					if(Command.substring(j,j+1).equals(Epsilon[k]))
					{
						index = k;
						NotFound = false;
						break;
					}
					
				}
				//Handles nonexistant characters
				if(NotFound == true)
				{
					System.out.println("ERROR: Character not in alphabet");
					continue;
				}
				
				//Deals with blank transitions
				boolean done1 = false;
				boolean done2 = false;
				if(CurrentTransitions[index].equals("^") &&  done2 != true)
				{
					while(done1 != true)
					{
						//Scans through epsilon & the current transitions arrays simultaneously.
						for(int i = index; i < CurrentTransitions.length; i++)
						{
							for(int k = 0; k < Epsilon.length; k++)
							{
								//If the current transition is equal to epsilon k, set the index correctly.
								if(CurrentTransitions[i].equals(Epsilon[k]) && !Epsilon[k].equals("^"))
								{
									index = k;
									done1 = true;
									done2 = true;
									break;
								}
							}
						}
					
					}
				}
				//If currenttransitions is expended fully and the last index is still equal to ^, reject the string.
				if(CurrentTransitions[index].equals("^"))
				{
					System.out.println("NO");
					break;
				}
				System.out.println(index);
					
				//Transitions to the next state
				Temp = CurrentTransitions[index];
				State = Integer.parseInt(Temp);
				//Force loop to restart.
				if(j == Command.length())
				{
					j = 0;
					//Change all CurrentTransitions to be shifted left.
					for(int i = 0; i < CurrentTransitions.length; i++)
					{
						String tempstring1 = CurrentTransitions[i];
						for(int l = 0; l < tempstring1.length(); l++)
						{
							//Temp string to hold the new currenttransitions substring
							String tempstring = CurrentTransitions[l].substring(CurrentTransitions[i].length()-A, A);
							//Reassign current index to the new string.
							CurrentTransitions[l] = tempstring;
						}
					}
				}
				
			}
			//checks the ending state against the array of final states
			for(int l = 0; l < Finals.length; l++)
			{
				Temp = Finals[l];
				CheckState = Integer.parseInt(Temp);
				//If the state is found in the list,  finalstate is set to true.
				if(State == CheckState)
				{
					finalState = true;
				}
			}
			if(finalState == true)
			{
				System.out.println("YES");
			}
			if(finalState == false)
			{
				System.out.println("NO");
			}
		
		}
		System.out.println(Arrays.toString(Transitions));
	}

}
>>>>>>> origin/master
