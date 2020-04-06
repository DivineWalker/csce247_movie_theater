package csce247_moive_theater;

import java.util.ArrayList;

/**
 * 
 * @author brandon Base Event type, will be extended by different event types: Movie, Play, and
 *         Concert
 */
public abstract class Event {
  protected String name;
  protected ArrayList<String> reviews;
  protected int runTime;
  protected String stars;
  protected String genre;
  protected String description;


  /**
   * 
   * @param name - name of the event
   * @param runTime - run time of the event
   * @param stars - actor/performer staring the event
   * @param genre - genre of the event
   * @param description - short description of the event
   */
  public Event(String name, int runTime, String stars, String genre, String description) {
    this.name = name;
    this.runTime = runTime;
    this.stars = stars;
    this.genre = genre;
    this.description = description;
    this.reviews = new ArrayList<>();
  }

  /**
   * Construct an existing event from the JSON Loader
   * 
   * @param name - name of the event
   * @param runTime - run time of the event
   * @param stars - actor/performer staring the event
   * @param genre - genre of the event
   * @param description - short description of the event
   * @param reviews - reviews of the event
   */
  public Event(String name, int runTime, String stars, String genre, String description,
      ArrayList<String> reviews) {
    this.name = name;
    this.runTime = runTime;
    this.stars = stars;
    this.genre = genre;
    this.description = description;
    this.reviews = reviews;
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<String> getReviews() {
    return reviews;
  }

  public int getRunTime() {
    return runTime;
  }

  public String getStars() {
    return stars;
  }

  public String getGenre() {
    return genre;
  }

  public String getDescription() {
    return description;
  }
}
