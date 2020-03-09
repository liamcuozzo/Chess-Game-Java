public class Bishop extends Piece {

    public Bishop(boolean color, Player player){ super(color, player, "Bishop");}

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}
