package nye.progkor.beadando_film_katalogus.Service.impl;

import nye.progkor.beadando_film_katalogus.Data.model.Filmek;
import nye.progkor.beadando_film_katalogus.Data.model.Genre;
import nye.progkor.beadando_film_katalogus.Data.repository.Repository;
import nye.progkor.beadando_film_katalogus.Service.FilmekService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Unit tests for {@link DefaultFilmekService}.
 */

class DefaultFilmekServiceTest {

    private static final Long Dune_film_ID = 1L;
    private static final Filmek Dune_film = new Filmek(Dune_film_ID, "Dune", Genre.Scifi, "Devis",2019);
    @Mock
    private Repository<Filmek, Long> FilmekRepository;

    private FilmekService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultFilmekService(FilmekRepository);
    }

    @Test
    void createFilmekShouldDelegateToTheRepositoryAndReturnSavedFilmek() {
        // Given
        given(FilmekRepository.save(Dune_film)).willReturn(Dune_film);

        // When
        final Filmek actual = underTest.createFilmek(Dune_film);

        // Then
        assertThat(actual, equalTo(Dune_film));
        verify(FilmekRepository).save(Dune_film);
        verifyNoMoreInteractions(FilmekRepository);
    }
    @Test
    void retrieveFilmekByIdShouldDelegateToTheRepoAndReturnTheFilmekFound() {
        //Given
        given(FilmekRepository.getAll()).willReturn(List.of(Dune_film));

        //When
        final List<Filmek> actual = underTest.retrieveAllFilmek();

        //Then
        assertThat(actual,equalTo(List.of(Dune_film)));
        verify(FilmekRepository).getAll();
        verifyNoMoreInteractions(FilmekRepository);
    }
    @Test
    void updateFilmek() {
    }

    @Test
    void deleteFilmekById() {
    }
}