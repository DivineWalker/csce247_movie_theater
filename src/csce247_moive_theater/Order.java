package csce247_moive_theater;

import java.util.Date;

/**
 * This class holds the information for one ticket order
 * 
 * @author Christopher Moyer
 *
 */

public class Order {
  private Showtime showtime;
  private double amountPaid;
  private String seatNumber;
  private String orderNumber;

  /**
   * Construct an order with a new order number
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
   * Construct an order with an existing order number
   * 
   * @param showtime The showtime being purchased
   * @param amountPaid Total amount the user paid
   * @param seatNumber The seat number being booked
   * @param orderNumber The order number for the purchase
   */
  public Order(Showtime showtime, double amountPaid, String seatNumber, String orderNumber) {
    this.showtime = showtime;
    this.amountPaid = amountPaid;
    this.seatNumber = seatNumber;
    this.orderNumber = orderNumber;
  }

  /**
   * Generates a new order number
   * 
   * @return orderNumber
   */
  private String generateOrderNumber() {
    // Gets the current Epoch time and adds the seat number to end
    Date now = new Date();
    return String.valueOf(now.getTime()) + seatNumber;
  }
}
