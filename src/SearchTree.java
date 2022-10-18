//Reference from https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
public class SearchTree{
	public Node root;
	other helper = new other(); //creating an object of helper class
	//Default constructor to create instance
	public SearchTree(){

	}
	boolean add(String key) {
		//key is null
		if(key == null){
			return false;
		}
		//First node in the tree
		if(root == null){
			root = new Node(key);
			return true;
		}

		//instance of root
		Node oldROot = root;
		while(root != null){
			if(key.compareToIgnoreCase(root.key) == 0){
				root = oldROot;
				return false;
			}
			//Add to the left
			else if(key.compareToIgnoreCase(root.key) < 0 && root.left == null){
				root.left = new Node(key);
				root = oldROot;
				return true;
			}
			//Add to the right
			else if (key.compareToIgnoreCase(root.key) > 0 && root.right == null) {
				root.right = new Node(key);
				root = oldROot;
				return true;
			}

			//Find leaf node to the right
			else if (root.key.compareToIgnoreCase(key) < 0){
				root = root.right;
			}

			//Find leaf node to the left
			else if(root.key.compareToIgnoreCase(key) >0){
				root = root.left;
			}

		}
		return false;
	}

	int find(String key) {
		int depth = 1;//Initializing value of depth to 1
		try{

			if(key == null || key == ""){
				return 0;
			}
			Node currentNode;
			if(root == null){
				return 0;
			}
			else{
				//creating a reference variable with value of root
				currentNode = root;
			}

			//finding parent node of current node
			Node parentNode = helper.getParentNode(currentNode, key);
			//Root node is being searched
			if(parentNode == null){
				currentNode.counter++;
				return depth;
			}

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
