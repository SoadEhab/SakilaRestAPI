package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.entities.*;

import java.util.List;

public class ActorDao extends SakilaContext {

    public List<Film> getActorFilms(int actorId){
         Actor actor = getById(Actor.class, actorId);
         return actor.getFilmActorList().stream()
                 .map(FilmActor::getFilm).toList();
    }
}
