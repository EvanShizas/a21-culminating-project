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
			for (int i = 0; i < posX; i++) {
				if (chessBoardMap[i][posY].contains("bK")) {
					System.out.println("true1");
					return true;
				}
			}

			for (int i = posX; i < BOARD_SIZE-1; i++) {
				if (chessBoardMap[i][posY].contains("bK")) {
					System.out.println("true2");
					return true;
				}
			}

			for (int i = 0; i < posY; i++) {
				if (chessBoardMap[posX][i].contains("bK")) {
					System.out.println("true3");
					return true;
				}
			}

			for (int i = posY; i < BOARD_SIZE-1; i++) {
				if (chessBoardMap[posX][i].contains("bK")) {
					System.out.println("true4");
					return true;
				}
			}
		}

		if (chessBoardMap[posX][posY].equals("bR")) {
			for (int i = 0; i < posX; i++) {
				if (chessBoardMap[i][posY].contains("wK")) {
					System.out.println("true5");
					return true;
				}
			}

			for (int i = posX; i < BOARD_SIZE-1; i++) {
				if (chessBoardMap[i][posY].contains("wK")) {
					System.out.println("true6");
					return true;
				}
			}

			for (int i = 0; i < posY; i++) {
				if (chessBoardMap[posX][i].contains("wK")) {
					System.out.println("true7");
					return true;
				}
			}

			for (int i = posY; i < BOARD_SIZE-1; i++) {
				if (chessBoardMap[posX][i].contains("wK")) {
					System.out.println("true8");
					return true;
				}
			}
		}
		return false;
	}
	
	public void pieceBlockCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		
	}
}