public class Knight extends Piece {

    Knight(Player player){
        super(player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        // Information from Wikipedia
        /*
        Compared to other chess pieces, the knight's movement is unique: it may move two squares vertically and one square horizontally,
        or two squares horizontally and one square vertically (with both forming the shape of an L).
        While moving, the knight can jump over pieces to reach its destination.
        Knights capture in the same way, replacing the enemy piece on the square and removing it from the board.
        Knights and pawns are the only pieces that can be moved in the initial position.
        */

        // If the space has teammate in it, always invalid
        if (teammateOccupied(end))
            return false;

        int yDist = Math.abs(end.getY() - start.getY());
        int xDist = Math.abs(end.getX() - start.getX());
        int check = yDist * xDist; // Must always be 2

        return check == 2;
    }

    public void printAction() {
        System.out.print("[K]");
    }
}
