package gateways;


import java.util.ArrayList;

public interface DataAccessInterface<T> {

    T get(int id);

    ArrayList<T> getAll();

    int insert(T t);

    int update(T t);

    int delete(T t);
}
