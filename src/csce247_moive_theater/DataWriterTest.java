package csce247_moive_theater;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest extends DataConstants {

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    User newUser = new User("John", "Smith", "abc123@email.com", "123-456-7890");
    User registeredUser = new RegisteredUser("Jane", "Doe", "jdoe@gmail.com", "555-555-5555",
        "05/05/1962", "556 Wayland St", "jdoe56", "12345", false);

    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");
    Event jungleBook = new Event("The Jungle Book", 111, "Phil Harris", "Adventure",
        "Raised by a family of wolves since birth, Mowgli (Neel Sethi) must leave the only home he's ever known when the fearsome tiger Shere Khan (Idris Elba) unleashes his mighty roar. Guided by a no-nonsense panther (Ben Kingsley) and a free-spirited bear (Bill Murray), the young boy meets an array of jungle animals, including a slithery python and a smooth-talking ape. Along the way, Mowgli learns valuable life lessons as his epic journey of self-discovery leads to fun and adventure",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);
    Venue playHouse =
        new Venue("PlaysRUs", "223 Gervais St", "Play House", 10.00, 5.00, 10.00, map, 1);

    Showtime jungleBookShow = new Showtime(theater, jungleBook, "0", "11:00am");
    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Venue> venues = new ArrayList<Venue>();
    ArrayList<Event> events = new ArrayList<Event>();
    ArrayList<Showtime> showtimes = new ArrayList<Showtime>();

    newUser.purchaseTicket(jungleBookShow, "A2", 12.99);
    newUser.purchaseTicket(frozenShow, "G20", 5.99);
    users.add(newUser);
    users.add(registeredUser);
    venues.add(theater);
    venues.add(playHouse);
    events.add(jungleBook);
    events.add(frozen);
    showtimes.add(jungleBookShow);
    showtimes.add(frozenShow);

    DataWriter jsonWriter = new DataWriter();

    jsonWriter.saveUsers(users);
    jsonWriter.saveEvents(events);
    jsonWriter.saveVenues(venues);
    jsonWriter.saveShowtimes(showtimes);
  }

  @BeforeEach
  void setUp() throws Exception {
    File usersJSON = new File(USER_FILE_NAME);
    File eventsJSON = new File(EVENT_FILE_NAME);
    File venuesJSON = new File(VENUE_FILE_NAME);
    File showtimeJSON = new File(SHOWTIME_FILE_NAME);

    usersJSON.delete();
    eventsJSON.delete();
    venuesJSON.delete();
    showtimeJSON.delete();
  }

  @Test
  void testSaveUsers() {
    User newUser = new User("John", "Smith", "abc123@email.com", "123-456-7890");
    User registeredUser = new RegisteredUser("Jane", "Doe", "jdoe@gmail.com", "555-555-5555",
        "05/05/1962", "556 Wayland St", "jdoe56", "12345", false);

    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");
    Event jungleBook = new Event("The Jungle Book", 111, "Phil Harris", "Adventure",
        "Raised by a family of wolves since birth, Mowgli (Neel Sethi) must leave the only home he's ever known when the fearsome tiger Shere Khan (Idris Elba) unleashes his mighty roar. Guided by a no-nonsense panther (Ben Kingsley) and a free-spirited bear (Bill Murray), the young boy meets an array of jungle animals, including a slithery python and a smooth-talking ape. Along the way, Mowgli learns valuable life lessons as his epic journey of self-discovery leads to fun and adventure",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);
    Venue playHouse =
        new Venue("PlaysRUs", "223 Gervais St", "Play House", 10.00, 5.00, 10.00, map, 1);

    Showtime jungleBookShow = new Showtime(theater, jungleBook, "0", "11:00am");
    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Venue> venues = new ArrayList<Venue>();
    ArrayList<Event> events = new ArrayList<Event>();
    ArrayList<Showtime> showtimes = new ArrayList<Showtime>();

    newUser.purchaseTicket(jungleBookShow, "A2", 12.99);
    newUser.purchaseTicket(frozenShow, "G20", 5.99);
    users.add(newUser);
    users.add(registeredUser);
    venues.add(theater);
    venues.add(playHouse);
    events.add(jungleBook);
    events.add(frozen);
    showtimes.add(jungleBookShow);
    showtimes.add(frozenShow);

    DataWriter writer = new DataWriter();

    writer.saveUsers(users);

    DataLoader loader = new DataLoader();
    ArrayList<User> usersFromJSON = loader.loadUsers();

    assertEquals(users.get(0).getFirstName(), usersFromJSON.get(0).getFirstName());
  }

  @Test
  void testSaveEvents() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");
    Event jungleBook = new Event("The Jungle Book", 111, "Phil Harris", "Adventure",
        "Raised by a family of wolves since birth, Mowgli (Neel Sethi) must leave the only home he's ever known when the fearsome tiger Shere Khan (Idris Elba) unleashes his mighty roar. Guided by a no-nonsense panther (Ben Kingsley) and a free-spirited bear (Bill Murray), the young boy meets an array of jungle animals, including a slithery python and a smooth-talking ape. Along the way, Mowgli learns valuable life lessons as his epic journey of self-discovery leads to fun and adventure",
        "movie", "G");

    ArrayList<Event> events = new ArrayList<Event>();

    events.add(jungleBook);
    events.add(frozen);


    DataWriter writer = new DataWriter();
    writer.saveEvents(events);

    DataLoader loader = new DataLoader();
    ArrayList<Event> eventsFromJSON = loader.loadEvents();

    assertEquals(events.get(0).getName(), eventsFromJSON.get(0).getName());
  }

  @Test
  void testSaveVenues() {
    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);
    Venue playHouse =
        new Venue("PlaysRUs", "223 Gervais St", "Play House", 10.00, 5.00, 10.00, map, 1);

    ArrayList<Venue> venues = new ArrayList<Venue>();

    venues.add(theater);
    venues.add(playHouse);

    DataWriter writer = new DataWriter();
    writer.saveVenues(venues);

    DataLoader loader = new DataLoader();
    ArrayList<Venue> venuesFromJSON = loader.loadVenues();

    assertEquals(venues.get(0).getName(), venuesFromJSON.get(0).getName());
  }

  @Test
  void testSaveShowtimes() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");
    Event jungleBook = new Event("The Jungle Book", 111, "Phil Harris", "Adventure",
        "Raised by a family of wolves since birth, Mowgli (Neel Sethi) must leave the only home he's ever known when the fearsome tiger Shere Khan (Idris Elba) unleashes his mighty roar. Guided by a no-nonsense panther (Ben Kingsley) and a free-spirited bear (Bill Murray), the young boy meets an array of jungle animals, including a slithery python and a smooth-talking ape. Along the way, Mowgli learns valuable life lessons as his epic journey of self-discovery leads to fun and adventure",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);
    Venue playHouse =
        new Venue("PlaysRUs", "223 Gervais St", "Play House", 10.00, 5.00, 10.00, map, 1);

    Showtime jungleBookShow = new Showtime(theater, jungleBook, "0", "11:00am");
    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    ArrayList<Venue> venues = new ArrayList<Venue>();
    ArrayList<Event> events = new ArrayList<Event>();
    ArrayList<Showtime> showtimes = new ArrayList<Showtime>();

    venues.add(theater);
    venues.add(playHouse);
    events.add(jungleBook);
    events.add(frozen);
    showtimes.add(jungleBookShow);
    showtimes.add(frozenShow);

    DataWriter writer = new DataWriter();
    writer.saveShowtimes(showtimes);

    DataLoader loader = new DataLoader();
    ArrayList<Showtime> showtimesFromJSON = loader.loadShowtimes();

    assertEquals(showtimes.get(0).getEvent().getName(),
        showtimesFromJSON.get(0).getEvent().getName());
  }
}
