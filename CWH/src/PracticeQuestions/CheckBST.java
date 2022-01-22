package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class CheckBST 
{
	public static boolean checkBst(TreeNode root)
	{
		return checkBSTRecursive(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static boolean checkBSTRecursive(TreeNode root, int min, int max)
	{
		if(root==null)
			return true;
		
		if(root.getData()>max||root.getData()<min)
			return false;
		
		//check the left is atleast minimum and atmost root's data
		//check the right is atleast root's data and atmost maximum
		return (checkBSTRecursive(root.getLeft(),min,root.getData()))&&
				(checkBSTRecursive(root.getRight(),root.getData(),max));
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(65);
		
		System.out.println(checkBst(tree.getRoot()));
	}
}
