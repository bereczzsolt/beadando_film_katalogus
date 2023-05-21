package nye.progkor.beadando_film_katalogus.Data.repository;
import java.util.List;

import java.util.List;

public interface Repository<T, ID> {
    T save(T item);

    T getById(ID id);

    List<T> getAll();

    T update(T item);

    void deleteById(ID id);
}

