package nye.progkor.beadando_film_katalogus.Service;

import nye.progkor.beadando_film_katalogus.Data.model.Filmek;

import java.util.List;

/**
 * TODO.
 */

public interface FilmekService {

    Filmek createFilmek(Filmek filmek);

    Filmek retrieveFilmekById(Long id);

    List<Filmek>retrieveAllFilmek();

    Filmek updateFilmek(Filmek filmek);

    void deleteFilmekById(Long id);
}
