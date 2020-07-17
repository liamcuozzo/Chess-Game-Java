public class Board implements Global{
    private Spot[][] spots;

    public Board(Player player1, Player player2) {
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
    private void initBoard(Player whitePlayer, Player blackPlayer){
        // Initialize the 2D array
        spots = new Spot[8][8];

        // Going to build the board from the bottom up, with the white pieces at the bottom
        // White pieces
        //    x  y
        spots[0][0] = new Spot(0, 0, new Rook(white, whitePlayer));
        spots[1][0] = new Spot(1, 0, new Knight(white, whitePlayer));
        spots[2][0] = new Spot(2, 0, new Bishop(white, whitePlayer));
        spots[3][0] = new Spot(3, 0, new Queen(white, whitePlayer));
        spots[4][0] = new Spot(4, 0, new King(white, whitePlayer));
        spots[5][0] = new Spot(5, 0, new Bishop(white, whitePlayer));
        spots[6][0] = new Spot(6, 0, new Knight(white, whitePlayer));
        spots[7][0] = new Spot(7, 0, new Rook(white, whitePlayer));

        // White pawns
        for (int i = 0; i < 8; i++) // x going across y = 1
        {
            spots[i][1] = new Spot(i, 1, new Pawn(white, whitePlayer));
        }

        // Empty board spaces
        for (int i = 2; i < 6; i++) // y values: 2 -> 5
        {
            for (int j = 0; j < 8; j++) // x values going across
            {
                spots[j][i] = new Spot(j, i, null);
            }
        }

        // Black pawns
        for (int i = 0; i < 8; i++) // x going across y = 6
        {
            spots[i][6] = new Spot(i, 6, new Pawn(black, blackPlayer));
        }

        // Black pieces
        //    x  y
        spots[0][7] = new Spot(0, 7, new Rook(black, blackPlayer));
        spots[1][7] = new Spot(1, 7, new Knight(black, blackPlayer));
        spots[2][7] = new Spot(2, 7, new Bishop(black, blackPlayer));
        spots[3][7] = new Spot(3, 7, new Queen(black, blackPlayer));
        spots[4][7] = new Spot(4, 7, new King(black, blackPlayer));
        spots[5][7] = new Spot(5, 7, new Bishop(black, blackPlayer));
        spots[6][7] = new Spot(6, 7, new Knight(black, blackPlayer));
        spots[7][7] = new Spot(7, 7, new Rook(black, blackPlayer));
    }
}
