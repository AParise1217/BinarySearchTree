package com.parisesoftware.datastructure.model

import com.parisesoftware.model.INode
import spock.lang.Specification

class BSTNodeTest extends Specification {

    def "BSTNode: should be of type INode"() {

        when: 'a BSTNode instance is constructed'
        final BSTNode node = new BSTNode()

        then: "the node is of type INode"
        node instanceof INode
    }

}
