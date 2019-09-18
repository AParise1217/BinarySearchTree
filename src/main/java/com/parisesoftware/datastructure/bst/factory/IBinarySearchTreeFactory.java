package com.parisesoftware.datastructure.bst.factory;

import com.parisesoftware.datastructure.bst.IBinarySearchTree;

/**
 * Encapsulation of creational logic for {@link com.parisesoftware.datastructure.bst.IBinarySearchTree} instances
 * </p>
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.2
 * @since 1.0.2
 */
public interface IBinarySearchTreeFactory<T extends Comparable<T>> {

    /**
     * Constructs an Empty Binary Search Tree instance
     * @return {@code IBinarySearchTree}
     */
    IBinarySearchTree<T> createBST();

}
