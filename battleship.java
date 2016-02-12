package daniel;

/**
 *
 * @author Daniel Britt, djbritt@live.com
 * @version 1.0
 * @since 2/11/2015
 *
 **/
public class battleship {
	static String letters = "0ABCDEFGHIJ";
	static String num = "ABSDP";

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		char[][] gameBoard = new char[10][10];
		setBoard(gameBoard);
		gameBoard = shipChoose(gameBoard);
		printBoard(gameBoard);
		player(gameBoard);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + "ms");
	}

	// clear and reset the board
	static void setBoard(char[][] board) {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				board[row][col] = '0';
			}
		}
	}

	// print board
	static void printBoard(char[][] board) {
		for (int row = 0; row < 10; row++) {
			if (row == 0) {
				for (int i = 0; i < letters.length(); i++) {
					System.out.printf(" %-2c", letters.charAt(i));
				}
				System.out.println();
				System.out.println();
			}
			System.out.printf(" %-2d", row + 1);
			for (int col = 0; col < 10; col++) {
				System.out.printf(" %-2c", board[row][col]);
			}

			System.out.println();
		}
	}

	private static char[][] player(char[][] gameBoard) {
		for (int i = 0; i < 100; i++) {
			int counter = 0;
			double g1 = Math.random() * 10;
			double g2 = Math.random() * 10;
			int guess1 = (int) g1;
			int guess2 = (int) g2;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (gameBoard[j][k] == 'A') {
						counter++;
					}
					if (gameBoard[j][k] == 'B') {
						counter++;
					}
					if (gameBoard[j][k] == 'S') {
						counter++;
					}
					if (gameBoard[j][k] == 'D') {
						counter++;
					}
					if (gameBoard[j][k] == 'P') {
						counter++;
					}
				}
			}
			if (counter == 0) {
				break;
			}

			if (gameBoard[guess1][guess2] != 'X') {
				gameBoard[guess1][guess2] = 'X';
			} else {
				i--;
			}
//			if (i > 89) {
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					System.out.println("can't sleep");
//				}
//			}
			printBoard(gameBoard);
		}
		return gameBoard;
	}

	private static char[][] shipChoose(char[][] gameBoard) {
		char[][] ships = new char[5][2];
		ships[0][0] = 'A';
		ships[0][1] = 5;
		ships[1][0] = 'B';
		ships[1][1] = 4;
		ships[2][0] = 'S';
		ships[2][1] = 3;
		ships[3][0] = 'D';
		ships[3][1] = 3;
		ships[4][0] = 'P';
		ships[4][1] = 2;

		for (int i = 0; i < 5; i++) {
			double ranNo = Math.random() * 8;
			double aPo = Math.random() * 10;
			int aPos = (int) aPo;
			double bPo = Math.random() * 10;
			int bPos = (int) bPo;
			double sdPo = Math.random() * 10;
			int sdPos = (int) sdPo;
			double pPo = Math.random() * 10;
			int pPos = (int) pPo;

			int curNum = (int) ships[i][1];
			char curLet = ships[i][0];
			if (ranNo > 4) {
				if (i == 0) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[aPos][j] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[aPos][k] = '0';
							}
							i--;
							break;
						}
						gameBoard[aPos][j] = curLet;
					}
				} else if (i == 1) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[bPos][j] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[bPos][k] = '0';
							}
							i--;
							break;
						}
						gameBoard[bPos][j] = curLet;
					}
				} else if (i == 2) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[sdPos][j] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[sdPos][k] = '0';
							}
							i--;
							break;
						}
						gameBoard[sdPos][j] = curLet;
					}
				} else if (i == 3) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[sdPos][j] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[sdPos][k] = '0';
							}
							i--;
							break;
						}
						gameBoard[sdPos][j] = curLet;
					}
				} else {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[pPos][j] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[pPos][k] = '0';
							}
							i--;
							break;
						}
						gameBoard[pPos][j] = curLet;
					}
				}
			} else {
				if (i == 0) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[j][aPos] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[k][aPos] = '0';
							}
							i--;
							break;
						}
						gameBoard[j][aPos] = curLet;
					}
				} else if (i == 1) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[j][bPos] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[k][bPos] = '0';
							}
							i--;
							break;
						}
						gameBoard[j][bPos] = curLet;
					}
				} else if (i == 2) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[j][sdPos] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[k][sdPos] = '0';
							}
							i--;
							break;
						}
						gameBoard[j][sdPos] = curLet;
					}
				} else if (i == 3) {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[j][sdPos] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[k][sdPos] = '0';
							}
							i--;
							break;
						}
						gameBoard[j][sdPos] = curLet;
					}
				} else {
					for (int j = 0; j < curNum; j++) {
						if (gameBoard[j][pPos] != '0') {
							for (int k = 0; k < j; k++) {
								gameBoard[k][pPos] = '0';
							}
							i--;
							break;
						}
						gameBoard[j][pPos] = curLet;
					}
				}

			}
		}
		return gameBoard;
	}
}

