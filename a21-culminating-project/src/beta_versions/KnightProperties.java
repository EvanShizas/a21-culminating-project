package beta_versions;

public class KnightProperties {
	public void ruleSet(String[][] chessBoardMap, String charTurnContain, int posX, int posY, final int BOARD_SIZE) {
		try {
			if (chessBoardMap[posX + 2][posY + 1].equals("eE") || !chessBoardMap[posX + 2][posY + 1].contains(charTurnContain)) {
				chessBoardMap[posX + 2][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 2][posY - 1].equals("eE") || !chessBoardMap[posX + 2][posY - 1].contains(charTurnContain)) {
				chessBoardMap[posX + 2][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 2][posY + 1].equals("eE") || !chessBoardMap[posX - 2][posY + 1].contains(charTurnContain)) {
				chessBoardMap[posX - 2][posY + 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 2][posY - 1].equals("eE") || !chessBoardMap[posX - 2][posY - 1].contains(charTurnContain)) {
				chessBoardMap[posX - 2][posY - 1] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY + 2].equals("eE") || !chessBoardMap[posX + 1][posY + 2].contains(charTurnContain)) {
				chessBoardMap[posX + 1][posY + 2] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY - 2].equals("eE") || !chessBoardMap[posX + 1][posY - 2].contains(charTurnContain)) {
				chessBoardMap[posX + 1][posY - 2] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY + 2].equals("eE") || !chessBoardMap[posX - 1][posY + 2].contains(charTurnContain)) {
				chessBoardMap[posX - 1][posY + 2] += "s";
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY - 2].equals("eE") || !chessBoardMap[posX - 1][posY - 2].contains(charTurnContain)) {
				chessBoardMap[posX - 1][posY - 2] += "s";
			}
		} catch (Exception e) {}
	}
	
	public boolean gameCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE, String charTurnContain) {
		try {
			if (chessBoardMap[posX + 2][posY + 1].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 2][posY - 1].contains(charTurnContain + "K")) {
				return true;			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 2][posY + 1].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 2][posY - 1].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY + 2].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX + 1][posY - 2].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY + 2].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}

		try {
			if (chessBoardMap[posX - 1][posY - 2].contains(charTurnContain + "K")) {
				return true;
			}
		} catch (Exception e) {}
		
		return false;
	}
	
	public void pieceBlockCheck(String[][] chessBoardMap, int posX, int posY, final int BOARD_SIZE) {
		
	}
}
