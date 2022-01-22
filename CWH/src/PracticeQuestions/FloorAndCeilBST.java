package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class FloorAndCeilBST 
{
	/* The problem is to find floor and ceil value for a key in BST.
	 * Floor for a key - Node with the greatest data lesser than or equal to the key value. 
	 * Ceil - Node with the smallest data larger than or equal to the key value.
	 * 
	 * Example -
	 *  Inorder for a BST - 2,4,6,8,10,12,14 (8 is root)
	 *  
	 *  Key: 11  Floor: 10  Ceil: 12 (10 is less than 11 but closest to 11)
	 *  							 (12 is greater than 11 but closest to 11)
	 *	Key: 1   Floor: -1  Ceil: 2
	 *	Key: 6   Floor: 6   Ceil: 6
	 *	Key: 15  Floor: 14  Ceil: -1
	 */
	static int floor=-1, ceil=-1;
	//example key is 11
	public static void floorCeil(TreeNode root, int key)
	{
		TreeNode currNode = root;
		if(currNode==null)
			return;
		
		while(currNode!=null)
		{
			// if 11 found it is both floor and ceil
			if(currNode.getData()==key)
			{
				floor=currNode.getData();
				ceil=currNode.getData();
				break;
			}
			// if 11>node found, move to right to get closer
			else if(key>currNode.getData())
			{
				// set floor as it can be closest lesser number than 11
				floor = currNode.getData();
				currNode = currNode.getRight();
			}
			else
			{
				ceil = currNode.getData();
				currNode = currNode.getLeft();
			}
		}
		
		System.out.println("Floor for " + key + "is - " + floor);
		System.out.println("ceil for " + key + "is - " + ceil);
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
		floorCeil(tree.getRoot(), 76);
	}
}
