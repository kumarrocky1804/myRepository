package DataStructures;

public class ReverseLinkedList extends LinkedList
{
	public void reverseList()
	{
		// if list is empty or list has only one elements
		if (head == null || head.next == null)
		{
			System.out.println("The list has too less elements");
		}
		else
		{
			CurrNode = head;
			Node prev = null;
			Node temp = null;
			while(CurrNode != null)
			{
				temp = CurrNode.next;
				CurrNode.next = prev;
				prev = CurrNode;
				CurrNode = temp;
			}
			head = prev;
		}
	}
	
	public static void main(String[] args) 
	{
		ReverseLinkedList list = new ReverseLinkedList();
		Node newNode = new Node(1);
		
		list.addEnd(newNode);
		newNode = new Node(2);
		list.addEnd(newNode);
		newNode = new Node(3);
		list.addEnd(newNode);
		
		list.display();
		
		list.reverseList();
		list.display();
	}

}
