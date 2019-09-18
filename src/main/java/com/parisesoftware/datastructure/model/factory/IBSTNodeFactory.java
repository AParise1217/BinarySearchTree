package com.parisesoftware.datastructure.model.factory;

import com.parisesoftware.datastructure.model.IBSTNode;
import com.parisesoftware.model.factory.INodeFactory;

/**
 * {@inheritDoc}
 * <p>
 * Encapsulation of creational logic for {@link IBSTNode} instances
 * </p>
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.2
 */
public interface IBSTNodeFactory<T extends Comparable<T>> extends INodeFactory<T> {

    @Override
    IBSTNode<T> createNode(T info);

    IBSTNode<T> createEmptyNode();

}
