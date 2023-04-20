package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.entities.Inventory;
import gov.iti.jets.web.entities.Rental;

import java.util.List;

public class InventoryDao extends SakilaContext{
    public List<Rental> getInventoryRentals(int inventoryId) {
        Inventory inventory = getById(Inventory.class, inventoryId);
        return inventory.getRentalList().stream().toList();
    }
}
