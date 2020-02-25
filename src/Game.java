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

    public void start(){

    }



}
