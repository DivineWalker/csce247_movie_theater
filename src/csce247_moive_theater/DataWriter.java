package csce247_moive_theater;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Writes all the system data back into the program from JSON Files
 * 
 * @author Christopher Moyer
 *
 */
public class DataWriter extends DataConstants {

  /**
   * Save the given users array list to a json file
   * 
   * @param users array list of users
   */
  public static void saveUsers(ArrayList<User> users) {
    JSONArray jsonUsers = new JSONArray();

    for (int i = 0; i < users.size(); ++i) {
      jsonUsers.add(getUserJSON(users.get(i)));
    }

    try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
      file.write(jsonUsers.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Turn the user class into JSON
   * 
   * @param user the user to be converted
   * @return a JSONObject of a user
   */
  private static JSONObject getUserJSON(User user) {
    JSONObject userDetails = new JSONObject();
    userDetails.put(USER_FIRST_NAME, user.getFirstName());
    userDetails.put(USER_LAST_NAME, user.getLastName());
    userDetails.put(USER_TYPE, user.getType());
    userDetails.put(USER_EMAIL, user.getEmail());
    userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
    userDetails.put(USER_ORDER_HISTORY, saveOrderHistory(user.getOrderHistory()));

    if (user.getType().equals("registered")) {
      userDetails = getRegisteredUserJSON((RegisteredUser) user, userDetails);
    }

    return userDetails;
  }

  /**
   * Turn the RegisteredUser details in JSON
   * 
   * @param user the registered user
   * @param userDetails the JSON user details
   * @return returns the registered user JSON data
   */
  private static JSONObject getRegisteredUserJSON(RegisteredUser user, JSONObject userDetails) {
    userDetails.put(USER_DATE_OF_BIRTH, user.getDateOfBirth());
    userDetails.put(USER_ADDRESS, user.getAddress());
    userDetails.put(USER_USERNAME, user.getUsername());
    userDetails.put(USER_PASSWORD, user.getPassword());
    userDetails.put(USER_IS_MILITARY, user.isMilitary());

    return userDetails;
  }

  /**
   * Turns the orderHistory array list into a JSONArray
   * 
   * @param orderHistory array list of a users order history
   * @return a JSONArray of a users order history
   */
  private static JSONArray saveOrderHistory(ArrayList<Order> orderHistory) {
    JSONArray userOrderHistory = new JSONArray();

    for (int i = 0; i < orderHistory.size(); ++i) {
      userOrderHistory.add(getOrderHistoryJSON(orderHistory.get(i)));
    }

    return userOrderHistory;
  }

  /**
   * Turn the order details into JSON
   * 
   * @param order the order to be converted
   * @return a JSONObject of an order
   */
  private static JSONObject getOrderHistoryJSON(Order order) {
    JSONObject orderHistoryDetails = new JSONObject();

    orderHistoryDetails.put(ORDER_SHOWTIME, getShowtimeJSON(order.getShowtime()));
    orderHistoryDetails.put(ORDER_AMOUNT_PAID, order.getAmountPaid());
    orderHistoryDetails.put(ORDER_SEAT_NUMBER, order.getSeatNumber());
    orderHistoryDetails.put(ORDER_ORDER_NUMBER, order.getOrderNumber());

    return orderHistoryDetails;
  }

  /**
   * Saves the given events array list to a json file
   * 
   * @param events array list of events
   */
  public static void saveEvents(ArrayList<Event> events) {
    JSONArray jsonEvents = new JSONArray();

    for (int i = 0; i < events.size(); ++i) {
      jsonEvents.add(getEventJSON(events.get(i)));
    }

    try (FileWriter file = new FileWriter(EVENT_FILE_NAME)) {
      file.write(jsonEvents.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Turns an event into JSON
   * 
   * @param event event to be converted
   * @return JSONObject of an event
   */
  private static JSONObject getEventJSON(Event event) {
    JSONObject eventDetails = new JSONObject();

    eventDetails.put(EVENT_NAME, event.getName());
    eventDetails.put(EVENT_REVIEWS, saveEventReviews(event.getReviews()));
    eventDetails.put(EVENT_RUN_TIME, event.getRunTime());
    eventDetails.put(EVENT_STARS, event.getStars());
    eventDetails.put(EVENT_GENRE, event.getGenre());
    eventDetails.put(EVENT_DESCRIPTION, event.getDescription());
    eventDetails.put(EVENT_TYPE, event.getType());

    if (event.getType().equals("movie")) {
      eventDetails = getMovieJSON((Movie) event, eventDetails);
    }

    return eventDetails;
  }

  private static JSONObject getMovieJSON(Movie movie, JSONObject eventDetails) {
    eventDetails.put(MOVIE_MPAA_RATING, movie.getMpaaRating());
    return eventDetails;
  }

  /**
   * Turns an array list of reviews into a JSONArray
   * 
   * @param reviews array list to be converted
   * @return JSONArray of reviews
   */
  private static JSONArray saveEventReviews(ArrayList<String> reviews) {
    JSONArray jsonReviews = new JSONArray();

    for (int i = 0; i < reviews.size(); ++i) {
      jsonReviews.add(getEventReviewJSON(reviews.get(i)));
    }

    return jsonReviews;
  }

  /**
   * Turns a single string into a JSONObject
   * 
   * @param review string to be converted
   * @return a JSONObject of a string
   */
  private static JSONObject getEventReviewJSON(String review) {
    JSONObject reviewDetails = new JSONObject();

    reviewDetails.put("EVENT_REVIEW", review);

    return reviewDetails;
  }

  /**
   * Saves the given venues array list to a json file
   * 
   * @param venues array list of venues
   */
  public static void saveVenues(ArrayList<Venue> venues) {
    // ArrayList<Venue> venues = manager.getVenues();
    JSONArray jsonVenues = new JSONArray();

    for (int i = 0; i < venues.size(); ++i) {
      jsonVenues.add(getVenueJSON(venues.get(i)));
    }

    try (FileWriter file = new FileWriter(VENUE_FILE_NAME)) {
      file.write(jsonVenues.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Turn a venue into JSON
   * 
   * @param venue venue to be converted
   * @return a JSONObject of a venue
   */
  private static JSONObject getVenueJSON(Venue venue) {
    JSONObject venueDetails = new JSONObject();

    venueDetails.put(VENUE_NAME, venue.getName());
    venueDetails.put(VENUE_ADDRESS, venue.getAddress());
    venueDetails.put(VENUE_TYPE, venue.getType());
    venueDetails.put(VENUE_ADULT_TICKET_PRICE, venue.getAdultTicketPrice());
    venueDetails.put(VENUE_CHILD_TICKET_PRICE, venue.getChildTicketPrice());
    venueDetails.put(VENUE_HANDICAP_TICKET_PRICE, venue.getHandicapTicketPrice());
    venueDetails.put(VENUE_AUDITORIUMS, saveVenueAuditoriums(venue.getAuditoriumList()));

    return venueDetails;
  }

  /**
   * Turns an array list of auditoriums into a JSONArray
   * 
   * @param auditoriums array list of auditoriums
   * @return JSONArray of auditoriums
   */
  private static JSONArray saveVenueAuditoriums(ArrayList<Auditorium> auditoriums) {
    JSONArray jsonAuditoriums = new JSONArray();

    for (int i = 0; i < auditoriums.size(); ++i) {
      jsonAuditoriums.add(getAuditoriumJSON(auditoriums.get(i)));
    }

    return jsonAuditoriums;
  }

  /**
   * Turns an auditorium into JSON
   * 
   * @param auditorium auditorium to be converted
   * @return a JSONObject of an auditroium
   */
  private static JSONObject getAuditoriumJSON(Auditorium auditorium) {
    JSONObject auditoriumDetails = new JSONObject();
    JSONArray seatingArray = convertSeatingArray(auditorium.getSeatingMap());
    auditoriumDetails.put(AUDITORIUM_NUMBER, auditorium.getAuditoriumNumber());
    auditoriumDetails.put(AUDITORIUM_SEATING_MAP, seatingArray);

    return auditoriumDetails;
  }

  /**
   * Turn the seating maps string double array into a json double array
   * 
   * @param seatingMap the map of seats
   * @return a double json array of seats
   */
  private static JSONArray convertSeatingArray(String[][] seatingMap) {
    JSONArray seatingArray = new JSONArray();

    for (String[] row : seatingMap) {
      JSONArray seatingColumnArray = new JSONArray();
      for (String column : row) {
        seatingColumnArray.add(column);
      }
      seatingArray.add(seatingColumnArray);
    }

    return seatingArray;
  }

  /**
   * Saves the given showtimes array list to a json file
   * 
   * @param showtimes array list of showtimes
   */
  public static void saveShowtimes(ArrayList<Showtime> showtimes) {
    JSONArray jsonShowtimes = new JSONArray();

    for (int i = 0; i < showtimes.size(); ++i) {
      jsonShowtimes.add(getShowtimeJSON(showtimes.get(i)));
    }

    try (FileWriter file = new FileWriter(SHOWTIME_FILE_NAME)) {
      file.write(jsonShowtimes.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Turns the showtime into json
   * 
   * @param showtime showtime to be converted
   * @return a JSONObject of a showtime
   */
  private static JSONObject getShowtimeJSON(Showtime showtime) {
    JSONObject showtimeDetails = new JSONObject();

    showtimeDetails.put(SHOWTIME_VENUE, getVenueJSON(showtime.getVenue()));
    showtimeDetails.put(SHOWTIME_EVENT, getEventJSON(showtime.getEvent()));
    showtimeDetails.put(SHOWTIME_AVAILABLE_SEATS,
        convertSeatingArray(showtime.getAvailableSeats()));
    showtimeDetails.put(SHOWTIME_TIME_OF_SHOW, showtime.getTimeOfShow());
    showtimeDetails.put(SHOWTIME_AUDITORIUM_NUMBER, showtime.getAuditoriumNumber());

    return showtimeDetails;
  }
}
