package gateways;

import java.util.List;

/**
 * An interface which hides the details of database operations
 *
 * @param <T> The class to be operated on
 */
public interface DataAccessInterface<T> {

    /**
     * Returns the instance of T given an identifier
     *
     * @param identifier A unique identifier of T
     * @return The instance of T
     */
    T get(String identifier);

    /**
     * Returns all instances of T
     * Constraints can be set by implementing methods
     * (Only returning T of a certain User, rather than T of all Users)
     *
     * @return A list of instances of T
     */
    List<T> getAll();

    /**
     * Adds T into the database
     *
     * @param t The object to be added
     */
    void insert(T t);

    /**
     * Updates an instance of T already in the database
     *
     * @param t The object to be updated
     * @return A boolean representing if the update was successful
     */
    boolean update(T t);

    /**
     * Deletes an instance of T already in the database
     *
     * @param t The object to be deleted
     * @return A boolean representing if the delete was successful
     */
    boolean delete(T t);
}
