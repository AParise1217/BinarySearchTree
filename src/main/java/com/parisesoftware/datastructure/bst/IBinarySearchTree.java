package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.model.Node;

/**
 * Binary Search Tree
 * <p>
 *     Core abstraction for the Binary Search Tree Data Structure
 * </p>
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IBinarySearchTree<T extends Comparable<T>> {

    boolean isEmpty();

    void populateTraverseLists();

    ILinkedList<T> getPreOrder();

    ILinkedList<T> getPostOrder();

    void insert(T data);

    void removeNode(T data);

    void setRoot(Node<T> root);

    Node<T> getRoot();

}
