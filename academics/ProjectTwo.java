import java.util.*;
import java.io.*;

public class ProjectTwo
{

	public void main(String[] args) throws FileNotFoundException, IOException
	{
		
		//Reads in the contents of matrices.txt
		Scanner MatrixBuilder = new Scanner(new File("matrices.txt"));
		//Creates a list of strings used to develop the matrices
		List<String> MatrixList = new ArrayList<String>();
		while(MatrixBuilder.hasNextLine())
		{
			MatrixList.add(MatrixBuilder.nextLine());
		}
	
		System.out.println(MatrixList);
		
		//Gets height and width for both matrices
		//Matrix 1 size
		int MatrixOneHeight = Integer.parseInt(MatrixList.get(0));
		int MatrixOneWidth = Integer.parseInt(MatrixList.get(1));
		//Matrix 2 size
		int MatrixTwoHeight = Integer.parseInt(MatrixList.get(2+MatrixOneHeight));
		int MatrixTwoWidth = Integer.parseInt(MatrixList.get(3+MatrixOneHeight));
		
		
		//Set up base matrices
		int MatrixOne[][] = new int[MatrixOneHeight][MatrixOneWidth];
		int MatrixTwo[][] = new int[MatrixTwoHeight][MatrixTwoWidth];
		
		System.out.println(Arrays.deepToString(MatrixOne));
		System.out.println(Arrays.deepToString(MatrixTwo));
		//Assigning values to matrix 1
		int i = 0;
		
		while(MatrixBuilder.hasNextLine() && i != 2+MatrixOneHeight)
		{
			//Creates teststring for each line in the file
			String TestString = MatrixBuilder.nextLine();
			if(i == 2 || i > 2)
			{
				String[] TempString = TestString.split(" ");
				System.out.println(TempString);
				//Goes from left to right for each line
				for(int j = 0; j < TempString.length; j++)
				{
					int TempInt = Integer.parseInt(TempString[j]);
					System.out.println(TempInt);
					MatrixOne[i-2][j] = TempInt;
				}
				
			}
			i++;
		}
		
		System.out.println(Arrays.deepToString(MatrixOne));
		
		//Assigning values to matrix 2
		int k = 0;
		//calculation used to determine where the end of 
		//Stripping should occur: 4 (width and height indicators)
		//Plus the sum of both matrix heights
		while(MatrixBuilder.hasNextLine() && k != 4+MatrixOneHeight+MatrixTwoHeight)
		{
			
			String TestString = MatrixBuilder.nextLine();
			if(k == 4+MatrixOneHeight)
			{
				String[] TempString = TestString.split(" ");
				System.out.println(TempString);
				for(int j = 0; j < TempString.length; j++)
				{
					int TempInt = Integer.parseInt(TempString[j]);
					System.out.println(TempInt);
					MatrixTwo[k][j] = TempInt;
				}
			}
			k++;
		}
		
		System.out.println(Arrays.deepToString(MatrixTwo));
		
		//I believe my methodology here is correct, but I think the reason the arrays appear as empty is
		//because my calculations for where to start and stop assignment of values may be wrong
	
	
		int FinalMatrixWidth = 0;
		//Determine the width of the final matrix
		if(MatrixOneWidth <= MatrixTwoWidth)
		{
			FinalMatrixWidth = MatrixOneWidth;
		}
		if(MatrixOneWidth >= MatrixTwoWidth)
		{
			FinalMatrixWidth = MatrixTwoWidth;
		}
		int FinalMatrixHeight1 = 0;
		//Determine the height of the final matrix
		if(MatrixOneHeight <= MatrixTwoHeight)
		{
			FinalMatrixHeight1 = MatrixOneHeight;
		}
		if(MatrixOneHeight >= MatrixTwoHeight)
		{
			FinalMatrixHeight1 = MatrixTwoHeight;
		}
		final int FinalMatrixHeight = FinalMatrixHeight1;
		//Matrix multiplication is essentially the sum of the product of the rows of matrix A
		//paired with the columns of matrix B. A(1)B(1) = C(1) and so on. A's rows correspond
		//to the product's row in C, while the column in B corresponds to the column in C.
		//A[1][1]*B[1][1] = C[1][1], A[1][1]*B[1][2] = C[1][2], A[2][1]*B[1][1] = C[2][1]
		//and so on.
		
		//Sets up the final matrix that contains all the answers
		int FinalMatrix[][] = new int[FinalMatrixHeight][FinalMatrixWidth];
		
		//Determines if the number of columns is odd or even
		boolean Odd = false;
		if(FinalMatrixWidth % 2 != 0)
		{
			Odd = true;
		}
		
		//Sets up the # of columns each thread has to do
		int LeftThread2 = FinalMatrixWidth/2;
		final int RightThread = FinalMatrixWidth;
		//If the # of columns is odd, cast the int to double and convert it such that 
		//the left thread deals with the additional central column
		if(Odd == true)
		{
			double LeftThread1 = (double)(FinalMatrixWidth / 2);
			LeftThread2 = (int)(Math.ceil(LeftThread1));
		}
		final int LeftThread = LeftThread2;
		//The actual multiplication operations to be used in the threads
		
		//declaration of final vars related to heights and widths...
		final int MatrixOneHeightFin = MatrixOneHeight;
		final int MatrixOneWidthFin = MatrixOneWidth;
		final int MatrixTwoHeightFin = MatrixTwoHeight;
		final int MatrixTwoWidthFin = MatrixTwoWidth;
		
		final int[][] MatrixOneFin = MatrixOne;
		final int[][] MatrixTwoFin = MatrixTwo;
		
		Runnable Left = new Runnable()
		{
			public void run()
			{
				//iterate width wise
				for(int i = 0; i < LeftThread; i++)
				{
					
					//iterate height wise
					for(int j = 0; j < FinalMatrixHeight; j++)
					{
						int sum = 0;
						//iterate through the width of matrix one
						for(int k = 0; k < MatrixOneHeightFin; k++)
						{
							//iterate through the height of matrix 2
							for(int l = 0; l < MatrixTwoWidthFin; l++)
							{
								sum = sum+MatrixOneFin[i][k]*MatrixTwoFin[l][i];
							}
						
						}
						FinalMatrix[i][j] = sum;
					}
				}
			}
		};
		Runnable Right = new Runnable()
		{
			public void run()
			{
				//Iterate width wise
				for(int i = RightThread; i == LeftThread; i--)
				{
					//Iterate height wise
					for(int j = 0; j < FinalMatrixHeight; j++)
					{
						int sum = 0;
						//iterate through the width of matrix one
						for(int k = MatrixOneWidthFin; k > (MatrixOneWidthFin/2); k--)
						{
							//iterate through the height of matrix 2
							for(int l = 0; l < MatrixTwoHeightFin; l++)
							{
								sum = sum+MatrixOneFin[i][k]*MatrixTwoFin[l][i];
							}
						
						}
						FinalMatrix[i][j] = sum;
					}
				}
			}
		};
		//Finally execute the math in two separate threads
		//First create the thread objects
		Thread LeftOne = new Thread(Left);
		Thread RightOne = new Thread(Right);
		
		//Start the threads
		LeftOne.start();
		RightOne.start();
	
	
	}
	
}