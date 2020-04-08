package csce247_moive_theater;

/**
 * 
 * @author Chen
 *
 */
import java.util.Scanner;

public class TheaterDriver {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    TheaterManager user = TheaterManager.getInstance();

    int scenario = 0;
    System.out.println("Choose scenario:");
    scenario = Integer.parseInt(sc.nextLine());
    switch (scenario) {
      case 1:
        System.out.println("Welcome to Movie Theater!\n" + "Please create a guest account");
        TheaterManager gUser = TheaterManager.getInstance();
        User guest = gUser.createUser();
        System.out.println("Your guest account is created");
        Showtime case1Time = gUser.search();
        gUser.ticketS1(case1Time, guest);
      case 2:
        System.out.println("Welcome to Movie Theater!\n" + "Please register an account");
        TheaterManager rUser = TheaterManager.getInstance();
        rUser.createUser();
        rUser.createRegisteredUser();
        System.out.println("Your registered account is created");
        Showtime case2Time = rUser.search();
        rUser.ticketS2(case2Time, guest);
      case 3:
        System.out.println("Welcome to Movie Theater" + "Please create an employee account");
        TheaterManager eUser = TheaterManager.getInstance();
        eUser.createUser();
        eUser.createEmployeeUser();
        System.out.println("Your employee account is created");
        eUser.createEvent();// Add play
        System.out.println("New play is updated");
        eUser.createShowtime();// Find target combination of target venue and new play
        System.out.println("New showtime created");
    }
  }
}
