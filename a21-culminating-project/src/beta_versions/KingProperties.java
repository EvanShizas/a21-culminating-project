package beta_versions;

public class KingProperties {
	public void ruleSet(String[][] chessBoardMap, String charTurnContain, int posX, int posY, final int BOARD_SIZE, boolean castlingDoneP1, boolean castlingDoneP2) {
		try {
			if (chessBoardMap[posX + 1][posY].equals("eE") || !chessBoardMap[posX + 1][posY].contains(charTurnContain) && !chessBoardMap[posX + 1][posY].contains("K")) {
				chessBoardMap[posX + 1][posY] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY].equals("eE") || !chessBoardMap[posX - 1][posY].contains(charTurnContain) && !chessBoardMap[posX - 1][posY].contains("K")) {
				chessBoardMap[posX - 1][posY] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX][posY + 1].equals("eE") || !chessBoardMap[posX][posY + 1].contains(charTurnContain) && !chessBoardMap[posX][posY + 1].contains("K")) {
				chessBoardMap[posX][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX][posY - 1].equals("eE") || !chessBoardMap[posX][posY - 1].contains(charTurnContain) && !chessBoardMap[posX][posY - 1].contains("K")) {
				chessBoardMap[posX][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY + 1].equals("eE") || !chessBoardMap[posX + 1][posY + 1].contains(charTurnContain) && !chessBoardMap[posX + 1][posY + 1].contains("K")) {
				chessBoardMap[posX + 1][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY + 1].equals("eE") || !chessBoardMap[posX - 1][posY + 1].contains(charTurnContain) && !chessBoardMap[posX - 1][posY + 1].contains("K")) {
				chessBoardMap[posX - 1][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY - 1].equals("eE") || !chessBoardMap[posX + 1][posY - 1].contains(charTurnContain) && !chessBoardMap[posX + 1][posY - 1].contains("K")) {
				chessBoardMap[posX + 1][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY - 1].equals("eE") || !chessBoardMap[posX - 1][posY - 1].contains(charTurnContain) && !chessBoardMap[posX - 1][posY - 1].contains("K")) {
				chessBoardMap[posX - 1][posY - 1] += "s";
			}
		} catch (Exception e) {}

		if (chessBoardMap[posX][posY].equals("wK")) {
			if (chessBoardMap[BOARD_SIZE - 1][0].equals("wR") && chessBoardMap[BOARD_SIZE - 1][1].equals("eE") && chessBoardMap[BOARD_SIZE - 1][2].equals("eE") && chessBoardMap[BOARD_SIZE - 1][3].equals("eEs") 
					&& chessBoardMap[BOARD_SIZE - 1][4].equals("wK") && !castlingDoneP1) {
				chessBoardMap[BOARD_SIZE - 1][2] += "sR";
			}

			else if (chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 1].equals("wR") && chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 2].equals("eE") && chessBoardMap[BOARD_SIZE - 1][BOARD_SIZE - 3].equals("eEs") 
					&& chessBoardMap[BOARD_SIZE - 1][4].equals("wK") && !castlingDoneP2) {
				chessBoardMap[BOARD_SIZE - 1][6] += "sR";
			}
		}

		else {
			if (chessBoardMap[0][0].equals("bR") && chessBoardMap[0][1].equals("eE") && chessBoardMap[0][2].equals("eE") && chessBoardMap[0][3].equals("eEs") 
					&& chessBoardMap[0][4].equals("bK")) {
				chessBoardMap[0][2] += "sR";
			}

			else if (chessBoardMap[0][0].equals("bR") && chessBoardMap[0][BOARD_SIZE - 2].equals("eE") && chessBoardMap[0][BOARD_SIZE - 3].equals("eEs") 
					&& chessBoardMap[0][4].equals("bK")) {
				chessBoardMap[0][6] += "sR";
			}
		}

		checkKingScanner(chessBoardMap, posX, posY, BOARD_SIZE);
	}
	
	public void checkKingScanner(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) { // Checks if king(s) are in check, and what spots are danger/check spots...
		// TODO -> remove selected spots that will put the king in check by changing the chessBoardMap[][] values.
		
	}
}