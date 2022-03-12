package Networking;

import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* An one way server that connect with one client at a time and displays 
 * the messages sent to it by the client.
 */

public class OneWayServer {
	
	private DataInputStream in = null;
	private ServerSocket server = null;
	private Socket socket = null;
	
	// Server on given port
	public OneWayServer(int port)
	{
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started at port - " + port);
			InetAddress address = server.getInetAddress();
			System.out.println("Server started at address - " + address.getHostAddress() +
					" " + address.getHostName());
			
			socket = server.accept();
			
			System.out.println("client accepted --");
			
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			String line = "";
			
			while(!line.equalsIgnoreCase("over"))
			{
				line = in.readUTF();
				System.out.println("Server listening - ");
				System.out.println(line);
			}
			
			System.out.println("server got over - --");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				in.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
	{
		new OneWayServer(5000);
	}

}
