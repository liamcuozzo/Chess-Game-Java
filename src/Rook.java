public class Rook extends Piece {

    public Rook(boolean color, Player player){
        super(color, player, "Rook");
    }

    public boolean canMove(Board board, Spot start, Spot end)
    {
        //Rook is my first unlimited move piece I will develop
        //I must check that the rook moves in a straight line, and that it can reach it's final spot
        //This means I must check for any pieces in between that may be blocking
        //I suppose I could do this in a loop and check for all pieces in between using Board

        int distY = start.getY() - end.getY(); //check if Y position changes to detect forward or back movement
        int distX = start.getX() - end.getX(); //check if X position changes to detect sideways movement
        int absY = Math.abs(distY); //absolute distance moved Y
        int absX = Math.abs(distX); //absolute distance moved X

        if (end.getPiece().getColor() == this.getColor()) //Moving to same teammate spot
        {
            return false;
        }
        else if ((absX > 0 && absY != 0) || (absY > 0 && absX != 0)) //Not one direction
        {
            return false;
        }
        
        //This block of code determines which axis the rook is moving along, and whether that is a positive or negative direction
        boolean XorY; //True for along x-axis, False for along y-axis
        boolean direction; //True for positive, False for negative
        int beginVal;
        int endVal;
        if (absX > 0) {
            XorY = true;
            direction = start.getX() - end.getX() < 0;
            beginVal = start.getX();
            endVal = end.getX();
        }
        else {
            XorY = false;
            direction = start.getY() - end.getY() < 0;
            beginVal = start.getY();
            endVal = end.getY();
        }
        

        return false;
    }

}
