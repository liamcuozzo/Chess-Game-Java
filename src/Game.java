import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.regex.*;

public class Game implements Global{

    private static class  Coords {
        private final int x;
        private final int y;

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

    private final Board gameBoard;
    private final HashMap<String, Coords> commands = new HashMap<>(64);
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


    private boolean makeMove (String from, String to, boolean currentPlayer)
    {
        Coords a = commands.get(from);
        Coords b = commands.get(to);

        Spot start = gameBoard.getSpot(a.getX(), a.getY());
        Spot end = gameBoard.getSpot(b.getX(), b.getY());

        if (start.getPiece() == null)
        {
            System.out.println("Choose a non-empty space.");
            return false;
        }

        if (start.getPiece().getPlayer().getColor() != currentPlayer)
        {
            System.out.println("This is not your piece. Choose another.");
            return false;
        }

        if (start.getPiece().canMove(gameBoard, start, end))
        {
            // Want to put the piece at start at the end
            end.setPiece(null); // I set it to null first to make sure the garbage collector gets it. Probably not needed.
            end.setPiece(start.getPiece());
            start.setPiece(null);

            if (end.getPiece().getCharacter().equals("[P]") && end.getPiece().getMoves() == 6)
                promotePawn(gameBoard, end);

            return true;
        }
        else
        {
            System.out.println("Invalid move. Try again.");
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
            System.out.println("ERROR: Invalid move format. Try again.");
            System.out.print("Make a move: ");
            move = input.nextLine();
            matcher = pattern.matcher(move);
            matchFound = matcher.find();
        }

        return move;
    }

    private void promotePawn(Board board, Spot spot)
    {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        boolean tryForInput = true;
        while (tryForInput)
        {
            try
            {
                System.out.println("Choose a type of piece to upgrade to (type a number).");
                System.out.println("1. Queen");
                System.out.println("2. Knight");
                System.out.println("3. Bishop");
                System.out.println("4. Rook.");

                choice = input.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Input not recognized as a number choice. Please try again.");
            }

            if (choice < 0 || choice > 4)
            {
                System.out.println("Input not recognized as one of the choices. Please try again.");
            }
            else
                tryForInput = false;
        }

        Piece newPiece = null;
        Player player = board.getSpot(spot.getX(), spot.getY()).getPiece().getPlayer();
        switch (choice)
        {
            case 1:
                newPiece = new Queen(player);
                break;
            case 2:
                newPiece = new Knight(player);
                break;
            case 3:
                newPiece = new Bishop(player);
                break;
            case 4:
                newPiece = new Rook(player);
                break;
        }

        board.getSpot(spot.getX(), spot.getY()).setPiece(newPiece);
    }

    private int isKingDead (Board board)
    {
        boolean whiteKing = false;
        boolean blackKing = false;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Piece checkPiece = board.getSpot(i, j).getPiece();
                if (checkPiece != null)
                {
                    if (checkPiece.getCharacter().equals("[C]"))
                        if (checkPiece.getPlayer().getColor())
                            whiteKing = true;
                        else if (!checkPiece.getPlayer().getColor())
                            blackKing = true;
                }
            }
        }

        if (!whiteKing)
            return 1;
        else if (!blackKing)
            return -1;
        else
            return 0;
    }

    public void start() {
        boolean gameOver = false;
        boolean isValidMove = false;

        drawBoard();
        //Game logic goes here
        int tracker = 0; // Used to switch between P1 and P2 turns
        while (!gameOver)
        {
            Player currentPlayer = tracker % 2 == 0 ? p1 : p2; // if tracker is even, p1 (white) goes, else p2 (black) goes
            System.out.println("\n" + currentPlayer.getName() + "'s turn.");

            while (!isValidMove)
            {
                String move = getMove();
                String[] moves = move.split(" ");
                isValidMove = makeMove(moves[0], moves[1], currentPlayer.getColor());
            }
            int deadKingCheck = isKingDead(gameBoard);
            drawBoard();
            if (deadKingCheck != 0)
            {
                if (deadKingCheck == -1) // White wins
                {
                    System.out.println("Congratulations to " + p1.getName() + "! You have won!");
                }
                else // Black wins
                {
                    System.out.println("Congratulations to " + p2.getName() + "! You have won!");
                }
                System.out.println("Game Over.");
                gameOver = true;
            }
            tracker++;
            isValidMove = false;
        }
    }
}
