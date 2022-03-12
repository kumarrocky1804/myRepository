package Networking;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/* An one way client that connect with server and takes messages from keyboard
 * and send it to server
 */

public class OneWayClient {
	
	// initialize socket and input output streams
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;
  
    // constructor to put ip address and port
    public OneWayClient(String address, int port)
    {
  
        // establish a connection
        try {
  
            socket = new Socket(address, port);
  
            System.out.println("Connected");
  
            // takes input from terminal
            input = new BufferedReader(new InputStreamReader(System.in));
  
            // sends output to the socket
            out = new DataOutputStream(
                socket.getOutputStream());
            
         // string to read message from input
            String line = "";
      
            // keep reading until "over" is input
            while (!line.equalsIgnoreCase("over")) {
      
      
                    line = input.readLine();
      
                    out.writeUTF(line);
            }
        }
  
        catch (Exception u) {
  
            u.printStackTrace();
        }
        
  
        // close the connection
        try {
  
            input.close();
  
            out.close();
  
            socket.close();
        }
  
        catch (IOException i) {
  
            System.out.println(i);
        }
    }

	public static void main(String[] args) 
	{
		//new OneWayClient("127.0.0.1", 5000);
		new OneWayClient("100.66.175.247", 5000);
	}

}
