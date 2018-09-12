package library.dao;

import java.util.List;

public interface CrudDao<ID, T> extends Dao<T> {
    Long create(T o);

    T read(ID id);

    List<T> readAll();

    void update(T o);

    void delete(ID id);
}
