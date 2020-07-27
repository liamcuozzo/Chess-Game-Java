public class Bishop extends Piece {

    public Bishop(Player player){ super(player, "[B]");}

    public boolean canMove(Board board, Spot start, Spot end) {
        // Information from Wikipedia
        /*
        The bishop has no restrictions in distance for each move, but is limited to diagonal movement.
        Bishops, like all other pieces except the knight, cannot jump over other pieces.
        A bishop captures by occupying the square on which an enemy piece sits.

        The bishops may be differentiated according to which wing they begin on, i.e. the king's bishop and queen's bishop.
        As a consequence of its diagonal movement, each bishop always remains on either the white or black squares,
        and so it is also common to refer to them as light-squared or dark-squared bishops.
        */

        // If the space has teammate in it, always invalid
        if (teammateOccupied(end))
            return false;

        int yDist = Math.abs(end.getY() - start.getY());
        int xDist = Math.abs(end.getX() - start.getX());

        if (Math.abs(yDist) != Math.abs(xDist))
            return false;

        int yDir = yDist > 0 ? 1 : -1;
        int xDir = xDist > 0 ? 1 : -1;

        for (int y = 1; y <= yDist; y++)
        {
            for (int x = 1; x <= xDist; x++)
            {
                if (isOccupied(board.getSpot(start.getX() + (x * xDir), start.getY() + (y * yDir))))
                    return false;
            }
        }

        return true;
    }

    public String printAction() {
        String color = this.getPlayer().getColor() ? WHITE_BRIGHT : BLACK;

        return color + character + RESET;
    }
}
