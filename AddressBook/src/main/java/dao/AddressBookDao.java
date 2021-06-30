package dao;

import dto.Address;

import java.util.List;

public interface AddressBookDao {

    Address addAddress(String addressId, Address lastName) throws Exception;
    Address deleteAddress(String addressId) throws Exception;

    Address getAddress(String lastName) throws Exception;

    void countAddresses();

    List<Address> getAllAddresses() throws Exception;

}
