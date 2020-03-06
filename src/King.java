public class King extends Piece {

    King(boolean color, Player player){
        super(color, player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
