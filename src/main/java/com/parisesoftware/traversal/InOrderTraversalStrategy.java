package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * Traversal Algorithm for "In Order" BST
 */
public class InOrderTraversalStrategy implements ITraversalStrategy {

    private ILinkedList linkedList;

    public InOrderTraversalStrategy() {
        this.linkedList = new LinkedListImpl();
    }

    public void traverse(Node parentNode) {
        if(parentNode != null) {
            traverse(parentNode.getLeftNode());
            this.linkedList.insertEnd(parentNode.getData());
            traverse(parentNode.getRightNode());
        }
    }

    public ILinkedList getTraversalPath() {
        return this.linkedList;
    }


}
