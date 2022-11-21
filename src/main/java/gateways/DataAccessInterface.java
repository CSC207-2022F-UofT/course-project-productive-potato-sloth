package gateways;

import java.util.List;

public interface DataAccessInterface<T> {

    List<T> getAll();

    void insert(T t);

    boolean update(T t);

    boolean delete(T t);
}
