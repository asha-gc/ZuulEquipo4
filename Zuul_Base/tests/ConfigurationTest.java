package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.Room;
import utils.FileParser;

public class ConfigurationTest {

    @Test
    public void testConfiguration() {
        Room testRoom = new Room();
        testRoom.setDescription("Test Room");

        FileParser fileParser = new FileParser("TestRoom.txt");
        
        Room generatedRoom = fileParser.generateRooms();

        assertEquals(true, testRoom.getDescription().equals(generatedRoom.getDescription()));
    }
}
