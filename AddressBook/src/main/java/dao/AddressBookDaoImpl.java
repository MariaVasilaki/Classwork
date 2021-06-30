package dao;

import dto.Address;

import java.io.*;
import java.util.*;

public class AddressBookDaoImpl implements AddressBookDao{
    private Map<String, Address> addresses = new HashMap<>();

    public static final String ROSTER_FILE = "addressBook.txt";
    public static final String DELIMITER = "::";

    @Override
    public Address addAddress(String addressId, Address lastName) throws Exception {
        loadRoster();
        Address newAddress = addresses.put(addressId, lastName);
        writeRoster();
        return newAddress;
    }


    @Override
    public Address deleteAddress(String addressId) throws Exception {
        loadRoster();
        Address deletedAddress = addresses.remove(addressId);
        writeRoster();
        return deletedAddress;
    }



    @Override
    public Address getAddress(String lastName) throws Exception {
        loadRoster();
        for (String i : addresses.keySet()) {
            if (lastName.equals(addresses.get(i).getLastName())) {

                return addresses.get(i);
            } else {
                System.out.println("Cannot find an entry based on this last name.");
            }
        }
        return getAddress(lastName);
    }



    @Override
    public void countAddresses()  {
        System.out.println("Number of entries:  " + addresses.size() );
    }

    @Override
    public List<Address> getAllAddresses() throws Exception {
        loadRoster();
        return new ArrayList(addresses.values());
    }


    //UNMARSHALL
    private Address unmarshallAddress(String addressAsText){
        // addressAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in addressTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] addressTokens = addressAsText.split(DELIMITER);

        // Given the pattern above, the address Id is in index 0 of the array.
        String addressId = addressTokens[0];

        // Which we can then use to create a new Address object to satisfy
        // the requirements of the Address constructor.
        Address addressFromFile = new Address(addressId);

        // However, there are 3 remaining tokens that need to be set into the
        // new Address object. Do this manually by using the appropriate setters.

        // Index 1 - FirstName
        addressFromFile.setFirstName(addressTokens[1]);

        // Index 2 - LastName
        addressFromFile.setLastName(addressTokens[2]);

        // Index 3 - Street Address
        addressFromFile.setAddress(addressTokens[3]);

        //Index 4 - City
        addressFromFile.setCity((addressTokens[4]));

        // Index 5 - State
        addressFromFile.setState(addressTokens[5]);

        //Index 6 - Postcode
        addressFromFile.setPostcode(addressTokens[6]);

        // We have now created a address! Return it!
        return addressFromFile;
    }

    //LOAD FILE
    private void loadRoster() throws Exception {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new Exception(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentAddress holds the most recent address unmarshalled
        Address currentAddress;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Address object by calling the unmarshallAddress method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Address
            currentAddress = unmarshallAddress(currentLine);

            // We are going to use the address id as the map key for our address object.
            // Put currentAddress into the map using address id as the key
            addresses.put(currentAddress.getAddressId(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    //MARSHALL
    private String marshallAddress(Address aAddress){
        // We need to turn a Address object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the address id, since that's supposed to be first.
        String addressAsText = aAddress.getAddressId() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        addressAsText += aAddress.getFirstName() + DELIMITER;

        // LastName
        addressAsText += aAddress.getLastName() + DELIMITER;

        // Street Address
        addressAsText +=aAddress.getAddress() + DELIMITER;

        // City
        addressAsText += aAddress.getCity() + DELIMITER;

        // State
        addressAsText += aAddress.getState() + DELIMITER;

        // Postcode - don't forget to skip the DELIMITER here.
        addressAsText += aAddress.getPostcode();

        // We have now turned a address to text! Return it!
        return addressAsText;
    }

    //WRITE TO FILE
    /**
     * Writes all addresss in the roster out to a ROSTER_FILE.  See loadRoster
     * for file format.
     *
     * @throws Exception if an error occurs writing to the file
     */

    private void writeRoster() throws Exception {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new Exception(
                    "Could not save address data.", e);
        }

        // Write out the Address objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the address map,
        // get the Collection of Addresses and iterate over them but we've
        // already created a method that gets a List of Addresses so
        // we'll reuse it.
        String addressAsText;
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // turn a Address into a String
            addressAsText = marshallAddress(currentAddress);
            // write the Address object to the file
            out.println(addressAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }


}
