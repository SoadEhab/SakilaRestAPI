package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Actor;
import gov.iti.jets.web.models.ActorModel;
import gov.iti.jets.web.models.FilmModel;
import gov.iti.jets.web.persistence.dao.ActorDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;


@Path("actor")
public class ActorService {
    ActorDao actorDao = new ActorDao();
    ModelMapper modelMapper = new ModelMapper();

    public ActorService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<ActorModel> getAllActors(){
        return modelMapper.map(actorDao.getAll("Actor.findAll"), new TypeToken<List<ActorModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public ActorModel getActorById(@PathParam("id") int id){
        return modelMapper.map(actorDao.getById(Actor.class,id), ActorModel.class);
    }

    @GET
    @Path("{fName}")
    @Produces(MediaType.APPLICATION_XML)
    public List<ActorModel> getActorByFirstName(@PathParam("fName") String fName){
        return modelMapper.map(actorDao.getBy("Actor.findByFirstName","firstName",fName), new TypeToken<List<ActorModel>>(){}.getType());
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public ActorModel addActor(ActorModel actorModel){
        Actor actor = actorDao.add(modelMapper.map(actorModel, Actor.class));
        ActorModel addedActor = modelMapper.map(actor, ActorModel.class);
        return addedActor;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateActor(ActorModel actorModel){
        return actorDao.update(modelMapper.map(actorModel, Actor.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteActor(@PathParam("id") int id){
        return actorDao.deleteById(id, Actor.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getActorFilms(@PathParam("id") int actorId){
        return modelMapper.map(actorDao.getActorFilms(actorId), new TypeToken<List<FilmModel>>(){}.getType());
    }
}
