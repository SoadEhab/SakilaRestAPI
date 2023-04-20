package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Rental;
import gov.iti.jets.web.models.PaymentModel;
import gov.iti.jets.web.models.RentalModel;
import gov.iti.jets.web.persistence.dao.RentalDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("rental")
public class RentalService {

    RentalDao rentalDao = new RentalDao();
    ModelMapper modelMapper = new ModelMapper();

    public RentalService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<RentalModel> getAllRentals() {
        return modelMapper.map(rentalDao.getAll("Rental.findAll"), new TypeToken<List<RentalModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public RentalModel getRentalById(int id) {
        return modelMapper.map(rentalDao.getById(Rental.class, id), RentalModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public RentalModel addRental(RentalModel rentalModel) {

        Rental rental = rentalDao.add(modelMapper.map(rentalModel, Rental.class));
        RentalModel addedRental = modelMapper.map(rental, RentalModel.class);
        return addedRental;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateRental(RentalModel rentalModel) {
        return rentalDao.update(modelMapper.map(rentalModel, Rental.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteRental(@PathParam("id") int id) {
        return rentalDao.deleteById(id, Rental.class);
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<PaymentModel> getRentalPayments(@PathParam("id") int rentalID) {
        return modelMapper.map(rentalDao.getRentalPayments(rentalID), new TypeToken<List<PaymentModel>>() {}.getType());
    }
}
