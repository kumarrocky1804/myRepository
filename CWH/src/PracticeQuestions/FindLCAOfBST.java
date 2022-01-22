package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class FindLCAOfBST 
{
	public static int LCA(TreeNode root, int num1, int num2)
	{
		//case when the numbers are on oppposite side of current node
				if(root.getData()>num1 && root.getData()<num2)
					return root.getData();
				if(root.getData()<num1 && root.getData()>num2)
					return root.getData();
				
				// when either number is equal to current node
				if(root.getData()==num1)
					return num1;
				if(root.getData()==num2)
					return num2;
				
				// when number are on same side of current node but not equal to any of the numbers
				if(num1>root.getData() && num2>root.getData())
					return LCA(root.getRight(),num1,num2);
				else
					return LCA(root.getLeft(),num1,num2);
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(65);
		
		tree.inorderTraversal(tree.getRoot());
		
		System.out.println();
		int num1=60;
		int num2=65;
		System.out.println("The Lowest common Ancestor for " + num1 + " and " + num2 + " is - " +
				LCA(tree.getRoot(),num1,num2));
	}
}
