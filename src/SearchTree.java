
public class SearchTree{
	public Node root;
	other helper = new other(); //creating an object of helper class
	//Default constructor to create instance
	public SearchTree(){

	}
	boolean add(String key) {
		try{
			if(key == null || key == ""){
				return false;
			}
			//Adding key to the bottom of the tree and returning the newly added node as root
			root = insert(root,key);
			return true;
//		if (root == null|| root.key!=key){
//			return false;
//		}
//		else{
//			return true;
//		}

		}
		catch(Exception e){
			return false;
		}
	}

	//Reference from https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	Node insert(Node root, String key) {
		try{
			//Tree is empty New node can be added
			if(root == null) {
				root = new Node(key);
				return root;
			}
//		int comparison = helper.comparison(key, root.key);
//		if(comparison == 0){
//			return null;
//		}

			//Key of new node is less than root
			else if(helper.comparison(key, root.key) < 0) {
				//Passing left node as root with the key till we reach the leaf node
				root.left = insert(root.left, key);
			}
			//Key of new node is less than root
			else if(helper.comparison(key, root.key) > 0) {
				//Passing right node as root with the key till we reach the leaf node
				root.right = insert(root.right, key);
			}
			return root;
		}

		catch(Exception e){
			System.out.println(e);
		}

		return root;

	}

	int find(String key) {
		int depth = 1;//Initializing value of depth to 1
		try{

			if(key == null || key == ""){
				return 0;
			}
			//creating a reference variable with value of root
			Node currentNode = root;
			//finding parent node of current node
			Node parentNode = helper.getParentNode(currentNode, key);
			//current node is root node with depth 1
//			if(parentNode == currentNode){
//				depth++;
//				return depth ;
//			}

			//Traversing till we find the node whose key is equal to key we are finding
			while(currentNode.key!= key) {
				if (helper.comparison(key, currentNode.key) == 0) {
					//Node found. Incrementing the counter by 1
					currentNode.counter++;

					//Rotating the tree
					if(currentNode.counter > parentNode.counter) {
						rotateNode(parentNode, currentNode);
					}
					return depth;
				}

				//Traversing the tree to the left if our key is less than root node's key
				else if(helper.comparison(key, currentNode.key) < 0) {
					currentNode = currentNode.left;
					//Incrementing the depth of tree by one as we go deep
					depth++;
				}

				//Traversing the tree to the right if our key is less than root node's key
				else if(helper.comparison(key, currentNode.key) > 0) {
					currentNode = currentNode.right;
					//Incrementing the depth of tree by one as we go deep
					depth++;
				}
				else{
					return 0;
				}
			}

			//Current Node -> key is equal to key we are finding
			currentNode.counter++;
			if(currentNode.counter > parentNode.counter) {
				//Calling rotate method
				rotateNode(parentNode, currentNode);
			}

		}
		catch(Exception e){
			return 0;
			//return depth;
		}
		return depth;
	}

	void reset() {
		treeTraverse(root);
	}

	void treeTraverse(Node currentNode) {
		try{
			//Tree is empty
			if(currentNode == null) {
				return;
			}
			//Performing inorder traversal
			treeTraverse(currentNode.left);
			//Setting counter of all our nodes to 0
			currentNode.counter = 0;
			treeTraverse(currentNode.right);
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

	void rotateNode(Node parentNode1, Node currentNode1) {
		try{
			//creating reference variables of our parent nodes children
			Node left = parentNode1.left;
			Node right = parentNode1.right;

			//Finding parent node of parent node
			Node parentP = helper.getParentNode(root, parentNode1.key);

			//We are doing rotation with the parent node. After rotation our current node will be the root node
			if(parentP == null) {
				//Finding whether our current node is left or right child of parent node
				if(left!=null && left.key.equalsIgnoreCase(currentNode1.key)) {
					//Right rotation if left child
					helper.rotateRight(currentNode1, parentNode1);
				}
				else {
					//Left rotation if right child
					helper.rotateLeft(currentNode1, parentNode1);
				}
				//Setting current node as root
				root = currentNode1;
			}

			//Parent node is not root node and hence parent of parent node will have to
			// assigned to new child after rotation
			else {
				if(left!=null && left.key.equalsIgnoreCase(currentNode1.key)) {
					//Right rotation if left child
					helper.rotateRight(currentNode1, parentNode1);
					//Method to assign parent of current node after rotation
					helper.assignParent(parentP, parentNode1, currentNode1);
				}
				else {
					//Left rotation if right child
					helper.rotateLeft(currentNode1, parentNode1);
					//Method to assign parent of current node after rotation
					helper.assignParent(parentP, parentNode1, currentNode1);
				}
			}
		}
		catch (Exception e){
			System.out.println(e);
		}

	}

	String printTree(){
		String tree = printNode(root, "");
		return tree;
	}

	String printNode (Node currentN, String stringMain){
		try{
			//Exit if all nodes have been returned and tree has reached the end
			if(currentN == null){
				return "";
			}

			if(currentN!=null){
				//Traversing to left
				if(currentN.left!=null){
					stringMain = printNode(currentN.left,stringMain);
				}
				//Finding depth of current node
				int d1 = helper.DepthFind(currentN.key, this.root);
				//Appending value of key and depth
				//stringMain = stringMain + currentN.key + " " + d1 + System.getProperty("line.separator");;
				stringMain = stringMain + currentN.key + " " + d1 + "\n";

				//Traversing to right
				if(currentN.right!=null){
					stringMain = printNode(currentN.right,stringMain);
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return stringMain;
	}

}
