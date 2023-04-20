package gov.iti.jets.web.models;

import java.util.Date;

public class StoreModel {

    private Short storeId;
    private Date lastUpdate;
//    private Address addressId;
//    private Staff managerStaffId;

    public Short getStoreId() {
        return storeId;
    }

    public void setStoreId(Short storeId) {
        this.storeId = storeId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
