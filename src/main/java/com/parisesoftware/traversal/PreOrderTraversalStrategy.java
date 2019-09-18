package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.model.IBSTNode;

/**
 * {@inheritDoc}
 * Traversal Algorithm for "Pre Order" BST
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.0
 */
public class PreOrderTraversalStrategy<T extends Comparable<T>> implements ITraversalStrategy<T> {

    private ILinkedList<T> linkedList;

    public PreOrderTraversalStrategy(ILinkedListFactory<T> linkedListFactory) {
        this.linkedList = linkedListFactory.createLinkedList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void traverse(IBSTNode<T> parentNode) {
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
