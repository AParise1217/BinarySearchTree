package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.model.Node;

/**
 * Abstraction for BST Traversal Strategies
 */
public interface ITraversalStrategy {

    void traverse(Node parentNode);

    ILinkedList getTraversalPath();

}
