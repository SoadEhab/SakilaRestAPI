package gov.iti.jets.web.resource;

import gov.iti.jets.web.entities.Address;
import gov.iti.jets.web.models.AddressModel;
import gov.iti.jets.web.persistence.dao.AddressDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("address")
public class AddressResource {

    AddressDao addressDao = new AddressDao();
    ModelMapper modelMapper = new ModelMapper();

    public AddressResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<AddressModel> getAllAddresses(){
        return modelMapper.map(addressDao.getAll("Address.findAll"), new TypeToken<List<AddressModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public AddressModel getAddressById(@PathParam("id") int id){
        return modelMapper.map(addressDao.getById(Address.class,id), AddressModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public AddressModel addAddress(AddressModel addressModel){

        Address address = addressDao.add(modelMapper.map(addressModel, Address.class));
        AddressModel addedAddress = modelMapper.map(address, AddressModel.class);
        return addedAddress;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateAddress(AddressModel addressModel){
        return addressDao.update(modelMapper.map(addressModel, Address.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteAddress(@PathParam("id") int id){
        return addressDao.deleteById(id, Address.class);
    }

}
