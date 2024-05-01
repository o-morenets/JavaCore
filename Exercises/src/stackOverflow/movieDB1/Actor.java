package stackOverflow.movieDB1;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private String name;
    private List<Film> films = new ArrayList();

    public Actor(String name) {
        this.name = name;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", films=" + films +
                '}';
    }
}