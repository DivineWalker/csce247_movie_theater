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
   * Creates a new Event
   * 
   * @param name - name of the event -
   * 
   */
  public Event(String name, int runTime, String stars, String genre, String description) {
    this.name = name;
    this.runTime = runTime;
    this.stars = stars;
    this.genre = genre;
    this.description = description;
    this.reviews = new ArrayList<>();  
  }

  public String getName() {
    return this.name;
  }
}
