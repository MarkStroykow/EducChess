public class Horse extends ChessPiece {
    public Horse(String color) {
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
        return Math.abs(toColumn - column) + Math.abs(toLine - line) == 3;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
