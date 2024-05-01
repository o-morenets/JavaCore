package stackOverflow.movieDB;

import java.util.ArrayList;
import java.util.List;

class Film {
    private String name;
    private List<Actor> actors = new ArrayList();

    public Film(String name) {
        this.name = name;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public List<Actor> getActors() {
        return this.actors;
    }

    public String getName() {
        return this.name;
    }
}