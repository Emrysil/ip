package sebastianExceptions;

/**
 * Exception when a user input cannot be comprehended by Sebastian
 */
public class IllegalInputException extends Exception{
    public IllegalInputException() {
        super("Apologies, I'm afraid I don't understand your instruction");
    }
}
