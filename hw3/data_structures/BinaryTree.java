// currently only has functionality needed for problem 1

public class BinaryTree {
	int[] data; 
	int size;
	int curr;

	public BinaryTree( int size ) {
		data = new int[data];
		this.size = size;
		curr = 0;
	}

	public insert( int num ) {
		if( curr == size )
			throw new IllegalStateException();
		data[curr] = num;
		curr++;
	}

	public String inorder( int pos ) {
		if( curr == 0 )
				return "";
			
		String str = "";
		int left = pos*2 + 1;
		int right = pos*2 + 2;

		if( left < arr.length ) {
			str += makeInorder(arr, left);
		}
		str += arr[pos] + " ";
		if( right < arr.length ) {
			str += makeInorder(arr, right);
		}
		return str;
	}
}