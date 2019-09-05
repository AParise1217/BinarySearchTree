package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * {@inheritDoc}
 * <p>
 * Traversal Algorithm for "In Order" BST
 */
public class InOrderTraversalStrategy<T extends Comparable<T>> implements ITraversalStrategy<T> {

    private ILinkedList<T> linkedList;

    public InOrderTraversalStrategy() {
        this.linkedList = new LinkedListImpl<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void traverse(Node<T> parentNode) {
        if (parentNode != null) {
            traverse(parentNode.getLeftNode());
            this.linkedList.insertEnd(parentNode.getData());
            traverse(parentNode.getRightNode());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ILinkedList<T> getTraversalPath() {
        return this.linkedList;
    }


}
