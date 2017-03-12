/*
 * Andrew Parise
 * March 10th 2016
 * Assignment 6.1
 * Programming II
 * 
 * MyBinarySearchTreeTest.java
 * 
 * Test Class to test the functionality of the MyBinarySearchTree.java methods
 * 
 */
public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBinarySearchTree bst = new MyBinarySearchTree();
		
		//test isEmpty()
		if(bst.isEmpty()){
			System.out.println("The BST is empty");
		}
		
		//test insert()
		bst.insert("Boogie");
		bst.insert("Dog");
		bst.insert("Road");
		bst.insert("Ocean");
		bst.insert("Apart");
		bst.insert("Begin");
		bst.insert("Wings");
		bst.insert("Haywire");
		
		if(!bst.isEmpty()){
			System.out.println("The BST is not empty.");
		}
		
		
		//test traversal functions
		bst.populateTraverseLists();
		MyLinkedListClass inorderTrav = bst.getInOrder();
		MyLinkedListClass preOrderTrav = bst.getPreOrder();
		MyLinkedListClass postOrderTrav = bst.getPostOrder();
		
	
		
		System.out.println("Inorder Traversal: " + inorderTrav.toString());
		System.out.println("PreOrder Traversal: " + preOrderTrav.toString());
		System.out.println("PostOrder Traversal: " + postOrderTrav.toString());
		
		//Test removal functions
		bst.removeNode("Apart");
		bst.removeNode("Ocean");
		
		
		bst.populateTraverseLists();
		
		System.out.println("New List (post-order): " + bst.getPostOrder());
	}

}
