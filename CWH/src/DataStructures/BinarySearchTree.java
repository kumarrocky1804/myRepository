package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree 
{
	private TreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public TreeNode getRoot()
	{
		return root;
	}
	
	public void setRoot(TreeNode node)
	{
		root = node;
	}
	
	public void insert(int data)
	{
		TreeNode node  = new TreeNode(data);
		if(root == null)
		{
			root = node;
			return;
		}
		
		TreeNode currNode = root;
		while(true)
		{
			if(node.getData()<=currNode.getData())
			{
				if(currNode.getLeft() == null)
				{
					currNode.setLeft(node);
					return;
				}
				currNode = currNode.getLeft();
			}
			else
			{
				if(currNode.getRight() == null)
				{
					currNode.setRight(node);
					return;
				}
				currNode = currNode.getRight();
			}
		}
	}
	
	public void delete(TreeNode start,int data)
	{		
		if(start == null)
		{
			System.out.println("Nothing to delete");
			return;
		}
		
		// if only one element in the tree
		if(start.getLeft() == null && start.getRight()==null)
		{
			if(start.getData() == data)
			{
				start = null;
				return;
			}
			else
			{
				System.out.println("element not found");
				return;
			}
		}
		
		deleteOtherThanRoot(start,data);
	}
	
	// Delete nodes other than root
	public void deleteOtherThanRoot(TreeNode start,int data)
	{
		TreeNode currNode = start;
		TreeNode parent=null;
		boolean leftChild=false;
		
		while(currNode != null)
		{
			if(data < currNode.getData())
			{
				parent  = currNode;
				leftChild = true;
				currNode = currNode.getLeft();
			}
			else if(data > currNode.getData())
			{
				parent = currNode;
				leftChild = false;
				currNode = currNode.getRight();
			}
			else
			{
				// We got the parent now and the currNode to delete
				// IF currNode has 0 child
				if(currNode.getLeft()==null && currNode.getRight() == null)
				{
					if(leftChild == true)
					{
						parent.setLeft(null);
						return;
					}
					parent.setRight(null);
					return;
				}
				// IF node has 1 child
				else if(currNode.getRight() == null)
				{
					if(leftChild == true)
					{
						parent.setLeft(currNode.getLeft());
						return;
					}
					parent.setRight(currNode.getLeft());
					return;
				}
				else if(currNode.getLeft() == null)
				{
					if(leftChild == true)
					{
						parent.setLeft(currNode.getRight());
						return;
					}
					parent.setRight(currNode.getRight());
					return;
				}
				//if currNode has 2 children
				else
				{
					// find the inorder successor, swap values from it and delete that node
					// inorder successor is the minimum value in right subtree.
					
					TreeNode inorderSuccessor = MinValue(currNode.getRight());
					//store value
					int temp = inorderSuccessor.getData();
					
					//delete inorder successor
					delete(currNode, inorderSuccessor.getData());
					
					//assign value
					currNode.setData(temp);
					return;
				}
			}
		}
		System.out.println("Element not found");
	}
	
	public TreeNode MinValue(TreeNode start)
	{
		if(start==null)
		{
			return null;
		}
		while(start.getLeft() != null)
		{
			start = start.getLeft();
		}
		return start;
	}
	
	// FOR BST, this will always give non decreasing order elements
	public void inorderTraversal(TreeNode start)
	{
		if(start == null)
			return;
		
		TreeNode currNode = start;
		this.inorderTraversal(currNode.getLeft());
		System.out.print(start.getData() + " -> ");
		this.inorderTraversal(currNode.getRight());
	}
	
	//INORDER WITH RECURSION
	public void inorderIterative(TreeNode start)
	{		
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		
		TreeNode currNode = start;
		
		while(currNode!=null || !stack.isEmpty())
		{
			while(currNode!=null)
			{
				stack.push(currNode);
				currNode=currNode.getLeft();
			}
			
			currNode = stack.pop();
			System.out.print(currNode.getData() + " -> ");
			currNode=currNode.getRight();
		}
		
	}
	
	public void preorderTraversal(TreeNode start)
	{
		if(start == null)
			return;
		
		TreeNode currNode = start;
		System.out.print(start.getData() + " -> ");
		this.preorderTraversal(currNode.getLeft());
		this.preorderTraversal(currNode.getRight());
	}
	
	public void preorderIterative(TreeNode start)
	{		
		java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
		
		TreeNode currNode = start;
		stack.push(currNode);
		
		while(!stack.isEmpty())
		{
			currNode = stack.pop();
			System.out.print(currNode.getData() + " -> ");
			if(currNode.getRight()!=null)
				stack.push(currNode.getRight());
			if(currNode.getLeft()!=null)
				stack.push(currNode.getLeft());
		}
		
	}
	
	public void postorderTraversal(TreeNode start)
	{
		if(start == null)
			return;
		
		TreeNode currNode = start;
		this.postorderTraversal(currNode.getLeft());
		this.postorderTraversal(currNode.getRight());
		System.out.print(start.getData()+ " -> ");
	}
	
	public void postorderIterative(TreeNode root)
	{
        java.util.Stack<TreeNode> stack1 = new java.util.Stack<TreeNode>();
        java.util.Stack<TreeNode> stack2 = new java.util.Stack<TreeNode>();
        TreeNode currNode=root;
        stack1.push(root);
		
		while(!stack1.isEmpty())
		{
			currNode = stack1.pop();
			
			stack2.push(currNode);
			
			if(currNode.getLeft()!=null)
			    stack1.push(currNode.getLeft());
		    if(currNode.getRight()!=null)
		        stack1.push(currNode.getRight());
		}
		
		while(!stack2.isEmpty())
		    System.out.print(stack2.pop().getData() + " -> ");
    }
	
	public void levelOrderTraversal(TreeNode start)
	{
		if(start==null)
			return;
		
		TreeNode currNode = start;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(currNode);
		while(!q.isEmpty())
		{
			System.out.print(q.peek().getData() + " -> ");
			
			if(q.peek().getLeft() != null)
				q.add(q.peek().getLeft());
			if(q.peek().getRight()!=null)
				q.add(q.peek().getRight());
			
			q.remove();
		}
	}
	
	public void leftView(TreeNode root)
	{
		// level order traversal and print first node from every level
		if(root==null)
			return;
		
		TreeNode currNode = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(currNode);
		while(!q.isEmpty())
		{
			// size of each level
			int sizeOfQ = q.size();
			for(int i=0; i<sizeOfQ; i++)
			{
				// if first of level print it
				if(i==0)
					System.out.print(q.peek().getData() + " -> ");
				
				// continue traversal
				if(q.peek().getLeft() != null)
					q.add(q.peek().getLeft());
				if(q.peek().getRight()!=null)
					q.add(q.peek().getRight());
				//remove parent node after adding child nodes.
				q.remove();
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
		
		/*System.out.println();
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		tree.delete(tree.getRoot(),50);
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println(tree.getRoot().getData()); */
		
		System.out.println("InOrder Traversal - ");
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Inorder Traversal iterative - ");
		tree.inorderIterative(tree.getRoot());
		System.out.println();
		System.out.println("PreOrder Traversal - ");
		tree.preorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("PreOrder Traversal Iterative - ");
		tree.preorderIterative(tree.getRoot());
		System.out.println();
		System.out.println("PostOrder Traversal");
		tree.postorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("PostOrder Traversal Iterative - ");
		tree.postorderIterative(tree.getRoot());
		System.out.println();
		System.out.println("Level Order Traversal");
		tree.levelOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Left View");
		tree.leftView(tree.getRoot());
	}
}

