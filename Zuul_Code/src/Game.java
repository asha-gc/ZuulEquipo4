/*.Publicado por ArcodeTeam: Jonathan, Roberto y Ashanty el 10 de Diciembre de 2021*/

package src;

import utils.Command;
import utils.FileParser;
import utils.Parser;


public class Game {
    private Parser parser;
    private Room currentRoom;
    
    public Game() {
        FileParser fileParser = new FileParser("config.txt");
        this.currentRoom = fileParser.generateRooms();
        this.parser = new Parser();
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    public boolean processCommand(Command command) {
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

    public boolean goRoom(Command command) {
        boolean canChange = false;
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return canChange;
        }

        String direction = command.getSecondWord();

        if (this.currentRoom.isValidExit(direction)) {
            this.currentRoom = this.currentRoom.getExit(direction);
            canChange = true;
        } else {
            System.out.println("There is no door!");
        }
        displayDirections();
        return canChange;
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        
        displayDirections();
    }

    private void displayDirections(){
        System.out.println();
        System.out.println("You are " + this.currentRoom.getDescription());
        System.out.print("Exits: ");

        if (this.currentRoom.isValidExit("north")) {
            System.out.print("north ");
        }
        if (this.currentRoom.isValidExit("east")) {
            System.out.print("east ");
        }
        if (this.currentRoom.isValidExit("south")) {
            System.out.print("south ");
        }
        if (this.currentRoom.isValidExit("west")) {
            System.out.print("west ");
        }
        System.out.println();
    }
    
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }
    
}
