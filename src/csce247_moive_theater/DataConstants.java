package csce247_moive_theater;

public abstract class DataConstants {
  protected static final String USER_FILE_NAME = "src/users.json";
  protected static final String USER_FIRST_NAME = "firstName";
  protected static final String USER_LAST_NAME = "lastName";
  protected static final String USER_TYPE = "type";
  protected static final String USER_EMAIL = "email";
  protected static final String USER_PHONE_NUMBER = "phoneNumber";
  protected static final String USER_ORDER_HISTORY = "orderHistory";

  protected static final String USER_DATE_OF_BIRTH = "dateOfBirth";
  protected static final String USER_ADDRESS = "address";
  protected static final String USER_USERNAME = "username";
  protected static final String USER_PASSWORD = "password";
  protected static final String USER_IS_MILITARY = "isMilitary";

  protected static final String ORDER_SHOWTIME = "showtime";
  protected static final String ORDER_AMOUNT_PAID = "amountPaid";
  protected static final String ORDER_SEAT_NUMBER = "seatNumber";
  protected static final String ORDER_ORDER_NUMBER = "orderNumber";

  protected static final String EVENT_FILE_NAME = "src/events.json";
  protected static final String EVENT_NAME = "name";
  protected static final String EVENT_REVIEWS = "reviews";
  protected static final String EVENT_RUN_TIME = "runTime";
  protected static final String EVENT_STARS = "stars";
  protected static final String EVENT_GENRE = "genre";
  protected static final String EVENT_DESCRIPTION = "description";
  protected static final String EVENT_TYPE = "type";

  protected static final String MOVIE_MPAA_RATING = "mpaaRating";

  protected static final String VENUE_FILE_NAME = "src/venues.json";
  protected static final String VENUE_NAME = "name";
  protected static final String VENUE_ADDRESS = "address";
  protected static final String VENUE_TYPE = "type";
  protected static final String VENUE_ADULT_TICKET_PRICE = "adultTicketPrice";
  protected static final String VENUE_CHILD_TICKET_PRICE = "childTicketPrice";
  protected static final String VENUE_HANDICAP_TICKET_PRICE = "handicapTicketPrice";
  protected static final String VENUE_AUDITORIUMS = "auditoriums";

  protected static final String AUDITORIUM_NUMBER = "auditoriumNumber";
  protected static final String AUDITORIUM_SEATING_MAP = "seatingMap";

  protected static final String SHOWTIME_FILE_NAME = "src/showtimes.json";
  protected static final String SHOWTIME_VENUE = "venue";
  protected static final String SHOWTIME_EVENT = "event";
  protected static final String SHOWTIME_AVAILABLE_SEATS = "availableSeats";
  protected static final String SHOWTIME_TIME_OF_SHOW = "timeOfShow";
  protected static final String SHOWTIME_AUDITORIUM_NUMBER = "auditoriumNumber";
}
