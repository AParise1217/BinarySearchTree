package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * {@inheritDoc}
 * Traversal Algorithm for "Pre Order" BST
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class PreOrderTraversalStrategy<T extends Comparable<T>> implements ITraversalStrategy<T> {

    private ILinkedList<T> linkedList;

    public PreOrderTraversalStrategy() {
        this.linkedList = new LinkedListImpl<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void traverse(Node<T> parentNode) {
        if (parentNode != null) {
            this.linkedList.insertEnd(parentNode.getData());
            traverse(parentNode.getLeftNode());
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
