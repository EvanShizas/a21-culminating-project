package beta_versions;

import javax.swing.ImageIcon;

public class IconSelect {
	
	ImageIcon whiteKing = new ImageIcon("assets/images/white-king.png");
	ImageIcon whiteQueen = new ImageIcon("assets/images/white-queen.png");
	ImageIcon whiteRook = new ImageIcon("assets/images/white-rook.png");
	ImageIcon whiteKnight = new ImageIcon("assets/images/white-knight.png");
	ImageIcon whiteBishop = new ImageIcon("assets/images/white-bishop.png");
	ImageIcon whitePawn = new ImageIcon("assets/images/white-pawn.png");
	ImageIcon blackKing = new ImageIcon("assets/images/black-king.png");
	ImageIcon blackQueen = new ImageIcon("assets/images/black-queen.png");
	ImageIcon blackRook = new ImageIcon("assets/images/black-rook.png");
	ImageIcon blackKnight = new ImageIcon("assets/images/black-knight.png");
	ImageIcon blackBishop = new ImageIcon("assets/images/black-bishop.png");
	ImageIcon blackPawn = new ImageIcon("assets/images/black-pawn.png");
	ImageIcon whiteKingSelect = new ImageIcon("assets/images/white-king-select.png");
	ImageIcon whiteQueenSelect = new ImageIcon("assets/images/white-queen-select.png");
	ImageIcon whiteRookSelect = new ImageIcon("assets/images/white-rook-select.png");
	ImageIcon whiteKnightSelect = new ImageIcon("assets/images/white-knight-select.png");
	ImageIcon whiteBishopSelect = new ImageIcon("assets/images/white-bishop-select.png");
	ImageIcon whitePawnSelect = new ImageIcon("assets/images/white-pawn-select.png");
	ImageIcon blackKingSelect = new ImageIcon("assets/images/black-king-select.png");
	ImageIcon blackQueenSelect = new ImageIcon("assets/images/black-queen-select.png");
	ImageIcon blackRookSelect = new ImageIcon("assets/images/black-rook-select.png");
	ImageIcon blackKnightSelect = new ImageIcon("assets/images/black-knight-select.png");
	ImageIcon blackBishopSelect = new ImageIcon("assets/images/black-bishop-select.png");
	ImageIcon blackPawnSelect = new ImageIcon("assets/images/black-pawn-select.png");
	ImageIcon emptySelect = new ImageIcon("assets/images/empty-select.png");
	ImageIcon placeholder = new ImageIcon();
	
	public ImageIcon load(ImageIcon icon, String[][] chessBoardMap, int row, int col) {
		switch (chessBoardMap[row][col]) {
		case "wK":
			icon = whiteKing;
			break;
		case "wQ":
			icon = whiteQueen;
			break;
		case "wR":
			icon = whiteRook;
			break;
		case "wN":
			icon = whiteKnight;
			break;
		case "wB":
			icon = whiteBishop;
			break;
		case "wP":
			icon = whitePawn;
			break;
		case "bK":
			icon = blackKing;
			break;
		case "bQ":
			icon = blackQueen;
			break;
		case "bR":
			icon = blackRook;
			break;
		case "bN":
			icon = blackKnight;
			break;
		case "bB":
			icon = blackBishop;
			break;
		case "bP":
			icon = blackPawn;
			break;
		case "wKs":
			icon = whiteKingSelect;
			break;
		case "wQs":
			icon = whiteQueenSelect;
			break;
		case "wRs":
			icon = whiteRookSelect;
			break;
		case "wNs":
			icon = whiteKnightSelect;
			break;
		case "wBs":
			icon = whiteBishopSelect;
			break;
		case "wPs":
			icon = whitePawnSelect;
			break;
		case "bKs":
			icon = blackKingSelect;
			break;
		case "bQs":
			icon = blackQueenSelect;
			break;
		case "bRs":
			icon = blackRookSelect;
			break;
		case "bNs":
			icon = blackKnightSelect;
			break;
		case "bBs":
			icon = blackBishopSelect;
			break;
		case "bPs":
			icon = blackPawnSelect;
			break;
		case "eEs":
			icon = emptySelect;
			break;
		case "eEsR":
			icon = emptySelect;
			break;
		default:
			icon = null;
		}
		
		return icon;
	}
}
