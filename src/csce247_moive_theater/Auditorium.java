package csce247_moive_theater;

/**
 * @author Divine Walker
 * @since
 * @version 1.0
 */
public class Auditorium {
  private String auditoriumNumber;
  private String[][] seatingMap;

  /**
   * 
   * @param auditoriumNumber name of the auditorium
   * @param seatingMap       seating map of auditorium
   */
  public Auditorium(String auditoriumNumber, String[][] seatingMap) {
    this.auditoriumNumber = auditoriumNumber;
    this.seatingMap = seatingMap;

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
   * @return seating map
   */
  public String[][] getSeatingMap() {
    return this.seatingMap;
  }
}
