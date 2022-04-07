package PracticeQuestions;

import DataStructures.LinkedList;
import DataStructures.Node;

/** The problem is that there is a linked list given and we have to separate the odd and even
 * elements of the linked list.
 * 
 * Solution - We are going to keep track of head and tail of odd and even list and the
 * combine the two to form one single list with odd elements first and then the even
 * elements
 */

public class SeparateEvenOddLinkedList 
{
	public static void rearrangeEvenOdd(LinkedList list)
    {
        Node evenStart, evenEnd, oddStart, oddEnd, currNode;
        evenStart = evenEnd = oddStart = oddEnd = null;
        currNode = list.getHead();
        
        while(currNode!=null)
        {
            if(currNode.getData() % 2 == 0)
            {
                //even numbers
                if(evenStart == null)
                {
                    evenStart = currNode;
                    evenEnd = currNode;
                }
                else
                {
                    evenEnd.setNext(currNode);
                    evenEnd = currNode;
                }
            }
            else
            {
                //odd numbers
                if(oddStart == null)
                {
                    oddStart = currNode;
                    oddEnd = currNode;
                }
                else
                {
                    oddEnd.setNext(currNode);
                    oddEnd = currNode;
                }
            }
            
            currNode = currNode.getNext();
        }
        
        list.setHead(oddStart);
        oddEnd.setNext(evenStart);;
        evenEnd.setNext(null);
    }
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.addEnd(new Node(1));
		list.addEnd(new Node(2));
		list.addEnd(new Node(3));
		list.addEnd(new Node(4));
		
		list.display();
		
		rearrangeEvenOdd(list);
		
		list.display();
	}
}
