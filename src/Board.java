import java.util.Random;

public class Board {

	private Squares[][] square;
	SmallBattleship[] smallShipsArr = new SmallBattleship[SmallBattleship.maxNum];
	MediumBattleship[] mediumShipsArr = new MediumBattleship[MediumBattleship.maxNum];
	LargeBattleship[] largeShipsArr = new LargeBattleship[LargeBattleship.maxNum];

	public Board(int row, int col) { // When board object created squares and battleships are created
		populateSquares(row, col);
		populateBattleship();
	}

//	Populate the board data structure with Square objects
	public void populateSquares(int row, int col) {
		square = new Squares[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				square[i][j] = new Squares(i, j);
			}
		}

	}

// Creating all battleships
	public void createBattleShips() {

		for (int i = 0; i < smallShipsArr.length; i++) { // creating small battleship object
			smallShipsArr[i] = new SmallBattleship(1);
		}

		for (int i = 0; i < mediumShipsArr.length; i++) { // creating medium-size battleship object
			mediumShipsArr[i] = new MediumBattleship(2);
		}

		for (int i = 0; i < largeShipsArr.length; i++) { // creating large-size battleship object
			largeShipsArr[i] = new LargeBattleship(3);
		}
	}

	public boolean checkSquareAvaibility(int row, int col, boolean direction, int shipSize) {

		if (shipSize == 1) {// checking available squares for small-size battle ships
			if (!square[row][col].getHasShip()) {
				return true;
			}
		}

		if (shipSize == 2) { // checking available squares for middle-size battle ships
			if (direction) { // if true check position vertically
				if (((row + shipSize) < square[row].length) && !square[row][col].getHasShip()
						&& !square[row + 1][col].getHasShip()) {
					return true;
				}
			} else {// if false check position horizontally
				if (((col + shipSize) < square[col].length) && !square[row][col].getHasShip()
						&& !square[row][col + 1].getHasShip()) {
					return true;
				}
			}

		}

		if (shipSize == 3) { // checking available squares for large-size battle ships
			if (direction) { // if true check position vertically
				if (((row + shipSize) < square[row].length) && !square[row][col].getHasShip()
						&& !square[row + 1][col].getHasShip() && !square[row + 2][col].getHasShip()) {
					return true;
				}
			} else {// if false check position horizontally
				if (((col + shipSize) < square[col].length) && !square[row][col].getHasShip()
						&& !square[row][col + 1].getHasShip() && !square[row][col + 2].getHasShip()) {
					return true;
				}
			}

		}

		return false;
	}

//	Generating battleships => When generating battleships, the placement of the ships should follow certain restrictions
	public void populateBattleship() {
		createBattleShips();
		Random r = new Random();

// Placing small battleships
		for (int i = 0; i < smallShipsArr.length; i++) {
			int row = r.nextInt(10);
			int col = r.nextInt(10);
			if (checkSquareAvaibility(row, col, true, smallShipsArr[i].getShipSize())) { //checkSquare method returns true small ships are located on the square
				square[row][col].setHasShip(true);
				square[row][col].setBattleship(smallShipsArr[i]);
			} else {
				i--;
			}
		}
//		------------------------------------------------------
// Placing of medium battleship
		for (int i = 0; i < mediumShipsArr.length; i++) {
			int row = r.nextInt(10);
			int col = r.nextInt(10);

			boolean orientation = r.nextBoolean();// define the placement orientation of medium battleship = if true =>
													// place vertically, otherwise horizontally
			if (checkSquareAvaibility(row, col, orientation, mediumShipsArr[i].getShipSize())) {//checkSquare method returns true middle-size ships are located on the square
				if (orientation) {
					square[row][col].setHasShip(true);
					square[row + 1][col].setHasShip(true);
					square[row][col].setBattleship(mediumShipsArr[i]);
					square[row + 1][col].setBattleship(mediumShipsArr[i]);
				} else {
					square[row][col].setHasShip(true);
					square[row][col + 1].setHasShip(true);
					square[row][col].setBattleship(mediumShipsArr[i]);
					square[row][col + 1].setBattleship(mediumShipsArr[i]);
				}
			} else {
				i--;
			}
		}

//		------------------------------------------------------
// Placing of large battleship
		for (int i = 0; i < largeShipsArr.length; i++) {
			int row = r.nextInt(10);
			int col = r.nextInt(10);
			boolean orientation = r.nextBoolean();// define the placement orientation of large battleships = if true =>
													// place vertically, otherwise horizontally
			if (checkSquareAvaibility(row, col, orientation, largeShipsArr[i].getShipSize())) {//checkSquare method returns true large-size ships are located on the square
				if (orientation) {
					square[row][col].setHasShip(true);
					square[row + 1][col].setHasShip(true);
					square[row + 2][col].setHasShip(true);
					square[row][col].setBattleship(largeShipsArr[i]);
					square[row + 1][col].setBattleship(largeShipsArr[i]);
					square[row + 2][col].setBattleship(largeShipsArr[i]);
				} else {
					square[row][col].setHasShip(true);
					square[row][col + 1].setHasShip(true);
					square[row][col + 2].setHasShip(true);
					square[row][col].setBattleship(largeShipsArr[i]);
					square[row][col + 1].setBattleship(largeShipsArr[i]);
					square[row][col + 2].setBattleship(largeShipsArr[i]);
				}
			} else {
				i--;
			}
		}

	}

	public String toString() {
		String boardView = "";
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				boardView += square[i][j].toString();
			}
			boardView += "\n";
		}

		return boardView;
	}

//	Getter square
	public Squares getSquare(int x, int y) {
		return square[x][y];
	}

}
