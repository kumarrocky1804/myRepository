package DataStructures;

public class ReverseDoublyLinkedList 
{
	public static DoublyNode reverse(DoublyNode head)
	{
		// if 0 or 1 element
		if(head==null||head.next==null)
		{
			return head;
		}
		
		DoublyNode currNode = head;
		DoublyNode prev=null;
		while(currNode!=null)
		{
			DoublyNode nextPointer = currNode.next;
			DoublyNode temp = currNode.next;
			currNode.next = currNode.prev;
			currNode.prev = temp;
			
			prev = currNode;
			currNode = nextPointer;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtEnd(3);
		list.addAtEnd(4);
		list.addAtEnd(5);
		
		list.display();
		System.out.println();
		list.head = reverse(list.head);
		list.display();
	}
}
