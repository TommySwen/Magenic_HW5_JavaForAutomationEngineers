package models;

import java.util.*;

public class MovieDatabase {

    /**
     * Hash map which holds all movies in the database
     */
    private HashMap<String,VideoMedia> movies;

    /**
     * creates an instance of the MovieDatabase
     */
    public MovieDatabase(){
        movies = new HashMap<String, VideoMedia>();
    }

    /**
     * Adds a movie to the movie database
     * @param movie
     */
    public void addMovie(VideoMedia movie){
        this.movies.put(movie.getTitle(), movie);
    }

    /**
     * Method to determine if the movie database contains a movie with a given title
     * @param title Title of the movie to check in map
     * @return true or false if the map contains the given title
     */
    public boolean contains(String title){
        return movies.containsKey(title);
    }

    /**
     * Gets a movie from the map when given a title as the key
     * @param title Title of the movie to check if is in the map
     * @return the VideoMedia if it is in the map otherwise return null
     */
    public VideoMedia getMedia(String title){
        if(movies.containsKey(title)){
            return movies.get(title);
        }
        else{
            return null;
        }
    }

    /**
     * Remove the movie if it is in the map
     * @param title The title of the movie to remove from the map
     */
    public void removeMovie(String title){
        if (movies.containsKey(title)){
            movies.remove(title);
        }
    }

    /**
     * Creates a Random object with a given seed then calls the doRandom with that Random object
     * @param seed int to serve as the seed for the Random function
     * @return the VideoMedia returned from doRandom
     */
    public VideoMedia random(int seed){
        Random rand = new Random(seed);
        return doRandom(rand);
    }

    /**
     * Creates a Random object without a seed then calls doRandom with that Random object
     * @return the VideoMedia returned from doRandom
     */
    public VideoMedia random(){
        Random rand = new Random();
        return doRandom(rand);
    }

    /**
     * Generates a random number and loops through the map using an iterator until that number is reached
     * @param rand The Random object to be used to generate the random number
     * @return A Random VideoMedia from the Map
     */
    private VideoMedia doRandom(Random rand){
        int len = movies.size();
        Iterator iterator = movies.keySet().iterator();
        int i = 0;
        while (iterator.hasNext() && i < rand.nextInt(len)){
            i++;
            iterator.next();
        }
        if(iterator.hasNext()){
            return movies.get(iterator.next());
        }
        else {
            return null;
        }

    }
}
