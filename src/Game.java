public class Game {
    private Board gameBoard;
    private Player p1;
    private Player p2;

    public Game(){
        p1 = new Player();
        p2 = new Player();
        gameBoard = new Board(p1, p2); //initializes the new game board
    }


}
