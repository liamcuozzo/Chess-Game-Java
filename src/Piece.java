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
}
