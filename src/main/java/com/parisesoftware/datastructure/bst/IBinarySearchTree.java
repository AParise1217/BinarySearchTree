package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.model.Node;

/**
 * Binary Search Tree
 * <p>
 * Core abstraction for the Binary Search Tree Data Structure
 * </p>
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IBinarySearchTree<T extends Comparable<T>> {

    /**
     * Checks if BST is empty, returns true if it is empty, false if it contains data
     * @return {@code boolean} representing if the BST is empty or not
     */
    boolean isEmpty();

    /**
     * Calls the three traversal functions to populate respective linked lists
     */
    void populateTraverseLists();

    /**
     * @return the BST in pre order
     */
    ILinkedList<T> getPreOrder();

    /**
     * @return the BST in post order
     */
    ILinkedList<T> getPostOrder();

    /**
     * Inserts the given data into the Binary Search tree
     * @param data information to be stored in the bst
     */
    void insert(T data);

    /**
     * Removes the Node containing the given data from the Binary Search Tree
     * @param data to search for
     */
    void removeNode(T data);

    /**
     * Sets the Binary Search Tree's Root Node
     * @param root node to be the BSTs root
     */
    void setRoot(Node<T> root);

    /**
     * Fetch the Root Node of the Binary Search Tree
     * @return {@code Node} that is at the root of the tree
     */
    Node<T> getRoot();

}
