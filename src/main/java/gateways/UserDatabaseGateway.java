package gateways;

import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabaseGateway extends DatabaseGateway implements UserDataAccessInterface {

    private List<User> userList;

    /**
     * Instantiating DatabaseGateway with a relative path will store the absolute path to the respective database.
     * If the file at the path does not exist, one will be created
     * This absolute path can be fetched using the getAbsoluteFilepath method
     *
     * @param relativePath The relative path to the database
     * @throws IOException Throws exception if encountering failed or interrupted IO exceptions
     */
    public UserDatabaseGateway(String relativePath) throws IOException {
        super(relativePath);
        userList = loadFromFile();
    }

    @Override
    public User get(String username) {
        // Returns a user with the given username, if it exists.
        for (User user: userList) {
            if(user.getUsername().equals(username)){
                return user; // the user was found
            }
        }
            return null; // the user was not found
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public void insert(User user) {
        userList.add(user);
        persistData();
    }

    @Override
    public boolean update(User user) {
        /*
        Updates the given user in the linked list.
        I don't even think we need this method, since
        the linked list just contains pointers to users.
        Will leave it in for now in case others are using
        it -- I don't want to break the interface.
        Vishnu 28/11/22
         */
        User userToUpdate = this.get(user.getUsername());
        if (userToUpdate != null) {
            // replace the user with that username with the new user object
            this.delete(userToUpdate);
            this.insert(user);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(User user) {
        return this.userList.remove(user);
    }

    public List<User> loadFromFile(){
        try{
            List<User> usersRead = new ArrayList<>();

            FileInputStream inputStream = new FileInputStream(this.absoluteFilepath);

            if(inputStream.available() == 0){
                return usersRead;
            }

            ObjectInputStream objectIn = new ObjectInputStream(inputStream);

            boolean cont = true;
            while(cont){
                try{
                    User user = (User) objectIn.readObject();
                    if(user != null){
                        usersRead.add(user);
                    }else{
                        cont = false;
                    }
                } catch(EOFException e){
                    cont = false;
                }
            }

            objectIn.close();
            inputStream.close();
            return usersRead;

        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public boolean saveToFile(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(this.absoluteFilepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(User user: this.userList){
                objectOutputStream.writeObject(user);
            }

            objectOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void deleteAll(){
        this.userList = new ArrayList<>();
    }

    @Override
    public boolean persistData() {
        return saveToFile();
    }
}
