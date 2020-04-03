package edu.neu.ccs.cs5004.problem4;

import java.util.Objects;

/**
 * Represents the common properties of the Director Entity.
 */
public class Director {

  private Name name;

  /**
   * Constructor for the Director Entity.
   *
   * @param name Name of the Director
   */
  public Director(Name name) {
    this.name = name;
  }

  /**
   * Getter for the name of the Director.
   *
   * @return the name of the director
   */

  public Name getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Director director = (Director) object;
    return Objects.equals(name, director.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Director{"
            +
            "name="
            +
            name
            +
            '}';
  }
}
