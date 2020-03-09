public class Knight extends Piece {

    Knight(boolean color, Player player){
        super(color, player, "Knight");
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
