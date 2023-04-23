package gov.iti.jets.web.resource;

import gov.iti.jets.web.entities.*;
import gov.iti.jets.web.models.*;
import gov.iti.jets.web.persistence.dao.StoreDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("store")
public class StoreResource {

    StoreDao storeDao = new StoreDao();
    ModelMapper modelMapper = new ModelMapper();

    public StoreResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<StoreModel> getAllStores() {
        return modelMapper.map(storeDao.getAll("Store.findAll"), new TypeToken<List<StoreModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public StoreModel getStoreById(@PathParam("id") int id) {
        return modelMapper.map(storeDao.getById(Store.class, id), StoreModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public StoreModel addStore(StoreModel storeModel) {

        Store store = storeDao.add(modelMapper.map(storeModel, Store.class));
        StoreModel addedStore = modelMapper.map(store, StoreModel.class);
        return addedStore;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateStore(StoreModel storeModel) {
        return storeDao.update(modelMapper.map(storeModel, Store.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteStore(@PathParam("id") int id) {
        return storeDao.deleteById(id, Store.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<InventoryModel> getStoreInventories(@PathParam("id") int storeId) {
        return modelMapper.map(storeDao.getStoreInventories(storeId), new TypeToken<List<InventoryModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<CustomerModel> getStoreCustomers(@PathParam("id") int storeId) {
        return modelMapper.map(storeDao.getStoreCustomers(storeId), new TypeToken<List<CustomerModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<StaffModel> getStoreStaff(@PathParam("id") int storeId) {
        return modelMapper.map(storeDao.getStoreStaff(storeId), new TypeToken<List<StaffModel>>() {
        }.getType());
    }
}
