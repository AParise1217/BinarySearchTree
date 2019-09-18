package com.parisesoftware.datastructure.bst;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.parisesoftware.datastructure.bst.factory.BinarySearchTreeFactory;
import com.parisesoftware.datastructure.bst.factory.IBinarySearchTreeFactory;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.linkedlist.factory.LinkedListFactory;
import com.parisesoftware.datastructure.model.factory.BSTNodeFactory;
import com.parisesoftware.datastructure.model.factory.IBSTNodeFactory;
import com.parisesoftware.model.factory.INodeFactory;
import com.parisesoftware.model.factory.NodeFactory;

/**
 * Guice Dependency Injection Module Configuration
 */
public class StringBSTTestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<INodeFactory<String>>() {})
                .to(new TypeLiteral<NodeFactory<String>>() {});

        bind(new TypeLiteral<IBSTNodeFactory<String>>() {})
                .to(new TypeLiteral<BSTNodeFactory<String>>() {});

        bind(new TypeLiteral<ILinkedListFactory<String>>() {})
                .to(new TypeLiteral<LinkedListFactory<String>>() {});

        bind(new TypeLiteral<IBinarySearchTreeFactory<String>>() {})
                .to(new TypeLiteral<BinarySearchTreeFactory<String>>() {});

    }

}
