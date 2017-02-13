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
	
		//Status codes
		String FourHundred = "400 Bad Request: Client has issued a malformed or illegal request";
		String TwoHundred = "200 OK";
		String FourOhFour = "404 File Not Found: The requested file does not exist or has been deleted";
	
		//Socket setup
		ServerSocket ss = new ServerSocket(80);
		Socket sock = ss.accept();
		InputStream recvStream = sock.getInputStream();
		OutputStream sendStream = sock.getOutputStream();
		
		byte[] buffer = new byte[1024];
		recvStream.read(buffer, 0, 1024);
		System.out.println(new String(buffer, 0, 1024));
		
		String buf = new String(buffer, 0, 1024);
		
		String RequestedFile = buf.substring(buf.indexOf("GET")+5, buf.indexOf("html")+4);
		
		System.out.println(RequestedFile);
		
		//Acquire the data from the file
		Scanner FileScanner = null;
		//Array to hold the data
		List<String> TextFile = new ArrayList<String>();
		boolean ErrorFileNotFound = false;
		try{
			FileScanner = new Scanner(new File(RequestedFile));
		}catch(Exception FileNotFoundException){ ErrorFileNotFound = true;}
		if(ErrorFileNotFound == false)
		{
			while(FileScanner.hasNext())
			{
				TextFile.add(FileScanner.nextLine());
			}
		}
		
		//Report status code + data
		if(buf.contains("GET") && ErrorFileNotFound == false)
		{
			sendStream.write(TwoHundred.getBytes());
			sendStream.write("\n".getBytes());
			for(int i = 0; i < TextFile.size(); i++)
			{
				sendStream.write(TextFile.get(i).getBytes());
			}
		}
		//Report error
		if(!buf.contains("GET"))
		{
			sendStream.write(FourHundred.getBytes());
		}
		if(ErrorFileNotFound == true)
		{
			sendStream.write(FourOhFour.getBytes());
		}
		
			

		recvStream.close();
		sendStream.close();
		
		sock.close();
		ss.close();
	}
}