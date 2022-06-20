package beta_versions;

public class PawnProperties {
	public void ruleSet(String[][] chessBoardMap, String charTurnContain, int posX, int posY, final int BOARD_SIZE) {
		if (chessBoardMap[posX][posY].equals("wP")) {
			if (posX == 6) {
				if (chessBoardMap[posX - 2][posY].equals("eE") && chessBoardMap[posX - 1][posY].equals("eE")) {
					chessBoardMap[posX - 2][posY] += "s";
				}
			}

			if (posX != 0) {
				if (chessBoardMap[posX - 1][posY].equals("eE")) {
					chessBoardMap[posX - 1][posY] += "s";
				}

				if (posY != BOARD_SIZE - 1) {
					if (!chessBoardMap[posX - 1][posY + 1].equals("eE") && !chessBoardMap[posX - 1][posY + 1].contains(charTurnContain)) {
						chessBoardMap[posX - 1][posY + 1] += "s";
					}
				}

				if (posY != 0) {
					if (!chessBoardMap[posX - 1][posY - 1].equals("eE") && !chessBoardMap[posX - 1][posY - 1].contains(charTurnContain)) {
						chessBoardMap[posX - 1][posY - 1] += "s";
					}
				}
			}
		}

		else {
			if (posX == 1) {
				if (chessBoardMap[posX + 2][posY].equals("eE") && chessBoardMap[posX + 1][posY].equals("eE")) {
					chessBoardMap[posX + 2][posY] += "s";
				}
			}

			if (posX != BOARD_SIZE - 1) {
				if (chessBoardMap[posX + 1][posY].equals("eE")) {
					chessBoardMap[posX + 1][posY] += "s";
				}

				if (posY != BOARD_SIZE - 1) {
					if (!chessBoardMap[posX + 1][posY + 1].equals("eE") && !chessBoardMap[posX + 1][posY + 1].contains(charTurnContain)) {
						chessBoardMap[posX + 1][posY + 1] += "s";
					}
				}

				if (posY != 0) {
					if (!chessBoardMap[posX + 1][posY - 1].equals("eE") && !chessBoardMap[posX + 1][posY - 1].contains(charTurnContain)) {
						chessBoardMap[posX + 1][posY - 1] += "s";
					}
				}
			}
		}
	}
	
	public boolean gameCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		if (chessBoardMap[posX][posY].equals("wP")) {
			try {
				if (chessBoardMap[posX - 1][posY + 1].contains("bK")) {
					return true;
				}
			} catch (Exception e) {}

			try {
				if (chessBoardMap[posX - 1][posY - 1].contains("bK")) {
					return true;
				}
			} catch (Exception e) {}
		}

		else {
			try {
				if (chessBoardMap[posX + 1][posY + 1].contains("wK")) {
					return true;
				}
			} catch (Exception e) {}

			try {
				if (chessBoardMap[posX + 1][posY - 1].contains("wK")) {
					return true;
				}
			} catch (Exception e) {}
		}

		return false;
	}
	
	public void pieceBlockCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		
	}
	
	public void promotion(String[][] chessBoardMap, final int BOARD_SIZE) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (chessBoardMap[0][i].contains("wP")) {
				chessBoardMap[0][i] = "wQ";
				System.out.println("h");
			} 
			
			if (chessBoardMap[7][i].contains("bP")) {
				chessBoardMap[7][i] = "bQ";
			}
			
			System.out.println("p");
		}
	}
}
