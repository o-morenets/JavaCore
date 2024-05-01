package stackOverflow.movieDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Film film1 = new Film("Harry Potter");
        Film film2 = new Film("Split");
        Film film3 = new Film("Victor Frankenstein");

        Actor actor1 = new Actor("Daniel Redcliff");
        Actor actor2 = new Actor("Emma Watson");
        Actor actor3 = new Actor("James McAvoy");
        Actor actor4 = new Actor("BattleField Overwatch");

        Database.addFilm(film1);
        Database.addFilm(film2);
        Database.addFilm(film3);
        Database.addActor(actor1);
        Database.addActor(actor2);
        Database.addActor(actor3);
        Database.addActor(actor4);

        film1.addActor(actor1);
        film1.addActor(actor2);
        film2.addActor(actor3);
        film3.addActor(actor1);
        film3.addActor(actor3);
        actor1.addFilm(film1);
        actor1.addFilm(film3);
        actor2.addFilm(film1);
        actor3.addFilm(film2);
        actor3.addFilm(film3);

        System.out.println(notFilmed()); // [Actor{name='BattleField Overwatch'}]
    }

    private static List<Actor> notFilmed() {
        List<Actor> resultList = new ArrayList<>();

        Iterator<Actor> actorIterator = Database.getActors().iterator();
        while (actorIterator.hasNext()) {
            Actor actor = actorIterator.next();
            Iterator<Film> filmIterator = Database.getFilms().iterator();

            boolean present = false;
            while (filmIterator.hasNext()) {
                Film film = filmIterator.next();
                if (film.getActors().contains(actor)) {
                    present = true;
                    break;
                }
            }

            if (!present) {
                resultList.add(actor);
            }
        }

        return resultList;
    }
}
