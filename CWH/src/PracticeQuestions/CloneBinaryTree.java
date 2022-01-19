package PracticeQuestions;

import java.util.HashMap;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class CloneBinaryTree extends BinarySearchTree
{
	// using pre-order traversal to clone the tree
	public static void cloneNode(TreeNode node, TreeNode clone, HashMap<TreeNode,TreeNode> map,boolean leftChild)
	{
		if(node==null)
			return;
		
		TreeNode currCloneNode = new TreeNode(node.getData());
		map.put(node, currCloneNode);
		if(leftChild==true)
		{
			clone.setLeft(currCloneNode);
			clone = clone.getLeft();
		}
		else
		{
			clone.setRight(currCloneNode);
			clone = clone.getRight();
		}
		
		cloneNode(node.getLeft(),clone,map,true);
		cloneNode(node.getRight(),clone,map,false);
	}
	
	// wrapper function
	public static BinarySearchTree clone(TreeNode root)
	{
		if(root == null)
			return null;
		
		// Hashmap is just used for another question, not needed to clone the tree only
		// - https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
		HashMap<TreeNode,TreeNode> map = new HashMap<TreeNode,TreeNode>();
		BinarySearchTree clonedTree = new BinarySearchTree();
		TreeNode cloneRoot = new TreeNode(root.getData());
		clonedTree.setRoot(cloneRoot);
		map.put(root, cloneRoot);
		cloneNode(root.getLeft(),cloneRoot,map,true);
		cloneNode(root.getRight(),cloneRoot,map,false);
		return clonedTree;
	}
	
	public static void main(String[] args) {
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
		
		System.out.println("Original Tree is - ");
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		
		BinarySearchTree newTree = clone(tree.getRoot());
		newTree.inorderTraversal(newTree.getRoot());
	}
}
