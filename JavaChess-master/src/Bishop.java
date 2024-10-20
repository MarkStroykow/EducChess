public class Bishop extends ChessPiece {
    public Bishop(String color) {
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

        if (!(Math.abs(line - toLine) == Math.abs(column - toColumn))) {
            return false;
        }

        int stepl = -(int) Math.signum(line - toLine);
        int stepc = -(int) Math.signum(column - toColumn);
        int i = line + stepl;
        int j = column + stepc;
        while (i < toLine) {
            if (chessBoard.board[i][j] != null) {
                return false;
            }
            i += stepl;
            j += stepc;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

}
