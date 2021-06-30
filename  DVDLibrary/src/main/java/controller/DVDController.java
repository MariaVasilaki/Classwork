package controller;

import dao.DVDDao;

import dto.DVD;
import java.util.List;

import ui.DVDView;

public class DVDController {
    private final DVDView view;
    private final DVDDao dao;

    public DVDController(DVDDao dao, DVDView view){
        this.dao = dao;
        this.view = view;
    }

    public void run(){
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

               // do{
                    switch (menuSelection) {
                        case 1:
                            addDVD();
                            break;
                        case 2:
                            removeDVD();
                            break;
                        case 3:
                            editDVD();
                            break;
                        case 4:
                            listDVDs();
                            break;
                        case 5:
                            getDVD();
                            break;
                        case 6:
                            keepGoing = false;
                            break;
                        default:
                            unknownCommand();
                            break;

                    }

                    exitMessage();


               // } while (menuSelection <7) ;

            }
        } catch (Exception e){
            view.displayErrorMessage(e.getMessage());
        }

    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // ------------------------------------------------ add DVD --------------------------------------------------------
    private void addDVD() throws Exception {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddSuccessBanner();
    }
    // ----------------------------------------------- remove DVD ------------------------------------------------------
    private void removeDVD() throws Exception {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }

    // ----------------------------------------------- edit DVD --------------------------------------------------------
    private void editDVD() throws Exception {
        view.displayEditDVDBanner();
        DVD editedDVD = view.getNewDVDInfo();
        dao.editDVD(editedDVD.getTitle(), editedDVD);
        view.displayEditSuccessBanner();
    }

    // ----------------------------------------------- list all DVDs ---------------------------------------------------

    private void listDVDs() throws Exception{
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    // ----------------------------------------------- get DVD by title ------------------------------------------------
    private void getDVD() throws Exception{
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
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