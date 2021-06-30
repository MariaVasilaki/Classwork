package dao;

import dto.DVD;

import java.io.*;
import java.util.*;

public class DVDDaoFileImpl implements DVDDao {
    public static final String README_FILE = "DVDList.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) throws Exception {
        loadDVD();
        DVD newDVD = DVDs.put(title, dvd);
        writeDVD();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String title) throws Exception {
        loadDVD();
        DVD removedDVD = DVDs.remove(title);
        writeDVD();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws Exception {
        loadDVD();
        DVD existingDVD = DVDs.put(title, dvd);
        writeDVD();
        return existingDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws Exception {
        loadDVD();
        return new ArrayList(DVDs.values());
    }

    @Override
    public DVD getDVD(String title) throws Exception {
        loadDVD();
        return DVDs.get(title);
    }


//UNMARSHALL
    private DVD unmarshallDVD(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Given the pattern above, the title is in index 0 of the array.
        String title = dvdTokens[0];

        // Which we can then use to create a new DVD object to satisfy
        // the requirements of the DVD constructor.
        DVD dvdFromFile = new DVD(title);

        // However, there are 3 remaining tokens that need to be set into the
        // new DVD object. Do this manually by using the appropriate setters.

        // Index 1 - Release Date
        dvdFromFile.setReleaseDate(Integer.parseInt(dvdTokens[1]));

        // Index 2 - Mpaa Rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - Director
        dvdFromFile.setDirector(dvdTokens[3]);

        //Index 4 - Studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - User Comments
        dvdFromFile.setUserComments(dvdTokens[5]);

        // We have now created a address! Return it!
        return dvdFromFile;
    }
    //LOAD FILE

    private void loadDVD() throws Exception {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(README_FILE)));
        } catch (FileNotFoundException e) {
            throw new Exception(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDVD = unmarshallDVD(currentLine);


          DVDs.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    //MARSHALL
    private String marshallDVD(DVD aDVD){
        // Title
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        // Release date
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        // Mpaa Rating
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;

        // Director's name
        dvdAsText += aDVD.getDirector() + DELIMITER;

        //Studio
        dvdAsText += aDVD.getStudio() + DELIMITER;

        //User Comments - don't forget to skip the DELIMITER here
        dvdAsText += aDVD.getUserComments();

        return dvdAsText; // We return the converted DVD object to text.

    }
    //WRITE TO FILE
    private void writeDVD() throws Exception {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(README_FILE));
        } catch (IOException e) {
            throw new Exception("Could not save address data.", e);
        }
        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            // turn a DVD into a String
            dvdAsText = marshallDVD(currentDVD);
            // write the DVD object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }



}










