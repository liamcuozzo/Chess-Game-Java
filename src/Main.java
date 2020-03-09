import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        //Start Game
        try {
            Game Game = new Game();

            Game.start();


        } catch (IOException e) {
            System.out.println("Error in entering names.");
            e.printStackTrace();
        }
    }
}
