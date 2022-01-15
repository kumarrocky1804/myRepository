package DataStructures;

public class DoublyLinkedList 
{
	public DoublyNode head;
	
	public DoublyLinkedList()
	{
		head = null;
	}
	
	public void delete(int element)
	{
		boolean foundElement = false;
		DoublyNode CurrNode = head;
		while(CurrNode != null)
		{
			if(CurrNode.data == element)
			{
				// IF NOT FIRST NODE
				if (CurrNode.prev != null)
				{
					CurrNode.prev.next = CurrNode.next;
				}
				else
				{
					head = CurrNode.next;
				}
				// IF NOT LAST NODE
				if(CurrNode.next != null)
				{
					CurrNode.next.prev = CurrNode.prev;
				}
				foundElement = true;
				break;
			}
			CurrNode = CurrNode.next;
		}
		if(foundElement == false)
		{
			System.out.println("ELEMENT NOT FOUND");
		}
	}
	
	public void addAfter(int element, int newData)
	{
		boolean foundElement = false;
		DoublyNode newNode = new DoublyNode(newData);
		DoublyNode CurrNode = head;
		while(CurrNode != null)
		{
			if(CurrNode.data == element)
			{
				// IF NOT LAST ELEMENT
				if(CurrNode.next != null)
				{
					newNode.next = CurrNode.next;
					CurrNode.next.prev = newNode;
				}
				newNode.prev = CurrNode;
				CurrNode.next = newNode;
				foundElement = true;
				break;
			}
			CurrNode = CurrNode.next;
		}
		if(foundElement == false)
		{
			System.out.println("Element not found");
			return;
		}
	}
	
	public void addAtEnd(int data)
	{
		DoublyNode newNode = new DoublyNode(data);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			DoublyNode CurrNode = head;
			while(CurrNode.next != null)
			{
				CurrNode = CurrNode.next;
			}
			CurrNode.next = newNode;
			newNode.prev = CurrNode;
		}
	}
	
	public void display()
	{
		System.out.println();
		DoublyNode CurrNode = head;
		if(head == null)
		{
			System.out.println("List is Empty!!");
			return;
		}
		while(CurrNode != null)
		{
			System.out.print(CurrNode.data + " -> ");
			CurrNode = CurrNode.next;
		}
	}
	
	public void displayReverse()
	{
		System.out.println();
		DoublyNode CurrNode = head;
		if(head == null)
		{
			System.out.println("List is Empty!!");
			return;
	
		}
		else
		{
			while(CurrNode.next != null)
			{
				CurrNode = CurrNode.next;
			}
			while(CurrNode != null)
			{
				System.out.print(CurrNode.data + " -> ");
				CurrNode = CurrNode.prev;
			}
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtEnd(1);
		list.addAtEnd(2);
		list.display();
		list.displayReverse();
		
		list.addAfter(2, 4);
		list.display();
		list.displayReverse();
		
		//list.addAfter(5, 6);
		
		list.delete(1);
		//list.delete(4);
		list.display();
	}
}
