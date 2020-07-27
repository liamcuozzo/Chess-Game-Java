public class Player {
    private String name;
    private boolean color;

    public Player(String name, boolean color){
        setName(name);
        setColor(color);
    }

    private void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    private void setColor(boolean color) {this.color = color;}
    public boolean getColor() {return this.color;}
}
