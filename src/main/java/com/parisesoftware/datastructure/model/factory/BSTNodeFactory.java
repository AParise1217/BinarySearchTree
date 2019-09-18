package com.parisesoftware.datastructure.model.factory;

import com.parisesoftware.datastructure.model.BSTNode;
import com.parisesoftware.datastructure.model.IBSTNode;
import com.parisesoftware.model.factory.NodeFactory;

/**
 * {@inheritDoc}
 * <p>
 * Default Implementation of {@link IBSTNodeFactory}
 * </p>
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.2
 */
public class BSTNodeFactory<T extends Comparable<T>> extends NodeFactory<T> implements IBSTNodeFactory<T> {

    /**
     * {@inheritDoc}
     */
    @Override
    public IBSTNode<T> createNode(T info) {
        return new BSTNode<>(info);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IBSTNode<T> createEmptyNode() {
        return new BSTNode<>();
    }

}
