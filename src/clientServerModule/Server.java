package clientServerModule;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String args[]) throws IOException
	{
		String text;
		String res = "KHAN";
		ServerSocket ss =   new ServerSocket(1337);
		Socket s = ss.accept();
		Scanner sc = new Scanner(s.getInputStream());
		try {
			text = sc.next();
			res = text + res;
			//Passing to client
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println(res);
			
		} finally  {
			ss.close();
			sc.close();
		}
		
	}
}