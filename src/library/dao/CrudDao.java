package library.dao;

import java.util.List;

public interface CrudDao<ID, T> extends Dao<T> {
    void create(T o);

    T read(ID id);

    List<T> reedAll();
    
    void update(T o);

    void delete(ID id);
}
