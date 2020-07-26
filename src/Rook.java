public class Rook extends Piece {

    public Rook(Player player){
        super(player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        // Information from Wikipedia
        /*
        The white rooks start on squares a1 and h1, while the black rooks start on a8 and h8.
        The rook moves horizontally or vertically, through any number of unoccupied squares (see diagram).
        As with captures by other pieces, the rook captures by occupying the square on which the enemy piece sits.
        The rook also participates, with the king, in a special move called castling.

        I am not going to add castling right now.
        */

        // If the space has teammate in it, always invalid
        if (teammateOccupied(end))
            return false;

        int yDist = end.getY() - start.getY();
        int xDist = end.getX() - start.getX();

        /*
        Check from starting spot up until the end spot.
        This allows to make sure there are no pieces in between and even if the last spot is occupied,
        because already checks for if the spot is a teammate, then it either attacks or moves to an
        empty spot.
        */
        int dir;
        if (yDist != 0 && xDist == 0)
        {
            dir = yDist > 0 ? 1 : -1;

            for (int y = 0; y < yDist - 1; y++)
            {
                if (isOccupied(board.getSpot(start.getX(), start.getY() + (y * dir))))
                    return false;
            }
            return true;
        }
        else if (xDist != 0 && yDist == 0)
        {
            dir = xDist > 0 ? 1 : -1;

            for (int x = 0; x < xDist - 1; x++) {
                if (isOccupied(board.getSpot(start.getX() + (x * dir), start.getY())))
                    return false;
            }
            return true;
        }

        return false;
    }

    public String printAction(){
        String color = this.getPlayer().getColor() ? WHITE_BRIGHT : BLACK;

        return color + "[R]" + RESET;
    }
}
