package com.parisesoftware.traversal;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * {@inheritDoc}
 * <p>
 * Traversal Algorithm for "Post Order" BST
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public class PostOrderTraversalStrategy<T extends Comparable<T>> implements ITraversalStrategy<T> {

    private ILinkedList<T> linkedList;

    public PostOrderTraversalStrategy() {
        this.linkedList = new LinkedListImpl<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void traverse(Node<T> parentNode) {
        if (parentNode != null) {
            traverse(parentNode.getLeftNode());
            traverse(parentNode.getRightNode());
            this.linkedList.insertEnd(parentNode.getData());
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
