package edu.neu.ccs.cs5004.assignment9;

import java.util.Objects;

/**
 * stores individual information.
 */
public class IndividualInfo {
  private String firstName;
  private String lastName;
  private String companyName;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;
  private String phone1;
  private String phone2;
  private String email;
  private String webPage;

  /**
   * construct IndividualInfo for the person.
   * @param info of the person
   */
  public IndividualInfo(String[] info) {
    this.firstName = info[0];
    this.lastName = info[1];
    this.companyName = info[2];
    this.address = info[3];
    this.city = info[4];
    this.county = info[5];
    this.state = info[6];
    this.zip = info[7];
    this.phone1 = info[8];
    this.phone2 = info[9];
    this.email = info[10];
    this.webPage = info[11];
  }

  /**
   * get the field required.
   * @param title name
   * @return field value
   */
  public String get(String title) {

    switch (Info.valueOf(title.toUpperCase())) {
      case FIRST_NAME:
        return firstName;
      case LAST_NAME:
        return lastName;
      case COMPANY_NAME:
        return companyName;
      case ADDRESS:
        return address;
      case CITY:
        return city;
      case COUNTY:
        return county;
      case STATE:
        return state;
      case ZIP:
        return zip;
      case PHONE1:
        return phone1;
      case PHONE2:
        return phone2;
      case EMAIL:
        return email;
      case WEB:
        return webPage;
      default:
        throw new IllegalArgumentException("");
    }
  }

  /**
   * generate a file name for the person.
   * @return file name
   */
  public String generateFileName() {
    return firstName + "_"
        + lastName + "_" + phone1 + ".txt";
  }

  @Override
  public String toString() {
    return "IndividualInfo{"
        + "firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + ", companyName='" + companyName + '\''
        + ", address='" + address + '\''
        + ", city='" + city + '\''
        + ", county='" + county + '\''
        + ", state='" + state + '\''
        + ", zip='" + zip + '\''
        + ", phone1='" + phone1 + '\''
        + ", phone2='" + phone2 + '\''
        + ", email='" + email + '\''
        + ", webPage='" + webPage + '\''
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    IndividualInfo that = (IndividualInfo) obj;
    return Objects.equals(firstName, that.firstName)
        && Objects.equals(lastName, that.lastName)
        && Objects.equals(companyName, that.companyName)
        && Objects.equals(address, that.address)
        && Objects.equals(city, that.city)
        && Objects.equals(county, that.county)
        && Objects.equals(state, that.state)
        && Objects.equals(zip, that.zip)
        && Objects.equals(phone1, that.phone1)
        && Objects.equals(phone2, that.phone2)
        && Objects.equals(email, that.email)
        && Objects.equals(webPage, that.webPage);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName, companyName, address,
        city, county, state, zip, phone1, phone2, email, webPage);
  }
}
