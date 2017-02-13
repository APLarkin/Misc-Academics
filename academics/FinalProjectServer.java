<<<<<<< HEAD
//miniproject 2 - server
import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.*;

public class FinalProjectServer
{
	public static void main(String[] args) throws IOException
	{		
	
		//Socket setup
		ServerSocket ss = new ServerSocket(80);
		Socket sock = ss.accept();
		InputStream recvStream = sock.getInputStream();
		OutputStream sendStream = sock.getOutputStream();
		
		//Byte arrays
		byte[] buffer = new byte[1024];
		byte[] outBuffer = new byte[1024];
		//Get initial input
		recvStream.read(buffer, 0, 1024);
		System.out.println(new String(buffer, 0, 1024));
		
		String buf = new String(buffer, 0, 1024);
		
		//Other variables
		String Goodbye = "Play again?";
		String Correct = "Correct!";
		String Incorrect = "Incorrect!";
		String Win = "You win!";
		String Lose = "You lose!";
		
		//Boolean to keep game in loop
		boolean End = false;
		while(End == false)
		{
			//Win or lose.
			boolean WinLose = false;
			
			//Counts the # of occurrances in the stirng
			//Ideally I would generate a random string, then count the number of occurances and assign variables appropriately using a string array or similar.
			int T = 2;
			int E = 1;
			int S = 1;
			
			int TCount = 0;
			int ECount = 0;
			int SCount = 0;
			
			//Number of tries the client has
			int tries = 10;
			String Answer = "test";
			String Temp = "";
			char CharHolder;
			for(int i = 0; i < tries; i++)
			{
				boolean IsCorrect = false;
				recvStream.read(buffer, 0, 1024);
				//String Check = new String(buffer, "UTF-8");
				for(int j = 0; j < Answer.length();j++)
				{
					CharHolder = Answer.charAt(j);
					if(buffer.equals(Answer.charAt(j)))
					{
						if(CharHolder == 't')
						{
							TCount++;
						}
						if(CharHolder == 'e')
						{
							ECount++;
						}
						if(CharHolder == 's')
						{
							SCount++;
						}
						//Remove item from the string.
						Temp = Answer.substring(0, j) + Answer.substring(j+1);
						Answer = Temp;
						//Send message to the client.
						outBuffer = Serializer(Correct);
						sendStream.write(outBuffer);
						IsCorrect = true;
						j = j-1;
					}
				}
				//If not correct, send message + iterate tries down.
				if(IsCorrect == false)
				{
					tries = tries - 1;
					outBuffer = Serializer(Incorrect);
					sendStream.write(outBuffer);
				}
				if(TCount == T && ECount == E && SCount == S)
				{
					WinLose = true;
					break;
				}
			}
			
			//Display result
			if(WinLose == false)
			{
				outBuffer = Serializer(Lose);
				sendStream.write(outBuffer);
			}
			if(WinLose == true)
			{
				outBuffer = Serializer(Win);
				sendStream.write(outBuffer);
			}
			
			//Ask the player if they would like to replay.
			outBuffer = Serializer(Goodbye);
			sendStream.write(outBuffer);
			recvStream.read(buffer, 0, 1024);
			buf = new String(buffer, 0, 1024);
			
			if(buf == Goodbye)
			{
				End = true;
			}
		
		}
		recvStream.close();
		sendStream.close();
		
		sock.close();
		ss.close();
	}
	
	
	public static byte[] Serializer(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
=======
//miniproject 2 - server
import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.*;

public class FinalProjectServer
{
	public static void main(String[] args) throws IOException
	{		
	
		//Socket setup
		ServerSocket ss = new ServerSocket(80);
		Socket sock = ss.accept();
		InputStream recvStream = sock.getInputStream();
		OutputStream sendStream = sock.getOutputStream();
		
		//Byte arrays
		byte[] buffer = new byte[1024];
		byte[] outBuffer = new byte[1024];
		//Get initial input
		recvStream.read(buffer, 0, 1024);
		System.out.println(new String(buffer, 0, 1024));
		
		String buf = new String(buffer, 0, 1024);
		
		//Other variables
		String Goodbye = "Play again?";
		String Correct = "Correct!";
		String Incorrect = "Incorrect!";
		String Win = "You win!";
		String Lose = "You lose!";
		
		//Boolean to keep game in loop
		boolean End = false;
		while(End == false)
		{
			//Win or lose.
			boolean WinLose = false;
			
			//Counts the # of occurrances in the stirng
			//Ideally I would generate a random string, then count the number of occurances and assign variables appropriately using a string array or similar.
			int T = 2;
			int E = 1;
			int S = 1;
			
			int TCount = 0;
			int ECount = 0;
			int SCount = 0;
			
			//Number of tries the client has
			int tries = 10;
			String Answer = "test";
			String Temp = "";
			char CharHolder;
			for(int i = 0; i < tries; i++)
			{
				boolean IsCorrect = false;
				recvStream.read(buffer, 0, 1024);
				//String Check = new String(buffer, "UTF-8");
				for(int j = 0; j < Answer.length();j++)
				{
					CharHolder = Answer.charAt(j);
					if(buffer.equals(Answer.charAt(j)))
					{
						if(CharHolder == 't')
						{
							TCount++;
						}
						if(CharHolder == 'e')
						{
							ECount++;
						}
						if(CharHolder == 's')
						{
							SCount++;
						}
						//Remove item from the string.
						Temp = Answer.substring(0, j) + Answer.substring(j+1);
						Answer = Temp;
						//Send message to the client.
						outBuffer = Serializer(Correct);
						sendStream.write(outBuffer);
						IsCorrect = true;
						j = j-1;
					}
				}
				//If not correct, send message + iterate tries down.
				if(IsCorrect == false)
				{
					tries = tries - 1;
					outBuffer = Serializer(Incorrect);
					sendStream.write(outBuffer);
				}
				if(TCount == T && ECount == E && SCount == S)
				{
					WinLose = true;
					break;
				}
			}
			
			//Display result
			if(WinLose == false)
			{
				outBuffer = Serializer(Lose);
				sendStream.write(outBuffer);
			}
			if(WinLose == true)
			{
				outBuffer = Serializer(Win);
				sendStream.write(outBuffer);
			}
			
			//Ask the player if they would like to replay.
			outBuffer = Serializer(Goodbye);
			sendStream.write(outBuffer);
			recvStream.read(buffer, 0, 1024);
			buf = new String(buffer, 0, 1024);
			
			if(buf == Goodbye)
			{
				End = true;
			}
		
		}
		recvStream.close();
		sendStream.close();
		
		sock.close();
		ss.close();
	}
	
	
	public static byte[] Serializer(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
>>>>>>> origin/master
}