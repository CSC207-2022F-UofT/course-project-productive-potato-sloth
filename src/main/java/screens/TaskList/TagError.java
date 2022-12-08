package screens.TaskList;

/**
 * An Exception which represents a Tag-related error
 */
public class TagError extends RuntimeException {

    /**
     * Instantiates a TagError with a detailed message
     *
     * @param error The error message
     */
    public TagError(String error) {
        super(error);
    }
}
