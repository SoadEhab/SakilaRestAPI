package gov.iti.jets.web.models;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentModel {
    private Short paymentId;

    private BigDecimal amount;

    private Date paymentDate;

    private Date lastUpdate;

//    private Customer customerId;
//
//    private Rental rentalId;
//
//    private Staff staffId;

    public Short getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Short paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
