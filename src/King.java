public class King extends Piece {

    King(boolean color, Player player){
        super(color, player, "King");
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        //Need to check if the piece moves exactly one space in any direction

        int distY = start.getY() - end.getY(); //check if Y position changes to detect forward or back movement
        int distX = start.getX() - end.getX(); //check if X position changes to detect sideways movement
        int absY = Math.abs(distY); //absolute distance moved Y
        int absX = Math.abs(distX); //absolute distance moved X

        if (end.getPiece().getColor() == this.getColor()) //checks if end spot is occupied by teammate or tries to go backwards
        {
            return false;
        }
        else if ((absX == 1 && absY == 0) || (absY == 1 && absX == 0) || (absX == 1 && absY == 1))
        {
            return true;
        }

        System.out.println("Error:Got to last return in Knight");
        return false;
    }
}
