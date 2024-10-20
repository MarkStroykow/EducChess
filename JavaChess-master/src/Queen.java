public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        ChessPiece bishop = new Bishop(this.getColor());
        ChessPiece rook = new Rook(this.getColor());
        return bishop.canMoveToPosition(chessBoard, line, column, toLine, toColumn) ||
                rook.canMoveToPosition(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
