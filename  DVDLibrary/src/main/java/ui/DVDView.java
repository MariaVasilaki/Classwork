package ui;

import dto.DVD;

import java.util.List;

public class DVDView {

    private final UserIO io;

        public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit DVD information");
        io.print("4. List all DVDs");
        io.print("5. Display DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the " + "above choices.", 1, 6); }

        public DVDView(UserIO io) {
            this.io = io;
        }

        public void displayAddDVDBanner() {
        io.print("=== Add DVD ===");
    }
        public DVD getNewDVDInfo() {
            String title = io.readString("Please enter title.");
            int releaseDate = Integer.parseInt(io.readString("Please enter release date."));
            String MpaaRating = io.readString("Please enter Mpaa Rating.");
            String director = io.readString("Please enter the Director's Name.");
            String studio = io.readString("Please enter studio.");
            String userComments = io.readString("Please enter your comments.");
            DVD currentDVD = new DVD(title);
            currentDVD.setReleaseDate(releaseDate);
            currentDVD.setMpaaRating(MpaaRating);
            currentDVD.setDirector(director);
            currentDVD.setStudio(studio);
            currentDVD.setUserComments(userComments);
            return currentDVD;
        }
        public void displayAddSuccessBanner() {
            io.readString("DVD successfully added.  Please hit enter to continue");
        }





        public void displayRemoveDVDBanner () {
            io.print("=== Remove DVD ===");
        }
        public String getTitleChoice() {
            return io.readString("Please enter the title.");
        }
        public void displayRemoveResult(DVD DVDRecord) {
            if(DVDRecord != null){
                io.print("DVD successfully removed.");
            }else{
                io.print("No such DVD.");
            }
            io.readString("Please hit enter to continue.");
        }





        public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }
        public void displayEditSuccessBanner() {
            io.readString( "DVD successfully edited.  Please hit enter to continue");
        }



        public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
        public void displayDVDList(List<DVD> dvdList) {
            for (DVD currentDvd : dvdList) {
                String dvdInfo = String.format("#%s : %s %s %s %s %s",
                        currentDvd.getTitle(),
                        currentDvd.getReleaseDate(),
                        currentDvd.getMpaaRating(),
                        currentDvd.getDirector(),
                        currentDvd.getStudio(),
                        currentDvd.getUserComments());
                io.print(dvdInfo);
            }
            io.readString("Please hit enter to continue.");
        }



        public void displayDisplayDVDBanner () {
            io.print("=== Display DVD ===");
        }
        public void displayDVD(DVD dvd) {
            if (dvd != null) {
                io.print(dvd.getTitle());
                io.print(String.valueOf(dvd.getReleaseDate()));
                io.print(dvd.getMpaaRating());
                io.print(dvd.getDirector());
                io.print(dvd.getStudio());
                io.print(dvd.getUserComments());
                io.print("");
            } else {
                io.print("No such DVD.");
            }
            io.readString("Please hit enter to continue.");
        }





        public void displayErrorMessage(String errorMsg) {
            io.print("=== ERROR ===");
            io.print(errorMsg);
        }

        public void displayExitBanner() {
            io.print("Good Bye!!!");
        }

        public void displayUnknownCommandBanner() {
            io.print("Unknown Command!!!");
        }

}
