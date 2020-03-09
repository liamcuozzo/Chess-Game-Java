import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private Board gameBoard;
    private Player p1;
    private Player p2;

    public Game() throws IOException {
        initPlayers();
        gameBoard = new Board(p1, p2); //initializes the new game board
    }

    private void initPlayers() throws IOException {
        String p1Name;
        String p2Name;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Player 1's name (white): ");
        p1Name = reader.readLine();

        System.out.println("Enter Player 2's name (black): ");
        p2Name = reader.readLine();

        this.p1 = new Player(p1Name);
        this.p2 = new Player(p2Name);
    }

    public void start()
    {
        drawBoard();
    }



    private void drawBoard()
    {
        for (int i = 0; i < 8; i++) //y coordinate
        {
            String c = Character.toString((char) (i + 65));
            System.out.print(c + ": ");
            for (int j = 7; j >= 0; j--) //x coordinate
            {
                String whatPiece;
                try
                {
                    whatPiece = gameBoard.getSpot(j, i).getPiece().getName();
                }
                catch(NullPointerException e)
                {
                    whatPiece = ""; //set to empty to invoke the default case
                }

                switch(whatPiece)
                {
                    case "Pawn":
                        System.out.print("[P]");
                        break;
                    case "King":
                        System.out.print("[C]"); //only using C because knight uses K and C is for crown
                        break;
                    case "Queen":
                        System.out.print("[Q]");
                        break;
                    case "Bishop":
                        System.out.print("[B]");
                        break;
                    case "Rook":
                        System.out.print("[R]");
                        break;
                    case "Knight":
                        System.out.print("[K]");
                        break;
                    default:
                        System.out.print("[ ]");
                }

                if (j == 0)
                {
                    System.out.println();
                }

            }
        }
        System.out.print("    1  2  3  4  5  6  7  8");
    }



}
