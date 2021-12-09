package src;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A "Room" represents one location in the scenery of the game. It is
 * connected to other rooms via exits. The exits are labelled north,
 * east, south, west. For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 */
public class Room {
    private String description;
    private HashMap<String, Room> paths;

    public Room(String description) {
        this.description = description;
    }

    public Room getExit(String path){
        return this.paths.get(path);
    }

    public void setExits(HashMap<String, Room> paths) {
        this.paths = paths;
    }

    public String getDescription() {
        return description;
    }

}
