package tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import utils.FileHandler;


public class ConfigurationTest {
    ArrayList<String> expectedList = new ArrayList<>();
    @Before
    public void crateList(){
        expectedList.add("RoomTest");
        expectedList.add(" description: Test Room");
        expectedList.add(" paths:");
    }
    @Test
    public void testConfiguration() {
        FileHandler fileHandler = new FileHandler("");
        ArrayList<String> configurationList = fileHandler.readFile("TestRoom.txt");
        assertArrayEquals(expectedList.toArray(), configurationList.toArray());
    }
}
