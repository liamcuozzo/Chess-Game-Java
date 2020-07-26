import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.*;

public class Game implements Global{

    private static class  Coords {
        private int x;
        private int y;

        private Coords(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }

    private Board gameBoard;
    private HashMap<String, Coords> commands = new HashMap<>(64);
    private Player p1 = null;
    private Player p2 = null;

    public Game() {
        System.out.println("Welcome to my chess game!");
        System.out.println("Game Information:");
        System.out.println("1. The castling move and en passant move are not implemented. There is no warning for check or checkmate, just capture the king to win.");
        System.out.println("2. A move is made by first entering the chess coordinate of your piece and then the chess coordinate of where you want to move it to.");
        System.out.println("3. For example: a1 -> a3 would move the piece from the bottom left corner two spaces up.");
        System.out.println("4. If that move is not valid, the player will be asked to make a different move.");
        System.out.println("5. When inputting a move, the format should be 'Starting Spot' 'Ending Spot'.");
        System.out.println("Example: 'a1 a4' would try and move the piece at a1 to a4.");
        System.out.println("6. White goes first, then black, until someone wins.");
        System.out.println("\nNow we'll ask the players to begin.");

        initPlayers();
        initCommands();
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

    private void initCommands() {
        char add = 'a';
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                String put = String.valueOf(add);
                put = put + (y + 1);
                commands.put(put, new Coords(x, y));
            }
            add += 1;
        }
    }

    private void drawBoard()
    {
        for (int i = 7; i >= 0; i--) // y coordinate
        {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < 8; j++) // x coordinate
            {
                String backgroundColor = (j + i)%2 == 0 ? BLACK_BACKGROUND_BRIGHT: WHITE_BACKGROUND;
                try{
                    String str = gameBoard.getSpot(j, i).getPiece().printAction();
                    System.out.print(backgroundColor + str);
                }
                catch (NullPointerException e) {
                    System.out.print(backgroundColor + WHITE_BRIGHT + "[ ]" + RESET);
                }

                if (j == 7)
                {
                    System.out.println();
                }

            }
        }
        System.out.print("    A  B  C  D  E  F  G  H");
    }

    private boolean makeMove (String from, String to)
    {
        Coords a = commands.get(from);
        Coords b = commands.get(to);

        Spot start = gameBoard.getSpot(a.getX(), a.getY());
        Spot end = gameBoard.getSpot(b.getX(), b.getY());

        if (start.getPiece() != null && start.getPiece().canMove(gameBoard, start, end))
        {
            // Want to put the piece at start at the end
            end.setPiece(null); // I set it to null first to make sure the garbage collector gets i. Probably not needed
            end.setPiece(start.getPiece());
            start.setPiece(null);
            return true;
        }
        else
        {
            System.out.println("Invalid move.");
            return false;
        }
    }

    private String getMove()
    {
        Scanner input = new Scanner(System.in);
        String move;
        Pattern pattern = Pattern.compile("[abcdefgh][1-8] [abcdefgh][1-8]");

        boolean matchFound;
        System.out.print("\nMake a move: ");
        move = input.nextLine();
        Matcher matcher = pattern.matcher(move);
        matchFound = matcher.find();

        while (!matchFound)
        {
            System.out.println("ERROR: Invalid move format.");
            System.out.print("Make a move: ");
            move = input.nextLine();
            matcher = pattern.matcher(move);
            matchFound = matcher.find();
        }

        return move;
    }

    public void start() {
        boolean gameOver = false;

        drawBoard();
        //Game logic goes here
        System.out.println("\n" + p1.getName() + " goes first.");
        while (!gameOver)
        {
            String move = getMove();
            String[] moves = move.split(" ");
            makeMove(moves[0], moves[1]);
            drawBoard();
        }
    }
}
