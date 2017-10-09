public class Stack {
	String[] arr;
	int curr;
	int size;

	public Stack( int size ) {
		arr = new String[size];
		curr = 0;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push( String item ) {
		if( curr == arr.length ) {
			curr = 0;
		}
		arr[curr] = item;
		curr++;
		//System.out.println(curr);
	}

	public String pop() {
		String temp = arr[curr-1];
		arr[curr-1] = null;
		curr--;
		if( curr == 0 ) {
			curr = arr.length;
		}

		//System.out.println(curr);
		return temp;
	}

	@Override
	public String toString() {
		///*
		//Stack order toString
		String str = "";
		for( int i = 0, j = curr-1; i < arr.length; i++, j-- ) {
			str += arr[j] + " ";
			if( j == 0 ) {
				j = arr.length;
			}
		}
		return str;
		//*/

		/*
		//array order toString (testing purposes)
		String str = "";
		for( String s : arr ) {
			str += s + " ";
		}
		return str;
		*/
	}
}