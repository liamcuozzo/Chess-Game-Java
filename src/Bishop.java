public class Bishop extends Piece {

    public Bishop(boolean color, Player player){ super(color, player);}

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }

    public void printAction() {
        System.out.print("[B]");
    }
}
