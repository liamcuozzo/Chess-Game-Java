public class Board {
    private Spot[][] spots;

    public Board(Player whitePlayer, Player blackPlayer) {
        initBoard(whitePlayer, blackPlayer);
    }

    public Spot getSpot(int x, int y){
        return spots[x][y];
    }

    private void initBoard(Player whitePlayer, Player blackPlayer){
        // Initialize the 2D array
        spots = new Spot[8][8];

        // Going to build the board from the bottom up, with the white pieces at the bottom
        // White pieces
        //    x  y
        spots[0][0] = new Spot(0, 0, new Rook(whitePlayer));
        spots[1][0] = new Spot(1, 0, new Knight(whitePlayer));
        spots[2][0] = new Spot(2, 0, new Bishop(whitePlayer));
        spots[3][0] = new Spot(3, 0, new Queen(whitePlayer));
        spots[4][0] = new Spot(4, 0, new King(whitePlayer));
        spots[5][0] = new Spot(5, 0, new Bishop(whitePlayer));
        spots[6][0] = new Spot(6, 0, new Knight(whitePlayer));
        spots[7][0] = new Spot(7, 0, new Rook(whitePlayer));

        // White pawns
        for (int i = 0; i < 8; i++) // x going across y = 1
        {
            spots[i][1] = new Spot(i, 1, new Pawn(whitePlayer));
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
            spots[i][6] = new Spot(i, 6, new Pawn(blackPlayer));
        }

        // Black pieces
        //    x  y
        spots[0][7] = new Spot(0, 7, new Rook(blackPlayer));
        spots[1][7] = new Spot(1, 7, new Knight(blackPlayer));
        spots[2][7] = new Spot(2, 7, new Bishop(blackPlayer));
        spots[3][7] = new Spot(3, 7, new Queen(blackPlayer));
        spots[4][7] = new Spot(4, 7, new King(blackPlayer));
        spots[5][7] = new Spot(5, 7, new Bishop(blackPlayer));
        spots[6][7] = new Spot(6, 7, new Knight(blackPlayer));
        spots[7][7] = new Spot(7, 7, new Rook(blackPlayer));
    }
}
