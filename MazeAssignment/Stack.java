
//STACK CLASS
public class Stack {

	// Data Members
	private Node head;
	private Node tail;

	// Stack constructor
	public Stack() {

		head = null;
		tail = null;

	}

	// Getters and Setters
	public Node getHead() {
		return this.head;
	}

	public Node getTail() {
		return this.tail;
	}

	public void setHead(Node n) {
		this.head = n;
	}

	public void setTail(Node n) {
		this.tail = n;
	}

	public int getHeadValue() {
		return this.head.nodeValue;
	}

	public int getTailValue() {
		return this.tail.nodeValue;
	}

	public void printStack() {

		Node temp;
		temp = this.head;
		while (temp != null) {
			System.out.print(temp.nodeValue + "(" + temp.nodeRow + ", " + temp.nodeColumn + ")" + "-->");
			temp = temp.next;
		}

		System.out.println("NULL");
	}
	//Print the [row][column] of the current Node to keep track
	public void printOrder() {
		System.out.print("START-->");
		Node temp;
		temp = this.head;
		while (temp != null) {
			System.out.print("(" + temp.nodeRow + ", " + temp.nodeColumn + ")" + "-->");
			temp = temp.next;
		}

		System.out.println("END");
	}

	// Push method

	public void push(Node n) {

		if (this.head == null) {
			this.setHead(n);
			this.setTail(n);
		}

		else {
			n.next = this.head;
			this.head = n;
		}

	}

	// Pop method

	public Node pop() {

		Node n = new Node(this.head.nodeValue, this.head.nodeRow, this.head.nodeColumn);

		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			
			return n;
		} else {
			this.head = this.head.next;
		}
		return n;

	}

	// Append -- NOT A TRUE STACK METHOD BUT NEEDED FOR GETTING THE ORDER
	public void append(Node n) {

		if (this.head == null) {
			this.setHead(n);
			this.setTail(n);
		}

		else {
			this.tail.next = n;
			n.next = null;
			this.setTail(n);
		}

	}

	// Peek method

	public void peek() {

		if (this.head == null) {
			System.out.println("Empty List");
		}

		else {

			System.out.println(this.head.nodeValue);

		}

	}

}
