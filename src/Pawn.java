import java.lang.*;

public class Pawn extends Piece {
    private int moves; //checks for pawn making it to other side of board
    private boolean firstMove; //used to check if two space first move will be made

    public Pawn(boolean color, Player player){
        super(color, player, "Pawn");
        this.moves = 0;
        this.firstMove = true;
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        //Need to make sure only goes forward by 1 or 2, or diagonal to attack
        //Can't move backwards at all or directly sideways

        int distY = start.getY() - end.getY(); //check if Y position changes to detect forward or back movement
        int distX = start.getX() - end.getX(); //check if X position changes to detect sideways movement
        int absY = Math.abs(distY); //absolute distance moved Y
        int absX = Math.abs(distX); //absolute distance moved X

        //distY for white is positive if going backwards
        //distY for black is negative if going backwards
        boolean backwards = ((distY > 0 && start.getPiece().getColor()) | (distY < 0 && !start.getPiece().getColor()));

        if (end.getPiece().getColor() == this.getColor() || !backwards) //checks if end spot is occupied by teammate or tries to go backwards
        {
            return false;
        }
        else if (absY == 1 && absX == 0) //checks if it only moves forward
        {
            incMoves();
            return true;
        }
        else if (absY == 2 && absX == 0) //checks if the first move wants to move two spots forward
        {
            this.firstMove = false;
            incMoves();
            incMoves();
            return true;
        }
        else if (absY == 1 && absX == 1 && end.getPiece().getColor() != this.getColor()) //checks for attack
        {
            incMoves();
            return true;
        }


        return false;
    }

    private void incMoves(){
        this.moves++;
    }

}