package gov.iti.jets.web.resource;

import gov.iti.jets.web.entities.City;
import gov.iti.jets.web.models.CityModel;
import gov.iti.jets.web.persistence.dao.CityDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("city")
public class CityResource {
    CityDao cityDao = new CityDao();
    ModelMapper modelMapper = new ModelMapper();

    public CityResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CityModel> getAllCities(){
        return modelMapper.map(cityDao.getAll("City.findAll"), new TypeToken<List<CityModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public CityModel getCityById(@PathParam("id") int id){
        return modelMapper.map(cityDao.getById(City.class,id), CityModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public CityModel addCity(CityModel cityModel){

        City city = cityDao.add(modelMapper.map(cityModel, City.class));
        CityModel addedCity = modelMapper.map(city, CityModel.class);
        return addedCity;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateCity(CityModel cityModel){
        return cityDao.update(modelMapper.map(cityModel, City.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteCity(@PathParam("id") int id){
        return cityDao.deleteById(id, City.class);
    }
}
