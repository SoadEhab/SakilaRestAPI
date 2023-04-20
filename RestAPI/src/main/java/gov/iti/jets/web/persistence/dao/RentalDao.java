package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.entities.Payment;
import gov.iti.jets.web.entities.Rental;

import java.util.List;

public class RentalDao extends SakilaContext{

    public List<Payment> getRentalPayments(int rentalID) {
        Rental rental = getById(Rental.class, rentalID);
        return rental.getPaymentList().stream().toList();
    }

}
