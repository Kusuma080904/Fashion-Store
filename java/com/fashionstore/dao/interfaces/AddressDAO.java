package com.fashionstore.dao.interfaces;

import com.fashionstore.model.Address;
import java.util.List;

public interface AddressDAO {
    boolean addAddress(Address address);
    List<Address> getAddressesByUserId(int userId);
    Address getAddressById(int id);
    boolean updateAddress(Address address);
    boolean deleteAddress(int id);
    void resetDefaultAddress(int userId);
}