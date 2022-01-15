package PracticeQuestions;

import java.util.Scanner;

import DataStructures.LinkedList;
import DataStructures.Node;

public class nthNodeFromEndLinkedList {
	static Node retNodeFromLast(Node head,int n)
	{
		Node currNode = head;
		Node fixedNode = head;
		
		//GO TO nTH node from start
		for(int i=1; i<n; i++)
		{
			currNode = currNode.getNext();
		}
		
		// move both pointer to last
		while(currNode.getNext()!=null)
		{
			currNode = currNode.getNext();
			fixedNode = fixedNode.getNext();
		}
		
		return fixedNode;
	}
	
	public static void main(String[] args) {
		LinkedList list  = new LinkedList();
		list.addEnd(new Node(1));
		list.addEnd(new Node(2));
		list.addEnd(new Node(3));
		
		list.display();
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n (nth node from end will be displayed - ");
		int n = sc.nextInt();
		sc.close();
		System.out.println(retNodeFromLast(list.getHead(),n).getData());
	}
}
