package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;
import Sorting.QuickSort;

/** The problem is to convert a binary tree to BST keeping its original structure.
 * i.e. each node in the BST should also have the same number of children as original binary tree
 * but their data can be swapped :P
 */

/** steps involved are -
 *  1. Inorder the tree and put them in an array.
 *  2. Sort the array
 *  3. Inorder the tree again and keep replacing the nodes with array elements.
 */

public class BinaryTreeToBST 
{	
	static int index;
	
	public static void inorderAndStore(TreeNode root, int[] arr)
	{
		if(root==null)
			return;
		
		inorderAndStore(root.getLeft(),arr);
		arr[index]=root.getData();
		index++;
		inorderAndStore(root.getRight(), arr);
	}
	
	public static void inorderAndReplace(TreeNode root, int[] arr)
	{
		if(root==null)
			return;
		
		inorderAndReplace(root.getLeft(),arr);
		root.setData(arr[index]);
		index++;
		inorderAndReplace(root.getRight(), arr);
	}
	
	public static void inorderAndcountNodes(TreeNode root)
	{
		if(root==null)
			return;
		
		inorderAndcountNodes(root.getLeft());
		index++;
		inorderAndcountNodes(root.getRight());
	}
	
	public static void BinaryToBST(TreeNode root)
	{
		index=0;
		inorderAndcountNodes(root);
		int[] arr = new int[index];
		index=0;
		inorderAndStore(root, arr);
		QuickSort.sort(arr,0,arr.length-1);
		index=0;
		inorderAndReplace(root, arr);
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(new TreeNode(1));
		tree.getRoot().setLeft(new TreeNode(2));
		tree.getRoot().setRight(new TreeNode(6));
		tree.getRoot().getLeft().setLeft(new TreeNode(100));
		tree.getRoot().getRight().setRight(new TreeNode(3));
		
		tree.inorderTraversal(tree.getRoot());
		
		BinaryToBST(tree.getRoot());
		System.out.println();
		tree.inorderTraversal(tree.getRoot());
	}
	
}
