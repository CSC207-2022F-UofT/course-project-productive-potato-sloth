package gateways.Tags;

import entities.Tag;
import gateways.DatabaseGateway;

import java.io.*;
import java.util.ArrayList;

public class TagDatabaseGateway extends DatabaseGateway implements TagDataAccessInterface {

    private ArrayList<Tag> tagList;

    /**
     * Instantiating DatabaseGateway with a relative path will store the absolute path to the respective database.
     * If the file at the path does not exist, one will be created
     * This absolute path can be fetched using the getAbsoluteFilepath method
     *
     * @param relativePath The relative path to the database
     * @throws IOException Throws exception if encountering failed or interrupted IO exceptions
     */
    public TagDatabaseGateway(String relativePath) throws IOException, ClassNotFoundException {
        super(relativePath);
        load();
    }

    @Override
    public Tag get(int id) {
        return null;
    }

    @Override
    public ArrayList<Tag> getAll() {
        return null;
    }

    @Override
    public int insert(Tag tag) {
        this.tagList.add(tag);
        return 0;
    }

    @Override
    public int update(Tag tag) {
        return 0;
    }

    @Override
    public int delete(Tag tag) {
        return 0;
    }

    public void save() throws IOException {
        FileOutputStream fileout = new FileOutputStream(this.absoluteFilepath);
        ObjectOutputStream out = new ObjectOutputStream(fileout);

        out.writeObject(this.tagList);

        out.close();
        fileout.close();
    }

    public void load() throws IOException, ClassNotFoundException {

//        FileInputStream fileIn = new FileInputStream(this.absoluteFilepath);
//        ObjectInputStream in = new ObjectInputStream(fileIn);
//        this.tagList = (ArrayList<Tag>) in.readObject();
//        if (this.tagList == null) {
//            this.tagList = new ArrayList<Tag>();
//        }
//
//        in.close();
//        fileIn.close();


    }

}
