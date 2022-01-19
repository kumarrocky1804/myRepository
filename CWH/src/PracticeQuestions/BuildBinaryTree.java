package PracticeQuestions;

import java.util.HashMap;

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public class BuildBinaryTree 
{
	/* The problem is to build the binary tree from given inorder and preorder traversal
	 * results.
	 */
	
	static int preIndex=0;
	
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	public static Node buildTree(int[] inorder, int[] preorder, int startInorder, int endInOrder)
	{
		if(startInorder>endInOrder)
			return null;
		Node root = new Node(preorder[preIndex++]);
		
		if(startInorder==endInOrder)
			return root;
		
		int elementIndex = map.get(root.data);
		
		root.left = buildTree(inorder, preorder, startInorder, elementIndex-1);
		root.right = buildTree(inorder, preorder, elementIndex+1, endInOrder);
		
		return root;
	}
	
	public static void putInorderInMap(int[] inorder)
	{
		for(int i=0; i<inorder.length;i++)
		{
			map.put(inorder[i], i);
		}
	}
	
	public static void postorderTraverse(Node root)
	{
		if(root==null)
			return;
		
		inorderTraverse(root.left);
		inorderTraverse(root.right);
		System.out.println(root.data + " -> ");
	}
	
	public static void inorderTraverse(Node root)
	{
		if(root==null)
			return;
		
		inorderTraverse(root.left);
		System.out.println(root.data + " -> ");
		inorderTraverse(root.right);
	}
	
	public static void main(String[] args) {
		BuildBinaryTree tree = new BuildBinaryTree();
		//char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};
		//char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
		int[] inorder = {10,1,30,40,20};
		int[] preorder = {1,10,20,30,40};
		putInorderInMap(inorder);
		postorderTraverse(buildTree(inorder, preorder, 0, preorder.length-1));
		
		
	}
}
