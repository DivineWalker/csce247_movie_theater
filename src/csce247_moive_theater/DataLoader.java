package csce247_moive_theater;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Reads all the system data back into the program from JSON Files
 * 
 * @author Christopher Moyer
 *
 */
public class DataLoader extends DataConstants {

  /**
   * Loads all users from the users.json file and returns them in an array list
   * 
   * @return An array list of users in the json file
   */
  public static ArrayList<User> loadUsers() {
    ArrayList<User> users = new ArrayList<User>();

    try {
      FileReader reader = new FileReader(USER_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray usersJSON = (JSONArray) new JSONParser().parse(reader);

      for (int i = 0; i < usersJSON.size(); ++i) {
        JSONObject userDetails = (JSONObject) usersJSON.get(i);
        String firstName = (String) userDetails.get(USER_FIRST_NAME);
        String lastName = (String) userDetails.get(USER_LAST_NAME);
        String type = (String) userDetails.get(USER_TYPE);
        String email = (String) userDetails.get(USER_EMAIL);
        String phoneNumber = (String) userDetails.get(USER_PHONE_NUMBER);

        JSONArray userOrderHistory = (JSONArray) userDetails.get(USER_ORDER_HISTORY);
        ArrayList<Order> orderHistory = new ArrayList<Order>();
        for (int j = 0; i < userOrderHistory.size(); ++i) {
          JSONObject orderDetails = (JSONObject) userOrderHistory.get(i);
          double amountPaid = (double) orderDetails.get(ORDER_AMOUNT_PAID);
          String seatNumber = (String) orderDetails.get(ORDER_SEAT_NUMBER);
          String orderNumber = (String) orderDetails.get(ORDER_ORDER_NUMBER);
        }

        if (type.equals("guest")) {
          User newUser = new User(firstName, lastName, email, phoneNumber, orderHistory);
          users.add(newUser);
        } else if (type.equals("registered")) {
          String dateOfBirth = (String) userDetails.get(USER_DATE_OF_BIRTH);
          String address = (String) userDetails.get(USER_ADDRESS);
          String username = (String) userDetails.get(USER_USERNAME);
          String password = (String) userDetails.get(USER_PASSWORD);
          boolean isMilitary = (boolean) userDetails.get(USER_IS_MILITARY);
          RegisteredUser newRegisteredUser = new RegisteredUser(firstName, lastName, email,
              phoneNumber, orderHistory, dateOfBirth, address, username, password, isMilitary);
          users.add(newRegisteredUser);
        }
      }
      return users;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  /**
   * Loads all events from the events.json file and returns them in an array list
   * 
   * @return An array list of events in the json file
   */
  public static ArrayList<Event> loadEvents() {
    try {
      FileReader reader = new FileReader(EVENT_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray eventsJSON = (JSONArray) new JSONParser().parse(reader);
      ArrayList<Event> events = new ArrayList<Event>();
      for (int i = 0; i < eventsJSON.size(); ++i) {
        JSONObject eventDetails = (JSONObject) eventsJSON.get(i);
        events.add(getEventData(eventDetails));
      }
      return events;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Turn the event JSONObject back into an event class
   * 
   * @param eventDetails A JSONObject of an event
   * @return A fully constructed event class
   */
  private static Event getEventData(JSONObject eventDetails) {
    String name = (String) eventDetails.get(EVENT_NAME);
    int runTime = (int) eventDetails.get(EVENT_RUN_TIME);
    String stars = (String) eventDetails.get(EVENT_STARS);
    String genre = (String) eventDetails.get(EVENT_GENRE);
    String description = (String) eventDetails.get(EVENT_DESCRIPTION);
    String type = (String) eventDetails.get(EVENT_TYPE);
    String rating = (String) eventDetails.get(EVENT_RATING);

    JSONArray jsonReviews = (JSONArray) eventDetails.get(EVENT_REVIEWS);
    ArrayList<String> reviews = getReviewData(jsonReviews);

    return new Event(name, runTime, stars, genre, description, type, rating, reviews);
  }

  /**
   * Turn the JSONArray of reviews back into an Array List of strings
   * 
   * @param jsonReviews a JSONArray of reviews
   * @return A string ArrayList of reviews
   */
  private static final ArrayList<String> getReviewData(JSONArray jsonReviews) {
    ArrayList<String> reviews = new ArrayList<String>();

    for (int i = 0; i < jsonReviews.size(); ++i) {
      JSONObject reviewDetails = (JSONObject) jsonReviews.get(i);
      String review = (String) reviewDetails.get("EVENT_REVIEW");
      reviews.add(review);
    }
    return reviews;
  }

  /**
   * Loads all venues from the venues.json file and returns them in an array list
   * 
   * @return An array list of venues in the json file
   */
  public static ArrayList<Venue> loadVenues() {
    try {
      FileReader reader = new FileReader(VENUE_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray venuesJSON = (JSONArray) new JSONParser().parse(reader);
      ArrayList<Venue> venues = new ArrayList<Venue>();
      for (int i = 0; i < venuesJSON.size(); ++i) {
        JSONObject venueDetails = (JSONObject) venuesJSON.get(i);
        venues.add(getVenueData(venueDetails));
      }
      return venues;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Turn the venue JSONObject back into an venue class
   * 
   * @param venueDetails A JSONObject of a venue
   * @return A fully constructed venue
   */
  private static Venue getVenueData(JSONObject venueDetails) {
    String name = (String) venueDetails.get(VENUE_NAME);
    String address = (String) venueDetails.get(VENUE_ADDRESS);
    String type = (String) venueDetails.get(VENUE_TYPE);
    double adultTicketPrice = (double) venueDetails.get(VENUE_ADULT_TICKET_PRICE);
    double childTicketPrice = (double) venueDetails.get(VENUE_CHILD_TICKET_PRICE);
    double handicapTicketPrice = (double) venueDetails.get(VENUE_HANDICAP_TICKET_PRICE);

    JSONArray auditoriumsJSON = (JSONArray) venueDetails.get(VENUE_AUDITORIUMS);
    ArrayList<Auditorium> auditoriums = new ArrayList<Auditorium>();
    for (int i = 0; i < auditoriumsJSON.size(); ++i) {
      JSONObject auditoriumDetails = (JSONObject) auditoriumsJSON.get(i);
      auditoriums.add(getAuditoriumData(auditoriumDetails));
    }

    System.out.println(name + " " + address + " " + type + " " + adultTicketPrice + " "
        + childTicketPrice + " " + handicapTicketPrice);
    for (int i = 0; i < auditoriums.size(); ++i) {
      auditoriums.get(i).getSeatingLayout();
      String[][] layout = auditoriums.get(i).getSeatingMap();

      for (String[] row : layout) {
        for (String column : row) {
          System.out.print(column + " ");
        }
        System.out.println();
      }

    }
    return new Venue(name, address, type, adultTicketPrice, childTicketPrice, handicapTicketPrice,
        auditoriums);
  }

  /**
   * Turns a JSONObject of an auditorium back into an auditorium class
   * 
   * @param auditoriumDetails A JSONObject of an auditorium
   * @return A fully constructed auditorium
   */
  private static Auditorium getAuditoriumData(JSONObject auditoriumDetails) {
    String auditoriumNumber = (String) auditoriumDetails.get(AUDITORIUM_NUMBER);
    JSONArray seatingRows = (JSONArray) auditoriumDetails.get(AUDITORIUM_SEATING_MAP);
    JSONArray seatingColumns = (JSONArray) seatingRows.get(0);

    String[][] seatingMap = convertSeatingLayout(seatingRows, seatingColumns);
    return new Auditorium(auditoriumNumber, seatingMap);
  }

  /**
   * Turns the double JSONArray back into double array of Strings
   * 
   * @param seatingRows first dimension of the JSONArray
   * @param seatingColumns second dimension of the JSONArray
   * @return A fully filled seating layout
   */
  private static String[][] convertSeatingLayout(JSONArray seatingRows, JSONArray seatingColumns) {
    String[][] seatingMap = new String[seatingRows.size()][seatingColumns.size()];
    for (int i = 0; i < seatingRows.size(); ++i) {
      seatingColumns = (JSONArray) seatingRows.get(i);
      for (int j = 0; j < seatingColumns.size(); ++j) {
        seatingMap[i][j] = (String) seatingColumns.get(i);
      }
    }
    return seatingMap;
  }

  /**
   * Loads all showtimes from the showtimes.json file and returns them in an array list
   * 
   * @return An array list of all showtimes in the json file
   */
  public static ArrayList<Showtime> loadShowtimes() {
    try {
      FileReader reader = new FileReader(SHOWTIME_FILE_NAME);
      JSONArray showtimesJSON = (JSONArray) new JSONParser().parse(reader);
      ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
      for (int i = 0; i < showtimesJSON.size(); ++i) {
        JSONObject showtimeDetails = (JSONObject) showtimesJSON.get(i);
        showtimes.add(getShowtimeData(showtimeDetails));
      }
      return showtimes;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Turns a showtime JSONObject back into a Showtime class
   * 
   * @param showtimeDetails A showtime JSONObject
   * @return a fully constructed Showtime class
   */
  private static Showtime getShowtimeData(JSONObject showtimeDetails) {
    Venue venue = getVenueData((JSONObject) showtimeDetails.get(SHOWTIME_VENUE));
    Event event = getEventData((JSONObject) showtimeDetails.get(SHOWTIME_EVENT));
    JSONArray seatingRows = (JSONArray) showtimeDetails.get(SHOWTIME_AVAILABLE_SEATS);
    JSONArray seatingColumns = (JSONArray) seatingRows.get(0);
    String[][] seatingMap = convertSeatingLayout(seatingRows, seatingColumns);
    String timeOfShow = (String) showtimeDetails.get(SHOWTIME_TIME_OF_SHOW);
    String auditoriumNumber = (String) showtimeDetails.get(SHOWTIME_AUDITORIUM_NUMBER);

    return new Showtime(venue, event, seatingMap, timeOfShow, auditoriumNumber);
  }
}
