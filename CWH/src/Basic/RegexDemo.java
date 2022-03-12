package Basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo 
{
	public static void main(String[] args) {
		String str = "GeeksForGeeks";
		
		Pattern pattern = Pattern.compile("gee*", Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find())
		{
			System.out.println("Pattern - " + matcher.pattern() + " found at " +
					matcher.start() + " to " + matcher.end());
		}
		
		System.out.println(pattern.matches("ge+", str));

	}
}