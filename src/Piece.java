public abstract class Piece {

    private Player player;
    private boolean white;
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

    public abstract boolean canMove(int newX, int newY);

    public boolean getColor(){return this.white;}
    private void setColor(boolean color){this.white = color;}

    public boolean isKilled(){return this.killed;}
    public void setKilled(boolean killed){this.killed = killed;}

}
