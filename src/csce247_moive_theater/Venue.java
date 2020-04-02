
/**
 * @author Divine Walker
 * @since 
 * @version 1.0
 */
import java.util.ArrayList;

public class Venue {
    private String name;
    private String address;
    private String type;
    private double adultTicketPrice;
    private double childTicketPrice;
    private double handicapTicketPrice;
    private ArrayList<Auditorium> auditoriums;

    /**
     * 
     * @param name                name of venue
     * @param address             address of venue
     * @param type                type of venue
     * @param adultTicketPrice    price for adult ticket
     * @param childTicketPrice    price for child ticket
     * @param handicapTicketPrice price for handicap ticket
     * @param seatingMap          seating map for the venue
     * @param numberOfAuditoriums number of auditoriums in the venue
     */
    public Venue(String name, String address, String type, double adultTicketPrice, double childTicketPrice,
            double handicapTicketPrice, String[][] seatingMap, int numberOfAuditoriums) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.adultTicketPrice = adultTicketPrice;
        this.childTicketPrice = childTicketPrice;
        this.handicapTicketPrice = handicapTicketPrice;

        auditoriums = new ArrayList<>();

        for (int i = 0; i < numberOfAuditoriums; i++) {
            auditoriums.add(new Auditorium(("" + (i + 1)), seatingMap));
        }
    }

    public void printAuditoriums() {
        for (int i = 0; i < auditoriums.size(); i++)
            System.out.println(auditoriums.get(i).getAuditoriumNumber());
    }

    /**
     * 
     * @param auditoriumNumber
     * @return auditorium
     */
    public Auditorium getAuditorium(String auditoriumNumber) {
        return auditoriums.get(Integer.parseInt(auditoriumNumber));
    }
}