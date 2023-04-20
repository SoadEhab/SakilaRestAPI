package gov.iti.jets.web.models;

import java.util.Date;

public class InventoryModel {

    private Integer inventoryId;

    private Date lastUpdate;

//    private Film filmId;
//
//    private Store storeId;

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
