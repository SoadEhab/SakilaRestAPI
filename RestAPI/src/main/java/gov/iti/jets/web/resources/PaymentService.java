package gov.iti.jets.web.resources;

import gov.iti.jets.web.entities.Payment;
import gov.iti.jets.web.models.PaymentModel;
import gov.iti.jets.web.persistence.dao.PaymentDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

@Path("payment")
public class PaymentService {
    PaymentDao paymentDao = new PaymentDao();
    ModelMapper modelMapper = new ModelMapper();

    public PaymentService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<PaymentModel> getAllPayments(){
        return modelMapper.map(paymentDao.getAll("Payment.findAll"), new TypeToken<List<PaymentModel>>(){}.getType());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public PaymentModel getPaymentById(@PathParam("id") int id){
        return modelMapper.map(paymentDao.getById(Payment.class,id), PaymentModel.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public PaymentModel addPayment(PaymentModel paymentModel){

        Payment payment = paymentDao.add(modelMapper.map(paymentModel, Payment.class));
        PaymentModel addedPayment = modelMapper.map(payment, PaymentModel.class);
        return addedPayment;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean updatePayment(PaymentModel paymentModel){
        return paymentDao.update(modelMapper.map(paymentModel, Payment.class));
    }

    @POST
    @Path("{id}")
    public boolean deletePayment(@PathParam("id") int id){
        return paymentDao.deleteById(id, Payment.class);
    }
}
