package PracticeQuestions;

import java.util.ArrayList;

import DataStructures.BinarySearchTree;
import DataStructures.TreeNode;

public class kTHSmallestBST 
{
	public static  int KthSmallestElement(TreeNode root, int K) {
        // Write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root,list,K);
        if(list.size()<K)
            return -1;
        return list.get(K-1);
    }
    
    public static void inorder(TreeNode root, ArrayList<Integer> list,int k)
    {
        if(root==null)
            return;
        
        inorder(root.getLeft(),list,k);
        list.add(root.getData());
        if(list.size()==k)
            return;
        inorder(root.getRight(),list,k);
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
		
		System.out.println(KthSmallestElement(tree.getRoot(),2));
	}
}
