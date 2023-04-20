package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Country;
import gov.iti.jets.web.models.CountryModel;
import gov.iti.jets.web.persistence.dao.CountryDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("country")
public class CountryService {
    CountryDao countryDao = new CountryDao();
    ModelMapper modelMapper = new ModelMapper();

    public CountryService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CountryModel> getAllCountries(){
        return modelMapper.map(countryDao.getAll("Country.findAll"), new TypeToken<List<CountryModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public CountryModel getCountryById(@PathParam("id") int id){
        return modelMapper.map(countryDao.getById(Country.class,id), CountryModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public CountryModel addCountry(CountryModel countryModel){

        Country country = countryDao.add(modelMapper.map(countryModel, Country.class));
        CountryModel addedCountry = modelMapper.map(country, CountryModel.class);
        return addedCountry;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateCountry(CountryModel countryModel){
        return countryDao.update(modelMapper.map(countryModel, Country.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteCountry(@PathParam("id") int id){
        return countryDao.deleteById(id, Country.class);
    }

}
