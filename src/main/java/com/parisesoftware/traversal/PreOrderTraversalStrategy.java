package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * Traversal Algorithm for "Pre Order" BST
 */
public class PreOrderTraversalStrategy implements ITraversalStrategy {

    private ILinkedList linkedList;

    public PreOrderTraversalStrategy() {
        this.linkedList = new LinkedListImpl();
    }

    public void traverse(Node parentNode) {
        if(parentNode != null) {
            this.linkedList.insertEnd(parentNode.getData());
            traverse(parentNode.getLeftNode());
            traverse(parentNode.getRightNode());
        }
    }

    public ILinkedList getTraversalPath() {
        return this.linkedList;
    }


}
