public class Knight extends Piece {

    Knight(Player player){
        super(player);
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }

    public void printAction() {
        System.out.print("[K]");
    }
}
