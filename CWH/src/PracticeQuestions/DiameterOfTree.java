package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class DiameterOfTree extends BinarySearchTree
{
	/* The diameter of a tree (sometimes called the width) is the number of nodes on the longest 
	 * path between two end nodes.
	 * For more info - https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	 * 
	 * Solution Hint - 
	 * The diameter of a tree T is the largest of the following quantities:
	 * 1. the diameter of T’s left subtree.
	 * 2. the diameter of T’s right subtree.
	 * 3. the longest path between leaves that goes through the root of T (this can be computed from 
	 * 	  the heights of the subtrees of T)
	 */
	
	// if we pass root to this function, it will pass height of full tree.
	public int height(TreeNode node)
	{
		if(node==null)
			return 0;
		
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}
	
	public int diameter(TreeNode node)
	{
		if(node==null)
			return 0;
		
		// to calculate longest path from left to right of current node
		int lh = height(node.getLeft());
		int rh = height(node.getRight());
		
		// to calculate dia of left and right subtree
		int diaLeft = diameter(node.getLeft());
		int diaRight = diameter(node.getRight());
		
		return Math.max(1 + lh + rh, Math.max(diaLeft, diaRight));
	}
	
	// The same thing can be done with only one recursion for both height and diameter
	
	class Height
	{
		int h;
	}
	
	public int diameterRecur(TreeNode node, Height height)
	{
		if(node==null)
		{
			height.h=0;
			return 0;
		}
		
		Height lh = new Height(), rh= new Height();
		
		int leftDia = diameterRecur(node.getLeft(),lh);
		int rightDia = diameterRecur(node.getRight(),rh);
		
		// As we are not returning height, we will keep updating the object
		height.h = 1 + Math.max(lh.h, rh.h);	
		
		return Math.max(1+lh.h+rh.h, Math.max(leftDia, rightDia));
	}
	
	public int diameter2(TreeNode node)
	{
		Height height = new Height();
		return diameterRecur(node, height);
	}
	
	public static void main(String[] args) {
		DiameterOfTree tree = new DiameterOfTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		//tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(65);
		
		System.out.println("Current Tree is -");
		tree.levelOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Height of tree is -");
		System.out.println(tree.height(tree.getRoot()));
		System.out.println();
		System.out.println("Diameter of tree with 1st method is -");
		System.out.println(tree.diameter(tree.getRoot()));
		System.out.println();
		System.out.println("Diameter of tree with 2nd method is -");
		System.out.println(tree.diameter2(tree.getRoot()));
	}
}
