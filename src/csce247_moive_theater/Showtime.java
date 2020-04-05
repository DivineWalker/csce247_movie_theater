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
  public Showtime(Venue venue, Event event, String auditoriumNumber) {
    this.venue = venue;
    this.event = event;
    this.auditoriumNumber = auditoriumNumber;
    this.availableSeats = venue.getAuditorium(auditoriumNumber).getSeatingMap();
  }

  /**
   * 
   * @return available seats
   */
  public String[][] getAvailableSeats() {
    return availableSeats;
  }

  public void showAvailableSeats() {
    for (int i = 0; i < availableSeats.length; i++) {
      for (int j = 0; j < availableSeats[i].length; j++) {
        System.out.print("| ");
        if (availableSeats[i][j] != null)
          System.out.print(availableSeats[i][j]);
        else
          System.out.print("A");
        System.out.print(" |");
      }
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

  /**
   * 
   * @return event
   */
  public Event getEvent() {
    return this.event;
  }

  /**
   * 
   * @return auditorium number
   */
  public String getAuditoriumNumber() {
    return this.auditoriumNumber;
  }
}
