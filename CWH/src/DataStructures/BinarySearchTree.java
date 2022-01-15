package DataStructures;

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
	
	public void preorderTraversal(TreeNode start)
	{
		if(start == null)
			return;
		
		TreeNode currNode = start;
		System.out.println(start.getData());
		this.preorderTraversal(currNode.getLeft());
		this.preorderTraversal(currNode.getRight());
	}
	
	public void postorderTraversal(TreeNode start)
	{
		if(start == null)
			return;
		
		TreeNode currNode = start;
		this.postorderTraversal(currNode.getLeft());
		this.postorderTraversal(currNode.getRight());
		System.out.println(start.getData());
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
		
		System.out.println();
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		tree.delete(tree.getRoot(),50);
		tree.inorderTraversal(tree.getRoot());
		System.out.println();
		System.out.println(tree.getRoot().getData());
		
	}
}

