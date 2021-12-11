/*.Publicado por ArcodeTeam: Jonathan, Roberto y Ashanty el 10 de Diciembre de 2021*/

package utils;

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
