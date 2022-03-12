package Basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileHandlingDemo 
{
	public static void main(String[] args) {
		File file = new File("D:\\");
		
		String[] files = file.list();
		
		System.out.println("The directory contains - ");
		for(String f: files)
		{
			System.out.println(f);
		}
		
		file = new File("D:\\hello.txt");
		try {
			FileOutputStream stream = new FileOutputStream(file);
			stream.write("Hello World".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try
		{
			FileInputStream ip = new FileInputStream(file);
			byte i = 0;
			do
			{
				i = (byte) ip.read();
				System.out.print((char) i);
			}while(i!=-1);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String st;
			while ((st = br.readLine()) != null)

			    // Print the string
			    System.out.println(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
