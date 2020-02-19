public class Pawn extends Piece {

    private int castleMoves;

    public Pawn(boolean color, Player player){
        super(color, player);
        this.castleMoves = 0;
    }

    public void incMoves(){
        this.castleMoves++;
    }

}