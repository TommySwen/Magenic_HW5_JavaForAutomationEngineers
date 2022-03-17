package models;

public class Movie extends VideoMedia {

    /**
     * Creates an instance of the Movie class
     * @param title title of movie being created
     * @param length length of the movie being created in Minuets
     * @param available weather or not the movie is available in the movieStore or not
     */
    public Movie(String title, String length, boolean available){
        super(title,length,available);
    }

    /**
     * Method to get the length of the movie
     * Overrides the getLength from VideoMedia to add a Minuets to the end of the length
     * @return String which is the length of the movie plus the work minuets
     */
    @Override
    public String getLength() {
        return super.getLength() + " Minuets";
    }
}
