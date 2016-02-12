import java.util.Scanner;

public class battleship {
	static String letters = "0ABCDEFGH";
	static String num = "ABSDP";

	public static void main(String[] args) {
		char[][] gameBoard = new char[8][8];
		Scanner stdin = new Scanner(System.in);
		System.out.println(
				"There are five kind of boats. Aircraft Carrier, Battleship, Submarine, Destroyer, and Patrol Boat\nUse the first letter of each ship to target it.");
		System.out.println("Are you ready?");
		String answer = stdin.next();
		if (answer.contains("y")) {
			setBoard(gameBoard);
			gameBoard = randomize(gameBoard);
			printBoard(gameBoard);
		} else {
			System.out.println("Come back when you're ready...");
			System.exit(0);
		}
	}

	// clear and reset the board
	static void setBoard(char[][] board) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				board[row][col] = '0';
			}
		}
	}

	// print board
	static void printBoard(char[][] board) {
		for (int row = 0; row < 8; row++) {
			if (row == 0) {
				for (int i = 0; i < letters.length(); i++) {
					System.out.printf("%c ", letters.charAt(i));
				}
				System.out.println();
			}
			System.out.printf("%d ", row + 1);
			for (int col = 0; col < 8; col++) {
				System.out.printf("%c ", board[row][col]);
			}
			System.out.println();
		}
	}

	private static char[][] randomize(char[][] gameBoard) {
		char[] letters = new char[5];
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		int length = 0;
		char shipL = 'z';
		for (int i = 0; i < 5; i++) {
			counter3++;
			boolean skip = false;
			double shipBef = Math.random() * 5;
			int ship = (int) shipBef;

			// if(i == 3) {
			// break;
			// }
			if (i > 0) {
				for (int j = 0; j < 5; j++) {
					if (letters[j] == shipL) {
						skip = true;
					}
				}
				
				if (letters.toString().length() == 5) {
					break;
					// for (int l = 0; l < 5; l++) {
					// if (letters[l] == shipL) {
					// skip = true;
					// }
					// }
				}
				if (skip == false) {
					if (ship == 0) {
						length = 5;
						letters[i] = 'A';
						shipL = 'A';
					} else if (ship == 1) {
						length = 4;
						letters[i] = 'B';
						shipL = 'B';
					} else if (ship == 2) {
						length = 3;
						letters[i] = 'S';
						shipL = 'S';
					} else if (ship == 3) {
						length = 3;
						letters[i] = 'D';
						shipL = 'D';
					} else {
						length = 2;
						letters[i] = 'P';
						shipL = 'P';
					}

					double ranCo = Math.random() * 8;
					int ranCol = (int) ranCo;

					if (ranCo >= 4.5) {
						for (int k = 0; k < length; k++) {
							if (k == 0) {
								counter1++;
							}
							gameBoard[k][ranCol] = num.charAt(ship);
						}

					} else {
						for (int k = 0; k < length; k++) {
							if (k == 0) {
								counter2++;
							}
							gameBoard[ranCol][k] = num.charAt(ship);
						}
					}
				} else {
					i--;
				}
			}
		}
		return gameBoard;
	}
}

