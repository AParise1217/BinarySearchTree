package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;

/*
 * Andrew Parise
 * March 10th 2016
 * Assignment 6.1
 * Programming II
 * 
 * BinarySearchTreeImplTest.java
 * 
 * Test Class to test the functionality of the BinarySearchTreeImpl.java methods
 * 
 */
public class BinarySearchTreeImplTest {

	public static void main(String[] args) {
		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		
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
		ILinkedList inorderTrav = bst.getInOrder();
		ILinkedList preOrderTrav = bst.getPreOrder();
		ILinkedList postOrderTrav = bst.getPostOrder();
		
	
		
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
