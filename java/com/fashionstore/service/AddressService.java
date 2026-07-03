package com.fashionstore.service;

import com.fashionstore.dao.implementations.AddressDAOImpl;
import com.fashionstore.dao.interfaces.AddressDAO;
import com.fashionstore.model.Address;
import java.util.List;

public class AddressService {
    private AddressDAO addressDAO = new AddressDAOImpl();

    public List<Address> getUserAddresses(int userId) {
        return addressDAO.getAddressesByUserId(userId);
    }

    public Address getDefaultAddress(int userId) {
        List<Address> addresses = getUserAddresses(userId);
        return addresses.stream()
                .filter(Address::isDefault)
                .findFirst()
                .orElse(addresses.isEmpty() ? null : addresses.get(0));
    }

    public boolean addAddress(Address address) {
        if (address.isDefault()) {
            addressDAO.resetDefaultAddress(address.getUserId());
        }
        return addressDAO.addAddress(address);
    }

    public Address getAddressById(int id) {
        return addressDAO.getAddressById(id);
    }

    public boolean updateAddress(Address address) {
        if (address.isDefault()) {
            addressDAO.resetDefaultAddress(address.getUserId());
        }
        return addressDAO.updateAddress(address);
    }

    public boolean deleteAddress(int id) {
        return addressDAO.deleteAddress(id);
    }
}
