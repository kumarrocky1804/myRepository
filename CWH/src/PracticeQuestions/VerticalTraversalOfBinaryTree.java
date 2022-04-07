package PracticeQuestions;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

/** For more info on vertical traversal - 
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 */

public class VerticalTraversalOfBinaryTree 
{	
	public static void getVerticalOrder(TreeNode root, int hd, TreeMap<Integer,Vector<Integer>> map)
	{
		if(root==null)
			return;
		
		Vector<Integer> listOfNodes = map.get(hd);
		
		if(listOfNodes==null)
		{
			listOfNodes = new Vector<Integer>();
		}
		listOfNodes.add(root.getData());
		map.put(hd, listOfNodes);
		
		// traverse rest of nodes
		getVerticalOrder(root.getLeft(), hd-1, map);
		getVerticalOrder(root.getRight(), hd+1, map);
	}
	
	public static void VerticalTraversal(TreeNode root)
	{
		TreeMap<Integer,Vector<Integer>> map = new TreeMap<Integer,Vector<Integer>>();
		
		getVerticalOrder(root, 0, map);
		
		//traverse the map and print - 
		for(Entry<Integer,Vector<Integer>> entry: map.entrySet())
		{
			System.out.println(" Line: " + entry.getKey());
			System.out.println(" Contents of tree: " + entry.getValue());
			System.out.println();
		}
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
		
		VerticalTraversal(tree.getRoot());
	}
}
