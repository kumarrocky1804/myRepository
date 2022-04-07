package PracticeQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

/** The problem is that any two nodes in the BST has got swapped. We have to correct that
 * The simple method is to inorder traverse -> sort -> insert back to get tree (O(nlogn))
 * 
 * Another method is to use the same approach as sorting a array with swapped values.
 * For more info - https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 * 
 * In inorder traversal, there can be two cases -
 * 1. If adjacent nodes are swapped, then there is one irregularity (only one instance where
 *    current node is less than prev.
 * 2. If any other nodes are swapped, then there are two such irregularities
 */

public class CorrectBST 
{	
	static TreeNode prev,first,mid,last;
	public static void inorderAndFindIrregularity(TreeNode root)
	{
		// There can be max 2 irregulatities if one pair of node is swapped
		// if there are two irregularities, we are going to set first,mid and last otherwise only
		// first and mid		
		if(root==null)
			return;
		
		inorderAndFindIrregularity(root.getLeft());
		// if current is less than prev, then it is irregularity because inorder sort BST in
		// non-decreasing order
		if(prev!=null&&root.getData()<prev.getData())
		{
			// it is first irregularity
			if(first==null && mid==null)
			{
				first=prev;
				mid=root;
			}
			// if 2nd irregurlarity
			else
			{
				last=root;
			}
		}
		
		prev=root;
		inorderAndFindIrregularity(root.getRight());
	}
	
	public static void correctBST(TreeNode root)
	{
		// initialize all pointers
		first=mid=last=prev=null;
		
		// Find irregularity and set all pointers
		inorderAndFindIrregularity(root);
		
		//case 1 (swap first and mid)
		if(last==null)
		{
			int temp = first.getData();
			first.setData(mid.getData());
			mid.setData(temp);
		}
		//case 2 (swap first and last)
		else
		{
			int temp = first.getData();
			first.setData(last.getData());
			last.setData(temp);
		}
	}
	
	// search node for integer
	public static TreeNode search(TreeNode root,int data)
	{
		if(root==null)
			return null;
		if(root.getData()==data)
			return root;
		if(data<root.getData())
			return search(root.getLeft(),data);
		else
			return search(root.getRight(),data);
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
		
		System.out.println("Tree inorder - ");
		tree.inorderTraversal(tree.getRoot());
		//TreeNode node1 = search(tree.getRoot(), 70);
		//TreeNode node2 = search(tree.getRoot(), 80);
		TreeNode node1 = search(tree.getRoot(), 20);
		TreeNode node2 = search(tree.getRoot(), 65);
		
		//swap them
		int temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
		
		System.out.println();
		System.out.println("New Tree - ");
		tree.inorderIterative(tree.getRoot());
		
		correctBST(tree.getRoot());
		System.out.println();
		System.out.println("correct tree - ");
		tree.inorderIterative(tree.getRoot());
	}
}
