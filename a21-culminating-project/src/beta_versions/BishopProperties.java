package beta_versions;

public class BishopProperties {
	final int BOARD_SIZE = 8;
	
	public void ruleSet(String[][] chessBoardMap, String charTurnContain, int posX, int posY, final int BOARD_SIZE) {
		int j = 0;
		
		try {
			j = posY + 1;

			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j++;
			}
		} catch (Exception e) {}

		try {
			j = posY - 1;

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j--;
			}
		} catch (Exception e) {}

		try {
			j = posY + 1;

			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j++;
			}
		} catch (Exception e) {}

		try {
			j = posY - 1;

			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].equals("eE")) {
					chessBoardMap[i][j] += "s";
				}

				else if (!chessBoardMap[i][j].equals("eE") && !chessBoardMap[i][j].contains(charTurnContain)) {
					chessBoardMap[i][j] += "s";
					break;
				}

				else {
					break;
				}

				j--;
			}
		} catch (Exception e) {}
	}
	
	public boolean gameCheck(String[][] chessBoardMap, int posX, int posY) {
		int j = 0;
		
		if (chessBoardMap[posX][posY].equals("wB")) {
			j = posY + 1;
			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].contains("bK")) {
					return true;
				}
				j++;
			}

			j = posY - 1;
			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].contains("bK")) {
					return true;
				}
				j--;
			}

			j = posY + 1;
			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].contains("bK")) {
					return true;
				}
				j++;
			}

			j = posY - 1;
			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].contains("bK")) {
					return true;
				}
				j--;
			}
		}
		
		if (chessBoardMap[posX][posY].equals("bB")) {
			j = posY + 1;
			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].contains("wK")) {
					return true;
				}
				j++;
			}

			j = posY - 1;
			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].contains("wK")) {
					return true;
				}
				j--;
			}

			j = posY + 1;
			for (int i = posX - 1; i > -1; i--) {
				if (chessBoardMap[i][j].contains("wK")) {
					return true;
				}
				j++;
			}

			j = posY - 1;
			for (int i = posX + 1; i < BOARD_SIZE; i++) {
				if (chessBoardMap[i][j].contains("wK")) {
					return true;
				}
				j--;
			}
		}
		return false;
	}
	
	public void pieceBlockCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		
	}
}
