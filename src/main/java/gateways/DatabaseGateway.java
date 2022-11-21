package gateways;

import java.io.File;
import java.io.IOException;

abstract public class DatabaseGateway {

    protected final String absoluteFilepath;

    /**
     * Instantiating DatabaseGateway with a relative path will store the absolute path to the respective database.
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

    protected void createFile(String relativePath) throws IOException {
        File f = new File(relativePath);
        f.createNewFile();
    }

    protected boolean fileExists(String relativePath) {
        File f = new File(relativePath);
        return f.isFile();
    }

    protected String fetchAbsolutePath(String relativePath) {
        File f = new File(relativePath);
        return f.getAbsolutePath();
    }

    public String getAbsoluteFilepath() {
        return absoluteFilepath;
    }

}
