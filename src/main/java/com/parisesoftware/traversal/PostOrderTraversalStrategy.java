package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * Traversal Algorithm for "Post Order" BST
 */
public class PostOrderTraversalStrategy implements ITraversalStrategy {

    private ILinkedList linkedList;

    public PostOrderTraversalStrategy() {
        this.linkedList = new LinkedListImpl();
    }

    public void traverse(Node parentNode) {
        if(parentNode != null) {
            traverse(parentNode.getLeftNode());
            traverse(parentNode.getRightNode());
            this.linkedList.insertEnd(parentNode.getData());
        }
    }

    public ILinkedList getTraversalPath() {
        return this.linkedList;
    }


}
