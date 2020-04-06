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

  //Changed method so that it will fill the seatingMap with As instead of print a blank seating map
  public void getSeatingLayout() {
    for (int i = 0; i < seatingMap.length; i++)
      for (int j = 0; j < seatingMap[i].length; j++)
        seatingMap[i][j] = "A";
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
