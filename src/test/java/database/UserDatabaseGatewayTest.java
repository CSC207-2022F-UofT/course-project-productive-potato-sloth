//package database;
//
//import entities.User;
//import gateways.UserDatabaseGateway;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//public class UserDatabaseGatewayTest {
//    @Test public void testLoadUsersFromEmptyFile() {
//        try {
//            UserDatabaseGateway userGateway = new UserDatabaseGateway("src/main/java/database/emptyUserFile.ser");
//        } catch (IOException e){
//            assert false;
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test public void testSaveUsers(){
//        /**
//         * This test creates users in a stupid way, and may break if the user class constructor changes.
//         */
//        try{
//            UserDatabaseGateway userGateway = new UserDatabaseGateway("src/main/java/database/testSaveUsersUserfile.ser");
//            userGateway.deleteAll();
//            User user1 = new User();
//            user1.changeUsername("user1");
//            User user2 = new User();
//            user2.changeUsername("user2");
//            User user3 = new User();
//            user3.changeUsername("user3");
//            userGateway.insert(user1);
//            userGateway.insert(user2);
//            userGateway.insert(user3);
//            userGateway.saveToFile();
//        } catch (Exception e){
////            assert false;
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test public void testLoadUsersFromNonemptyFile(){
//        /**
//         * This test depends on the one above.
//         */
//
//        try{
//            testSaveUsers();
//            UserDatabaseGateway userGateway = new UserDatabaseGateway("src/main/java/database/testSaveUsersUserfile.ser");
//            assert userGateway.getAll().size() == 3;
//            int i = 1;
//            for(User user: userGateway.getAll()){
//                assert user.getUsername().equals("user" + i);
//                i += 1;
//            }
//        } catch (Exception e){
//            assert false;
//            throw new RuntimeException(e);
//        }
//    }
//}
