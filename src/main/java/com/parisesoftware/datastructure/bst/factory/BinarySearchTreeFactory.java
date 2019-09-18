package com.parisesoftware.datastructure.bst.factory;

import com.google.inject.Inject;
import com.parisesoftware.datastructure.bst.BinarySearchTreeImpl;
import com.parisesoftware.datastructure.bst.IBinarySearchTree;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.model.factory.IBSTNodeFactory;

/**
 * {@inheritDoc}
 * <p>
 * Default Implementation of {@link IBinarySearchTreeFactory}
 * </p>
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.2
 */
public class BinarySearchTreeFactory<T extends Comparable<T>> implements IBinarySearchTreeFactory<T> {

    private final ILinkedListFactory<T> linkedListFactory;

    private final IBSTNodeFactory<T> bstNodeFactory;

    @Inject
    public BinarySearchTreeFactory(ILinkedListFactory<T> linkedListFactory, IBSTNodeFactory<T> bstNodeFactory) {
        this.linkedListFactory = linkedListFactory;
        this.bstNodeFactory = bstNodeFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IBinarySearchTree<T> createBST() {
        return new BinarySearchTreeImpl<>(this.linkedListFactory, this.bstNodeFactory);
    }

}
