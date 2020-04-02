package csce247_moive_theater;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
  protected String firstName;
  protected String lastName;
  protected String type;
  protected String email;
  protected String phoneNumber;
  protected ArrayList<Order> orderHistory;

  /**
   * Construct a guest user
   * 
   * @param firstName Users first name
   * @param lastName Users last name
   * @param email Users email address
   * @param phoneNumber Users phone number
   */
  public User(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = "guest";
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.orderHistory = new ArrayList<Order>();
  }

  /**
   * Walks the user the purchase process to select ticket types and seats for the given Showtime
   * 
   * @param showtime Showtime the user would like to purchase tickets for
   */
  public void purchaseTicket(Showtime showtime) {
    int adultTicketsPurchased = 0;
    int childTicketsPurchased = 0;
    int handicapTicketsPurchased = 0;
    Scanner input = new Scanner(System.in);

    System.out.println("How many adult tickets would you like to purchase?");
    adultTicketsPurchased = input.nextInt();

    System.out.println("How many child tickets would you like to purchase?");
    childTicketsPurchased = input.nextInt();

    System.out.println("How may handicap tickets would you like to purchase?");
    handicapTicketsPurchased = input.nextInt();

    int totalTickets = adultTicketsPurchased + childTicketsPurchased + handicapTicketsPurchased;
    String selectedSeats;
    for (int i = totalTickets; i > 0; --i) {
      System.out.println("Please select your seat");
      // TODO Select the seat
    }

    double totalPurchasePrice = 0;
    // TODO Get the total purchase price
    System.out.println("Your total is $" + totalPurchasePrice + ". Processing your payment.");

    Order newOrder = new Order(showtime, totalPurchasePrice, selectedSeats);
    orderHistory.add(newOrder);

    System.out
        .println("Your purchase was successful! Please keep this order number for your records.");
    System.out.println("Order #: " + newOrder.getOrderNumber());

    System.out.println("Here is your ticket!");
    displayTicket(newOrder.getOrderNumber());
  }

  /**
   * Refunds the users order if found in their order history
   * 
   * @param orderNumber Order number being refunded
   */
  public void refundTicket(String orderNumber) {
    for (int i = 0; i < orderHistory.size(); ++i) {
      if (orderHistory.get(i).getOrderNumber().equals(orderNumber)) {
        System.out.println("Order: " + orderNumber + " refunded successfully!");
        return;
      }
    }
    System.out
        .println("Error: The order could not be found. Check your order number and try again");
  }

  public void displayTicket(String orderNumber) {
    for (int i = 0; i < orderHistory.size(); ++i) {
      if (orderHistory.get(i).getOrderNumber().equals(orderNumber)) {
        System.out.println("****** TICKET TO "/*TODO Put Showname here*/);
        System.out.print("AUDITORIUM: " //Print Audiortium);
        System.out.print("SEAT NUMBER: " + orderHistory.get(i).getSeatNumber());
      }
    }
  }

  /**
   * Prints the users entire order history
   * 
   */
  public void showOrderHistory() {
    for (Order order : orderHistory) {
      order.toString();
    }
  }

  private void applyCoupon(String couponNumber) {

  }

  private void applyDiscounts() {

  }
}
