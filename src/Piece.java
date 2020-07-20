public abstract class Piece {
    private Player player = null;
    private boolean alive = true;

    public Piece(Player assignedPlayer){
        this.setPlayer(assignedPlayer);
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
    public abstract void printAction();

    private void setPlayer(Player assignedPlayer){
        this.player = assignedPlayer;
    }
    public Player getPlayer(){
        return this.player;
    }

    public boolean isAlive() {return this.alive;}
    public void setAlive(boolean status) {this.alive = status;}

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
        return !isOccupied(check) && check.getPiece().getPlayer().getColor() == this.getPlayer().getColor();
    }
}
