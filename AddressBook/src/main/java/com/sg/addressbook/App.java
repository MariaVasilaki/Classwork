package com.sg.addressbook;

import controller.AddressBookController;
import dao.AddressBookDao;
import dao.AddressBookDaoImpl;
import view.AddressBookView;
import view.UserIO;
import view.UserIOImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoImpl();
        AddressBookController controller =
                new AddressBookController(myDao, myView);
        controller.run();
    }

}
