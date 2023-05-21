package nye.progkor.beadando_film_katalogus.Data.repository;


import nye.progkor.beadando_film_katalogus.Data.model.Filmek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TODO
 */
@org.springframework.stereotype.Repository
public class inMemoryFilmekRepository implements Repository<Filmek,Long> {

    private static final Map<Long, Filmek> STORAGE = new HashMap<Long,Filmek>();

    @Override
    public Filmek save(Filmek filmek) {
        Long id = STORAGE.size()+1L;
        filmek.setId(id);
        STORAGE.put(id,filmek);
        return STORAGE.get(id);
    }

    @Override
    public Filmek getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Filmek> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Filmek update(Filmek filmek) {
        Long id=filmek.getId();
        STORAGE.put(id,filmek);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }

}
