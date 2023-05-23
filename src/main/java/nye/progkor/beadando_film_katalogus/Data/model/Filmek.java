package nye.progkor.beadando_film_katalogus.Data.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;


public class Filmek {

    private Long Id;
    private String name;
    private Genre genre;
    private String director;
    private int releasedate;

    public Filmek(Long id, String name, Genre genre, String director, int releasedate) {
        Id = id;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.releasedate = releasedate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filmek filmek = (Filmek) o;

        if (releasedate != filmek.releasedate) return false;
        if (!Objects.equals(Id, filmek.Id)) return false;
        if (!Objects.equals(director,filmek.director)) return false;
        if (genre != filmek.genre) return false;
        return Objects.equals(name,filmek.name);
    }

    @Override
    public int hashCode() {
        int result = Id!= null ? Id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + releasedate;
        return result;
    }

    @Override
    public String toString() {
        return "Filmek{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", director='" + director + '\'' +
                ", releasedate=" + releasedate +
                '}';
    }
}