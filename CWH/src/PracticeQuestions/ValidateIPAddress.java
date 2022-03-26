package PracticeQuestions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {
	
	public static boolean isIPValid(String ipAddress)
	{
		String zeroTo255 = "(d{1}|[1-9]\\d{1}|1\\d{2}|2[0-4]\\d|25[0-5])";
		String regex = zeroTo255 + "\\." + zeroTo255 + "\\." +
				zeroTo255 + "\\." + zeroTo255;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ipAddress);
		
		if(matcher.find())
			return true;
		return false;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String ipAddress = sc.nextLine();
		boolean isValid = isIPValid(ipAddress);
		if(isValid) 
			System.out.println("It is valid");
		else
			System.out.println("Not valid");
		
		sc.close();
	}

}
