package utils;
/**
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * 
 */

public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
