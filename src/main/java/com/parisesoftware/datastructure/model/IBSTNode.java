package com.parisesoftware.datastructure.model;

import com.parisesoftware.model.INode;

/**
 * Abstraction for the some Container of Data to be housed in a
 * {@link com.parisesoftware.datastructure.bst.IBinarySearchTree} Data Structure
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.1
 */
public interface IBSTNode<T extends Comparable<T>> extends INode<T> {

    /**
     * Helper method for deletion
     *
     * @param data   to be removed
     * @param parent {@code IBSTNode} to set
     * @return {@code boolean}
     */
    boolean removeNode(T data, IBSTNode<T> parent);

    /**
     * Helper function, returns farthest left node from given node
     *
     * @return {@code T} the Data contained in the furthest left node
     */
    T getMinimumValue();

    /**
     * Fetch the BSTNode to the Left of this BSTNode
     * @return {@code BSTNode} that is to the left of this one in the sequence
     */
    IBSTNode<T> getLeftNode();

    /**
     * Setter for the BSTNode that is to the left of this one in the Sequence
     * @param leftNode to be set
     */
    void setLeftNode(IBSTNode<T> leftNode);

    /**
     * Fetch the BSTNode to the Right of this BSTNode
     * @return {@code BSTNode} that is to the right of it in the sequence
     */
    IBSTNode<T> getRightNode();

    /**
     * Setter for the BSTNode that is to the right of this one in the Sequence
     * @param rightNode {@code BSTNode} to be set
     */
    void setRightNode(IBSTNode<T> rightNode);

}
