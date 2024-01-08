
public class Squares {
	private int row;
	private int col;
	private boolean hasShip;
	private BattleShip battleship;
	private boolean hasFired;

//row and col shows if the position of square and will be used as reference if battleship has in it
	public Squares(int row, int col) {
		this.row = row;
		this.col = col;
	}

// Getter Setter methods
	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean getHasShip() {
		return this.hasShip;
	}

	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}

	public BattleShip getBattleship() {
		return this.battleship;
	}

	public void setBattleship(BattleShip b) {
		this.battleship = b;
	}

	public boolean getHasFired() {
		return hasFired;
	}

	public void setHasFired(boolean b) {
		this.hasFired = b;
	}

//Retuning the representation of each square object
	public String toString() {
		if (this.hasFired) {
			if (this.hasShip) {
				return String.format("%-3s", "x");
			} else {
				return String.format("%-3s", "o");
			}
		} else
			return String.format("%-3s", "-");

	}

}
