import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Board board = new Board(10, 10);// Creating game board

//Prompt players' name
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1st player name");
		String playerName1 = s.nextLine();

		System.out.println("Enter 2nd player name");
		String playerName2 = s.nextLine();

//Creating player objects
		Player player1 = new Player(playerName1, board);
		Player player2 = new Player(playerName2, board);

		boolean gameEnded = false;

		while (!gameEnded) {

			if (!gameEnded) {
				gameEnded = player1.takeTurn();
			}
			if (!gameEnded) {
				gameEnded = player2.takeTurn();

			}
			if (gameEnded) {// To compare the Players' scores at the end of the game to define WINNER.
				player1.checkWinner(player2);
			}

		}

	}

}
