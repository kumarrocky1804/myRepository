package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class PrintNodeAtkDistance 
{
	/* The problem is to print the nodes at k distance from the root.
	 */
	
	// The problem can also be done by level order traversal but I chose this to practice.
	public void printNodes(TreeNode root, int k)
	{
		if(root==null)
			return;
		if(k==0)
		{
			System.out.print(root.getData() + " , ");
			return;
		}
		
		printNodes(root.getLeft(), k-1);
		printNodes(root.getRight(), k-1);
	}
	
	public static void main(String[] args) 
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		//tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(65);
		
		tree.levelOrderTraversal(tree.getRoot());
		System.out.println();
		int k=2;
		PrintNodeAtkDistance app = new PrintNodeAtkDistance();
		app.printNodes(tree.getRoot(), k);
	}
}
