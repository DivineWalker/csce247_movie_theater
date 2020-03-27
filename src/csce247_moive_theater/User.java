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

  public void purchaseTicket(Showtime showtime) {

  }

  public void refundTicket(String orderNumber) {

  }

  public void displayTicket(String orderNumber) {

  }

  public void showOrderHistory(String orderNumber) {

  }

  private void applyCoupon(String couponNumber) {

  }

  private void applyDiscounts() {

  }
}
