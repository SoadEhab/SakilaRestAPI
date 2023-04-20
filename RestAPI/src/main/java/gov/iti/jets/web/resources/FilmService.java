package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Film;
import gov.iti.jets.web.models.ActorModel;
import gov.iti.jets.web.models.CategoryModel;
import gov.iti.jets.web.models.FilmModel;
import gov.iti.jets.web.models.InventoryModel;
import gov.iti.jets.web.persistence.dao.FilmDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("film")
public class FilmService {
    FilmDao filmDao = new FilmDao();
    ModelMapper modelMapper = new ModelMapper();

    public FilmService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getAllFilms(){
        return modelMapper.map(filmDao.getAll("Film.findAll"), new TypeToken<List<FilmModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public FilmModel getFilmById(@PathParam("id") int id){
        return modelMapper.map(filmDao.getById(Film.class,id), FilmModel.class);
    }

    @GET
    @Path("{title}")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getFilmByTitle(@PathParam("title") String title){
        return modelMapper.map(filmDao.getBy("Film.findByTitle","title",title), new TypeToken<List<FilmModel>>(){}.getType());
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public FilmModel addFilm(FilmModel filmModel){

        Film film = filmDao.add(modelMapper.map(filmModel, Film.class));
        FilmModel addedFilm = modelMapper.map(film, FilmModel.class);
        return addedFilm;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateFilm(FilmModel filmModel){
        return filmDao.update(modelMapper.map(filmModel, Film.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteFilm(@PathParam("id") int id){
        return filmDao.deleteById(id, Film.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getFilmsByLanguage(@PathParam("id") int langId) {
        return modelMapper.map(filmDao.getFilmsByLanguage(langId), new TypeToken<List<FilmModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getFilmsByOriginalLanguage(@PathParam("id") int langId) {
        return modelMapper.map(filmDao.getFilmsByOriginalLanguage(langId), new TypeToken<List<FilmModel>>(){}.getType());
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getFilmsByActorName(@PathParam("name") String name) {
        return modelMapper.map(filmDao.getFilmsByActorName(name), new TypeToken<List<FilmModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmModel> getFilmsByCategory(@PathParam("id") int categoryId) {
        return modelMapper.map(filmDao.getFilmsByCategory(categoryId), new TypeToken<List<FilmModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<CategoryModel> getFilmCategories(@PathParam("id") int filmId) {
        return modelMapper.map(filmDao.getFilmCategories(filmId), new TypeToken<List<CategoryModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<ActorModel> getFilmActors(@PathParam("id") int filmId) {
        return modelMapper.map(filmDao.getFilmActors(filmId), new TypeToken<List<ActorModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<InventoryModel> getFilmInventories(@PathParam("id") int filmId) {
        return modelMapper.map(filmDao.getFilmInventories(filmId), new TypeToken<List<InventoryModel>>(){}.getType());
    }
}
