package Networking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/* Helper thread class that will run for infinte time to read the messages
 * from the given socket unless the message is "over"
 * or the socket is closed
 */

class ReadThread implements Runnable
{
	private DataInputStream input;
	private Socket socket;

	ReadThread(Socket socket)
	{
		this.socket = socket;
		try {
			this.input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
	{
		String line = "";

		while(true)
		{
			try {
				line = input.readUTF();
				System.out.print("Getting: ");
				System.out.println(line);
				if(line.equalsIgnoreCase("over"))
					throw new Exception();
			}
			catch (Exception e) {
				System.out.println("Connection closed");
				// TODO Auto-generated catch block
				if(!socket.isClosed())
					try {
						socket.close();
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				break;
			}
		}
	}

}
