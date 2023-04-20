package gov.iti.jets.web.models;

import java.util.Date;

public class RentalModel {
    private Integer rentalId;

    private Date rentalDate;

    private Date returnDate;

    private Date lastUpdate;

//    private Customer customerId;
//
//    private Inventory inventoryId;
//
//    private Staff staffId;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
