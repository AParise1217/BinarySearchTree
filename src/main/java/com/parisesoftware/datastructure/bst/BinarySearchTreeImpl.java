package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/*
 * @author  Andrew Parise
 * @since   March 10th 2016
 * @version June 7th 2018
 *
 */
public class BinarySearchTreeImpl implements IBinarySearchTree {

	private Node root;
	private ILinkedList inOrder;
    private ILinkedList preOrder;
    private ILinkedList postOrder;

    /**
     * Default Constructor
     */
	public BinarySearchTreeImpl() {
		this.root = null;
        this.inOrder = new LinkedListImpl();
        this.preOrder = new LinkedListImpl();
        this.postOrder = new LinkedListImpl();
	}

    /**
     * Checks if BST is empty, returns true if it is empty, false if it contains data
     * @return boolean representing if the BST is empty or not
     */
	public boolean isEmpty() {
		return (this.root == null);
	}

    /**
     * Calls the three traversal functions to populate respective linked lists
     */
	public void populateTraverseLists() {
		deleteOldTraversals();
		traverseInOrder();
		traversePreOrder();
		traversePostOrder();
	}

    /**
     * Perform an in-order traversal of a binary tree
     */
    private void traverseInOrder() {
		traverseInOrder(getRoot());
	}

    /**
     * @param parentNode the node to begin the traversal from
     */
	private void traverseInOrder(Node parentNode) {
		if(parentNode != null) {
			traverseInOrder(parentNode.getLeftNode());
			this.inOrder.insertEnd(parentNode.getData());
			traverseInOrder(parentNode.getRightNode());
		}
	}

    /**
     * @return the BST in order
     */
	public ILinkedList getInOrder() {
		return this.inOrder;
	}

    /**
     * Cleans leftover data traversals
     */
    private void deleteOldTraversals() {
		this.preOrder = new LinkedListImpl();
        this.postOrder = new LinkedListImpl();
        this.inOrder = new LinkedListImpl();

	}

    /**
     * Performs a pre-order traversal of a binary tree
     */
    private void traversePreOrder() {
		traversePreOrder(getRoot());
	}

    /**
     * @param parentNode the parent node to begin the search from
     */
	private void traversePreOrder(Node parentNode) {
		if(parentNode != null) {
			this.preOrder.insertEnd(parentNode.getData());
			traversePreOrder(parentNode.getLeftNode());
			traversePreOrder(parentNode.getRightNode());
		}
	}

    /**
     * @return the BST in pre order
     */
	public ILinkedList getPreOrder() {
		return this.preOrder;
	}

    /**
     * Traverses tree and returns list of nodes: Print, LeftNode, RightNode
     */
    private void traversePostOrder() {
		traversePostOrder(getRoot());
	}

    /**
     * @param parentNode the parent node to begin the search from
     */
	private void traversePostOrder(Node parentNode) {
		if(parentNode != null){
			traversePostOrder(parentNode.getLeftNode());
			traversePostOrder(parentNode.getRightNode());
			this.postOrder.insertEnd(parentNode.getData());
		}
	}

    /**
     * @return  the BST in post order
     */
	public ILinkedList getPostOrder() {
		return this.postOrder;
	}

    /**
     * @param node  node to be inserted
     * @param data  if node is null, creates a new node from this data
     * @return
     *
     * Recursively insert data into the Tree
     */
	private Node insert(Node node, String data) {
		if(node == null) {
			node = new Node(data);
		} else if((data.compareTo(node.getData()) <= 0)) { //if data comes before, or is same as node.Data in alphabetical order
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else {
			node.setRightNode(insert(node.getRightNode(), data));
		}
		return node;
	}

    /**
     * @param data  information to be stored in the bst
     */
	public void insert(String data) {
		setRoot(insert(getRoot(), data));
	}

    /**
     * @param data  data of the node to be removed
     *
     * Deletion function to remove node from BST
     */
	public void removeNode(String data) {
        if (getRoot() != null) {
			if(getRoot().getData().equals(data)) {
				Node tempNode = new Node();
				tempNode.setLeftNode(getRoot());
				getRoot().removeNode(data, tempNode);
				setRoot(tempNode.getLeftNode());
            } else {
                getRoot().removeNode(data, null);
            }
		}
    }

    /**
     * @param root node to be the BSTs root
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @return the root node
     */
    public Node getRoot() {
        return root;
    }
}
