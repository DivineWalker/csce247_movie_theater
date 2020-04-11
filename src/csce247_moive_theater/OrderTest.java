package csce247_moive_theater;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void testGetSeatNumber() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.getSeatNumber(), "A2");
  }

  @Test
  void testGetAmountPaid() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.getAmountPaid(), 12.99);
  }

  @Test
  void testGetShowtime() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertSame(newOrder.getShowtime(), frozenShow);
  }

  @Test
  void testGetEventName() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.getEventName(), "Frozen 2");
  }

  @Test
  void testGetAuditoriumNumber() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.getAuditoriumNumber(), "0");
  }

  @Test
  void testGetTimeOfShow() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.getTimeOfShow(), "1:00pm");
  }

  @Test
  void testGetVenueName() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.getVenueName(), "USC Theater Co");
  }

  @Test
  void testToString() {
    Event frozen = new Event("Frozen 2", 103, "Elsa", "Family",
        "Elsa the Snow Queen has an extraordinary gift -- the power to create ice and snow. But no matter how happy she is to be surrounded by the people of Arendelle, Elsa finds herself strangely unsettled. After hearing a mysterious voice call out to her, Elsa travels to the enchanted forests and dark seas beyond her kingdom -- an adventure that soon turns into a journey of self-discovery.",
        "movie", "G");

    String[][] map = new String[5][5];
    Venue theater =
        new Venue("USC Theater Co", "1400 Greene St", "Movie Theater", 12.99, 5.99, 12.99, map, 1);

    Showtime frozenShow = new Showtime(theater, frozen, "0", "1:00pm");

    Order newOrder = new Order(frozenShow, 12.99, "A2");

    assertEquals(newOrder.toString(),
        "Order #: " + newOrder.getOrderNumber() + "            " + "$" + newOrder.getAmountPaid());
  }

}
