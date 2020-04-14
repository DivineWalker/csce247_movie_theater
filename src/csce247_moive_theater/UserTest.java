package csce247_moive_theater;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");

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
  }

  @Test
  void testAddingTicketToOrderHistory() {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");

    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    johnSmith.purchaseTicket(frozenShow, "A5", 12.99);

    assertEquals("Order in orderHistory should match",
        johnSmith.getOrderHistory().get(0).getEventName(), "Frozen 2");
  }


  @Test
  void testGetFirstName() {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");
    assertEquals("First Name Equals", johnSmith.getFirstName(), "John");
  }

  @Test
  void testGetLastName() {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");
    assertEquals("Last Name Equals", johnSmith.getLastName(), "Smith");
  }

  @Test
  void testGetType() {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");
    assertEquals("CheckType", johnSmith.getType(), "guest");
  }

  @Test
  void testGetEmail() {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");
    assertEquals("Check email", johnSmith.getEmail(), "jsmith@gmail.com");
  }

  @Test
  void testGetPhoneNumber() {
    User johnSmith = new User("John", "Smith", "jsmith@gmail.com", "123-456-7890");
    assertEquals("Check phone number", johnSmith.getPhoneNumber(), "123-456-7890");
  }

}
