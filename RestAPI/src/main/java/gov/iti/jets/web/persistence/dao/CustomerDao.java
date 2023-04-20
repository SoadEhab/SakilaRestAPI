package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.entities.*;

import java.util.List;

public class CustomerDao extends SakilaContext{

    public List<Rental> getCustomerRentals(int customerId){
        Customer customer = getById(Customer.class, customerId);
        return customer.getRentalList().stream().toList();
    }

    public List<Payment> getCustomerPayments(int customerId){
        Customer customer = getById(Customer.class, customerId);
        return customer.getPaymentList().stream().toList();
    }

}
