package beta_versions;

public class RookProperties {
	public void ruleSet(String[][] chessBoardMap, String charTurnContain, int posX, int posY, final int BOARD_SIZE) {
		for (int i = posX + 1; i < BOARD_SIZE; i++) {
			if (chessBoardMap[i][posY].equals("eE")) {
				chessBoardMap[i][posY] += "s";
			}

			else if (!chessBoardMap[i][posY].equals("eE") && !chessBoardMap[i][posY].contains(charTurnContain)) {
				chessBoardMap[i][posY] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posX - 1; i > -1; i--) {
			if (chessBoardMap[i][posY].equals("eE")) {
				chessBoardMap[i][posY] += "s";
			}

			else if (!chessBoardMap[i][posY].equals("eE") && !chessBoardMap[i][posY].contains(charTurnContain)) {
				chessBoardMap[i][posY] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posY + 1; i < BOARD_SIZE; i++) {
			if (chessBoardMap[posX][i].equals("eE")) {
				chessBoardMap[posX][i] += "s";
			}

			else if (!chessBoardMap[posX][i].equals("eE") && !chessBoardMap[posX][i].contains(charTurnContain)) {
				chessBoardMap[posX][i] += "s";
				break;
			}

			else {
				break;
			}
		}

		for (int i = posY - 1; i > -1; i--) {
			if (chessBoardMap[posX][i].equals("eE")) {
				chessBoardMap[posX][i] += "s";
			}

			else if (!chessBoardMap[posX][i].equals("eE") && !chessBoardMap[posX][i].contains(charTurnContain)) {
				chessBoardMap[posX][i] += "s";
				break;
			}

			else {
				break;
			}
		}
	}

	public boolean gameCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		if (chessBoardMap[posX][posY].equals("wR")) {
			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][posY].contains("bK")) {
					return true;
				}
			}

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][posY].contains("bK")) {
					return true;
				}
			}

			for (int i = posY + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][posY].contains("bK")) {
					return true;
				}
			}

			for (int i = posY - 1; i > -1; i--) {
				if (chessBoardMap[i][posY].contains("bK")) {
					return true;
				}
			}
		}

		if (chessBoardMap[posX][posY].equals("bR")) {
			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][posY].contains("wK")) {
					return true;
				}
			}

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][posY].contains("wK")) {
					return true;
				}
			}

			for (int i = posY + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][posY].contains("wK")) {
					return true;
				}
			}

			for (int i = posY - 1; i > -1; i--) {
				if (chessBoardMap[i][posY].contains("wK")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void pieceBlockCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		
	}
}