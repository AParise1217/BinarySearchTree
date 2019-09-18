package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.model.IBSTNode;

/**
 * {@inheritDoc}
 * <p>
 * Traversal Algorithm for "In Order" BST
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.0
 */
public class InOrderTraversalStrategy<T extends Comparable<T>> implements ITraversalStrategy<T> {

    private ILinkedList<T> linkedList;

    public InOrderTraversalStrategy(ILinkedListFactory<T> linkedListFactory) {
        this.linkedList = linkedListFactory.createLinkedList();
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
