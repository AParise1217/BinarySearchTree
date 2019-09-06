package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.datastructure.model.IBSTNode;

/**
 * {@inheritDoc}
 * <p>
 * Traversal Algorithm for "In Order" BST
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
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
    public void traverse(IBSTNode<T> parentNode) {
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
