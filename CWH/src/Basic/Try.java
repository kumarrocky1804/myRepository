package Basic;

import java.util.ArrayList;

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
	
	static ArrayList<Integer> fun(int data)
	{
		AddElement(data);
		return list;
	}
	public static void main(String[] args) {

		MyClass obj = new MyClass();
		obj.fun();
		System.out.println(fun(10));
		
		ArrayList<Integer> list  = new ArrayList<Integer>();
		list.clear();
		
		String s="A";
		System.out.println("A" + (char)66 + Integer.toString(66));
	}
}
