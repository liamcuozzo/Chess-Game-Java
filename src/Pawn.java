import java.lang.*;

public class Pawn extends Piece {
    private int moves; //checks for pawn making it to other side of board

    public Pawn(Player player){
        super(player);
        this.moves = 0;
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        /*
        Not sure if I'll need the constant, but I need to figure out direction differences
        between white and black pieces. White pieces will move up in a positive y direction to go forward,
        and black pieces will move in a negative y direction to go forward, relative to the board layout.

        Unlike the other pieces, pawns cannot move backwards.
        Normally a pawn moves by advancing a single square, but the first time a pawn moves, it has the option of advancing two squares.
        Pawns may not use the initial two-square advance to jump over an occupied square, or to capture.
        Any piece immediately in front of a pawn, friend or foe, blocks its advance.

        Unlike other pieces, the pawn does not capture in the same direction that it moves.
        A pawn captures diagonally forward one square to the left or right.

        Not gonna add the En Passant.
        */

        int constant = 0;
        if (getPlayer().getColor()) // checks if piece is white
            constant = 1;
        else
            constant = -1;


        // Check if spot is occupied by teammate
        if (end.getPiece().getPlayer() == this.getPlayer())
            return false;



        return false;
    }

    private void incMoves(){
        this.moves++;
    }

    public void printAction() {
        System.out.print("[P]");
    }
}