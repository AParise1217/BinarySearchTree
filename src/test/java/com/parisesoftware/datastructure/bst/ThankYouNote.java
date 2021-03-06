package com.parisesoftware.datastructure.bst;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.parisesoftware.datastructure.bst.factory.IBinarySearchTreeFactory;
import com.parisesoftware.datastructure.linkedlist.ILinkedList;

import java.util.Arrays;
import java.util.List;

/**
 * ThankYouNote.java
 * 
 * Assignment Overview:
 * "...you are seeking a way to store the names of the
 *  people to whom the notes must be sent in a way that reflects the 
 *  order that the gifts arrived. ...  create a binary search tree and make 
 *  an attempt to store the names as you think they should be stored. ...
 *  store the names of the sender and then do three searches to determine the best match."
 * 
 * 
 * Class Overview:
 * 	1. create a binary search tree 
 * 	2. populate it from an array of the following names: 
 * 		Daniel, George, Adam, Peter, Michael, Jones, Tom, Allison, James, and Brian.
 * 	3. Perform a preorder, inorder and postorder traversal on the binary tree
 * 	4. Print the names in the order of the traversal
 *  5. Remove Peter and Brian from the tree and perform the traversal again
 *  6. What do you observe when an inorder traversal is performed on the binary tree?
 *  
 */
public class ThankYouNote {

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new StringBSTTestModule());

		IBinarySearchTreeFactory<String> binarySearchTreeFactory =
				injector.getInstance(Key.get(new TypeLiteral<IBinarySearchTreeFactory<String>>() {}));

		//Step 1
		IBinarySearchTree<String> service = binarySearchTreeFactory.createBST();
		
		//Step 2
		List<String> names = Arrays.asList("Daniel", "George", "Adam", "Peter",
				"Michael", "Jones", "Tom", "Allison", "James", "Brian");

		for (String name : names) {
			service.insert(name);
		}
		
		//Step 3
		service.populateTraverseLists();
		ILinkedList inorderTrav = service.getInOrder();
		ILinkedList preOrderTrav = service.getPreOrder();
		ILinkedList postOrderTrav = service.getPostOrder();
		
		//Step 4
		System.out.println("Inorder Traversal: " + inorderTrav.toString());
		System.out.println("PreOrder Traversal: " + preOrderTrav.toString());
		System.out.println("PostOrder Traversal: " + postOrderTrav.toString());
		
		//Step 5
		
		service.removeNode("Peter");
		service.removeNode("Brian");
		service.removeNode("Tom");
		System.out.println("Removing 'Peter'.");
		System.out.println("Removing 'Brian'.");
		
		service.populateTraverseLists();
		inorderTrav = service.getInOrder();
		preOrderTrav = service.getPreOrder();
		postOrderTrav = service.getPostOrder();
		
		System.out.println("Inorder Traversal: " + inorderTrav.toString());
		System.out.println("PreOrder Traversal: " + preOrderTrav.toString());
		System.out.println("PostOrder Traversal: " + postOrderTrav.toString());
		
	}

}
