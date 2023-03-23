
//NODE CLASS
public class Node {
	
	// Added row and column values
	public int nodeValue;
	public int nodeRow;
	public int nodeColumn;
	public Node next;

	// Node constructor
	public Node(int value, int row, int col) { 

		nodeValue = value;
		nodeRow = row;
		nodeColumn = col;
		next = null;

	}
	//Node setter
	public void setNodeValue(int newValue) {
		this.nodeValue = newValue;
	}

}
