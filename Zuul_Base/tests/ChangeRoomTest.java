package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.Game;
import utils.Command;

public class ChangeRoomTest {
    Game game = new Game();
    @Test
    public void testgoRoom(){
        Command noChange = new Command("go", "north");
        Command canChange = new Command("go", "west");
        assertEquals(false, game.goRoom(noChange));
        assertEquals(true, game.goRoom(canChange));
    }
}
