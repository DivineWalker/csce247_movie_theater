package csce247_moive_theater;

public class RegisteredUser extends User {
  private String dateOfBirth;
  private String address;
  private String username;
  private String password;
  private boolean isMilitary;


  /**
   * Construct a new registered user
   * 
   * @param firstName Users first name
   * @param lastName Users last name
   * @param email Users email address
   * @param phoneNumber Users phone number
   * @param dateOfBirth Users date of birth
   * @param address Users home address
   * @param username Users username
   * @param password Users password
   * @param isMilitary Is the user active duty military/vetern
   */
  public RegisteredUser(String firstName, String lastName, String email, String phoneNumber,
      String dateOfBirth, String address, String username, String password, boolean isMilitary) {
    super(firstName, lastName, email, phoneNumber);
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.username = username;
    this.password = password;
    this.isMilitary = isMilitary;
    this.type = "registered";
  }


  public String getDateOfBirth() {
    return dateOfBirth;
  }


  public String getAddress() {
    return address;
  }


  public String getUsername() {
    return username;
  }


  public String getPassword() {
    return password;
  }


  public boolean isMilitary() {
    return isMilitary;
  }
}
