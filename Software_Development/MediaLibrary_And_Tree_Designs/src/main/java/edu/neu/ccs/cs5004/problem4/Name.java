package edu.neu.ccs.cs5004.problem4;

import java.util.Objects;

/**
 * Represents the common properties of Name.
 */
public class Name {

  private String first;
  private String last;

  /**
   * Represents the constructor of the Name.
   *
   * @param first the first of the name
   * @param last  the last of the name
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Getter for the first of the name.
   *
   * @return a String representing the first of the name
   */

  public String getFirst() {
    return this.first;
  }

  /**
   * Getter for the last of the name.
   *
   * @return a String representing the last of the name
   */

  public String getLast() {
    return this.last;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Name name = (Name) object;
    return Objects.equals(first, name.first)
            &&
            Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {

    return Objects.hash(this.first, this.last);
  }

  @Override
  public String toString() {
    return "Name{"
            +
            "first='"
            +
            this.first
            +
            '\''
            +
            ", last='"
            +
            this.last
            +
            '\''
            +
            '}';
  }
}
