public abstract class Piece {

    private Player player;
    private boolean color;
    private boolean killed = false;

    public Piece(boolean color, Player assignedPlayer){
        this.setColor(color);
        this.setPlayer(assignedPlayer);
    }

    private void setPlayer(Player assignedPlayer){
        this.player = assignedPlayer;
    }
    public Player getPlayer(){
        return this.player;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);

    public boolean getColor(){return this.color;}
    private void setColor(boolean color){this.color = color;}

    public boolean isKilled(){return this.killed;}
    public void setKilled(boolean killed){this.killed = killed;}

}
