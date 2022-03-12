package Basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Functional interfaces are the one that have only one abstract method.
 * But they can have any number of default, static or private methods.
 * After Java 8, we can use lambda expressions to call them.
 * @author rocky.kumar
 */

interface Square
{
	int fun(int x);
}

class Student
{
	int rollNo;
	String name;
	
	public Student(int rollNo, String name)
	{
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public void display()
	{
		System.out.println("RollNo - " + rollNo);
		System.out.println("Name -   " + name);
	}
}

public class FunctionalInterface
{
	public static void main(String[] args) {
		// Before JAVA 8
		// using anonymous inner class object
		Square sq = new Square() {
			@Override
			public int fun(int x) {
				// TODO Auto-generated method stub
				return x*x;
			}
		};
		
		System.out.println(sq.fun(10));
		
		// Using Runnable interface (a functional interface) to run a thread
		new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						System.out.println("A new Thread with anonymous class");
					}
				}).start();
		
		//After JAVA 8
		Square s = (int x) -> {return x*x;};
		
		System.out.println(s.fun(5));
		
		new Thread(
					()->{
						System.out.println("A new Thread with lambda expression");
					}
				).start();
		
		// Lets try lambda expression with comparator interface
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1,"aryan"));
		list.add(new Student(23,"jfdkj"));
		list.add(new Student(2,"jfdkj"));
		list.add(new Student(20,"jfdkj"));
		
		System.out.println("Unsorted - ");
		for(Student st: list)
		{
			st.display();
		}
		
		System.out.println("Sorted by Roll no - ");
		// lambda expression used to implement compare() method
		Collections.sort(list, (Student A,Student B) -> {
			return A.rollNo - B.rollNo;
		});
		for(Student st: list)
		{
			st.display();
		}
		
		// Function interfaces since 1.8
		// java.util.function.*
		Consumer<Integer> display = (a) -> {System.out.println(a);};
		display.accept(6);
		Consumer<Integer> repeat = display.andThen(display);
		
		repeat.accept(10);
	}
}
