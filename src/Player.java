import java.util.Scanner;

public class Player {
	private String name;
	private int score = 0;
	private Board gameBoard;

	Scanner s = new Scanner(System.in);

	// Constructor
	public Player(String name, Board board) {
		this.name = name;
		this.gameBoard = board;
	}

	// Getter Setter methods
	public String getName() {
		return name;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

// Method is for each player to take turns and will be called from main method.
	public boolean takeTurn() {
		// if final ship is hit and sunk.
		if (BattleShip.permisible != 6) { // each time when the battleships are sunk static value will be increased by
											// one

			Scanner s = new Scanner(System.in);
			System.out.println(this.name + " enter your guess as x y form: ");
			System.out.println(gameBoard.toString()); // Show the updated board state
			// Prompted to enter guess;
			int iRow = s.nextInt();
			int iCol = s.nextInt();

//			Check if the square is hit before or not
			if (!gameBoard.getSquare(iRow, iCol).getHasFired()) {
				gameBoard.getSquare(iRow, iCol).setHasFired(true);

//			Check if has ship in the square
				if (gameBoard.getSquare(iRow, iCol).getHasShip()) {
					System.out.println(this.name + " You hit the ship");
					gameBoard.getSquare(iRow, iCol).getBattleship().setRemainingHealth(1);
					if (gameBoard.getSquare(iRow, iCol).getBattleship().getRemainingHealth() == 0) {
						gameBoard.getSquare(iRow, iCol).getBattleship().setSunk(true);// later will be changed for big
						System.out.println("BattleShip has been destroyed!!! It is sunk!!!");
						System.out.println(this.name + " current score is: " + ++this.score + "\n");
						BattleShip.permisible++;
					}

				} else {// If the battleship is not exist in the hit square.
					System.out.println("Not hit right cell, MISSED!!!!");
				}

			} else { // If player hit the same square repeatedly
				System.out.println("This cell has been already hit. You lost your turn");
			}

			return false;
		} else { // As all ships are sunk method return false to end the game
			System.out.println("All ships are sink.Game is ended");
			return true;
		}

	}

	public void checkWinner(Player rival) { // To define the winner at the end of the game by evoking it from Main
											// method
		if (this.score > rival.getScore()) {
			System.out.println(this.name + " score is: " + this.score + ". He is WINNER!!!");
		} else if (this.score < rival.getScore()) {
			System.out.println(rival.getName() + " score is: " + rival.getScore() + ". He is WINNER!!!");
		} else {
			System.out.println(rival.getName() + " " + rival.getScore() + " score = " + this.name + " " + this.score
					+ ". No WINNER!!!");
		}

	}

}
