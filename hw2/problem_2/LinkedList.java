// This is a doubly-linked list

public class LinkedList<T> {

	// Node inner class

	class Node<T> {
		//instance vars
		private T data;
		private Node next, prev;

		//constructor
		public Node() {
			data = null;
			next = null;
			prev = null;
		}

		public Node( T value ) {
			data = value;
			next = null;
			prev = null;
		}

		public Node( T value, Node prev, Node next ) {
			data = value;
			this.next = next;
			this.prev = prev;
		}	

		//accessors
		public T getData() { return data; }
		public Node getNext() { return next; }
		public Node getPrev() { return prev; }

		//mutators
		public T setData( T newData ) {
			T temp = getData();
			data = newData;
			return temp;
		}

		public Node setNext( Node newNext ) {
			Node temp = getNext();
			next = newNext;
			return temp;
		}

		public Node setPrev( Node newPrev ) {
			Node temp = prev;
			prev = newPrev;
			return temp;
		}



		//override toString()
		public String toString() { return data.toString(); }

	}

	// instance vars
	private Node head, tail;
	private int size;

	//constructor
	public LinkedList() {
		head = tail = null;
		size = 0;
	}	


	//list interface methods

	// ~~~~~~~~~~~~~~~~~~~ ADD OPERATIONS ~~~~~~~~~~~~~~~~~~~
	//adds object at index
	public void add( int index, T newVal ) {
		if( index < 0 || index == size() )
			throw new IndexOutOfBoundsException();
		else if( index == 0 ) 
			addFirst(newVal);
		else if( index == size() )
			addLast(newVal);

		else {
			Node tmp1 = head;

			for( int i = 0; i < index-1; i++ )
				tmp1 = tmp1.getNext();

			Node newNode = new Node(newVal, tmp1, tmp1.getNext());
			tmp1.setNext(newNode);
			newNode.getNext().setPrev(newNode);

			size++;
		}
	}

	//adds object to front of list
	public void addFirst( T newVal ) {
		head = new Node(newVal, null, head);
		if( size == 0 ) {
			tail = head;
		}
		else {
			head.getNext().setPrev(head);
		}
		size++;
	}

	//adds object to end of list
	public void addLast( T newVal ) {
		if( size == 0 ) {
			tail = new Node(newVal, tail, null);
			head = tail;
		}
		else {
			Node tmp = tail;
			tail = new Node(newVal, tail, null);
			tmp.setNext(tail);
		}
		size++;
	}

	//adds object to end of list
	public boolean add( T newVal ) {
		addLast( newVal );
		return true;
	}


	// ~~~~~~~~~~~~~~~~~~~ REMOVE OPERATIONS ~~~~~~~~~~~~~~~~~~~
	//removes given node
	public void delete( Node val ) {
		Node tmp = val.getPrev();
		tmp.setNext(val.getNext());
		val.getNext().setPrev(tmp);
		size--;
	}

	//removes object at index from list
	public Node remove( int index ) {
		if( index < 0 || index >= size() )
			throw new IndexOutOfBoundsException();
		else if( index == 0 ) 
			return removeFirst();
		else if( index == size()-1 )
			return removeLast();
		else {
			Node tmp = get(index-1);
			Node removedNode = tmp.getNext();
			tmp.setNext(removedNode.getNext());
			removedNode.getNext().setPrev(tmp);
			
			size--;
			return removedNode;
		}
	}

	//removes first element
	public Node removeFirst() {
		Node first = head;
		if( size == 1 ) {
			head = tail = null;
		}
		else {
			head = head.getNext();
			head.setPrev(null);
		}
		size--;
		return first;
	}

	//removed last element
	public Node removeLast() {
		Node last = tail;
		if( size == 1 ) {
			head = tail = null;
		}
		else {
			tail = tail.getPrev();
			tail.setNext(null);
		}
		size--;
		return last;

	}

	
	// ~~~~~~~~~~~~~~~~~~~ GETTER OPERATIONS ~~~~~~~~~~~~~~~~~~~
	//returns object at index
	public Node get( int index ) {
		if( index < 0 || index >= size() )
			throw new IndexOutOfBoundsException();
		else if( index == 0 ) 
			return getFirst();
		else if( index == size()-1 )
			return getLast();
		else {
			Node tmp = head;

			for( int i = 0; i < index; i++ )
				tmp = tmp.getNext();

			return tmp;
		}
	}

	//gets first element
	public Node getFirst() {
		return head;
	}

	//gets last element
	public Node getLast() {
		return tail;
	}


	// ~~~~~~~~~~~~~~~~~~~ SEARCH OPERATIONS ~~~~~~~~~~~~~~~~~~~

	//true if object rpesent in list
	public boolean contains( T val ) {
		Node tmp = head;
		for( int i = 0; i < size; i++ )
			if( tmp.getData() == val )
				return true;
			tmp = tmp.getNext();
		return false;
	}

	//returns index of object if in list
	public int indexOf( T val ) {
		Node tmp = head;
		for( int i = 0; i < size; i++ )
			if( tmp.getData() == val )
				return i;
			tmp = tmp.getNext();
		return -1;
	}


	// ~~~~~~~~~~~~~~~~~~~ OTHER OPERATIONS ~~~~~~~~~~~~~~~~~~~

	//returns size of list
	public int size() {
		return size;
	}

	//returns if empty
	public boolean isEmpty() {
		return head == null;
	}

	//removes all elements from list
	public void clear() {
		head = null;
		tail = null;
	}

	//override toString
	@Override
	public String toString() {
		String retStr = "";
		Node tmp = head;
		while( tmp != null ) {
			retStr += tmp.getData() + " ";
			tmp = tmp.getNext();
		}
		return retStr;
	}

	/*
	public static void main( String[] args ) {
		LinkedList james = new LinkedList();

		System.out.println("initially: " );
		System.out.println( james.size() + "\t " + james );

		james.add("beat");
		System.out.println( james.size() + "\t " + james );

		james.add("a");
		System.out.println( james.size() + "\t " + james );

		james.add("need");
		System.out.println( james.size() + "\t " + james );

		james.add("I");
		System.out.println( james.size() + "\t " + james );

		james.add(0,"whut");
		System.out.println( "...after add(0,whut): " );
		System.out.println( james.size() + "\t " + james );

		james.add(4,"phat");
		System.out.println( "...after add(4,phat): " );
		System.out.println( james.size() + "\t " + james );

		System.out.println( "...after remove last: "
				    + james.remove( james.size()-1) );
		System.out.println( james.size() + "\t " + james );

		System.out.println( "...after remove(0): " + james.remove(0) );
		System.out.println( james.size() + "\t " + james );

		System.out.println( "...after remove(0): " + james.remove(0) );
		System.out.println( james.size() + "\t " + james );

		System.out.println( "...after remove(0): " + james.remove(0) );
		System.out.println( james.size() + "\t " + james );

		james.add("a");
		System.out.println( james.size() + "\t " + james );
	}
	*/

}