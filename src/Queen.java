public class Queen extends Piece {

    Queen(boolean color, Player player){
        super(color, player, "Queen");
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }

}
