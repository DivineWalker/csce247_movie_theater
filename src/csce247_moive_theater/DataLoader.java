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
      }
      return users;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

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

  private static final Event getEventData(JSONObject eventDetails) {
    String name = (String) eventDetails.get(EVENT_NAME);
    int runTime = (int) eventDetails.get(EVENT_RUN_TIME);
    String stars = (String) eventDetails.get(EVENT_STARS);
    String genre = (String) eventDetails.get(EVENT_GENRE);
    String description = (String) eventDetails.get(EVENT_DESCRIPTION);
    String type = (String) eventDetails.get(EVENT_TYPE);

    JSONArray jsonReviews = (JSONArray) eventDetails.get(EVENT_REVIEWS);
    ArrayList<String> reviews = getReviewData(jsonReviews);

    if (type.equals("movie")) {
      String mpaaRating = (String) eventDetails.get(MOVIE_MPAA_RATING);
      Movie newMovie = new Movie(name, runTime, stars, genre, description, reviews, mpaaRating);
      return newMovie;
    } else if (type.equals("play")) {
      Play newPlay = new Play(name, runTime, stars, genre, description, reviews);
      return newPlay;
    } else if (type.equals("concert")) {
      Concert newConcert = new Concert(name, runTime, stars, genre, description, reviews);
      return newConcert;
    } else {
      return null;
    }
  }

  private static final ArrayList<String> getReviewData(JSONArray jsonReviews) {
    ArrayList<String> reviews = new ArrayList<String>();

    for (int i = 0; i < jsonReviews.size(); ++i) {
      JSONObject reviewDetails = (JSONObject) jsonReviews.get(i);
      String review = (String) reviewDetails.get("EVENT_REVIEW");
      reviews.add(review);
    }
    return reviews;
  }

  public static final ArrayList<Venue> loadVenues() {
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

  private static Auditorium getAuditoriumData(JSONObject auditoriumDetails) {
    String auditoriumNumber = (String) auditoriumDetails.get(AUDITORIUM_NUMBER);
    JSONArray seatingRows = (JSONArray) auditoriumDetails.get(AUDITORIUM_SEATING_MAP);
    JSONArray seatingColumns = (JSONArray) seatingRows.get(0);

    String[][] seatingMap = convertSeatingLayout(seatingRows, seatingColumns);
    return new Auditorium(auditoriumNumber, seatingMap);
  }

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

  public static final ArrayList<Showtime> loadShowtimes() {
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