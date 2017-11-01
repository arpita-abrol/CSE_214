public class Tree234 {

	// Node inner class
	private class Node {
		int type; 			// 2, 3, or 4 tree
		int[] data;			// array of data elements
		Node[] children;	// array of node references to children
		int size;			// curren num of data elements
		int numChild; 		// current num of children

		public Node() {
			int size = 2;
			type = size;
			this.size = size;
			numChild = 0;
			data = new int[3];
			children = new Node[4];
		}

		public Node( int size ) {
			type = size;
			this.size = size;
			numChild = 0;
			data = new int[3];
			children = new Node[4];
		}

		public boolean isFull() {
			return size == type-1;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public boolean isLeaf() {
			return children[0] == null || children[0].isEmpty();
		}

		public int getNumChildren() {
			return numChild;
		}

		public Node getChild( int index ) {
			return children[index];
		}

		public int getElement( int index ) {
			return data[index];
		}

		public boolean insert( int val ) {
			if( isFull() )
				return false;
			data[size] = val;
			size++;
			return true;
		}

		public boolean search( int num ) {
			for( int i = 0; i < size-1; i++ ) {
				if( num == data[i] )
					return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			String str = "|";
			for( int i = 0; i < type; i++ ) {
				if( data[i] != -1 || data[i] == -1) {
					str += "0|";
				}
				else {
					str += data[i] + "|";
				}
			}
			return str;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	Node root;
	
	public Tree234() {
		root = new Node();
	}

	public Tree234( int num ) {
		root = new Node(num);
	}

	public Node getRoot() {
		return root;
	}

	// 4
	public void insert( int num ) {
		// insertion time
	}

	// 3
	public boolean delete( int num ) {
		if( !search(root, num) )
			return false;
		// insert deletion stuff
		return true;
	}

	// 4
	public boolean search( Node n, int num ) {
		int numChildren = n.getNumChildren();
		if( n.search(num) )
			return true;
		if( numChildren == 0 )
			return false;
		if( numChildren == 2 ) {
			if( num < n.getElement(0) )
				search(n.getChild(0), num);
			else
				search(n.getChild(1), num);
		}
		if( numChildren == 3 ) {
			if( num < n.getElement(0) )
				search(n.getChild(0), num);
			else if( num < n.getElement(1) )
				search(n.getChild(1), num);
			else
				search(n.getChild(2), num);

		}
		if( numChildren == 4 ) {
			if( num < n.getElement(0) )
				search(n.getChild(0), num);
			else if( num < n.getElement(1) )
				search(n.getChild(1), num);
			else if( num < n.getElement(2) )
				search(n.getChild(2), num);
			else
				search(n.getChild(3), num);
		}
		return true;
	}

	// 3
	public String inorder( Node n ) {
		String str = "";
		int numChildren = n.getNumChildren();
		if( numChildren == 0 )
			str += n.toString();
		if( numChildren == 2 ) {
			str += inorder(n.getChild(0));
			str += n.toString();
			str += inorder(n.getChild(1));
		}
		if( numChildren == 3 ) {
			str += inorder(n.getChild(0));
			str += "" + n.getElement(0);
			str += inorder(n.getChild(1));
			str += "" + n.getElement(1);
			str += inorder(n.getChild(2));
		}
		if( numChildren == 4 ) {
			str += inorder(n.getChild(0));
			str += "" + n.getElement(0);
			str += inorder(n.getChild(1));
			str += "" + n.getElement(1);
			str += inorder(n.getChild(2));
			str += "" + n.getElement(2);
			str += inorder(n.getChild(3));
		}
		return str;
	}

	// 3
	public String preorder( Node n ) {
		String str = "";
		int numChildren = n.getNumChildren();
		if( numChildren == 0 )
			str += n.toString();
		if( numChildren == 2 ) {
			str += n.toString();
			str += preorder(n.getChild(0));
			str += preorder(n.getChild(1));
		}
		if( numChildren == 3 ) {
			str += n.toString();
			str += preorder(n.getChild(0));
			str += preorder(n.getChild(1));
			str += preorder(n.getChild(2));
		}
		if( numChildren == 4 ) {
			str += n.toString();
			str += preorder(n.getChild(0));
			str += preorder(n.getChild(1));
			str += preorder(n.getChild(2));
			str += preorder(n.getChild(3));
		}
		return str;
	}

	// 3
	public String postorder( Node n ) {
		String str = "";
		int numChildren = n.getNumChildren();
		if( numChildren == 0 )
			str += n.toString();
		if( numChildren == 2 ) {
			str += postorder(n.getChild(0));
			str += postorder(n.getChild(1));
			str += n.toString();
		}
		if( numChildren == 3 ) {
			str += postorder(n.getChild(0));
			str += postorder(n.getChild(1));
			str += postorder(n.getChild(2));
			str += n.toString();
		}
		if( numChildren == 4 ) {
			str += postorder(n.getChild(0));
			str += postorder(n.getChild(1));
			str += postorder(n.getChild(2));
			str += postorder(n.getChild(3));
			str += n.toString();
		}
		return str;
	}

}