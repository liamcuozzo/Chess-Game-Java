public class Player {
    private String name;
    private boolean winner;


    public Player(String name){
        setName(name);
        setWin(false);
    };

    private void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public void setWin(boolean status){this.winner = status;}
    public boolean getWin(){return this.winner;}
}
