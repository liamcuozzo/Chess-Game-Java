public class Queen extends Piece {

    Queen(Player player){
        super(player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }

    public void printAction() {
        System.out.print("[Q]");
    }
}
