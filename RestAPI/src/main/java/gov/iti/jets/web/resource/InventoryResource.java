package gov.iti.jets.web.resource;

import gov.iti.jets.web.entities.Inventory;
import gov.iti.jets.web.models.InventoryModel;
import gov.iti.jets.web.models.RentalModel;
import gov.iti.jets.web.persistence.dao.InventoryDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("inventory")
public class InventoryResource {
    InventoryDao inventoryDao = new InventoryDao();
    ModelMapper modelMapper = new ModelMapper();

    public InventoryResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<InventoryModel> getAllInventories() {
        return modelMapper.map(inventoryDao.getAll("Inventory.findAll"), new TypeToken<List<InventoryModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public InventoryModel getInventoryById(@PathParam("id") int id) {
        return modelMapper.map(inventoryDao.getById(Inventory.class, id), InventoryModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public InventoryModel addInventory(InventoryModel inventoryModel) {

        Inventory inventory = inventoryDao.add(modelMapper.map(inventoryModel, Inventory.class));
        InventoryModel addedInventory = modelMapper.map(inventory, InventoryModel.class);
        return addedInventory;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateInventory(InventoryModel inventoryModel) {
        return inventoryDao.update(modelMapper.map(inventoryModel, Inventory.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteInventory(@PathParam("id") int id) {
        return inventoryDao.deleteById(id, Inventory.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<RentalModel> getInventoryRentals(@PathParam("id") int inventoryId) {
        return modelMapper.map(inventoryDao.getInventoryRentals(inventoryId), new TypeToken<List<RentalModel>>() {}.getType());
    }
}
