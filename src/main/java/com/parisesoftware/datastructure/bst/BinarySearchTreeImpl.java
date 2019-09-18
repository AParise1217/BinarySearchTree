package com.parisesoftware.datastructure.bst;

import com.google.inject.Inject;
import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.model.BSTNode;
import com.parisesoftware.datastructure.model.IBSTNode;
import com.parisesoftware.datastructure.model.factory.IBSTNodeFactory;
import com.parisesoftware.traversal.ITraversalStrategy;
import com.parisesoftware.traversal.InOrderTraversalStrategy;
import com.parisesoftware.traversal.PostOrderTraversalStrategy;
import com.parisesoftware.traversal.PreOrderTraversalStrategy;

/**
 * {@inheritDoc}
 * <p>
 * Default Implementation of {@link IBinarySearchTree}
 * </p>
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.0
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private final ILinkedListFactory<T> linkedListFactory;
    private final IBSTNodeFactory<T> bstNodeFactory;

    private IBSTNode<T> root;

    private ILinkedList<T> inOrder;

    private ILinkedList<T> preOrder;

    private ILinkedList<T> postOrder;

    @Inject
    public BinarySearchTreeImpl(ILinkedListFactory<T> linkedListFactory, IBSTNodeFactory<T> bstNodeFactory) {
        this.root = null;

        this.linkedListFactory = linkedListFactory;
        this.bstNodeFactory = bstNodeFactory;

        this.inOrder = this.linkedListFactory.createLinkedList();
        this.preOrder = this.linkedListFactory.createLinkedList();
        this.postOrder = this.linkedListFactory.createLinkedList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return (this.root == null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void populateTraverseLists() {
        deleteOldTraversals();
        traverseInOrder();
        traversePreOrder();
        traversePostOrder();
    }

    /**
     * Perform an in-order traversal of a binary tree
     */
    private void traverseInOrder() {
        ITraversalStrategy<T> inOrderTraversal = new InOrderTraversalStrategy<>(this.linkedListFactory);
        inOrderTraversal.traverse(getRoot());
        this.inOrder = inOrderTraversal.getTraversalPath();
    }

    /**
     * @return the BST in order
     */
    @Override
    public ILinkedList<T> getInOrder() {
        return this.inOrder;
    }

    /**
     * Cleans leftover data traversals
     */
    private void deleteOldTraversals() {
        this.inOrder = this.linkedListFactory.createLinkedList();
        this.preOrder = this.linkedListFactory.createLinkedList();
        this.postOrder = this.linkedListFactory.createLinkedList();
    }

    /**
     * Performs a pre-order traversal of a binary tree
     */
    private void traversePreOrder() {
        ITraversalStrategy<T> preOrderTraversal = new PreOrderTraversalStrategy<>(this.linkedListFactory);
        preOrderTraversal.traverse(getRoot());
        this.preOrder = preOrderTraversal.getTraversalPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ILinkedList<T> getPreOrder() {
        return this.preOrder;
    }

    /**
     * Traverses tree and returns list of nodes: Print, LeftNode, RightNode
     */
    private void traversePostOrder() {
        ITraversalStrategy<T> postOrderTraversal = new PostOrderTraversalStrategy<>(this.linkedListFactory);
        postOrderTraversal.traverse(getRoot());
        this.postOrder = postOrderTraversal.getTraversalPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ILinkedList<T> getPostOrder() {
        return this.postOrder;
    }

    /**
     * @param node node to be inserted
     * @param data if node is null, creates a new node from this data
     * @return Recursively insert data into the Tree
     */
    private IBSTNode<T> insert(IBSTNode<T> node, T data) {
        if (node == null) {
            node = this.bstNodeFactory.createNode(data);
        } else if ((data.compareTo(node.getData()) <= 0)) {
            //if data comes before, or is same as node.Data in alphabetical order
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }
        return node;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(T data) {
        setRoot(insert(getRoot(), data));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeNode(T data) {
        if (getRoot() != null) {
            if (getRoot().getData().equals(data)) {
                IBSTNode<T> tempNode = this.bstNodeFactory.createEmptyNode();
                tempNode.setLeftNode(getRoot());
                getRoot().removeNode(data, tempNode);
                setRoot(tempNode.getLeftNode());
            } else {
                getRoot().removeNode(data, null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRoot(IBSTNode<T> root) {
        this.root = root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IBSTNode<T> getRoot() {
        return this.root;
    }

}
