
public class other {
	//Method to compare values between 2 strings and return the offset in integer
	public int comparison(String k1, String k2) {
		int result = k1.compareToIgnoreCase(k2);
		return result;
	}

	//Method to find the depth of node without increasing the counter
	int DepthFind(String key, Node r1) {
		int depth = 1;
		try{
			//creating a local reference to root node
			Node currentNode = r1;

			//Traversing until we find the key
			while(currentNode.key!= key) {

				// returning value of depth once key is found
				if (comparison(key, currentNode.key) == 0) {
					return depth;
				}
				//Traversing the left subtree
				else if (comparison(key, currentNode.key) < 0) {
					currentNode = currentNode.left;
					depth++;
				}
				//Traversing the right subtree
				else if (comparison(key, currentNode.key) > 0) {
					currentNode = currentNode.right;
					depth++;
				}
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
		return depth;
	}

	public Node getParentNode(Node currentNode, String childKey) {
		Node parentNode = null;
		try{
			if(currentNode == null) {
				return null;
			}

			//Traversing till current node has a parent
			while(currentNode != null) {
				//Finding the current node in the left subtree
				if((currentNode.key.compareToIgnoreCase(childKey))>0) {
					//Saving node to parent node and incrementing the current node
					parentNode = currentNode;
					currentNode = currentNode.left;
				}
				//Finding the current node in the left subtree
				else if ((currentNode.key.compareToIgnoreCase(childKey))<0) {
					//Saving node to parent node and incrementing the current node
					parentNode = currentNode;
					currentNode = currentNode.right;
				}
				//current node is equal to the node we are trying to find
				else if ((currentNode.key.compareToIgnoreCase(childKey))==0)  {
					//return currentNode;
					return parentNode;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);;
		}
		//Returning the parent node
		return parentNode;
	}

	//Reference from https://www.youtube.com/watch?v=pMfoyc6zmZo&t=70s to learn rotations in BST
	void rotateRight(Node currentN, Node parentN) {
		try{
			//Saving current node's right node in a new node
			Node oldRight = currentN.right;
			//Setting the right child of current node to parent node
			currentN.right = parentN;
			//Setting left child of parent node to old right child of current node
			parentN.left = oldRight;
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

	void rotateLeft(Node currentN, Node parentN) {
		try{
			//Saving current node's left node in a new node
			Node oldLeft = currentN.left;
			//Setting the left child of current node to parent node
			currentN.left = parentN;
			//Setting right child of parent node to old left child of current node
			parentN.right = oldLeft;
		}
		catch (Exception e){
			System.out.println(e);
		}

	}

	void assignParent(Node parentP, Node parentNode, Node currentNode) {
		try{
			//Checking whether the newly rotated node will be the parent's left or right child
			if(parentP.left!=null && parentP.left.key.equalsIgnoreCase(parentNode.key)) {
				parentP.left = currentNode;
			}
			else {
				parentP.right = currentNode;
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}

