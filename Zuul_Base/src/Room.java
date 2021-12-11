/*.Publicado por ArcodeTeam: Jonathan, Roberto y Ashanty el 10 de Diciembre de 2021*/

package src;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> paths;

    public Room() {
        this.description = "";
        this.paths = new HashMap<String, Room>();
    }

    public Boolean isValidExit(String key){
        return this.paths.containsKey(key);
    }  

    public Room getExit(String path){
        return this.paths.get(path);
    }

    public void setExits(HashMap<String, Room> paths) {
        this.paths = paths;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "["+this.description+"]";
    }
}
