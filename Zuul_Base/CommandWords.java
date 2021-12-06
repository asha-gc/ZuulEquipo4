/**
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 */

public class CommandWords {
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    public CommandWords() {

    }

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString))
                return true;
        }
        return false;
    }
}
