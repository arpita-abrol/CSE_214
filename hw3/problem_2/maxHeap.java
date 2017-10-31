public class maxHeap {
	int data[];
	int size;
	int maxSize;
	static int DEFAULT = 15; //default capacity

	public maxHeap() {
		data = new int[DEFAULT];
		size = 0;
		maxSize = DEFAULT;
	}

	public maxHeap( int maxSize ) {
		this.maxSize = completeMaxSize(maxSize);
		size = 0;
		data = new int[this.maxSize];
	}

	public int completeMaxSize( int num ) {
		int init = 16;
		while( num >= init )
			init *= 2;
		return init-1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public void swap( int pos1, int pos2 ) {
		int tmp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = tmp;
	}

	public void heapify() {
		int pos = 0;
		int childPos;
		while( pos*2 + 1 < size ) {
			childPos = pos*2 + 1;
			if( childPos < size-1 && data[childPos+1] > data[childPos] )
				childPos++;
			if( data[pos] >= data[childPos] )
				return;
			swap(pos, childPos);
			pos = childPos;
		}
	}

	public void insert( int num ) {
		if( isFull() )
			throw new IllegalStateException();
		size++;
		data[size-1] = num;
		int pos = size-1;
		while( pos > 0 && data[pos] > data[(pos-1)/2] ) {
			swap(pos, (pos-1)/2);
			pos = (pos-1)/2;
		}

	}

	public int deleteMax() {
		if( isEmpty() )
			throw new IllegalStateException();
		int tmp = data[0];
		swap(0, size-1);
		size--;
		heapify();
		return tmp;
	}

	@Override
	public String toString() {
		String str = "[ ";
		for( int i = 0; i < size; i++ )
			str += data[i] + " ";
		return str + "]";
	}

}