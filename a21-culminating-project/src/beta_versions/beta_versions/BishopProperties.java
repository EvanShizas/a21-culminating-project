package beta_versions;

public class BishopProperties {
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

	public boolean gameCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		int j = 0;

		if (chessBoardMap[posX][posY].equals("wB")) {
			try {
				j = posY + 1;
				
				for (int i = posX + 1; i < BOARD_SIZE; i++) {
					if (chessBoardMap[i][j].contains("bK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j++;
				}
			} catch (Exception e) {}

			try {
				j = posY - 1;
				
				for (int i = posX - 1; i > -1; i--) {
					if (chessBoardMap[i][j].contains("bK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j--;
				}
			} catch (Exception e) {}

			try {
				j = posY + 1;
				
				for (int i = posX - 1; i > -1; i--) {
					if (chessBoardMap[i][j].contains("bK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j++;
				}
			} catch (Exception e) {}

			try {
				j = posY - 1;
				
				for (int i = posX + 1; i < BOARD_SIZE; i++) {
					if (chessBoardMap[i][j].contains("bK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j--;
				}
			} catch (Exception e) {}
		}

		if (chessBoardMap[posX][posY].equals("bB")) {
			try {
				j = posY + 1;
				
				for (int i = posX + 1; i < BOARD_SIZE; i++) {
					if (chessBoardMap[i][j].contains("wK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j++;
				}
			} catch (Exception e) {}

			try {
				j = posY - 1;
				
				for (int i = posX - 1; i > -1; i--) {
					if (chessBoardMap[i][j].contains("wK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j--;
				}
			} catch (Exception e) {}

			try {
				j = posY + 1;
				
				for (int i = posX - 1; i > -1; i--) {
					if (chessBoardMap[i][j].contains("wK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j++;
				}
			} catch (Exception e) {}

			try {
				j = posY - 1;
				
				for (int i = posX + 1; i < BOARD_SIZE; i++) {
					if (chessBoardMap[i][j].contains("wK")) {
						return true;
					}
					
					if (!chessBoardMap[i][j].equals("eE")) {
						break;
					}
					
					j--;
				}
			} catch (Exception e) {}
		}
		
		return false;
	}

	public void pieceBlockCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {

	}
}
