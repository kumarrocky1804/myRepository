package PracticeQuestions;

import java.util.Stack;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class Merge2BST 
{
	/* There are easier methods to merge 2 BSTs but they do not work efficiently for
	 * unbalanced tree. One of these methods is tried here - 
	 * https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1/#
	 * 
	 * Here we are attempting a better approach.
	 */
	
	// inorder traverse method
	public static void inorder(TreeNode node)
	{
		if(node==null)
			return;
		
		inorder(node.getLeft());
		System.out.print(node.getData() + " -> ");
		inorder(node.getRight());
	}
	
	// actual merging method
	// we are going to have the iterative inorder approach for both trees with separate stacks.
	public static void merge(TreeNode root1, TreeNode root2)
	{
		TreeNode currNode1 = root1;
		TreeNode currNode2 = root2;
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		//Tackling base cases, if any tree is empty
		if(root1==null)
			inorder(root2);
		if(root2==null)
			inorder(root1);
		
		// Run loop until we have nodes in any of the trees or in any of stacks
		while(currNode1!=null || !stack1.isEmpty() ||
				currNode2!=null || !stack2.isEmpty())
		{
			// if any of tree's current element is not null, go to its leftmost node
			// Stay in "IF" until both nodes does not point to null
			if(currNode1!=null || currNode2!=null)
			{
				if(currNode1!=null)
				{
					stack1.push(currNode1);
					currNode1 = currNode1.getLeft();
				}
				if(currNode2!=null)
				{
					stack2.push(currNode2);
					currNode2 = currNode2.getLeft();
				}
			}
			else
			{
				// now both the pointers point to null
				// if any of the stack is empty, that means the tree has exhausted
				// Just inorder the other tree and return
				if(stack1.isEmpty())
				{
					while(!stack2.isEmpty())
					{
						currNode2 = stack2.pop();
						// This step is done so that the left child does not get printed
						// as it is already printed in last iteration
						currNode2.setLeft(null);
						inorder(currNode2);
					}
					return;
				}
				if(stack2.isEmpty())
				{
					while(!stack1.isEmpty())
					{
						currNode1 = stack1.pop();
						currNode1.setLeft(null);
						inorder(currNode1);
					}
					return;
				}
				
				// If we are here, that means we have elements in both stacks but the current
				// is null (we are at leftmost of current subtree)
				currNode1 = stack1.pop();
				currNode2 = stack2.pop();
				
				// the greater element should go back in stack and lesser should be printed
				if(currNode1.getData()>=currNode2.getData())
				{
					System.out.print(currNode2.getData() + " -> ");
					currNode2 = currNode2.getRight();
					stack1.push(currNode1);
					// empty the node as its value is pushed back
					currNode1=null;
				}
				else
				{
					System.out.print(currNode1.getData() + " -> ");
					currNode1 = currNode1.getRight();
					stack2.push(currNode2);
					// empty the node as its value is pushed back
					currNode2=null;
				}
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
		
		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.insert(11);
		tree2.insert(7);
		tree2.insert(1);
		tree2.insert(10);
		//tree.insert(20);
		tree2.insert(25);
		tree2.insert(22);
		tree2.insert(88);
		tree2.insert(65);
		
		System.out.println("First tree is - ");
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Second tree is - ");
		tree2.inorderTraversal(tree2.getRoot());
		System.out.println();
		System.out.println("Merged tree is - ");
		merge(tree.getRoot(), tree2.getRoot());
	}
}
