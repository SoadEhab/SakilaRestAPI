package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Staff;
import gov.iti.jets.web.models.PaymentModel;
import gov.iti.jets.web.models.RentalModel;
import gov.iti.jets.web.models.StaffModel;
import gov.iti.jets.web.persistence.dao.StaffDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("staff")
public class StaffService {

    StaffDao staffDao = new StaffDao();
    ModelMapper modelMapper = new ModelMapper();

    public StaffService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<StaffModel> getAllStaffs() {
        return modelMapper.map(staffDao.getAll("Staff.findAll"), new TypeToken<List<StaffModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public StaffModel getStaffById(@PathParam("id") int id) {
        return modelMapper.map(staffDao.getById(Staff.class, id), StaffModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public StaffModel addStaff(StaffModel staffModel) {

        Staff staff = staffDao.add(modelMapper.map(staffModel, Staff.class));
        StaffModel addedStaff = modelMapper.map(staff, StaffModel.class);
        return addedStaff;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateStaff(StaffModel staffModel) {
        return staffDao.update(modelMapper.map(staffModel, Staff.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteStaff(@PathParam("id") int id) {
        return staffDao.deleteById(id, Staff.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<PaymentModel> getStaffPayments(@PathParam("id") int staffId) {
        return modelMapper.map(staffDao.getStaffPayments(staffId), new TypeToken<List<PaymentModel>>() {}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<RentalModel> getStaffRentals(@PathParam("id") int rentalID) {
        return modelMapper.map(staffDao.getStaffRentals(rentalID), new TypeToken<List<RentalModel>>() {}.getType());
    }

}
