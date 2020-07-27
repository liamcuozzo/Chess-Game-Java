public abstract class Piece implements Global{
    private Player player = null;
    protected String character;

    public Piece(Player assignedPlayer, String character){
        this.setPlayer(assignedPlayer);
        this.setCharacter(character);
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
    public abstract String printAction();

    private void setPlayer(Player assignedPlayer){
        this.player = assignedPlayer;
    }
    public Player getPlayer(){
        return this.player;
    }

    public String getCharacter() { return character; }
    private void setCharacter(String character) {this.character = character;}

    // Used to check if
    protected boolean isOccupied (Spot check)
    {
        // true = there is a piece on that spot
        // false = no piece
        return check.getPiece() != null;
    }

    protected boolean teammateOccupied (Spot check)
    {
        // Checks that spot piece is not null and that both piece colors are the same
        return isOccupied(check) && check.getPiece().getPlayer().getColor() == this.getPlayer().getColor();
    }

    public int getMoves(){return 0;}
}
