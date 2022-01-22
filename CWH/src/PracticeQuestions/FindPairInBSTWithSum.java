package PracticeQuestions;

import java.util.Stack;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class FindPairInBSTWithSum
{
	/* The problem is to find the pair in BST that has the sum equal to a certain number.
	 * Simple Method is-
	 * 	1. Store Inorder in an array. (Array will be sorted)
	 *  2. Start with left and right simultaneously as left will be smallest and right will 
	 *     be highest.
	 *  3. if sum ==k, great we are done; id sum<k, we need higher number, left++;
	 *     if sum>k, we need lower number, right--
	 *  In above algo, we need O(n) space, O(n) time.
	 *  
	 *  Better Method is -
	 *  Inorder and reverse inorder simultaneously and step by step take out the numbers similar
	 *  to above algo.
	 */
	
	public static void FindPair(TreeNode root, int sum)
	{
		// flags to check if one item from inorder and reverse inorder is taken out
		boolean done1=false;
		boolean done2=false;
		// to store temp values
		int val1=0,val2=0;
		//stacks to help in inorder and reverse order traversal
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		TreeNode curr1 = root;
		TreeNode curr2 = root;
		
		// we will break out of this when all the values are exhausted
		while(true)
		{
			// get one number out according to inorder
			while(done1==false)
			{
				if(curr1!=null)
				{
					stack1.push(curr1);
					curr1 = curr1.getLeft();
				}
				else
				{
					if(stack1.isEmpty())
						done1=true;
					else
					{
						curr1 = stack1.pop();
						val1=curr1.getData();
						curr1=curr1.getRight();
						done1=true;
					}
				}
			}
			
			// get one number out according to reverse inorder
			while(done2==false)
			{
				if(curr2!=null)
				{
					stack2.push(curr2);
					curr2 = curr2.getRight();
				}
				else
				{
					if(stack2.isEmpty())
						done2=true;
					else
					{
						curr2 = stack2.pop();
						val2=curr2.getData();
						curr2=curr2.getLeft();
						done2=true;
					}
				}
			}
			
			//Now start comparing
			if(val1+val2==sum)
			{
				System.out.println("The found pair is - " + val1 + ", " + val2);
				return;
			}
			else if(val1+val2>sum)
			{
				// next from reverse order
				done2=false;
			}
			else
				done1=false;
			
			// every possible pair is tried
			if(val1>=val2)
			{
				System.out.println("No pair is found....");
				return;
			}
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
		
		System.out.println("Tree is - ");
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		FindPair(tree.getRoot(), 700);
	}
}
