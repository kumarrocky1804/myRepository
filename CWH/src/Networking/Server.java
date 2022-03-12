package Networking;

import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/* A server that is capable of reading the client message through readThread
 * and write message to the client.
 * 
 * It will handle only one client, if needed to extend for multiple clients, we can put
 * accept() in loop and create another class like clientHandler to handle the clients.
 */

public class Server {
	private BufferedReader input = null;
	private DataOutputStream out = null;
	private ServerSocket server = null;
	private Socket socket = null;

	// Server on given port
	public Server(int port)
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

			Thread readThread = new Thread(new ReadThread(socket));
			readThread.start();

			// takes input from terminal
			input = new BufferedReader(new InputStreamReader(System.in));

			// sends output to the socket
			out = new DataOutputStream(
					socket.getOutputStream());

			// string to read message from input
			String line = "";

			// keep reading until "over" is input
			while (true) {

				line = input.readLine();
				if(!socket.isClosed())
					out.writeUTF(line);
				else
				{
					System.out.println("connection is closed");
					break;
				}
				if(line.equalsIgnoreCase("over"))
				{
					socket.close();
					break;
				}
			}


		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		new Server(5000);
	}

}
