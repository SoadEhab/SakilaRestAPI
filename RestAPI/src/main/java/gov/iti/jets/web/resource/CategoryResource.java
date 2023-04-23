package gov.iti.jets.web.resource;

import gov.iti.jets.web.entities.Category;
import gov.iti.jets.web.models.CategoryModel;
import gov.iti.jets.web.persistence.dao.CategoryDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("category")
public class CategoryResource {

    CategoryDao categoryDao = new CategoryDao();
    ModelMapper modelMapper = new ModelMapper();

    public CategoryResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CategoryModel> getAllCategories(){
        return modelMapper.map(categoryDao.getAll("Category.findAll"), new TypeToken<List<CategoryModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public CategoryModel getCategoryById(@PathParam("id") int id){
        return modelMapper.map(categoryDao.getById(Category.class,id), CategoryModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public CategoryModel addCategory(CategoryModel categoryModel){

        Category category = categoryDao.add(modelMapper.map(categoryModel, Category.class));
        CategoryModel addedCategory = modelMapper.map(category, CategoryModel.class);
        return addedCategory;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateCategory(CategoryModel categoryModel){
        return categoryDao.update(modelMapper.map(categoryModel, Category.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteCategory(@PathParam("id") int id){
        return categoryDao.deleteById(id, Category.class);
    }

}
