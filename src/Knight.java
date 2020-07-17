public class Knight extends Piece {

    Knight(boolean color, Player player){
        super(color, player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        //How does the knight move?
        //

        int distY = start.getY() - end.getY(); //check if Y position changes to detect forward or back movement
        int distX = start.getX() - end.getX(); //check if X position changes to detect sideways movement
        int absY = Math.abs(distY); //absolute distance moved Y
        int absX = Math.abs(distX); //absolute distance moved X

        if (end.getPiece().getColor() == this.getColor()) //checks if end spot is occupied by teammate or tries to go backwards
        {
            return false;
        }
        else if (absY * absX == 2)
        {
            return true;
        }

        System.out.println("Error: Got to last return in Knight");
        return false;
    }

    public void printAction() {
        System.out.print("[K]");
    }
}
