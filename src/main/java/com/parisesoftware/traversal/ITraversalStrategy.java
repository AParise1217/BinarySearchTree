package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.model.Node;

/**
 * Abstraction for BST Traversal Strategies
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ITraversalStrategy<T extends Comparable<T>> {

    void traverse(Node<T> parentNode);

    ILinkedList<T> getTraversalPath();

}
