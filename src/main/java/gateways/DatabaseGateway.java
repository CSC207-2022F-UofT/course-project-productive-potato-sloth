package gateways;

import java.io.File;
import java.io.IOException;

/**
 * An abstract class which defines base functionality all Database Gateways should inherit
 */
abstract public class DatabaseGateway {

    protected final String absoluteFilepath;

    /**
     * Instantiating any subclasses of DatabaseGateway with a relative path will store the absolute path to the respective database.
     * If the file at the path does not exist, one will be created
     * This absolute path can be fetched using the getAbsoluteFilepath method
     *
     * @param relativePath The relative path to the database
     * @throws IOException Throws exception if encountering failed or interrupted IO exceptions
     */
    public DatabaseGateway(String relativePath) throws IOException {
        if (!fileExists(relativePath)) {
            createFile(relativePath);
        }
        this.absoluteFilepath = fetchAbsolutePath(relativePath);
    }

    /**
     * Creates a new file with the name and path specified by the argument
     *
     * @param relativePath The name and path to create the new file
     * @throws IOException An input/output exception
     */
    protected void createFile(String relativePath) throws IOException {
        File f = new File(relativePath);
        try {
            f.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Check if a file exists at the relative path
     *
     * @param relativePath The location to check for the file
     * @return A boolean representing if a file exists at this path
     */
    protected boolean fileExists(String relativePath) {
        File f = new File(relativePath);
        return f.isFile();
    }

    /**
     * Saves the absolute path of a file given its relative path
     * This function is essential for the program to run on different machines,
     * where the absolute filepath varies
     *
     * @param relativePath The relative path of the file
     * @return The absolute path of the file, as a String
     */
    protected String fetchAbsolutePath(String relativePath) {
        File f = new File(relativePath);
        return f.getAbsolutePath();
    }

    /**
     * Gets the absolute filepath of the database for any outside class
     *
     * @return The absolute filepath, as a String
     */
    public String getAbsoluteFilepath() {
        return absoluteFilepath;
    }

}
