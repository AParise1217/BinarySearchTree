/*
 * Andrew Parise
 * March 10th, 2016
 * Assignment 6.1
 * Programming II
 * 
 * 
 * Node.java
 * Object which holds left node, right node, and some data as string
 * 
 * to be used in MyBinarySearchTree.java
 * 
 * 
 * 		Edit Log:
 * 			March 10th - initial edit, code copied and edited from "Assignment_5_1"'s "Node.java"
 * 			March 13th - added removal functionality
 */
public class Node {
	//init
	private Node _leftNode;
	private Node _rightNode;
	private String _data;
	private Node _link; //for linked list class
	
	public Node(){
		//default constructor
		_leftNode = null;
		_rightNode = null;
		_data = null;
		_link = null;
	}
	public Node(String data){ //constructor given some data
		_leftNode = null;
		_rightNode = null;
		_data = data;
		_link = null;
	}
	public Node(Node link, String data){ //for linked list class
		//since left and right nodes aren't a factor, they are left uninitialized
		_data = data;
		_link = link;
	}
	
	public boolean removeNode(String data, Node parent){ //helper method for deletion
		if(data.compareTo(getData()) < 0){ //if data comes before getData in alphabetical order
			if(getLeftNode() != null){
				return getLeftNode().removeNode(data, this);
			}
			else{
				return false;
			}
		}
		else if(data.compareTo(getData()) > 0){
			if(getRightNode() != null){
				return getRightNode().removeNode(data,  this);
			}
			else{
				return false;
			}
		}
		else{
			if(getLeftNode() != null && getRightNode() != null){
				setData(getRightNode().getMinimumValue());
				getRightNode().removeNode(data,  this);
			}
			else if(parent.getLeftNode() == this){
				parent.setLeftNode((getLeftNode() != null) ? getLeftNode() : getRightNode());
				
			}
			else if(parent.getRightNode() == this){
				parent.setRightNode((getLeftNode() != null) ? getLeftNode() : getRightNode()); //copied from above, may throw logic errors
			}
			return true;
		}
	}
	public String getMinimumValue(){ //helper function, returns farthest left node from given node
		if(getLeftNode() == null){
			return getData();
		}
		else{
			return getLeftNode().getMinimumValue();
		}
	}
	
	
	
	//Left Node Get/Set
	public Node getLeftNode(){
		return _leftNode;
	}
	public void setLeftNode(Node leftNode){
		_leftNode = leftNode;
	}
	
	//Right Node Get/Set
	public Node getRightNode(){
		return _rightNode;
	}
	public void setRightNode(Node rightNode){
		_rightNode = rightNode;
	}
	
	//Data Set/Get
	public String getData(){
		return _data;
	}
	public void setData(String data){
		_data = data;
	}
	
	//Link Set/Get - for linked list class
	public Node getLink(){
		return _link;
	}
	public void setLink(Node link){
		_link = link;
	}
	
	public String toString(){
		return "Node's data = ";
	}
}
