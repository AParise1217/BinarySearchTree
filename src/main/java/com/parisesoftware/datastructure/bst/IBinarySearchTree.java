package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.model.Node;

public interface IBinarySearchTree {

    boolean isEmpty();

    void populateTraverseLists();

    ILinkedList getPreOrder();

    ILinkedList getPostOrder();

    void insert(String data);

    void removeNode(String data);

    void setRoot(Node root);

    Node getRoot();

}
