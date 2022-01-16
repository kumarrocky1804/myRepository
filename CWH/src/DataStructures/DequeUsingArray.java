package DataStructures;

public class DequeUsingArray 
{
	/* We implemented deque using array.
	 * - Circular Array
	 * 
	 * Deques can be used for both stack and queue operations.
	 * DeQue are useful when rotation is required clockwise or anti-clockwise
	 */
	private int capacity;
	private int currentSize;
	private int[] arr;
	private int front;
	private int rear;
	
	public DequeUsingArray(int capacity)
	{
		this.capacity = capacity;
		this.arr = new int[this.capacity];
		this.front = -1;
		this.rear = -1;
		this.currentSize=0;
	}
	
	// see front element
	public int peek()
	{
		return arr[front];
	}
	
	// see rear
	public int peekRear()
	{
		return arr[rear];
	}
	
	public void addFront(int data)
	{
		if(isFull())
		{
			System.out.println("Overflow...cannot add - " + data);
			return;
		}
		// first insert
		if(front==-1)
		{
			front=rear=0;
		}
		else if(front==0)
			front = capacity-1;
		else
			front = front-1;
		arr[front] = data;
		currentSize++;
	}
	
	public void addRear(int data)
	{
		if(isFull())
		{
			System.out.println("Overflow...cannot add - " + data);
			return;
		}
		//first insert
		if(front==-1)
			front=rear=0;
		else if(rear==capacity-1)
			rear=0;
		else
			rear = rear+1;
		arr[rear] = data;
		currentSize++;
	}
	
	public int removeRear()
	{
		if(isEmpty())
			return -1;
		// only one element
		int temp = arr[rear];
		if(front==rear)
			front = rear = -1;
		else if (rear==0)
			rear = capacity-1;
		else
			rear--;
		currentSize--;
		return temp;
	}
	
	public int removeFront()
	{
		if(isEmpty())
			return -1;
		// only one element
		int temp = arr[front];
		if(front==rear)
			front=rear=-1;
		else if(front==capacity-1)
			front=0;
		else
			front++;
		currentSize--;
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
		DequeUsingArray arr = new DequeUsingArray(5);
		/*arr.addFront(1);
		arr.addFront(2);
		arr.addRear(3);
		arr.addRear(4);
		
		System.out.println(arr.removeFront());
		System.out.println(arr.removeRear());
		System.out.println(arr.removeRear());
		System.out.println(arr.removeRear());
		System.out.println(arr.removeRear());*/
		
		// Rotating clockwise
		int[] a = {1,2,3,4,5};
		int n=1;
		System.out.println("Current array is: ");
		for(int i=0; i<a.length;i++)
		{
			System.out.print(a[i] + " -> ");
		}
		
		
		for(int i=0; i<a.length;i++)
		{
			arr.addRear(a[i]);
		}
		
		System.out.println();
		System.out.println("After rotating by - " + n );
		
		int count=0;
		while(count<n)
		{
			int temp = arr.removeRear();
			arr.addFront(temp);
			count++;
		}
		
		for(int i=0; i<a.length;i++)
		{
			a[i] = arr.removeFront();
		}
		
		for(int i=0; i<a.length;i++)
		{
			System.out.print(a[i] + " -> ");
		}
		
	}
}
