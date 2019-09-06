package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.model.IBSTNode;

/**
 * Abstraction for BST Traversal Strategies
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public interface ITraversalStrategy<T extends Comparable<T>> {

    /**
     * Traverses the Binary Search Tree, beginning with the given node
     *
     * @param parentNode {@code BSTNode} to begin the traversal with
     */
    void traverse(IBSTNode<T> parentNode);

    /**
     * Fetches the Traversal Path that resulted from the {@link #traverse} operation
     *
     * @return {@code ILinkedList} of the Nodes in the order that the traversal went in
     */
    ILinkedList<T> getTraversalPath();

}
