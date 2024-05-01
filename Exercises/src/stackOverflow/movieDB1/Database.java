package stackOverflow.movieDB1;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Film> allfilms = new ArrayList();
    private static List<Actor> allactors = new ArrayList();

    public Database() {
    }

    public static void addFilm(Film film) {
        allfilms.add(film);
    }

    public static void addActor(Actor actor) {
        allactors.add(actor);
    }

    public static List<Actor> getActors() {
        return allactors;
    }

    public static List<Film> getFilms() {
        return allfilms;
    }
}