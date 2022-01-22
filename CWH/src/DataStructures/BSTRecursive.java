package DataStructures;

class Node2
{
	int data;
	Node2 left;
	Node2 right;
	
	public Node2(int data)
	{
		this.data=data;
		left=right=null;
	}
}

public class BSTRecursive 
{
	Node2 root=null;
	
	Node2 insert(Node2 root, int key) {
        // your code here
        if(root==null)
        {
            root = new Node2(key);
            return root;
        }
        
        if(key<root.data)
            root.left = insert(root.left,key);
        else if(key>root.data)
            root.right = insert(root.right,key);
        else
            return root;
            
        return root;
    }
	
	public static Node2 deleteNode(Node2 root, int key) {
        // code here.
        if(root==null)
        {
            return root;
        }
        
        if(key<root.data)
            root.left=deleteNode(root.left,key);
        else if(key>root.data)
            root.right = deleteNode(root.right,key);
        else
        {
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
                
            int inorderNext = min(root.right);
            
            root.data = inorderNext;
            
            root.right = deleteNode(root.right,inorderNext);
        }
        return root;
    }
    
    public static int min(Node2 node)
    {
        while(node.left!=null)
            node=node.left;
        return node.data;
    }
    
    static Node2 pre = new Node2(-1), suc = new Node2(-1);

 // This function finds predecessor and
 // successor of key in BST. It sets pre
 // and suc as predecessor and successor
 // respectively
 static void findPreSuc(Node2 root, int key) 
 {
     
     // Base case
     if (root == null)
         return;

     // If key is present at root
     if (root.data == key)
     {
         
         // The maximum value in left 
         // subtree is predecessor
         if (root.left != null) 
         {
             Node2 tmp = root.left;
             while (tmp.right != null)
                 tmp = tmp.right;
                 
             pre = tmp;
         }

         // The minimum value in 
         // right subtree is successor
         if (root.right != null) 
         {
             Node2 tmp = root.right;
             
             while (tmp.left != null)
                 tmp = tmp.left;
                 
             suc = tmp;
         }
         return;
     }

     // If key is smaller than 
     // root's key, go to left subtree
     if (root.data > key)
     {
         suc = root;
         findPreSuc(root.left, key);
     }
     
     // Go to right subtree
     else 
     {
         pre = root;
         findPreSuc(root.right, key);
     }
   }
}
