package csce247_moive_theater;

/**
 * @author Divine Walker
 * @since
 * @version 1.0
 */
public class Showtime {
  private Venue venue;
  private Event event;
  private String[][] availableSeats;
  private String timeOfShow;
  private String auditoriumNumber;

  /**
   * 
   * @param venue venue that the showtime is being added to
   * @param event what event is happening
   * @param auditoriumNumber which auditorium it will be playing in
   */
  public Showtime(Venue venue, Event event, String auditoriumNumber, String timeOfShow) {
    this.venue = venue;
    this.event = event;
    this.timeOfShow = timeOfShow;
    this.auditoriumNumber = auditoriumNumber;
    this.availableSeats = venue.getAuditorium(auditoriumNumber).getSeatingMap();
  }

  /**
   * Construct an existing showtime from JSON Data
   * 
   * @param venue venue that the showtime is being added to
   * @param event what event is happening
   * @param availableSeats available seats for the show
   * @param timeOfShow time the show will start
   * @param auditoriumNumber which auditorium it will be playing in
   */
  public Showtime(Venue venue, Event event, String[][] availableSeats, String timeOfShow,
      String auditoriumNumber) {
    this.venue = venue;
    this.event = event;
    this.availableSeats = availableSeats;
    this.timeOfShow = timeOfShow;
    this.auditoriumNumber = auditoriumNumber;
  }

  public Venue getVenue() {
    return this.venue;
  }

  /**
   * 
   * @return event
   */
  public Event getEvent() {
    return this.event;
  }

  public String[][] getAvailableSeats() {
    return availableSeats;
  }

  public String getTimeOfShow() {
    return this.timeOfShow;
  }

  /**
   * 
   * @return auditorium number
   */
  public String getAuditoriumNumber() {
    return this.auditoriumNumber;
  }

  /**
   * 
   * @return available seats
   */

  public void showAvailableSeats() {
    for (int i = 0; i < availableSeats.length; i++) {
      for (int j = 0; j < availableSeats[i].length; j++)
        System.out.print("| " + availableSeats[i][j] + " |");
      System.out.println();
    }
    System.out.println();
  }

  /**
   * 
   * @param i seating column
   * @param j seating row
   */
  public void takeSeat(int i, int j) {
    if (availableSeats[i][j] == null)
      availableSeats[i][j] = " ";
    else
      System.out
          .println("The seat in row " + j + ", column " + i + " is already taken. Choose again.");
  }
}
