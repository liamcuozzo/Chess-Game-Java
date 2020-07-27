public class King extends Piece {

    King(Player player){
        super(player, "[C]");
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        // Information from Wikipedia
        /*
        White starts with the king on the first rank to the right of the queen.
        Black starts with the king directly across from the white king.
        The white king starts on e1 and the black king on e8.

        A king can move one square in any direction (horizontally, vertically, or diagonally) unless the square is already
        occupied by a friendly piece or the move would place the king in check.
        As a result, opposing kings may never occupy adjacent squares (see opposition),
        but the king can give discovered check by unmasking a bishop, rook, or queen.
        The king is also involved in the special move of castling.

        I am not going to add castling right now.
        */

        // If the space has teammate in it, always invalid
        if (teammateOccupied(end))
            return false;

        int yDist = Math.abs(end.getY() - start.getY());
        int xDist = Math.abs(end.getX() - start.getX());

        return yDist <= 1 && xDist <= 1;
    }

    public String printAction() {
        String color = this.getPlayer().getColor() ? WHITE_BRIGHT : BLACK;

        return color + character + RESET;
    }
}
