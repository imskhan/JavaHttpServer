package clientServerModule;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) throws UnknownHostException, IOException
	{
		String myText = "Shoaib";
		String resp;
		Socket so = new Socket("127.0.0.1", 1337);
		Scanner sc = new Scanner(so.getInputStream());
		try {
			//Pass the text to server
			PrintStream ps = new PrintStream(so.getOutputStream());
			//Pass the text
			ps.println(myText);
			//Get the result from the server
			resp = sc.next();
			//Print the result from the server
			System.out.println(resp);	
		} finally {
			so.close();
			sc.close();
		}
	}
}