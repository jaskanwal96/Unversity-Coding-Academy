
package Practise;

import java.util.ArrayList;

public class BinarySearchTree {

public class Node{
	public int key;
	public Node right;
	public Node left;
	public int N = 0;
	public Node(int key){
		this.key = key;
		this.left = null;
		this.right = null;
	}
}
	public Node root;
	//*********************INSERT***************************
	public Node Insert(int key){
		root = Insert(root,key);
		return root;
	}
	private Node Insert(Node n, int key) {
		if(n == null) return new Node(key);
		//if(n.key == key){}
		else if(key < n.key){
			n.left = Insert(n.left,key);
		}
		else{
			n.right = Insert(n.right,key);
		}
			
		return n;
	}
	//*********************SEARCH***************************
	public boolean Search(int key){
		return Search(root,key);
		
	}
	private boolean Search(Node n,int key){
		if(n == null) return false;
		if(n.key == key)return true;
		if(n.key > key) return Search(n.left,key);
		
			return Search(n.right,key);
	}
	//*********************Get Min***************************
	public int getMin(){
		return getMin(root);
	}
	public int getMin(Node root)
	{
		if(root.left == null) return root.key;
		return getMin(root.left);
		
		
	}
	//*********************GET Maximum***************************
	public int getMax(){
		return getMax(root);
	}
	private int getMax(Node root)
	{
		if(root.right == null) return root.key;
		return getMax(root.right);
		
		
	}
	//*********************Delete Minimum***************************
	public void delmin(){
		root = delMin(root);
	}
	public Node delMin(Node n){
		if(n.left == null)	
			return n.right;
		
		n.left = delMin(n.left);
		return n;
	}
	//*********************Delete Maximum***************************
	public void delmax(){
		root = delMax(root);
	}
	private Node delMax(Node n){
		if(n.right == null)	
			return n.left;
		
		n.right = delMax(n.right);
		return n;
	}
	//*********************Display***************************
	public void display(){
		display(root);
	}
	Node temp = root;
	private void display(Node root){
		if(root==null) return;
		
		display(root.left);
		System.out.print(root.key+" ");
		display(root.right);
	}
	//*********************Display non-rec(Inorder)*************
	public void displayIterative(){
		java.util.Stack<Node> stk = new java.util.Stack<Node>();
		Node current = root;
		//stk.push(current);
		while(current != null)
		{
			stk.push(current);
			current  = current.left;
		}
		
		while(stk.size() > 0)
		{
			current = stk.pop();
			System.out.print(current.key+" ");
			if(current.right!=null)
			{
				current = current.right;
				while(current!=null)
				{
					stk.push(current);
					current  = current.left;
					
				}
			}
		}
		

	}
	//*************************Display postorder without rec
	public void PostOrderIterative(){
		java.util.Stack<Node> first = new java.util.Stack<Node>();
	     java.util.Stack<Node> second = new java.util.Stack<Node>();
        Node current = root;
        ArrayList<Integer> a =  new ArrayList<Integer>();
		 first.push(current);
		 while(!first.isEmpty())
		 {
		     Node temp = first.pop();
		     second.push(temp);
		     if(temp.left != null)
		     first.push(temp.left);
		     if(temp.right != null)
		     first.push(temp.right);
		 }
		 while(!second.isEmpty())
		 {
		     Node temp = second.pop();
		    System.out.print(temp.key+" ");
		 }
		 
	}
	//*********************Preorder without recursion*****************
	public ArrayList<Integer> preorderTraversal(Node root) {
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    java.util.Stack<Node> stk = new java.util.Stack<Node>();
	    stk.push(root);
	    while(!stk.isEmpty()){
	        Node temp = stk.pop();
	        a.add(temp.key);
	        if(temp.right!=null)
	        stk.push(temp.right);
	        if(temp.left!=null)
	        stk.push(temp.left);
	        
	    }
	    
	    return a;
	    
	}
	//*******************Deleting a Node*************
	  void deleteKey(int key)
	    {
	        root = deleteRec(root, key);
	    }
	 
	    /* A recursive function to insert a new key in BST */
	    Node deleteRec(Node root, int key)
	    {
	        /* Base Case: If the tree is empty */
	        if (root == null)  return root;
	 
	     
	        /* Otherwise, recur down the tree */
	       
	        if (key < root.key)
	            root.left = deleteRec(root.left, key);
	        else if (key > root.key)
	            root.right = deleteRec(root.right, key);
	 
	        // if key is same as root's key, then This is the node
	        // to be deleted
	        else
	        {
	           
	        	// node with only one child or no child
	        	 
	        	if (root.left == null)
	                return root.right;
	            else if (root.right == null)
	                return root.left;
	 
	            // node with two children: Get the inorder successor (smallest
	            // in the right subtree)
	            root.key = getMin(root.right);
	 
	            // Delete the inorder successor
	            root.right = deleteRec(root.right, root.key);
	        }
	 
	        return root;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree b = new BinarySearchTree();
		b.Insert(5);
		b.Insert(4);
		b.Insert(3);
		
		b.Insert(10);
		b.Insert(9);
		b.Insert(11);
	    b.displayIterative();
	    b.deleteKey(5);
	    System.out.println();
	    b.displayIterative();
     	
     	//b.PostOrderIterative();
		//b.display();
		/*
		System.out.println(b.Search(9));
		System.out.println(b.getMin());
		System.out.println(b.getMax());
		b.delmin();
		System.out.println(b.Search(1));
		b.delmax();
		System.out.println(b.Search(9));
		*/
	}

}

/*
 
 trie harder delete 
 top view 
 zig zag level order
 
 */
