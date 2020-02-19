public class Board {
    private Spot spots[][];

    public Board(Player player1, Player player2){
        initBoard(player1, player2));
    }

    Spot getSpot(int x, int y){
        return spots[x][y];
    }

    private void initBoard(Player p1, Player p2){
        spots = new Spot[8][8];

        //White Pieces (true = white)
        //x, y
        spots[0][0] = new Spot(0,0, new Rook(true, p1));
        spots[1][0] = new Spot(0,0, new Knight(true));
        spots[2][0] = new Spot(0,0, new Bishop(true));
        spots[3][0] = new Spot(0,0, new King(true));
        spots[4][0] = new Spot(0,0, new Queen(true));
        spots[5][0] = new Spot(0,0, new Bishop(true));
        spots[6][0] = new Spot(0,0, new Knight(true));
        spots[7][0] = new Spot(0,0, new Rook(true, p1));

        spots[1][0] = new Spot(0,0, new Pawn(true));
        spots[1][1] = new Spot(0,0, new Pawn(true));
        spots[1][2] = new Spot(0,0, new Pawn(true));
        spots[1][3] = new Spot(0,0, new Pawn(true));
        spots[1][4] = new Spot(0,0, new Pawn(true));
        spots[1][5] = new Spot(0,0, new Pawn(true));
        spots[1][6] = new Spot(0,0, new Pawn(true));
        spots[1][7] = new Spot(0,0, new Pawn(true));

        //Black Pieces (false = black)
        spots[0][7] = new Spot(0,0, new Rook(false));
        spots[1][7] = new Spot(0,0, new Knight(false));
        spots[2][7] = new Spot(0,0, new Bishop(false));
        spots[3][7] = new Spot(0,0, new King(false));
        spots[4][7] = new Spot(0,0, new Queen(false));
        spots[5][7] = new Spot(0,0, new Bishop(false));
        spots[6][7] = new Spot(0,0, new Knight(false));
        spots[7][7] = new Spot(0,0, new Rook(false));

        spots[0][6] = new Spot(0,0, new Pawn(false));
        spots[1][6] = new Spot(0,0, new Pawn(false));
        spots[2][6] = new Spot(0,0, new Pawn(false));
        spots[3][6] = new Spot(0,0, new Pawn(false));
        spots[4][6] = new Spot(0,0, new Pawn(false));
        spots[5][6] = new Spot(0,0, new Pawn(false));
        spots[6][6] = new Spot(0,0, new Pawn(false));
        spots[7][6] = new Spot(0,0, new Pawn(false));




    }
}
