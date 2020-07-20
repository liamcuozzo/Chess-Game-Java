public class Player {
    private String name;
    private boolean winner;
    private boolean color;

    public Player(String name, boolean color){
        setName(name);
        setColor(color);
        setWin(false);
    }

    private void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public void setWin(boolean status){this.winner = status;}
    public boolean getWin(){return this.winner;}

    private void setColor(boolean color) {this.color = color;}
    public boolean getColor() {return this.color;}
}
