package Basic;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class CWH_Strings {
	public static void main(String[] args) {
		char ch = 'A';
		System.out.println(++ch);
		
		String str1 = "Rocky";
		String str2 = "Rocky";
		// When strings are declared as above, the JVM will look for the string in the pool
		// at the time of str2 declaration. If found, it will return the same reference
		// Hence the below operation will return true.
		System.out.println(str1 == str2);
		
		String str3  = new String("Kumar");
		String str4 = new String("Kumar");
		// Above declaration will create a new reference every time. Hence below operation
		// will return false
		System.out.println(str3==str4);
		
		// Better way to compare strings is to use below method.
		System.out.println(str1.equals(str2));
		System.out.println(str3.equals(str4));
		
		// string buffer and string builder are mutable with initial capacity of 16
		// string buffer is thread safe but slower.
		// string builder is faster but not thread safe
		
		StringBuffer str = new StringBuffer();
		System.out.println(str.capacity());
		
		StringBuilder strBuilder = new StringBuilder("New String");
		System.out.println(strBuilder.capacity());
		
		strBuilder = strBuilder.append("More than 26 characters in this sentence.");
		System.out.println(strBuilder.capacity());
		System.out.println(strBuilder);
		
		// String tokenizer class. Can also work with 1 or 2 parameters.
		StringTokenizer tokens = new StringTokenizer(strBuilder.toString()," ", true);
		/*while(tokens.hasMoreTokens())
		{
			System.out.println(tokens.nextToken());
		}*/
		
		// string joiner class
		StringJoiner newStr = new StringJoiner(":");
		while(tokens.hasMoreTokens())
		{
			newStr.add(tokens.nextToken());
		}
		
		System.out.println(newStr.length());
		System.out.println(newStr);
		
	}
}
