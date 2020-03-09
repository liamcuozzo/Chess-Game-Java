public abstract class Piece {

    private Player player;
    private boolean color;
    private boolean killed = false;
    private String name;

    public Piece(boolean color, Player assignedPlayer, String name){
        this.setColor(color);
        this.setPlayer(assignedPlayer);
        this.name = name;
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

    public String getName(){return this.name;}
}
