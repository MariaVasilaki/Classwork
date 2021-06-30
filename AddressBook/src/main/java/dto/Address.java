package dto;

public class Address {
    private String addressId;
    private String lastName;
    private String firstName;
    private String address;
    private String postcode;
    private String city;
    private String state;

    public Address(String addressId, String lastName) {
        this.addressId = addressId;
        this.lastName = lastName;
    }

    public Address(String addressId) {
         this.addressId = addressId;
    }


    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getLastName() {
         return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
