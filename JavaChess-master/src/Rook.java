public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (super.invalidField(line, column, toLine, toColumn) ||
                super.busy(chessBoard,toLine, toColumn)) {
            return false;
        }
        if (line == toLine) {
            int step = -(int) Math.signum(column - toColumn);
            for (int c = column + step; c < toColumn; c += step) {
                System.out.println(c);
                if (chessBoard.board[line][c] != null) {
                    return false;
                }
            }
            return true;
        } else if (column == toColumn) {
            int step = -(int) Math.signum(line - toLine);
            for (int l = line + step; l < toLine; l += step) {
                if (chessBoard.board[l][column] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
