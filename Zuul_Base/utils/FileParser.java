package utils;

import java.util.ArrayList;
import java.util.HashMap;

import src.Room;
public class FileParser {
    private FileHandler fileHandler;

    public FileParser(){
        this.fileHandler = new FileHandler("");
    }

    public Room generateRooms(){
        ArrayList<String> gameData = fileHandler.readFile("config.txt");
        HashMap<String, Room> rooms = new HashMap<>();
        String currentRoom = "", fieldKey, fieldValue;
        String[] field;
        try {
            for (String line : gameData) {
                if (line.charAt(0) != ' ') {
                    currentRoom = line.trim();
                    rooms.put(currentRoom.trim(), new Room());
                }
            }
            for (String line : gameData) {
                if (line.charAt(0) != ' '){
                    currentRoom = line.trim();    
                }
                if (line.charAt(0) == ' ') {
                    field = line.split(":");
                    fieldKey = field[0].trim();
                    fieldValue = field[1].trim();
                    switch (fieldKey) {
                        case "description":
                            rooms.get(currentRoom).setDescription(fieldValue);
                            break;
                        case "paths":
                            HashMap<String, Room> paths = new HashMap<>();
                            if(!fieldValue.equals("")){
                                String[] roomsAvalible = fieldValue.trim().split(",");
                                for (String room : roomsAvalible) {
                                    String[] roomName = room.trim().split("-");
                                    paths.put(roomName[1].trim(), rooms.get(roomName[0].trim()));
                                }
                            }
                            rooms.get(currentRoom).setExits(paths);
                            break;
                        default:
                            break;
                    }
                }   
            } 
        } catch (Exception e) {
            System.out.println("Fallo al interpretar el archivo, revise que se encuentre en el formato correcto.");
        }
        return rooms.get(currentRoom);
    }

}
