package Basic;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueUtil 
{
	public static void main(String[] args) 
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(100);
		pq.add(2);
		pq.add(10);
		pq.add(85);
		pq.add(52);
		
		System.out.println("The elements in natural order of priority are- ");
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.add(100);
		q.add(2);
		q.add(10);
		q.add(85);
		q.add(52);
		
		System.out.println("The elements in natural order of priority are- ");
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}
