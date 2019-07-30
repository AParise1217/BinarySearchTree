package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;
import com.parisesoftware.traversal.ITraversalStrategy;
import com.parisesoftware.traversal.InOrderTraversalStrategy;
import com.parisesoftware.traversal.PostOrderTraversalStrategy;
import com.parisesoftware.traversal.PreOrderTraversalStrategy;

/**
 * {@inheritDoc}
 * <p>
 * Default Implementation of {@link IBinarySearchTree}
 * </p>
 *
 * @author Andrew Parise
 * @version 1.0.0
 * @since 1.0.0
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private Node<T> root;
    private ILinkedList<T> inOrder;
    private ILinkedList<T> preOrder;
    private ILinkedList<T> postOrder;

    /**
     * Default Constructor
     */
    BinarySearchTreeImpl() {
        this.root = null;
        this.inOrder = new LinkedListImpl<>();
        this.preOrder = new LinkedListImpl<>();
        this.postOrder = new LinkedListImpl<>();
    }

    /**
     * Checks if BST is empty, returns true if it is empty, false if it contains data
     *
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
        ITraversalStrategy<T> inOrderTraversal = new InOrderTraversalStrategy<>();
        inOrderTraversal.traverse(getRoot());
        this.inOrder = inOrderTraversal.getTraversalPath();
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
        this.preOrder = new LinkedListImpl<>();
        this.postOrder = new LinkedListImpl<>();
        this.inOrder = new LinkedListImpl<>();
    }

    /**
     * Performs a pre-order traversal of a binary tree
     */
    private void traversePreOrder() {
        ITraversalStrategy<T> preOrderTraversal = new PreOrderTraversalStrategy<>();
        preOrderTraversal.traverse(getRoot());
        this.preOrder = preOrderTraversal.getTraversalPath();
    }

    /**
     * @return the BST in pre order
     */
    public ILinkedList<T> getPreOrder() {
        return this.preOrder;
    }

    /**
     * Traverses tree and returns list of nodes: Print, LeftNode, RightNode
     */
    private void traversePostOrder() {
        ITraversalStrategy<T> postOrderTraversal = new PostOrderTraversalStrategy<>();
        postOrderTraversal.traverse(getRoot());
        this.postOrder = postOrderTraversal.getTraversalPath();
    }

    /**
     * @return the BST in post order
     */
    public ILinkedList<T> getPostOrder() {
        return this.postOrder;
    }

    /**
     * @param node node to be inserted
     * @param data if node is null, creates a new node from this data
     * @return Recursively insert data into the Tree
     */
    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
        } else if ((data.compareTo(node.getData()) <= 0)) {
            //if data comes before, or is same as node.Data in alphabetical order
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }
        return node;
    }

    /**
     * {@inheritDoc}
     * @param data information to be stored in the bst
     */
    @Override
    public void insert(T data) {
        setRoot(insert(getRoot(), data));
    }

    /**
     * {@inheritDoc}
     * @param data data of the node to be removed
     *             <p>
     *             Deletion function to remove node from BST
     */
    public void removeNode(T data) {
        if (getRoot() != null) {
            if (getRoot().getData().equals(data)) {
                Node<T> tempNode = new Node<>();
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
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * @return the root node
     */
    public Node<T> getRoot() {
        return root;
    }
}
