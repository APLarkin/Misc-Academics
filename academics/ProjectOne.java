//project 1

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProjectOne
{
	static Scanner user_input = new Scanner(System.in);
	public static void main(String args[]) throws FileNotFoundException
	{
		int AlgMode = 1; //1 - FIFO, 2 - LRU, 3 - CLOCK
		int NoLogicalPages = 0; //Number of logical pages
		int NoPageFrames = 0; //Number of page frames
		char SimInt = 'I'; //Used to determine which part of the sim to go to
		ArrayList<Integer> Pages = new ArrayList<Integer>();
		ArrayList<Integer> PageFrames = new ArrayList<Integer>();
		
		//setting up conditions
		//Skip either to sim, or to the interactive loop
		System.out.println("Simluator or interactive?(S for sim, I for interactive): ");
		SimInt = user_input.next().charAt(0);
		
		//get alg mode
		System.out.println("Please input the algorithm mode you would like to use (1 - FIFO, 2 - LRU, 3 - CLOCK: ");
		AlgMode = user_input.nextInt();
		
		//get number of logical pages
		System.out.println("Please input the number of pages you would like to use: ");
		NoLogicalPages = user_input.nextInt();
		NoLogicalPages = NoLogicalPages - 1;
		
		/*
		//set up the pages arraylist
		for(int i = 0; i<NoLogicalPages;i++)
		{
			Pages.set(i,null);
		}
		*/
		//get number of pageframes
		System.out.println("Please input the number of pageframes you would like to use: ");
		NoPageFrames = user_input.nextInt();
		/*
		//Set up the pageframes arraylist
		for(int i = 0; i<NoPageFrames;i++)
		{
			PageFrames.set(i,null);
		}
		*/
		//simulation-only stuff
		if(SimInt == 'S')
		{
			int CurrentPageFrame = 0;
			int NoPageFaults = 0;
			int CurrentPage = 0;
			ArrayList<Integer> LeastRecentlyUsed = new ArrayList<Integer>(); //Tracks index of the least recently used item
			
			int RefStringLength = 0;
			int K = 0;
			int tracker = 0;
			String FileName = "";
			ArrayList<Integer> RefString = new ArrayList<Integer>();
			
			//Get the length of reference string
			System.out.println("Input reference string length: ");
			RefStringLength = user_input.nextInt();
			
			//Get number of strings to randomly generate
			System.out.println("Input number of strings to randomly generate: ");
			K = user_input.nextInt();
		
			//Get filename for output
			System.out.println("Input filename for results: ");
			FileName = user_input.next();
			
			//File for output
			PrintWriter FileOutput = new PrintWriter(FileName);
		
			//FIFO loop
			if(AlgMode == 1)
			{
				boolean FirstPageLoaded = false;
				do{
					//Generate a random reference string
					for(int i = 0; i < RefStringLength;i++)
					{
						int RandomNo = 0 + (int)(Math.random() * ((NoLogicalPages - 0) + 0));
						RefString.set(i, RandomNo);
					
					}
					
					
					for(int m = 0; m < RefString.size(); m++)
					{
						CurrentPage = RefString.get(m);
						
						//Check if already a page in the array
						if(FirstPageLoaded == true)
						{
							//If valid, check if page is already in the array
							for(int j = 0; j < NoPageFrames;j++)
							{
								//Is in the array
								if(PageFrames.get(j).equals(CurrentPage))
								{
									System.out.println("Page loaded.");
									break;
								}
								//A null item is found
								if(PageFrames.get(j).equals(null))
								{
									System.out.println("Page fault");
									PageFrames.set(j, CurrentPage);
									break;
								}
								//If not in PageFrames, sets the index currently marked by CurrentPageFrame to the inputted value.
								if(NoPageFrames==j)
								{
									System.out.println("Page fault");
									PageFrames.set(CurrentPageFrame, CurrentPage);
									NoPageFaults++;
									CurrentPageFrame++;
								}
							}
						}
						//If first page is not yet loaded
						if(FirstPageLoaded != true)
						{
							System.out.println("Page loaded.");
							PageFrames.set(0, CurrentPage);
						}
					
						//Reset CurrentPageFrame to 0 if it exceeds total number of available page frames
						if(CurrentPageFrame > NoPageFrames)
						{
							CurrentPageFrame = 0;
						}
					}
					//Keeps track of which string K is currently on
					tracker++;
					//Writes outcomes to file on new lines
					FileOutput.println("String: " + RefString);
					FileOutput.println("Total pagefaults: " + NoPageFaults);
				}while(tracker != K);
			}
			
			//LRU loop
			if(AlgMode == 2)
			{
				boolean FirstPageLoaded = false;
				CurrentPageFrame = 0;
				do{
					//Generate a random reference string
					for(int i = 0; i < RefStringLength;i++)
					{
						int RandomNo = 0 + (int)(Math.random() * ((NoLogicalPages - 0) + 0));
						RefString.set(i, RandomNo);
					
					}
					for(int m = 0; m < RefString.size(); m++)
					{
						CurrentPage = RefString.get(m);
						//Check if already in the array
						if(FirstPageLoaded == true)
						{
							//If valid, check if page is already in the array
							for(int j = 0; j < NoPageFrames;j++)
							{
								//Already in the array
								if(PageFrames.get(j).equals(CurrentPage))
								{
									System.out.println("Page loaded.");
									for(int k = 0; k < LeastRecentlyUsed.size();k++)
									{
										if(LeastRecentlyUsed.get(k).equals(PageFrames.indexOf(CurrentPage)))
										{
											int temp1 = LeastRecentlyUsed.get(k);
											//Loop shifts all items from the acquired point and above one down.
											//This should let the least recently used items to "drift" to the bottom.
											for(int l = k; l < LeastRecentlyUsed.size()-1;l++)
											{
												LeastRecentlyUsed.set(l, LeastRecentlyUsed.get(l+1));
											}
											//Moves item to the very very end
											LeastRecentlyUsed.set(LeastRecentlyUsed.size(), temp1);
										}
									}
									break;
								}
								//If a null item is hit, sets index of LRU at j to j
								if(PageFrames.get(j).equals(null))
								{
									System.out.println("Page fault");
									PageFrames.set(j, CurrentPage);
									LeastRecentlyUsed.set(j, j);
									NoPageFaults++;
									break;
								}
								//If not in the array, replace pageframe marked as 0 in LeastRecentlyUsed
								if(j == NoPageFrames)
								{
									System.out.println("Page fault");
									PageFrames.set(LeastRecentlyUsed.get(0), CurrentPage);
									int temp2 = LeastRecentlyUsed.get(0);
									for(int k = 0; k < LeastRecentlyUsed.size();k++)
									{
										//Loop shifts all items from zero one down
										for(int l = 0; l < LeastRecentlyUsed.size()-1;l++)
										{
											LeastRecentlyUsed.set(l, LeastRecentlyUsed.get(l+1));
										}
										//places index of the new item in pageframes at the back
										LeastRecentlyUsed.set(LeastRecentlyUsed.size(), PageFrames.indexOf(temp2));
									
									}
									NoPageFaults++;
									break;
								}
								
							}
						
						}
					
						//If first page is not yet loaded
						if(FirstPageLoaded != true)
						{
							System.out.println("Page loaded.");
							PageFrames.set(0, CurrentPage);
						
							//I dont think i need to do anything special for the first part of LRU
							LeastRecentlyUsed.set(0, PageFrames.indexOf(CurrentPage));
						}
				
					}
				
					tracker++;
					//Writes outcomes to file on new lines
					FileOutput.println("String: " + RefString);
					FileOutput.println("Total pagefaults: " + NoPageFaults);
				}while(tracker != K);
			}
			
			//CLOCK loop
			if(AlgMode == 3)
			{
				boolean FirstPageLoaded = false;
				do{
					//Generate a random reference string
					for(int i = 0; i < RefStringLength;i++)
					{
						int RandomNo = 0 + (int)(Math.random() * ((NoLogicalPages - 0) + 0));
						RefString.set(i, RandomNo);
					
					}
					
					//Keeps track of 
					ArrayList<Boolean> ClockBoolTrack = new ArrayList<Boolean>();
					ArrayList<Integer> ClockIndexTrack = new ArrayList<Integer>();
					for(int m = 0; m < RefString.size(); m++)
					{
						CurrentPage = RefString.get(m);	
							
							//If first page is not yet loaded
							if(FirstPageLoaded != true)
							{
								System.out.println("Page loaded.");
								PageFrames.set(0, CurrentPage);
							}
							
							//If pages are already loaded
							if(FirstPageLoaded == true)
							{
							//If valid, check if page is already in the array
							for(int j = 0; j < NoPageFrames;j++)
							{
									//Pageframe we are currently on is true
									if(ClockBoolTrack.get(j).equals(true))
								{
									ClockBoolTrack.set(j, false);
									break;
								}
								//Pageframe we are on is false
								if(ClockBoolTrack.get(j).equals(false))
								{
									System.out.println("Page fault");
									PageFrames.set(j, CurrentPage);
									ClockBoolTrack.set(j, true);
									break;
								}
								//Pageframe is in PageFrames
								if(PageFrames.get(j).equals(CurrentPage))
								{
									System.out.println("Page loaded.");
									//Sets the bool tracker for the item to true
									ClockBoolTrack.set(CurrentPageFrame, true);
									break;
								}
								//A null pageframe is found
								if(PageFrames.get(j).equals(null))
								{
									System.out.println("Page fault");
									PageFrames.set(j, CurrentPage);
									ClockIndexTrack.set(j, PageFrames.indexOf(CurrentPage));
									ClockBoolTrack.set(j, true);
									break;
								}
								//If loop has not gone through break, sets the current value of that index on booltracker to false
								ClockBoolTrack.set(CurrentPageFrame, false);
								if(CurrentPageFrame < NoPageFrames)
								{
									CurrentPageFrame++;
									
								}
								if(CurrentPageFrame == NoPageFrames)
								{
									//Sets the current pageframe and "j" back to 0, to loop again
									CurrentPageFrame = 0;
									j = 0;
								}
							}
							
						}
					}
					
					tracker++;
					FileOutput.println("String: " + RefString);
					FileOutput.println("Total pagefaults: " + NoPageFaults);
				}while(tracker != K);
			}
		
			
		}
		//interactive-only stuff
		if(SimInt == 'I')
		{
			int CurrentPageFrame = 0;
			int NoPageFaults = 0;
			int CurrentPage = 0;
			ArrayList<Integer> LeastRecentlyUsed = new ArrayList<Integer>(); //Tracks index of the least recently used item
			boolean InteractiveComplete = false; //determines if the interactive part of the sim is complete
	
			//Main part of the interactive loop
			//FIFO loop
			if(AlgMode == 1)
			{
				boolean FirstPageLoaded = false;
				do
				{
					System.out.println("Input next number in reference string: ");
					CurrentPage = user_input.nextInt();
					
					//Check for invalid entry
					if(CurrentPage > NoLogicalPages)
					{
						System.out.println("Bad page entered");
						break;
					}
					if(CurrentPage < -1)
					{
						System.out.println("Bad page entered");
						break;
					}
					
					//Check if already a page in the array
					if(FirstPageLoaded == true)
					{
						//If valid, check if page is already in the array
						for(int j = 0; j < NoPageFrames;j++)
						{
							//Is in the array
							if(PageFrames.get(j).equals(CurrentPage))
							{
								System.out.println("Page loaded.");
								break;
							}
							//A null item is found
							if(PageFrames.get(j).equals(null))
							{
								System.out.println("Page fault");
								PageFrames.set(j, CurrentPage);
								break;
							}
							//If not in PageFrames, sets the index currently marked by CurrentPageFrame to the inputted value.
							if(NoPageFrames==j)
							{
								System.out.println("Page fault");
								PageFrames.set(CurrentPageFrame, CurrentPage);
								NoPageFaults++;
								CurrentPageFrame++;
							}
						}
					}
					//If first page is not yet loaded
					if(FirstPageLoaded != true)
					{
						System.out.println("Page loaded.");
						PageFrames.set(0, CurrentPage);
					}
				
					//Exit condition
					if(CurrentPage == -1)
					{
						InteractiveComplete = true;
						System.out.println("Number of page faults: " + NoPageFaults);
					}
					//Reset CurrentPageFrame to 0 if it exceeds total number of available page frames
					if(CurrentPageFrame > NoPageFrames)
					{
						CurrentPageFrame = 0;
					}
					
				}while(InteractiveComplete == false);
			}
			//LRU loop
			if(AlgMode == 2)
			{
				boolean FirstPageLoaded = false;
				CurrentPageFrame = 0;
				do
				{
					System.out.println("Input next number in reference string: ");
					CurrentPage = user_input.nextInt();
					
					//Check for invalid entry
					if(CurrentPage > NoLogicalPages)
					{
						System.out.println("Bad page entered");
						break;
					}
					if(CurrentPage < -1)
					{
						System.out.println("Bad page entered");
						break;
					}
					
					//Check if already in the array
					if(FirstPageLoaded == true)
					{
						//If valid, check if page is already in the array
						for(int j = 0; j < NoPageFrames;j++)
						{
							//Already in the array
							if(PageFrames.get(j).equals(CurrentPage))
							{
								System.out.println("Page loaded.");
								for(int k = 0; k < LeastRecentlyUsed.size();k++)
								{
									if(LeastRecentlyUsed.get(k).equals(PageFrames.indexOf(CurrentPage)))
									{
										int temp1 = LeastRecentlyUsed.get(k);
										//Loop shifts all items from the acquired point and above one down.
										//This should let the least recently used items to "drift" to the bottom.
										for(int l = k; l < LeastRecentlyUsed.size()-1;l++)
										{
											LeastRecentlyUsed.set(l, LeastRecentlyUsed.get(l+1));
										}
										//Moves item to the very very end
										LeastRecentlyUsed.set(LeastRecentlyUsed.size(), temp1);
									}
								}
								break;
							}
							//If a null item is hit, sets index of LRU at j to j
							if(PageFrames.get(j).equals(null))
							{
								System.out.println("Page fault");
								PageFrames.set(j, CurrentPage);
								LeastRecentlyUsed.set(j, j);
								NoPageFaults++;
								break;
							}
							//If not in the array, replace pageframe marked as 0 in LeastRecentlyUsed
							if(j == NoPageFrames)
							{
								System.out.println("Page fault");
								PageFrames.set(LeastRecentlyUsed.get(0), CurrentPage);
								int temp2 = LeastRecentlyUsed.get(0);
								for(int k = 0; k < LeastRecentlyUsed.size();k++)
								{
									//Loop shifts all items from zero one down
									for(int l = 0; l < LeastRecentlyUsed.size()-1;l++)
									{
										LeastRecentlyUsed.set(l, LeastRecentlyUsed.get(l+1));
									}
									//places index of the new item in pageframes at the back
									LeastRecentlyUsed.set(LeastRecentlyUsed.size(), PageFrames.indexOf(temp2));
									
								}
								NoPageFaults++;
								break;
							}
							
						}
						
					}
					
					//If first page is not yet loaded
					if(FirstPageLoaded != true)
					{
						System.out.println("Page loaded.");
						PageFrames.set(0, CurrentPage);
						
						//I dont think i need to do anything special for the first part of LRU
						LeastRecentlyUsed.set(0, PageFrames.indexOf(CurrentPage));
					}
				
					//Exit condition
					if(CurrentPage == -1)
					{
						InteractiveComplete = true;
					}
				
				}while(InteractiveComplete == false);
			}
			//CLOCK loop
			if(AlgMode == 3)
			{
				boolean FirstPageLoaded = false;
				//Keeps track of 
				ArrayList<Boolean> ClockBoolTrack = new ArrayList<Boolean>();
				ArrayList<Integer> ClockIndexTrack = new ArrayList<Integer>();
				do
				{
					System.out.println("Input next number in reference string: ");
					CurrentPage = user_input.nextInt();
					
					//Check for invalid entry
					if(CurrentPage > NoLogicalPages)
					{
						System.out.println("Bad page entered");
						break;
					}
					if(CurrentPage < -1)
					{
						System.out.println("Bad page entered");
						break;
					}
					
					//If first page is not yet loaded
					if(FirstPageLoaded != true)
					{
						System.out.println("Page loaded.");
						PageFrames.set(0, CurrentPage);
					}
					
					//If pages are already loaded
					if(FirstPageLoaded == true)
					{
						//If valid, check if page is already in the array
						for(int j = 0; j < NoPageFrames;j++)
						{
							//Pageframe we are currently on is true
							if(ClockBoolTrack.get(j).equals(true))
							{
								ClockBoolTrack.set(j, false);
								break;
							}
							//Pageframe we are on is false
							if(ClockBoolTrack.get(j).equals(false))
							{
								System.out.println("Page fault");
								PageFrames.set(j, CurrentPage);
								ClockBoolTrack.set(j, true);
								break;
							}
							//Pageframe is in PageFrames
							if(PageFrames.get(j).equals(CurrentPage))
							{
								System.out.println("Page loaded.");
								//Sets the bool tracker for the item to true
								ClockBoolTrack.set(CurrentPageFrame, true);
								break;
							}
							//A null pageframe is found
							if(PageFrames.get(j).equals(null))
							{
								System.out.println("Page fault");
								PageFrames.set(j, CurrentPage);
								ClockIndexTrack.set(j, PageFrames.indexOf(CurrentPage));
								ClockBoolTrack.set(j, true);
								break;
							}
							//If loop has not gone through break, sets the current value of that index on booltracker to false
							ClockBoolTrack.set(CurrentPageFrame, false);
							if(CurrentPageFrame < NoPageFrames)
							{
								CurrentPageFrame++;
								
							}
							if(CurrentPageFrame == NoPageFrames)
							{
								//Sets the current pageframe and "j" back to 0, to loop again
								CurrentPageFrame = 0;
								j = 0;
							}
						}
						
					}
				
					//Exit condition
					if(CurrentPage == -1)
					{
						InteractiveComplete = true;
					}
				}while(InteractiveComplete == false);
			}
		}
	
	}

	
}