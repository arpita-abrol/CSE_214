import java.util.*;

public class Queue<T> {

	// Node inner class

	class Node<T> {
		//instance vars
		private T data;
		private Node next;

		//constructor
		public Node() {
			data = null;
			next = null;
		}

		public Node( T value ) {
			data = value;
			next = null;
		}

		public Node( T value, Node next ) {
			data = value;
			this.next = next;
		}	

		//accessors
		public T getData() { return data; }
		public Node getNext() { return next; }

		//mutators
		public T setData( T newData ) {
			T temp = getData();
			data = newData;
			return temp;
		}

		public Node setNext( Node newNext ) {
			Node temp = next;
			next = newNext;
			return temp;
		}

		//override toString()
		public String toString() { return data.toString(); }

	}

	//Queue functions

	private Node<T> front, end;
	private int size;

	public Queue() {
		size = 0;
	}

	public void enqueue( T val ) {
		Node<T> newVal = new Node(val, null);
		if( isEmpty() ) {
			front = newVal;
			end = front;
			front.setNext(end);
		}
		else {
			end.setNext(newVal);
			end = newVal;
		}
		size++;
	}

	public T dequeue() {
		if( isEmpty() ) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			Node<T> tmp = front;
			front = front.getNext();
			size--;
			return tmp.getData();
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override 
	public String toString() {
		String str = "";
		Node<T> curr = front;
		while( curr != null ) {
			str += curr.getData() + " ";
			curr = curr.getNext();
		}
		return str;
	}

	/*
	//main method for testing
	public static void main( String[] args ) {
		Queue<String> PirateQueue = new Queue<String>();

		System.out.println("\nnow enqueuing..."); 
		PirateQueue.enqueue("Dread");
		PirateQueue.enqueue("Pirate");
		PirateQueue.enqueue("Roberts");
		PirateQueue.enqueue("Blackbeard");
		PirateQueue.enqueue("Peter");
		PirateQueue.enqueue("Stuyvesant");

		System.out.println("\nnow testing toString()..."); 
		System.out.println( PirateQueue ); //for testing toString()...

		System.out.println("\nnow dequeuing..."); 
		System.out.println( PirateQueue.dequeue() );
		System.out.println( PirateQueue.dequeue() );
		System.out.println( PirateQueue.dequeue() );
		System.out.println( PirateQueue.dequeue() );
		System.out.println( PirateQueue.dequeue() );
		System.out.println( PirateQueue.dequeue() );

		System.out.println("\nnow dequeuing for empty queue..."); 
		System.out.println( PirateQueue.dequeue() );	

		PirateQueue.enqueue("Dread");
	}
	*/


}