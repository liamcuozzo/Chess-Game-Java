public class Knight extends Piece {

    Knight(boolean color, Player player){
        super(color, player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
