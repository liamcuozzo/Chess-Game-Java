public class Board {
    private Spot spots[][];

    public Board(Player player1, Player player2){
        initBoard(player1, player2);
    }

    public Spot getSpot(int x, int y){
        return spots[x][y];
    }
    public void setSpot(int x, int y, Piece piece) {
        spots[x][y].setX(x);
        spots[x][y].setY(y);
        spots[x][y].setPiece(piece);
    }

    private void initBoard(Player p1, Player p2){
        spots = new Spot[8][8];

        //White Pieces (true = white)
        //x, y
        spots[0][0] = new Spot(0,0, new Rook(true, p1));
        spots[1][0] = new Spot(1,0, new Knight(true, p1));
        spots[2][0] = new Spot(2,0, new Bishop(true, p1));
        spots[3][0] = new Spot(3,0, new King(true, p1));
        spots[4][0] = new Spot(4,0, new Queen(true, p1));
        spots[5][0] = new Spot(5,0, new Bishop(true, p1));
        spots[6][0] = new Spot(6,0, new Knight(true, p1));
        spots[7][0] = new Spot(7,0, new Rook(true, p1));

        //White Pawns
        for (int i = 0; i < 8; i++)
        {
            spots[i][1] = new Spot(i, 1, new Pawn(true, p1));
        }

        //Black Pieces (false = black)
        spots[0][7] = new Spot(0,7, new Rook(false, p2));
        spots[1][7] = new Spot(1,7, new Knight(false, p2));
        spots[2][7] = new Spot(2,7, new Bishop(false, p2));
        spots[3][7] = new Spot(3,7, new King(false, p2));
        spots[4][7] = new Spot(4,7, new Queen(false, p2));
        spots[5][7] = new Spot(5,7, new Bishop(false, p2));
        spots[6][7] = new Spot(6,7, new Knight(false, p2));
        spots[7][7] = new Spot(7,7, new Rook(false, p2));

        //Black Pawns
        for (int j = 0; j < 8; j++)
        {
            spots[j][6] = new Spot(j, 6, new Pawn(false, p2));
        }

        //Rest of the board
        for (int i = 0; i < 8; i++)
        {
            for (int j = 2; j < 6; j++)
            {
                spots[i][j] = new Spot(i, j, null);
            }
        }



    }
}
