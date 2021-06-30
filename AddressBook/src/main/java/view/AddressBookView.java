package view;

import dto.Address;

import java.util.List;

public class AddressBookView {
    private UserIO io;

    public AddressBookView( UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Please select the operation you wish to perform:");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Address getNewAddressInfo() {
        String addressId = io.readString("Please enter Address ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String  address = io.readString("Please enter Street Address");
        String city = io.readString("Please enter city");
        String state = io.readString("Please enter state");
        String postcode = io.readString("Please enter postcode");
        Address currentAddress = new Address(addressId, lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setAddress(address);
        currentAddress.setCity(city);
        currentAddress.setPostcode(postcode);
        currentAddress.setAddress(state);
        return currentAddress;
    }

    public void displayAddBanner() {
        io.print("=== Add an address ===");
    }

    public void displayAdditionSuccessBanner() {
        io.readString(
                "Address successfully added.  Press 1 to go to Main Menu.");
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            String addressInfo = String.format("#%s : %s %s %s %s %s",
                    currentAddress.getAddressId(),
                    currentAddress.getFirstName(),
                    currentAddress.getLastName(),
                    currentAddress.getAddress(),
                    currentAddress.getCity(),
                    currentAddress.getPostcode(),
                    currentAddress.getState());
            io.print(addressInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }

    public void displayDisplayAddressBanner () {
        io.print("=== Display Address ===");
    }

    public String getAddressIdChoice() {
        return io.readString("Please enter the Address ID.");
    }
    public String getLastName() {
        return io.readString("Please enter the Last Name.");
    }
    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getAddressId());
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getCity());
            io.print(address.getPostcode());
            io.print(address.getState());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDeleteAddressBanner () {
        io.print("=== Delete Address ===");
    }

    public void displayDeleteResult(Address addressRecord) {
        if(addressRecord != null){
            io.print("Address successfully removed.");
        }else{
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }


    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }


    public void displayCounterBanner() {
        io.print("=== Count All Addresses Registered ===");
    }

}
