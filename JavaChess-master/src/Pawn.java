public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (super.invalidField(line, column, toLine, toColumn) ||
                super.busy(chessBoard, toLine, toColumn)) {
            return false;
        }
        int stepl = toLine - line;
        int stepc = toColumn - column;
        if (color.equals("White")) {
            if (!this.check && stepl == 2 && stepc == 0) {
                return chessBoard.board[toLine][toColumn] == null &&
                        this.canMoveToPosition(chessBoard, line+1, column, toLine, toColumn);
            } else {
                if (stepl == 1 && stepc == 0) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if (stepl == 1 && (stepc == 1 || stepc == -1)) {
                    ChessPiece piece = chessBoard.board[toLine][toColumn];
                    return piece != null && piece.getColor().equals("Black");
                }
                return false;
            }
        }
        if (color.equals("Black")) {
            if (!this.check && stepl == -2 && stepc == 0) {
                return chessBoard.board[toLine][toColumn] == null &&
                        this.canMoveToPosition(chessBoard, line+1, column, toLine, toColumn);
            } else {
                if (stepl == -1 && stepc == 0) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if (stepl == -1 && (stepc == 1 || stepc == -1)) {
                    ChessPiece piece = chessBoard.board[toLine][toColumn];
                    return piece != null && piece.getColor().equals("White");
                }
                return false;
            }
        }
        throw new RuntimeException("unknown color");
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}
