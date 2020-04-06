package csce247_moive_theater;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

  public static void saveUsers(ArrayList<User> users) {
    // ArrayList<User> users = manager.getPeople();
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

  private static JSONArray saveOrderHistory(ArrayList<Order> orderHistory) {
    JSONArray userOrderHistory = new JSONArray();

    for (int i = 0; i < orderHistory.size(); ++i) {
      userOrderHistory.add(getOrderHistoryJSON(orderHistory.get(i)));
    }

    return userOrderHistory;
  }

  private static JSONObject getOrderHistoryJSON(Order order) {
    JSONObject orderHistoryDetails = new JSONObject();

    orderHistoryDetails.put(ORDER_SHOWTIME, getShowtimeJSON(order.getShowtime()));
    orderHistoryDetails.put(ORDER_AMOUNT_PAID, order.getAmountPaid());
    orderHistoryDetails.put(ORDER_SEAT_NUMBER, order.getSeatNumber());
    orderHistoryDetails.put(ORDER_ORDER_NUMBER, order.getOrderNumber());

    return orderHistoryDetails;
  }

  public static void saveEvents(ArrayList<Event> events) {
    // ArrayList<Event> events = manager.getEvents();
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

  private static JSONObject getEventJSON(Event event) {
    JSONObject eventDetails = new JSONObject();

    eventDetails.put(EVENT_NAME, event.getName());
    eventDetails.put(EVENT_REVIEWS, saveEventReviews(event.getReviews()));
    eventDetails.put(EVENT_RUN_TIME, event.getRunTime());
    eventDetails.put(EVENT_STARS, event.getStars());
    eventDetails.put(EVENT_GENRE, event.getGenre());
    eventDetails.put(EVENT_DESCRIPTION, event.getDescription());

    return eventDetails;
  }

  private static JSONArray saveEventReviews(ArrayList<String> reviews) {
    JSONArray jsonReviews = new JSONArray();

    for (int i = 0; i < reviews.size(); ++i) {
      jsonReviews.add(getEventReviewJSON(reviews.get(i)));
    }

    return jsonReviews;
  }

  private static JSONObject getEventReviewJSON(String review) {
    JSONObject reviewDetails = new JSONObject();

    reviewDetails.put("EVENT_REVIEW", review);

    return reviewDetails;
  }

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

  private static JSONArray saveVenueAuditoriums(ArrayList<Auditorium> auditoriums) {
    JSONArray jsonAuditoriums = new JSONArray();

    for (int i = 0; i < auditoriums.size(); ++i) {
      jsonAuditoriums.add(getAuditoriumJSON(auditoriums.get(i)));
    }

    return jsonAuditoriums;
  }

  private static JSONObject getAuditoriumJSON(Auditorium auditorium) {
    JSONObject auditoriumDetails = new JSONObject();
    JSONArray seatingArray = convertSeatingArray(auditorium.getSeatingMap());

    /*
     * for (String[] row : seatingMap) { JSONArray seatingColumnArray = new JSONArray(); for (String
     * column : row) { seatingColumnArray.add(column); } seatingArray.add(seatingColumnArray); }
     */
    auditoriumDetails.put(AUDITORIUM_NUMBER, auditorium.getAuditoriumNumber());
    auditoriumDetails.put(AUDITORIUM_SEATING_MAP, seatingArray);

    return auditoriumDetails;
  }

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
