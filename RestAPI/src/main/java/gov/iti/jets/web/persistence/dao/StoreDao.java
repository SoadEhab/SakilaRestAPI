package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.entities.*;

import java.util.List;

public class StoreDao extends SakilaContext{

    public List<Inventory> getStoreInventories(int storeId) {
        Store store = getById(Store.class, storeId);
        return store.getInventoryList().stream().toList();
    }

    public List<Customer> getStoreCustomers(int storeId) {
        Store store = getById(Store.class, storeId);
        return store.getCustomerList().stream().toList();
    }

    public List<Staff> getStoreStaff(int storeId) {
        Store store = getById(Store.class, storeId);
        return store.getStaffList().stream().toList();
    }

}
