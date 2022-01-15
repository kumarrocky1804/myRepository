package DataStructures;

public class QueueUsingArray 
{
	/* We implemented queue using array.
	 * To make it space efficient, we are going to increase it in circular mode.
	 */
	private int capacity;
	private int currentSize;
	private int[] arr;
	private int front;
	private int rear;
	
	public QueueUsingArray(int capacity)
	{
		this.capacity = capacity;
		this.arr = new int[this.capacity];
		this.front = this.currentSize = 0;
		this.rear = this.capacity-1;
		// Example - if capacity is 100, front will be 0 and rear will be 99
	}
	
	public void add(int data)
	{
		if(isFull())
		{
			System.out.println("Overflow...cannot add - " + data);
			return;
		}
		// for first insert rear will be (99+1)%100 = 0
		this.rear = (this.rear+1)%this.capacity;
		this.arr[this.rear] = data;
		this.currentSize++;
	}
	
	public int remove()
	{
		if(isEmpty())
		{
			System.out.println("Underflow...cannot delete");
			return -1;
		}
		// for first delete, front will be 1
		int temp = this.arr[this.front];
		this.front = (this.front+1)%this.capacity;
		this.currentSize--;
		return temp;
	}
	
	public boolean isFull()
	{
		return this.currentSize==this.capacity;
	}
	
	public boolean isEmpty()
	{
		return this.currentSize==0;
	}
	
	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		//queue.add(6);
		while(!queue.isEmpty())
		{
			System.out.println(queue.remove());
		}
		//System.out.println(queue.remove());
		java.util.Stack<Integer> stack;
	}
}
