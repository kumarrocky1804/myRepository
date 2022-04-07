package Basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

interface FirstInterface
{
	default void fun()
	{
		System.out.println("I am having fun");
	}
}

interface SecondInterface
{
	default void fun()
	{
		System.out.println("I am having fun too");
	}
}

class MyClass implements FirstInterface,SecondInterface
{

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		FirstInterface.super.fun();
	}
	
}

public class Try {
	static ArrayList<Integer> list  = new ArrayList<Integer>();
	
	static void AddElement(int data)
	{
		if(data==1)
		{
			return;
		}
		list.add(data);
		AddElement(data-1);
	}
	void fun()
	{
		// non-static method can access static variables but not vice-versa
		list.add(1);
	}
	static ArrayList<Integer> fun(int data)
	{
		AddElement(data);
		return list;
	}
	public static void main(String[] args) {

		MyClass obj = new MyClass();
		//obj.fun();
		//System.out.println(fun(10));
		
		ArrayList<Integer> list  = new ArrayList<Integer>(6);
		//System.out.println(list.size());
		
		String s="Geeks";
		//System.out.println(""+s.charAt(s.length()-1));
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(1);
		
		/*System.out.println(Long.MAX_VALUE/1000/3600/24/365 + " is number of years that can be stored");
		System.out.println(System.currentTimeMillis()/1000/3600/24/365);*/
		
		Calendar c = Calendar.getInstance();
		Object obj2  = new Object();
		Class cl = c.getClass();
		//System.out.println(cl.getName());
		
		char ch='a';
		System.out.println(+ch);
		
		/*java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println(sc.nextInt());
		System.out.println("kdejk");
		System.out.println(sc.nextLine());*/
		//String pass = System.console().readLine(); // Does not work on IDE 	
		//System.out.println(pass);
	}
}
