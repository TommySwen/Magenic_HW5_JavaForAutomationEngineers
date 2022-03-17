package models;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovieStoreTest {

    @Test
    public void testAddRemoveMovieShowToDatabase() {
        MovieDatabase md = new MovieDatabase();
        md.addMovie(new Movie("It","192", true));
        Assert.assertTrue(md.contains("It"));
        md.removeMovie("It");
        Assert.assertFalse(md.contains("It"));
    }

    @Test
    public void testAddToCart(){
        MovieStore ms = new MovieStore();
        Movie mv = new Movie("It","192", true);
        ms.addToCart(mv);
        VideoMedia mvBack = (VideoMedia) ms.getCart().get(0);
        Assert.assertTrue(mvBack.equals(mv));
    }

    @Test
    public void testRemoveFromCart(){
        MovieStore ms = new MovieStore();
        Movie mv = new Movie("It","192", true);
        ms.addToCart(mv);
        assertTrue(ms.getCart().contains(mv));
        ms.removeFromCart(0);
        assertFalse(ms.getCart().contains(mv));
    }

    @Test
    public void TestSearch(){
        MovieStore ms = new MovieStore();
        Movie movie = new Movie("Pirates of the Caribbean: At Worlds End", "170", true);
        ms.db.addMovie(movie);
        Assert.assertTrue(ms.search("Pirates of the Caribbean: At Worlds End"));
    }

    @Test
    public void TestRandom(){
        MovieStore ms = new MovieStore();
        Movie movie1 = new Movie("Pirates of the Caribbean: At Worlds End", "170", true);
        Assert.assertTrue(null == ms.db.random());
        ms.db.addMovie(movie1);
        Assert.assertTrue(movie1 == ms.db.random());

        Movie movie2 = new Movie("Pirates of the Caribbean: At Worlds End2", "170", true);
        Movie movie3 = new Movie("Pirates of the Caribbean: At Worlds End3", "170", true);
        Movie movie4 = new Movie("Pirates of the Caribbean: At Worlds End4", "170", true);
        ms.db.addMovie(movie2);
        ms.db.addMovie(movie3);
        ms.db.addMovie(movie4);

        Assert.assertTrue(movie2 == ms.db.random(100));
        Assert.assertTrue(movie3 == ms.db.random(9));
        Assert.assertTrue(movie2 == ms.db.random(40));
        Assert.assertTrue(movie4 == ms.db.random(293934467));
    }
}