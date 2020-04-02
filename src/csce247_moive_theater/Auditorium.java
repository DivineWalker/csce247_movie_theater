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
     * @param auditoriumNumber
     * @param seatingMap
     */
    public Auditorium(String auditoriumNumber, String[][] seatingMap) {
        this.auditoriumNumber = auditoriumNumber;
        this.seatingMap = seatingMap;

    }

    public void getSeatingLayout() {
        for (int i = 0; i < seatingMap.length; i++) {
            System.out.println("| ");
            for (int j = 0; j < seatingMap[i].length; j++) {
                System.out.print("  |");
            }
            System.out.println();
        }
        System.out.println();
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