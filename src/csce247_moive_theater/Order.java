package csce247_moive_theater;

import java.util.Date;

public class Order {
  private Showtime showtime;
  private double amountPaid;
  private String seatNumber;
  private String orderNumber;

  /**
   * Construct a new order
   * 
   * @param showtime The showtime being purchased
   * @param amountPaid Total amount the user paid
   * @param seatNumber The seat number being booked
   */
  public Order(Showtime showtime, double amountPaid, String seatNumber) {
    this.showtime = showtime;
    this.amountPaid = amountPaid;
    this.seatNumber = seatNumber;
    this.orderNumber = generateOrderNumber();
  }

  /**
   * Generates a new order number
   * 
   * @return orderNumber
   */
  private String generateOrderNumber() {
    Date now = new Date();
    return String.valueOf(now.getTime()) + seatNumber;
  }
}
