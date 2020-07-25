import java.beans.XMLDecoder;
import java.lang.*;

public class Pawn extends Piece {
    private int moves; //checks for pawn making it to other side of board
    private boolean doubleStart = false;

    public Pawn(Player player){
        super(player);
        this.moves = 0;
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        // Information from Wikipedia
        /*
        Unlike the other pieces, pawns cannot move backwards.
        Normally a pawn moves by advancing a single square, but the first time a pawn moves, it has the option of advancing two squares.
        Pawns may not use the initial two-square advance to jump over an occupied square, or to capture.
        Any piece immediately in front of a pawn, friend or foe, blocks its advance.

        Unlike other pieces, the pawn does not capture in the same direction that it moves.
        A pawn captures diagonally forward one square to the left or right.

        Not going implement the En Passant move, perhaps later in the future.
        */

        // If the space has teammate in it, always invalid
        if (teammateOccupied(end))
            return false;

        // Use a constant to normalize y directions for black and white differences
        int constant;
        if (getPlayer().getColor())
            constant = 1;
        else
            constant = -1;

        // yDist > 0 : the piece is moving forward relative to its color
        // yDist < 0 : the piece is moving backwards relative to its color, not allowed for a Pawn
        // xDist : relative distance from start to end
        int yDist = constant * (end.getY() - start.getY());
        int xDist = Math.abs(end.getX() - start.getX());

        // Check list for basic movement rules
        /*
        1. yDist must be positive
        2. xDist and yDist both cannot be 0
        3. xDist cannot be larger than 1
        */
        if (yDist <= 0 || xDist > 1)
            return false;

        // Check to see if the spot moving to is occupied by another piece
        // true = occupied by enemy
        // false = not occupied
        boolean isOccupied = isOccupied(end);

        // Check List for true
        /*
        Only need to check for instances that return true, else, all other moves are false.
        1. Double space first move
        2. Single space move
        3. Attack enemy
        */

        // 1. Double space first move
        if (!doubleStart && yDist == 2 && xDist == 0)
        {
            // Need to check along y access for the next two spots
            for (int y = start.getY(); y < yDist; y += constant)
            {
                // If any space along this check is occupied, invalid move
                if (isOccupied(board.getSpot(start.getX(), y)))
                    return false;
            }
            doubleStart = true;
            incMoves();
            incMoves();
            return true;
        }

        // 2. Single space move
        if (!isOccupied && yDist == 1 && xDist == 0) {
            incMoves();
            return true;
        }

        // 3. Attack enemy
        if (isOccupied && yDist == 1 && xDist == 1) {
            incMoves();
            return true;
        }

        return false;
    }

    private void incMoves(){
        this.moves++;
    }

    public void printAction() {
        System.out.print("[P]");
    }
}