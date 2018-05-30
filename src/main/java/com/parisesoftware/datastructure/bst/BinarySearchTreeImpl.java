package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/*
 * @author Andrew Parise
 * March 10th 2016
 * Assignment 6.1
 * Programming II
 *
 *
 * BinarySearchTreeImpl.java
 * My implementation of a binary search tree
 *
 * Assignment Overview:
 * This programming exercise introduces binary search trees.
 * The students must create all the necessary methods for the binary search trees
 * and use the binary search trees in a Java program.
 *
 * 		Edit Log:
 * 			March 11th - initial edit
 * 			March 13th - added removal function
 *
 *
 */
public class BinarySearchTreeImpl {
	//init vars
	private Node _root;
	private LinkedListImpl _inOrder, _preOrder, _postOrder;

	public BinarySearchTreeImpl(){
		//default constructor
		_root = null;
		_inOrder = new LinkedListImpl();
		_preOrder = new LinkedListImpl();
		_postOrder = new LinkedListImpl();
	}

	//Root get/set
	public void setRoot(Node root){
		_root = root;
	}
	public Node getRoot(){
		return _root;
	}
	////////////////

	public boolean isEmpty(){
		//Checks if BST is empty, returns true if it is empty, false if it contains data
		return (_root == null);
	}

	//TRAVERSAL FUNCTIONS:
	public void populateTraverseLists(){ //calls the three traversal functions to populate respective linked lists
		deleteOldTraversals(); //clears data in the linked lists (if this function has already been called, it needs to reset the lists to prevent concatenating the new and old)
		traverseInOrder();
		traversePreOrder();
		traversePostOrder();
	}
	public void traverseInOrder(){ //Design and write a method to perform an in-order traversal of a binary tree
		//Traverses tree and returns list of nodes: LeftNode,Print, RightNode
		traverseInOrder(getRoot());
	}
	private void traverseInOrder(Node parentNode){ //recursive search
		if(parentNode != null){
			traverseInOrder(parentNode.getLeftNode()); //Left
			_inOrder.insertEnd(parentNode.getData()); //Add to list
			traverseInOrder(parentNode.getRightNode()); //Right
		}
	}
	public LinkedListImpl getInOrder(){
		return _inOrder;
	}
	public void deleteOldTraversals(){
		_preOrder = new LinkedListImpl();
		_postOrder = new LinkedListImpl();
		_inOrder = new LinkedListImpl();

	}
	public void traversePreOrder(){ //Design and write a method to perform a pre-order traversal of a binary tree
		//Traverses tree and returns list of nodes: LeftNode, RightNode, Print
		traversePreOrder(getRoot());
	}
	private void traversePreOrder(Node parentNode){//recursive search
		if(parentNode != null){
			_preOrder.insertEnd(parentNode.getData()); //Add to list
			traversePreOrder(parentNode.getLeftNode()); //Left
			traversePreOrder(parentNode.getRightNode()); //Right
		}
	}
	public LinkedListImpl getPreOrder(){
		return _preOrder;
	}

	public void traversePostOrder(){ //Design and write a method to perform a post-order traversal of a binary tree
		//Traverses tree and returns list of nodes: Print, LeftNode, RightNode
		traversePostOrder(getRoot());
	}
	private void traversePostOrder(Node parentNode){ //recursive search
		if(parentNode != null){
			traversePostOrder(parentNode.getLeftNode()); //Left
			traversePostOrder(parentNode.getRightNode()); //Right
			_postOrder.insertEnd(parentNode.getData()); //Add to list
		}
	}
	public LinkedListImpl getPostOrder(){
		return _postOrder;
	}
	////////////////////////

	//INSERTION FUNCTIONS:
	private Node insert(Node node, String data){
		//Recursively insert data into the Tree
		if(node == null){
			node = new Node(data);
		}
		else if((data.compareTo(node.getData()) <= 0)){ //if data comes before, or is same as node.Data in alphabetical order
			node.setLeftNode(insert(node.getLeftNode(), data));
		}
		else{
			node.setRightNode(insert(node.getRightNode(), data));
		}
		return node;
	}
	public void insert(String data){ //Design and write a method to build a binary tree
		setRoot(insert(getRoot(), data));
	}
	///////////////////////

	//DELETION FUNCTIONS:
	public boolean removeNode(String data){
		if(getRoot() == null){
			return false;
		}
		else{
			if(getRoot().getData() == data){
				Node tempNode = new Node();
				tempNode.setLeftNode(getRoot());
				boolean retVal = getRoot().removeNode(data, tempNode);
				setRoot(tempNode.getLeftNode());
				return retVal;
			}
			else{
				return getRoot().removeNode(data, null);
			}
		}
	}

	/////////////////////
}
