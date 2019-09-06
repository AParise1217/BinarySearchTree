package com.parisesoftware.datastructure.model;

import com.parisesoftware.model.INode;
import com.parisesoftware.model.Node;

/**
 * Model to encapsulate Data inside the
 * {@link com.parisesoftware.datastructure.linkedlist.ILinkedList} Data Structure
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public class BSTNode<T extends Comparable<T>> extends Node<T> implements IBSTNode<T> {

    private IBSTNode<T> leftNode;

    private IBSTNode<T> rightNode;

    /**
     * Default Constructor
     */
    public BSTNode() {
    }

    /**
     * @param data the information to store in the BSTNode
     */
    public BSTNode(T data) {
        super(data);
    }

    /**
     * @param link the next BSTNode in the Linked List
     * @param data the information to be stored in the BSTNode
     */
    public BSTNode(INode<T> link, T data) {
        super(link, data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeNode(T data, IBSTNode<T> parent) {

        //if data comes before getData in alphabetical order
        if (data.compareTo(getData()) < 0) {
            return getLeftNode() != null && getLeftNode().removeNode(data, this);
        }

        if (data.compareTo(getData()) > 0) {
            return getRightNode() != null && getRightNode().removeNode(data, this);
        }

        if (getLeftNode() != null && getRightNode() != null) {

            this.data = getRightNode().getMinimumValue();
            getRightNode().removeNode(data, this);

        } else if (parent.getLeftNode() == this) {

            if (getLeftNode() != null) {
                parent.setLeftNode(getLeftNode());
            } else {
                parent.setLeftNode(getRightNode());
            }

        } else if (parent.getRightNode() == this) {

            if (getLeftNode() != null) {
                parent.setRightNode(getLeftNode());
            } else {
                parent.setRightNode(getRightNode());
            }

        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getMinimumValue() {
        if (getLeftNode() == null) {
            return getData();
        }

        return getLeftNode().getMinimumValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IBSTNode<T> getLeftNode() {
        return this.leftNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLeftNode(IBSTNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IBSTNode<T> getRightNode() {
        return this.rightNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRightNode(IBSTNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BSTNode's data = " + this.data;
    }

}
