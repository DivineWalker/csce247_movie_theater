package csce247_moive_theater;

import java.util.ArrayList;

/**
 * 
 * @author brandon Extension of Event to create a Movie listing
 */
public class Movie extends Event {
  private String mpaaRating;


  /**
   * Creates a new Movie listings
   * 
   * @param name - name of the event
   * @param runTime - run time of the event
   * @param stars - actor/performer staring the event
   * @param genre - genre of the event
   * @param description - short description of the event
   * @param mpaaRating - mpaaRating for the Movie
   */
  public Movie(String name, int runTime, String stars, String genre, String description,
      String mpaaRating) {
    super(name, runTime, stars, genre, description);
    this.mpaaRating = mpaaRating;
  }

  /**
   * Creates an existing move from the JSON Loader
   * 
   * @param name - name of the event
   * @param runTime - run time of the event
   * @param stars - actor/performer staring the event
   * @param genre - genre of the event
   * @param description - short description of the event
   * @param mpaaRating - mpaaRating for the Movie
   * @param reviews - reviews of the event
   */
  public Movie(String name, int runTime, String stars, String genre, String description,
      ArrayList<String> reviews, String mpaaRating) {
    super(name, runTime, stars, genre, description, reviews);
    this.mpaaRating = mpaaRating;
  }

  public String getMpaaRating() {
    return mpaaRating;
  }
}
