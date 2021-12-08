import java.util.ArrayList;

import src.Game;
import utils.FileHandler;

public class Zuul {
    
    public static void main(String[] args) {
//      Game game = new Game();
//      game.acccederaljuego();

       FileHandler fileHandler = new FileHandler("Storage");
       fileHandler.writeFile("Test.txt", fileHandler.readFile("config.txt"));
    }
    
}
