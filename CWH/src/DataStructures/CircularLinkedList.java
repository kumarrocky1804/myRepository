package DataStructures;

public class CircularLinkedList implements Queue
{
	/* ONE OF ITS APPLICATION IS THAT WE CAN IMPLEMENT QUEUE
	 * WITH THE HELP OF THIS LINKED LIST WITH ONLY ONE POINTER
	 * INSTEAD OF TWO POINTERS (FRONT AND REAR)
	 * WE CAN MAINTAIN POINTER FOR LAST ELEMENT AS REAR
	 * AND FRONT WILL ALWAYS BE ACCESSIBLE BY LAST.NEXT
	 */
	Node last;
	
	public CircularLinkedList()
	{
		last = null;
	}
	
	// similar to dequeue
	public int deleteFromBegin()
	{
		// if empty
		if(last == null)
		{
			System.out.println("LIST IS EMPTY");
			return -1;
		}
		// if only one element
		if(last.getNext() == last)
		{
			int temp = last.getData();
			last=null;
			return temp;
		}
		int temp = last.getNext().getData();
		last.setNext(last.getNext().getNext());
		return temp;
	}
	
	// similar to enqueue
	public void addAtEnd(int data)
	{
		Node newNode = new Node(data);
		
		// if list is empty
		if(last == null)
		{
			last = newNode;
			newNode.next = last;
		}
		else
		{
			newNode.setNext(last.getNext());
			last.setNext(newNode);
			last = newNode;
		}
	}
	
	public void display()
	{
		System.out.println();
		Node currNode = last;
		if(currNode==null)
		{
			System.out.println("LIST IS EMPTY");
		}
		else
		{
			currNode = last.getNext();
			do
			{
				System.out.print(currNode.data + " -> ");
				currNode = currNode.next;
			}while(currNode != last.getNext());
		}
	}
	
	@Override
	public void add(int data) {
		// TODO Auto-generated method stub
		addAtEnd(data);
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		return deleteFromBegin();
	}

	@Override
	public int front() {
		// TODO Auto-generated method stub
		return last.getNext().getData();
	}

	@Override
	public int rear() {
		// TODO Auto-generated method stub
		return last.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return last==null;
	}
	
	public static void main(String[] args) {
		/*CircularLinkedList list = new CircularLinkedList();
		list.addAtEnd(1);
		list.addAtEnd(2);
		list.addAtEnd(3);
		list.addAtEnd(4);
		list.display();
		list.deleteFromBegin();
		list.display();
		list.addAtEnd(5);
		list.display();
		list.deleteFromBegin();
		list.display();
		list.deleteFromBegin();
		list.deleteFromBegin();
		list.display();
		list.deleteFromBegin();
		list.display();*/
		
		Queue q = new CircularLinkedList();
		q.add(1);
		q.add(2);
		q.add(3);
		
		while(!q.isEmpty())
			System.out.println(q.remove());
		
		System.out.println(q.remove());
		
	}
}
