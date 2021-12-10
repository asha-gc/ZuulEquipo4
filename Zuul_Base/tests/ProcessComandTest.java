package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import src.Game;
import utils.Command;

public class ProcessComandTest {
    @ParameterizedTest
    @ValueSource(strings = {"north", "south", "west", "east"})
    @DisplayName("go <ubication>")
    public void testProcessComand(String ubication){
        Game game = new Game();
        Command command = new Command("go", ubication);
        assertEquals(false, game.processCommand(command));
    }
}
