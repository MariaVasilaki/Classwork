package controller;

import dao.AddressBookDao;
import dto.Address;
import view.AddressBookView;
import view.UserIO;
import view.UserIOImpl;

import java.util.List;

public class AddressBookController {

    private AddressBookView view;
    private UserIO io = new UserIOImpl();
    private AddressBookDao dao;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        deleteAddress();
                        break;
                    case 3:
                        getAddress();
                        break;
                    case 4:
                        countAddresses();
                        break;
                    case 5:
                        getAllAddresses();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        //System.exit(0);
                }

            }
            exitMessage();

        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // ------------------------------------------------ add address --------------------------------------------------
    private void addAddress() throws Exception {
        view.displayAddBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getAddressId(), newAddress);
        view.displayAdditionSuccessBanner();
    }
    // ----------------------------------------------- delete address --------------------------------------------------
    private void deleteAddress() throws Exception {
        view.displayDeleteAddressBanner();
        String addressId = view.getAddressIdChoice();
        Address deletedAddress = dao.deleteAddress(addressId);
        view.displayDeleteResult(deletedAddress);
    }

    // ----------------------------------------------- get address by last name ----------------------------------------
    private void getAddress() throws Exception{
        view.displayDisplayAddressBanner();
        String lastName = view.getLastName();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    // ----------------------------------------------- count addresses -------------------------------------------------
    private void countAddresses() {
        view.displayCounterBanner();
        dao.countAddresses();
    }

    // ----------------------------------------------- return all addresses --------------------------------------------

    private void getAllAddresses() throws Exception{
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }


    // ----------------------------------------------- unknown command -------------------------------------------------
    private void unknownCommand () {
        view.displayUnknownCommandBanner();
    }

    // ----------------------------------------------- exit ------------------------------------------------------------
    private void exitMessage () {
        view.displayExitBanner();
    }
}
