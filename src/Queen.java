public class Queen extends Piece {

    Queen(Player player){
        super(player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        // Information from Wikipedia
        /*
        The white queen starts on d1, while the black queen starts on d8.
        With the chessboard oriented correctly, the white queen starts on a white square and the black queen starts on a black square—thus the mnemonics
        "queen gets her color", "queen on [her] [own] color", or "the dress [queen piece] matches the shoes [square]" (Latin: servat rēgīna colōrem).

        The queen can be moved any number of unoccupied squares in a straight line vertically, horizontally, or diagonally,
        thus combining the moves of the rook and bishop.
        The queen captures by occupying the square on which an enemy piece sits.
        */

        // If the space has teammate in it, always invalid
        if (teammateOccupied(end))
            return false;

        int yDist = end.getY() - start.getY();
        int xDist = end.getX() - start.getX();

        // Checks
        // 1. Diagonal
        // 2. Like a rook

        int yDir = yDist > 0 ? 1 : -1;
        int xDir = xDist > 0 ? 1 : -1;
        if (Math.abs(yDist) == Math.abs(xDist))
        {
            for (int y = start.getY(); y < yDist - 1; y += yDir)
            {
                for (int x = start.getX(); x < xDist - 1; x += xDir)
                {
                    if (isOccupied(board.getSpot(x, y)))
                        return false;
                }
            }
            return true;
        }
        else if (yDist != 0 && xDist == 0)
        {
            for (int y = start.getY(); y < yDist - 1; y += yDir)
            {
                if (isOccupied(board.getSpot(start.getX(), y)))
                    return false;
            }
            return true;

        }
        else if (yDist == 0 && xDist != 0)
        {
            for (int x = start.getX(); x < xDist - 1; x += xDir) {
                if (isOccupied(board.getSpot(x, start.getY())))
                    return false;
            }
            return true;
        }

        return false;
    }

    public String printAction() {
        String color = this.getPlayer().getColor() ? WHITE_BRIGHT : BLACK;

        return color + "[Q]" + RESET;
    }
}
