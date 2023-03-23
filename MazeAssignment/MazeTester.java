
//CLASS FOR SOLVING MAZE
public class MazeTester {

	// checks if the current Node is at the end position
	public static boolean atEnd(Node n, int rowSize, int columnSize) {
		if ((n.nodeRow == rowSize - 1) && (n.nodeColumn == columnSize - 1)) {
			return true;
		}
		return false;
	}

	// This function take the stack, maze, and hypothetical row and column values
	// If the hypothetical values are a valid position on the grid AND that grid
	// position is **ONE**
	// it returns an updated Stack
	public static Stack stackPusher1(Stack s, Maze m, int hypRow, int hypCol) {
		if (m.validPosition(hypRow, hypCol) && m.getGridValue(hypRow, hypCol) == 1) {
			Node n = new Node(m.getGridValue(hypRow, hypCol), hypRow, hypCol);
			s.push(n);
		}
		return s;
	}

	// This function take the stack, maze, and hypothetical row and column values
	// If the hypothetical values are a valid position on the grid AND that grid
	// position is **TWO**
	// it returns an updated Stack
	public static Stack stackPusher2(Stack s, Maze m, int hypRow, int hypCol) {
		if (m.validPosition(hypRow, hypCol) && m.getGridValue(hypRow, hypCol) == 2) {
			Node n = new Node(m.getGridValue(hypRow, hypCol), hypRow, hypCol);
			s.push(n);
		}
		return s;
	}

	// MAIN
	public static void main(String[] args) {

		// Creating Maze
		Maze m = new Maze();

		// Finding row + column sizes
		int rowSize = m.getNumRows();
		int columnSize = m.getNumCols();
		System.out.print("ROW SIZE: " + rowSize + "\n");
		System.out.println("COLUMN SIZE: " + columnSize + "\n");

		// Creating Stack
		Stack myStack = new Stack();

		// Creating Node 0,0
		Node startNode = new Node(m.getGridValue(0, 0), 0, 0);

		// Pushing Node (0,0) onto the Stack
		myStack.push(startNode);


		// Setting current to start node
		Node current = startNode;

		// Printing Maze Before Solve
		System.out.print("BEFORE SOLVE: \n");
		m.printMaze();

		// SOLVES MAZE
		// While current Node position != end position
		while (atEnd(current, rowSize, columnSize) == false) {

			// setting current to the popped node
			current = myStack.pop();
			int curRow = current.nodeRow;
			int curCol = current.nodeColumn;

			// Checks if it's a dead end
			if (m.isDeadEnd(curRow, curCol)) {

				// Test [-1][current]
				myStack = stackPusher2(myStack, m, curRow - 1, curCol);

				// Test [+1][current]
				myStack = stackPusher2(myStack, m, curRow + 1, curCol);

				// Test [current][-1]
				myStack = stackPusher2(myStack, m, curRow, curCol - 1);

				// Test [current][+1]
				myStack = stackPusher2(myStack, m, curRow, curCol + 1);

				// Changing value to 2 if the end is reached otherwise changing to 9
				if (atEnd(current, rowSize, columnSize)) {
					m.tryPosition(curRow, curCol);
				} else {
					m.markAs9(curRow, curCol);
				}

			}

			else {
				// Test [-1][current]
				myStack = stackPusher1(myStack, m, curRow - 1, curCol);

				// Test [+1][current]
				myStack = stackPusher1(myStack, m, curRow + 1, curCol);

				// Test [current][-1]
				myStack = stackPusher1(myStack, m, curRow, curCol - 1);

				// Test [current][+1]
				myStack = stackPusher1(myStack, m, curRow, curCol + 1);

				// Change current to TRIED
				m.tryPosition(curRow, curCol);

			}

			// Break if Stack gets to zero (Can't be solved)
			if (myStack.getHead() == null) {
				break;
			}

		}

		// new STACK for maze
		Stack myStack2 = new Stack();
		// new STACK for order
		Stack myStack3 = new Stack();

		if (m.canBeSolved()) {

			System.out.print("AFTER SOLVE: \n");
			m.printMaze();

			startNode.setNodeValue(m.getGridValue(0, 0));

			// Pushing Node (0,0) onto the Stack
			myStack2.push(startNode);

			// MARKS PATH
			current = startNode;

			while (atEnd(current, rowSize, columnSize) == false) {

				current = myStack2.pop();
				myStack3.append(current);
				int curRow = current.nodeRow;
				int curCol = current.nodeColumn;

				// Test [-1][current]
				myStack2 = stackPusher2(myStack2, m, curRow - 1, curCol);

				// Test [+1][current]
				myStack2 = stackPusher2(myStack2, m, curRow + 1, curCol);

				// Test [current][-1]
				myStack2 = stackPusher2(myStack2, m, curRow, curCol - 1);

				// Test [current][+1]
				myStack2 = stackPusher2(myStack2, m, curRow, curCol + 1);

				// Change current to PATH

				m.markPath(curRow, curCol);

			}

			// Printing Maze After Solve
			System.out.print("MARKED PATH: \n");
			m.printMaze();

			System.out.print("Maze can be solved.\n\n");

			System.out.println("ORDER:");
			myStack3.printOrder();

		} else {

			System.out.print("Maze cannot be solved.");
		}

	}

}
