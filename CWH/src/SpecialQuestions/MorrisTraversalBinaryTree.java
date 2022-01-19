package SpecialQuestions;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class MorrisTraversalBinaryTree extends BinarySearchTree
{
	/* Morris traversal is the method of inorder traversal of the tree
	 * without recursion or stack.
	 * 
	 * Threaded binary trees are based on this traversal.
	 * For more info - https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
	 */
	
	public void MorrisTraversal(TreeNode root)
	{
		TreeNode curr = root;
		
		while(curr!=null)
		{
			// if left subtree is empty, then print this - go to right child
			if(curr.getLeft()==null)
			{
				System.out.println(curr.getData() + " -> ");
				curr = curr.getRight();
			}
			else
			{
				// before printing current data, find inorder predecessor (righmost of left tree)
				TreeNode pre = curr.getLeft();
				
				while(pre.getRight()!=null && pre.getRight()!=curr)
					pre=pre.getRight();
				
				// now, we got a pre, whose right is current or null
				// if it is null, we are visiting it the first time and
				// we will make its right child as current
				if(pre.getRight()==null)
				{
					pre.setRight(curr);
					curr = curr.getLeft();
				}
				//otherwise, its right is current which we had made in IF block above when
				// we visited it the first time.
				// Also, it means that the full left subtree of current is printed
				// Now, print current and move to right. Also, undo the things we did in IF block
				else
				{
					pre.setRight(null);
					System.out.println(curr.getData() + " -> ");
					curr = curr.getRight();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MorrisTraversalBinaryTree tree = new MorrisTraversalBinaryTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		//tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(65);
		
		tree.MorrisTraversal(tree.getRoot());
	}
}
