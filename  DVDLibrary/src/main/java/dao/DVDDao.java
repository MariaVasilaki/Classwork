package dao;

import dto.DVD;

import java.util.List;

public interface DVDDao {
     DVD addDVD(String title, DVD dvd) throws Exception;
     DVD removeDVD(String title) throws Exception;
     DVD editDVD(String title, DVD dvd) throws Exception;
    List<DVD> getAllDVDs() throws Exception;
    DVD getDVD(String title) throws Exception;

}



