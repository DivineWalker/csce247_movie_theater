/**
 * @author Chen
 */
package csce247_moive_theater;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheaterManager {
  Random r = new Random();
  Scanner sc = new Scanner(System.in);
  private static TheaterManager theaterManager;

  ArrayList<Venue> venues = new ArrayList<Venue>();
  ArrayList<User> users = new ArrayList<User>();
  ArrayList<Event> events = new ArrayList<Event>();
  ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
  ArrayList<String> reviews = new ArrayList<String>();

  private TheaterManager() {
    users = new ArrayList<User>();
    events = new ArrayList<Event>();
    showtimes = new ArrayList<Showtime>();
    reviews = new ArrayList<String>();
    loadJSON();
  }

  public static TheaterManager getInstance() {
    if (theaterManager == null) {
      theaterManager = new TheaterManager();
    }
    return theaterManager;
  }

  String nv;
  Showtime st;
  boolean searched;
  int s = 15;

  public void createEvent() {
    System.out.println("Creating a new event");
    System.out.println("Enter name of event");
    String name = sc.nextLine();
    System.out.println("Enter run time of event");
    int runTime = Integer.parseInt(sc.nextLine());;
    System.out.println("Enter actors/performers");
    String stars = sc.nextLine();
    System.out.println("Enter genre of event");
    String genre = sc.nextLine();
    System.out.println("Enter description of event");
    String description = sc.nextLine();
    System.out.println("Enter type of event: movie/play/concert");
    String type = sc.nextLine();
    if (!type.equalsIgnoreCase("movie") && !type.equalsIgnoreCase("play")
        && !type.equalsIgnoreCase("concert"))
      System.out.println("Wrong type");
    String rating = "rating";
    Event newEvent = new Event(name, runTime, stars, genre, description, type, rating);
    events.add(newEvent);
    System.out.println("New event created\n");
  }

  public void createVenue() {
    System.out.println("Creating a new venue");
    System.out.println("Enter name of venue");
    String name = sc.nextLine();
    System.out.println("Enter address of venue");
    String address = sc.nextLine();
    System.out.println("Enter type of venue");
    String type = sc.nextLine();
    System.out.println("Enter price of adult ticket");
    double adultTicketPrice = Integer.parseInt(sc.nextLine());
    System.out.println("Enter price of child ticket");
    double childTicketPrice = Integer.parseInt(sc.nextLine());
    System.out.println("Enter price of handicap ticket");
    double handicapTicketPrice = Integer.parseInt(sc.nextLine());
    System.out.println("Enter size of auditoriums");
    int i = Integer.parseInt(sc.nextLine());
    String[][] seatingMap = new String[i][i];
    int numberOfAuditoriums = 1;
    Venue newVenue = new Venue(name, address, type, adultTicketPrice, childTicketPrice,
        handicapTicketPrice, seatingMap, numberOfAuditoriums);
    venues.add(newVenue);
    System.out.println("New venue created\n");
  }

  public void createShowtime() {
    /*
     * System.out.println("Enter name of auditorium"); String auditoriumNumber=sc.nextLine();
     */
    System.out.println("Creating a new showtime");
    System.out.println("Enter the venue name");
    String venueName = sc.nextLine();
    System.out.println("Enter the event name");
    String eventName = sc.nextLine();
    for (int i = 0; i < venues.size(); i++) {
      if (venues.get(i).getName().equalsIgnoreCase(venueName)) {
        for (int j = 0; i < events.size(); ++j) {
          if (events.get(j).getName().equals(eventName)) {
            System.out.println("Enter time of show");
            String timeOfShow = sc.nextLine();
            System.out.println("Enter the auditorium number");
            String auditoriumNumber = sc.nextLine();
            Showtime newShowtime =
                new Showtime(venues.get(i), events.get(i), auditoriumNumber, timeOfShow);
            showtimes.add(newShowtime);
            System.out.println("New showtime created\n");
            break;
          }
        }
      }
    }
  }

  public User createUser() {
    System.out.println("Creating a new user");
    System.out.println("Enter your first name");
    String firstName = sc.nextLine();
    System.out.println("Enter your last name");
    String lastName = sc.nextLine();
    System.out.println("Enter your email");
    String email = sc.nextLine();
    System.out.println("Enter your phone number");
    String phoneNumber = sc.nextLine();
    User newUser = new User(firstName, lastName, email, phoneNumber);
    users.add(newUser);
    return newUser;
  }

  public void createRegisteredUser() {
    boolean isMilitary;
    System.out.println("Enter your date of birth");
    String dateOfBirth = sc.nextLine();
    System.out.println("Enter your address");
    String address = sc.nextLine();
    System.out.println("Enter your username");
    String username = sc.nextLine();
    System.out.println("Enter your password");
    String password = sc.nextLine();
    System.out.println("Are you serving or have you served in military?\n" + "Enter yes or no");
    String ans = sc.nextLine();
    if (ans.equalsIgnoreCase("yes"))
      isMilitary = true;
    else if (ans.equalsIgnoreCase("no"))
      isMilitary = false;
  }

  public void createEmployeeUser() {
    boolean isMilitary;
    System.out.println("Enter your date of birth");
    String dateOfBirth = sc.nextLine();
    System.out.println("Enter your address");
    String address = sc.nextLine();
    System.out.println("Enter your username");
    String username = sc.nextLine();
    System.out.println("Enter your password");
    String password = sc.nextLine();
    System.out.println("Are you serving or have you served in military?\n" + "Enter yes or no");
    String ans = sc.nextLine();
    if (ans.equalsIgnoreCase("yes"))
      isMilitary = true;
    else if (ans.equalsIgnoreCase("no"))
      isMilitary = false;
  }

  public Showtime search() {
    int i;
    System.out.println("Enter name of event you want to search");
    String ne = sc.nextLine();
    System.out.println("Enter name of venue you want to visit");
    String nv = sc.nextLine();
    for (i = 0; i < showtimes.size(); i++) {
      if (showtimes.get(i).getVenue().getName().equals(nv)) {
        if (showtimes.get(i).getEvent().getName().equals(ne)) {
          System.out.println("Here is a showtime");
          System.out.println(showtimes.get(i).toString());
          return showtimes.get(i);
        }
      }
    }
    System.out.println("We couldn't find a matching event");
    return null;
  }



  // Dealing with ticket issue under senario 1
  public void ticketS1(Showtime showtime, User user) {
    double amountPaid = 0, ap = 0, cp = 0, hp = 0;
    for (int i = 0; i < venues.size(); i++) {
      while (venues.get(i).getName().equalsIgnoreCase(nv)) {
        ap = venues.get(i).getAdultTicketPrice();
        cp = venues.get(i).getChildTicketPrice();
        hp = venues.get(i).getHandicapTicketPrice();
      }
    }
    System.out.println("Enter type of first ticket:\nChoose one from adult/child/handicap");
    String tt1 = sc.nextLine();
    if (tt1.equalsIgnoreCase("adult"))
      amountPaid = ap;
    else if (tt1.equalsIgnoreCase("child"))
      amountPaid = cp;
    else if (tt1.equalsIgnoreCase("handicap"))
      amountPaid = hp;
    else
      System.out.println("Wrong ticket type");
    String seatNumber1 = String.valueOf(r.nextInt(s * s));
    System.out.println("Enter type of second ticket:\nChoose one from adult/child/handicap");
    String tt2 = sc.nextLine();
    if (tt2.equalsIgnoreCase("adult"))
      amountPaid += ap;
    else if (tt2.equalsIgnoreCase("child"))
      amountPaid += cp;
    else if (tt2.equalsIgnoreCase("handicap"))
      amountPaid += hp;
    else
      System.out.println("Wrong ticket type");
    String seatNumber2 = String.valueOf(r.nextInt(s * s));
    while (seatNumber2 == seatNumber1)
      seatNumber2 = String.valueOf(r.nextInt(s * s));

    user.purchaseTicket(showtime, seatNumber1 + " " + seatNumber2, amountPaid);
  }

  // Dealing with ticket issue under senario 2
  public void ticketS2(Showtime showtime, User user) {
    double amountPaid = 0, ap = 0, cp = 0, hp = 0;
    for (int i = 0; i < venues.size(); i++) {
      while (venues.get(i).getName().equalsIgnoreCase(nv)) {
        ap = venues.get(i).getAdultTicketPrice();
        cp = venues.get(i).getChildTicketPrice();
        hp = venues.get(i).getHandicapTicketPrice();
      }
    }
    System.out.println("Enter type of first ticket:\nChoose one from adult/child/handicap");
    String tt = sc.nextLine();
    if (tt.equalsIgnoreCase("adult"))
      amountPaid = ap;
    else if (tt.equalsIgnoreCase("child"))
      amountPaid = cp;
    else if (tt.equalsIgnoreCase("handicap"))
      amountPaid = hp;
    else
      System.out.println("Wrong ticket type");
    System.out
        .println("All seats are available now\n" + "Please choose your favored row and column");
    System.out.println("Enter your favored row nubmer");
    int r = Integer.parseInt(sc.nextLine());
    System.out.println("Enter your favored column number");
    int c = Integer.parseInt(sc.nextLine());
    String seatNumber = String.valueOf(s * r + c);

    user.purchaseTicket(showtime, seatNumber, amountPaid);

    System.out.println("Time passed......\n");
    System.out.println("Please rate this event");
    String rt = sc.nextLine();
    showtime.getEvent().rating = rt;
    System.out.println("Thanks\nRating submitted");
    System.out.println("Please review this event");
    String rv = sc.nextLine();
    showtime.getEvent().reviews.add(rv);
    System.out.println("Thanks\nReview submitted");

  }

  public void categorySearch() {
    System.out.println("Enter Movie or Play or Concert");
    String c = sc.nextLine();
    if (c.equalsIgnoreCase("movie")) {
      for (int i = 0; i < showtimes.size(); i++) {
        if (showtimes.get(i).getEvent().getGenre().equalsIgnoreCase("movie"))
          System.out.println(showtimes.get(i));
      }
    } else if (c.equalsIgnoreCase("play")) {
      for (int i = 0; i < showtimes.size(); i++) {
        if (showtimes.get(i).getEvent().getGenre().equalsIgnoreCase("movie"))
          System.out.println(showtimes.get(i));
      }
    } else if (c.equalsIgnoreCase("concert")) {
      for (int i = 0; i < showtimes.size(); i++) {
        if (showtimes.get(i).getEvent().getGenre().equalsIgnoreCase("movie"))
          System.out.println(showtimes.get(i));
      }
    } else
      System.out.println("Wrong type");
  }

  public void addReview() {
    System.out.println("Enter name of event you want to review:");
    String n = sc.nextLine();
    for (int i = 0; i < events.size(); i++) {
      if (events.get(i).getName().equalsIgnoreCase(n)) {
        System.out.println("Enter your review:");
        String r = sc.nextLine();
        events.get(i).getReviews().add(r);
        System.out.println("Review submitted");
      } else
        System.out.println("Event DNE");
    }
  }

  public void displayReviews() {
    System.out.println("Enter name of event you want to check reviews");
    String n = sc.nextLine();
    for (int i = 0; i < events.size(); i++) {
      if (events.get(i).getName().equalsIgnoreCase(n)) {
        for (String r : events.get(i).getReviews())
          System.out.println(r);
      } else
        System.out.println("Event DNE");
    }
  }

  public void removeShowtime(String venueName, String eventName) {
    for (int i = 0; i < showtimes.size(); i++) {
      if (showtimes.get(i).getVenue().getName().equalsIgnoreCase(venueName)) {
        if (showtimes.get(i).getEvent().getName().equalsIgnoreCase(eventName)) {
          showtimes.remove(i);
          System.out.println("Showtime removed");
        } else
          System.out.println("Showtime DNE");
      } else
        System.out.println("Such showtime DNE");
    }
  }

  public void removeVenue(String venueName) {
    for (int i = 0; i < venues.size(); i++) {
      if (venues.get(i).getName().equalsIgnoreCase(venueName)) {
        venues.remove(i);
        System.out.println("Venue removed");
      } else
        System.out.println("Such venue DNE");
    }
    for (int i = 0; i < showtimes.size(); i++) {
      if (showtimes.get(i).getVenue().getName().equalsIgnoreCase(venueName)) {
        showtimes.remove(i);
        System.out.println("Related showtimes removed");
      }
    }
  }

  public void removeEvent(String eventName) {
    for (int i = 0; i < events.size(); i++) {
      if (events.get(i).getName().equalsIgnoreCase(eventName)) {
        events.remove(i);
        System.out.println("Event removed");
      } else
        System.out.println("Such event DNE");
    }
    for (int i = 0; i < showtimes.size(); i++) {
      if (showtimes.get(i).getEvent().getName().equalsIgnoreCase(eventName)) {
        showtimes.remove(i);
        System.out.println("Related showtimes removed");
      }
    }
  }

  public void removeReview(String review, String eventName) {
    for (int i = 0; i < events.size(); i++) {
      if (events.get(i).getName().equalsIgnoreCase(eventName)) {
        for (int j = 0; j < events.get(i).getReviews().size(); j++) {
          if (events.get(i).getReviews().get(j).equals(review)) {
            events.get(i).getReviews().remove(j);
            System.out.println("Review removed");
          } else
            System.out.println("Such review DNE");
        }
      } else
        System.out.println("Such event DNE");
    }
  }

  /**
   * Load all the information from the JSON files into the internal Array Lists
   */

  private void loadJSON() {
    DataLoader jsonLoader = new DataLoader();
    users = jsonLoader.loadUsers();
    events = jsonLoader.loadEvents();
    venues = jsonLoader.loadVenues();
    showtimes = jsonLoader.loadShowtimes();
  }

}
