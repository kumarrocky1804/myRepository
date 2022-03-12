package Networking;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/* A client that is capable of reading the server message through readThread
 * and write message to the server.
 */

public class client 
{

	// initialize socket and input output streams
	private Socket socket = null;
	private BufferedReader input = null;
	private DataOutputStream out = null;

	// constructor to put ip address and port
	public client(String address, int port)
	{

		// establish a connection
		try {

			socket = new Socket(address, port);

			System.out.println("Connected");

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

		}

		catch (Exception u) {

			u.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		new client("127.0.0.1", 5000);
		//new OneWayClient("100.66.175.247", 5000);
	}


}
