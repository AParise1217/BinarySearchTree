/*
 * Andrew Parise
 * March 10th 2016
 * Assignment 6.1
 * Programming II
 * 
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
		// Solution to HW Assignment
		
		//Step 1
		MyBinarySearchTree service = new MyBinarySearchTree(); 
		
		//Step 2
		String[] names = {"Daniel", "George", "Adam", "Peter", "Michael", "Jones", "Tom", "Allison", "James", "Brian"}; 
		for(int i = 0; i < names.length; i++){
			service.insert(names[i]);
		}
		
		//Step 3
		service.populateTraverseLists();
		MyLinkedListClass inorderTrav = service.getInOrder();
		MyLinkedListClass preOrderTrav = service.getPreOrder();
		MyLinkedListClass postOrderTrav = service.getPostOrder();
		
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
