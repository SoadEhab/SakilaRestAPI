package gov.iti.jets.web.resource;

import gov.iti.jets.web.entities.Customer;
import gov.iti.jets.web.models.CustomerModel;
import gov.iti.jets.web.models.PaymentModel;
import gov.iti.jets.web.models.RentalModel;
import gov.iti.jets.web.persistence.dao.CustomerDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("customer")
public class CustomerResource {
    CustomerDao customerDao = new CustomerDao();
    ModelMapper modelMapper = new ModelMapper();

    public CustomerResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CustomerModel> getAllCustomers() {
        return modelMapper.map(customerDao.getAll("Customer.findAll"), new TypeToken<List<CustomerModel>>() {
        }.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public CustomerModel getCustomerById(@PathParam("id") int id) {
        return modelMapper.map(customerDao.getById(Customer.class, id), CustomerModel.class);
    }

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_XML)
    public List<CustomerModel> getCustomerByEmail(@PathParam("email") String email) {
        return modelMapper.map(customerDao.getBy("Customer.findByEmail", "email", email), new TypeToken<List<CustomerModel>>() {}.getType());
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public CustomerModel addCustomer(CustomerModel customerModel) {

        Customer customer = customerDao.add(modelMapper.map(customerModel, Customer.class));
        CustomerModel addedCustomer = modelMapper.map(customer, CustomerModel.class);
        return addedCustomer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updateCustomer(CustomerModel customerModel) {
        return customerDao.update(modelMapper.map(customerModel, Customer.class));
    }

    @POST
    @Path("{id}")
    public boolean deleteCustomer(@PathParam("id") int id) {
        return customerDao.deleteById(id, Customer.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<RentalModel> getCustomerRentals(@PathParam("id") int customerId){
        return modelMapper.map(customerDao.getCustomerRentals(customerId), new TypeToken<List<RentalModel>>() {}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<PaymentModel> getCustomerPayments(@PathParam("id") int customerId){
        return modelMapper.map(customerDao.getCustomerPayments(customerId), new TypeToken<List<PaymentModel>>() {}.getType());
    }

}
