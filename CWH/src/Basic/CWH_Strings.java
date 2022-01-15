package Basic;

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
	}
}
