import java.util.Scanner;

public class Game implements Global{
    private Board gameBoard;
    private Player p1 = null;
    private Player p2 = null;

    public Game() {
        initPlayers();
        gameBoard = new Board(p1, p2); //initializes the new game board
    }

    private void initPlayers() {
        String p1Name;
        String p2Name;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Player 1's name (white): ");
        p1Name = input.nextLine();

        System.out.println("Enter Player 2's name (black): ");
        p2Name = input.nextLine();

        this.p1 = new Player(p1Name, white);
        this.p2 = new Player(p2Name, black);
    }

   public void start() {
        drawBoard();
        // Rest of the game logic goes here
    }

    private void drawBoard()
    {
        for (int i = 0; i < 8; i++) // y coordinate
        {
            System.out.print((8 - i) + ": ");
            for (int j = 0; j < 8; j++) // x coordinate
            {
                try{
                    gameBoard.getSpot(j, i).getPiece().printAction();
                }
                catch (NullPointerException e) {
                    System.out.print("[ ]");
                }

                if (j == 7)
                {
                    System.out.println();
                }

            }
        }
        System.out.print("    A  B  C  D  E  F  G  H");
    }



}
