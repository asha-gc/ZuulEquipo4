package src;

import utils.Command;
import utils.Parser;

/**
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game. It also evaluates and
 * executes the commands that the parser returns.
 * 
 */

public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }
    
    public void acccederaljuego(){
        play();
    }
    
    // private ArrayList<String> leerArchivo() throws FileNotFoundException, IOException{
    //     ArrayList<String> lecturaArchivo = new ArrayList<String>();
    //     File doc = new File("juego_config.txt");

    //     BufferedReader obj = new BufferedReader(new FileReader(doc));

    //     String strng;
    //     while ((strng = obj.readLine()) != null)
    //         lecturaArchivo.add(strng);
    //     if(lecturaArchivo.size()>10){
    //         System.out.println("Favor de revisar la estructura del archivo");
    //         System.exit(0);
    //     }
    //     return lecturaArchivo;
    // }

    private void createRooms() {
        // Move Rooms to constructor
        // Read configuration from .txt file
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside;
    }
    
    // private Room inicializacionRoom(Room room, int i){
    //     String[] salidaCuartos = archivoTxt.get(i).split(",");
    //     ArrayList<Room> salidaRooms = new ArrayList<Room>();
    //     for(int j=0; j<salidaCuartos.length; j++){
    //         switch(salidaCuartos[j]){
    //             case "null":
    //                 salidaRooms.add(null);
    //                 break;
    //             case "theatre":
    //                 salidaRooms.add(theatre);
    //                 break;
    //             case "lab":
    //                 salidaRooms.add(lab);
    //                 break;
    //             case "pub":
    //                 salidaRooms.add(pub);
    //                 break;
    //             case "outside":
    //                 salidaRooms.add(outside);
    //                 break;
    //             case "office":
    //                 salidaRooms.add(office);
    //                 break;
    //             default:
    //                 System.out.println("Error en la sintaxis del archivo");
    //                 System.exit(0);
    //         }
    //     }
    //     room.setExits(salidaRooms.get(0), salidaRooms.get(1), salidaRooms.get(2), salidaRooms.get(3));
    //     return room;
    // }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if (currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if (currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if (currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if (currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = null;
        if (direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if (direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if (direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if (direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print("Exits: ");
            if (currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if (currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if (currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if (currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Game prueba = new Game();
        prueba.play();
    }
}