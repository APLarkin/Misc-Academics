//miniproject 2

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class HTTPRequest
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		URLConnection conn  =  new URL("http://45.79.189.210").openConnection();
		Scanner scanner = new Scanner(conn.getInputStream());		
		while (scanner.hasNext())
			System.out.println(scanner.nextLine());
	}

}