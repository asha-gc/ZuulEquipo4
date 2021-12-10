package src;

import utils.Command;
import utils.FileParser;
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
        FileParser fileParser = new FileParser();
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

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Replace multiple ifs with a method
        if (this.currentRoom.isValidExit(direction)) {
            this.currentRoom = this.currentRoom.getExit(direction);
        } else {
            System.out.println("There is no door!");
        }
        // Replace repeated code with method
        displayDirections();
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
