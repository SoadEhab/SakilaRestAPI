package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Language;
import gov.iti.jets.web.models.LanguageModel;
import gov.iti.jets.web.persistence.dao.LanguageDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;


@Path("language")
public class LanguageService {

    LanguageDao languageDao = new LanguageDao();
    ModelMapper modelMapper = new ModelMapper();

    public LanguageService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<LanguageModel> getAllLanguages(){
        return modelMapper.map(languageDao.getAll("Language.findAll"), new TypeToken<List<LanguageModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public LanguageModel getLanguageById(@PathParam("id") int id){
        return modelMapper.map(languageDao.getById(Language.class,id), LanguageModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public LanguageModel addLanguage(LanguageModel languageModel){

        Language language = languageDao.add(modelMapper.map(languageModel, Language.class));
        LanguageModel addedLanguage = modelMapper.map(language, LanguageModel.class);
        return addedLanguage;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateLanguage(LanguageModel languageModel){
        return languageDao.update(modelMapper.map(languageModel, Language.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteLanguage(@PathParam("id") int id){
        return languageDao.deleteById(id, Language.class);
    }
}
