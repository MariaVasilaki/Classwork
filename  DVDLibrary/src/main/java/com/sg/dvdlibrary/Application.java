package com.sg.dvdlibrary;

import controller.DVDController;
import dao.DVDDao;
import dao.DVDDaoFileImpl;
import ui.DVDView;
import ui.UserIO;
import ui.UserIOImpl;


public class Application {
    public static void main(String[] args){
        UserIO myIo = new UserIOImpl();
        DVDView myView = new DVDView(myIo);
        DVDDao myDao = new DVDDaoFileImpl();
        DVDController controller =
                new DVDController(myDao, myView);
        controller.run();
    }

}


