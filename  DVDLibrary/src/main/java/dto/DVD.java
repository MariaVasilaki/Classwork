package dto;

public class DVD {
    //These are the needed fields.
    private final String title;
    private int releaseDate;
    private String MpaaRating;
    private String director;
    private String studio;
    private String userComments;


    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    //Release Date
    public int getReleaseDate(){

        return releaseDate;
    }
    public void setReleaseDate(int releaseDate){

        this.releaseDate = releaseDate;

    }

    //Mpaa rating
    public String getMpaaRating(){

        return MpaaRating;
    }

    public void setMpaaRating(String MpaaRating) {

        this.MpaaRating = MpaaRating;
    }


    //Director's name
    public String getDirector(){

        return director;
    }
    public void setDirector(String director){

        this.director = director;
    }

    //Studio
    public String getStudio(){

        return studio;
    }
    public void setStudio(String studio){

        this.studio = studio;
    }

    //User's comments
    public String getUserComments(){

        return userComments;
    }
    public void setUserComments(String userComments){

        this.userComments = userComments;
    }


}
