
//MAZE CLASS
public class Maze {

	// PROVIDED
	private static final int TRIED = 2;
	private static final int PATH = 3;

  private int [][] grid = {{1,1,1,0,1,1,0,0,0,1,1,1,1},
				    		 {1,0,0,1,1,0,1,1,1,1,0,0,1},
				             {1,1,1,1,1,0,1,0,1,0,1,0,0},
				             {0,0,0,0,1,1,1,0,1,0,1,1,1},
				             {1,1,1,0,1,1,1,0,1,0,1,1,1},
				             {1,0,1,0,0,0,0,1,1,1,0,0,1},
				             {1,0,1,1,1,1,1,1,0,1,1,1,1},
				             {1,0,0,0,0,0,0,0,0,0,0,0,0},
				             {1,1,1,1,1,1,1,1,1,1,1,1,1}};

	public void printMaze() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(this.grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// Gets number of rows and returns the int value
	public int getNumRows() {
		int row = grid.length;
		return row;
	}

	// Gets number of columns and returns the int value
	public int getNumCols() {
		int column = grid[0].length;
		return column;
	}

	// Finds the grid value
	public int getGridValue(int row, int col) {
		return this.grid[row][col];
	}

	// Makes sure the position is within the row/column limits of the Grid
	public boolean validPosition(int row, int column) {
		if ((row >= 0 && row < grid.length) && (column >= 0 && column < grid[0].length)) {
			return true;
		}
		return false;

	}

	// Changes grid position to TRIED(2)
	public void tryPosition(int row, int col) {
		this.grid[row][col] = TRIED;
	}

	// Marks grid position at 9
	public void markAs9(int row, int col) {
		this.grid[row][col] = 9;
	}

	// Changes grid position to PATH(3)
	public void markPath(int row, int col) {
		this.grid[row][col] = PATH;
	}

	// Checks if the END Position is 2 and returns true if it is
	public boolean canBeSolved() {
		if (grid[getNumRows() - 1][getNumCols() - 1] == 2) {
			return true;
		}
		return false;
	}

	// Checks all directions of a position and if they're all not equal to 1 it returns true
	public boolean isDeadEnd(int row, int column) {
		int count = 0;
		// Test [-1][same]
		if (this.validPosition(row - 1, column) == false || (grid[row - 1][column] != 1)) {
			count += 1;
		}
		// Test [+1][same]
		if (this.validPosition(row + 1, column) == false || (grid[row + 1][column] != 1)) {
			count += 1;
		}
		// Test [same][-1]
		if (this.validPosition(row, column - 1) == false || (grid[row][column - 1] != 1)) {
			count += 1;
		}
		// Test [same][+1]
		if (this.validPosition(row, column + 1) == false || (grid[row][column + 1] != 1)) {
			count += 1;
		}
		if (count == 4) {
			return true;
		}
		return false;
	}
}
