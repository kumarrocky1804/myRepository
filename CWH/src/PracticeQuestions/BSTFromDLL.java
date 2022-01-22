package PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

import DataStructures.BinarySearchTree;
import DataStructures.DoublyLinkedList;
import DataStructures.DoublyNode;
import DataStructures.TreeNode;

public class BSTFromDLL 
{
	/* The problem is to create a balanced BST from a sorted Doubly Linked List */
	public static TreeNode DLLToBST(DoublyNode head)
	{
		DoublyNode currNode = head;
		ArrayList<DoublyNode> list = new ArrayList<DoublyNode>();
		while(currNode!=null)
		{
			list.add(currNode);
			currNode = currNode.next;
		}
		TreeNode root = DLLToBSTRecur(list, 0, list.size()-1);
		return root;
	}
	
	// O(nlogn) and this method gets trickier as we move forward
	public static TreeNode DLLToBSTRecur(List<DoublyNode> list, int start, int end)
	{
		if(start>end)
			return null;
		
		int mid = (start+end)/2;
		
		TreeNode root = new TreeNode(list.get(mid).data);
		root.setLeft(DLLToBSTRecur(list,start,mid-1));
		root.setRight(DLLToBSTRecur(list,mid+1,end));
		return root;
	}
	
	// we will apply a better method O(n), it is better to make head as class variable, 
	// to save memory
	// In this method we are going to create left subtree with half of number of nodes
	// Then make root as that node
	// and create right subtree with remaining number of nodes
	public static TreeNode listToBST(DoublyNode head,int length)
	{
		if(length<=0)
			return null;
		//make left subtree recursively, head will point to next for each increment
		TreeNode left = listToBST(head,length/2);
		// now make current node as head
		TreeNode root = new TreeNode(head.data);
		root.setLeft(left);
		// increment head for right subtree
		head = head.next;
		// make right subtree with rest of elements
		root.setRight(listToBST(head, length-length/2-1));
		return root;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtEnd(1);
		list.addAtEnd(2);
		list.addAtEnd(3);
		list.addAtEnd(5);
		list.addAtEnd(7);
		list.addAtEnd(9);
		list.addAtEnd(10);
		
		list.display();
		//System.out.println(returnMid(list.head, null).data);
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(DLLToBST(list.head));
		
		System.out.println();
		tree.inorderTraversal(tree.getRoot());
		
		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.setRoot(listToBST(list.head, 7));
		
		System.out.println();
		tree2.inorderTraversal(tree.getRoot());
	}
}
