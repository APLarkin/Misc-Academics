//miniproject 2 - server
import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.*;

public class FinalProjectClient
{
	public static void main(String[] args) throws IOException
	{		
	
		Scanner user_input = new Scanner(System.in);
		//Socket setup
		Socket sock = new Socket("localhost", 80);
		InputStream recvStream = sock.getInputStream();
		OutputStream sendStream = sock.getOutputStream();
		
		//Buffers
		byte[] buffer = new byte[1024];
		byte[] outBuffer = new byte[1024];
		//Get initial input
		recvStream.read(buffer, 0, 1024);
		System.out.println(new String(buffer, 0, 1024));
		
		String buf = new String(buffer, 0, 1024);
		String input = "";
		
		//Boolean to keep game in loop
		boolean End = false;
		while(End == false)
		{
			
			System.out.println("Next input: " );
			input = user_input.next();
			
			BufferedReader Reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter Out = new PrintWriter(sock.getOutputStream(), true);

			BufferedReader In = new BufferedReader(new InputStreamReader(System.in));


			System.out.println(Reader.readLine());
			
		}
		recvStream.close();
		sendStream.close();
		
		sock.close();
	}
	
	public static byte[] Serializer(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
}