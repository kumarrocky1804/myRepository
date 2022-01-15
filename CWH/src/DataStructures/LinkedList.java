package DataStructures;

public class LinkedList implements Stack
{
	Node head;
	Node CurrNode;
	
	public LinkedList()
	{
		head = null;
	}
	
	public Node getHead()
	{
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public void addBegin(Node node)
	{
		if(head==null)
		{
			head = node;
			return;
		}
		
		node.next = head;
		head = node;
	}
	
	public void addEnd(Node node)
	{
		// if empty list
		if(head == null)
		{
			head = node;
		}
		else
		{
			CurrNode = head;
			while(CurrNode.next != null)
			{
				CurrNode = CurrNode.next;
			}
			CurrNode.next = node;
		}
	}
	
	public int deleteFromBegin()
	{
		if(head==null)
			return -1;
		int retElement = head.getData();
		head = head.getNext();
		return retElement;
	}
	

	public void display()
	{
		CurrNode = head;
		System.out.println("Currently the list is -");
		while(CurrNode != null)
		{
			System.out.print(CurrNode.data + " -> ");
			CurrNode = CurrNode.next;
		}
	}
	
	public void displayFromNode(Node start)
	{
		CurrNode = start;
		System.out.println("Currently the list is -");
		while(CurrNode != null)
		{
			System.out.print(CurrNode.data + " -> ");
			CurrNode = CurrNode.next;
		}
	}
	
	public int getLength()
	{
		Node currNode = this.getHead();
		int count = 0;
		while(currNode!=null)
		{
			currNode = currNode.getNext();
			count++;
		}
		return count;
	}

	@Override
	public void push(int data) {
		Node newNode = new Node(data);
		addBegin(newNode);
	}

	@Override
	public int pop() {
		return deleteFromBegin();
	}

	@Override
	public int peek() {
		if(head==null)
			return -1;
		return head.getData();
	}

	@Override
	public boolean isEmpty() {
		if(head==null)
			return true;
		return false;
	}
	
	@Override
	public void stackDisplay()
	{
		display();
	}
}
