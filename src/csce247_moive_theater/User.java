package csce247_moive_theater;

import java.util.ArrayList;

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
   * Purchases the users tickets, adds them to their order history, then displays the ticket
   * 
   * @param showtime Showtime the user would like to purchase tickets for
   */
  public void purchaseTicket(Showtime showtime, String seatNumbers, double orderTotal) {
    Order newOrder = new Order(showtime, orderTotal, seatNumbers);
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

  /**
   * Prints out the ticket with the specified order number
   * 
   * @param orderNumber Order number of the ticket to print
   */
  public void displayTicket(String orderNumber) {
    for (int i = 0; i < orderHistory.size(); ++i) {
      if (orderHistory.get(i).getOrderNumber().equals(orderNumber)) {
        System.out.println("****** " + orderHistory.get(i).getEventName() + " ******");
        System.out.print("AUDITORIUM: " + orderHistory.get(i).getAuditoriumNumber());
        System.out.print("SEAT NUMBER: " + orderHistory.get(i).getSeatNumber());
        return;
      }
    }
    System.out
        .println("Error: The ticket could not be found. Check your order number and try again");
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
