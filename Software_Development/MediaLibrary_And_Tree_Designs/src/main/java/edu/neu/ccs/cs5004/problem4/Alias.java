package edu.neu.ccs.cs5004.problem4;

import java.util.Objects;

/**
 * Represents the common properties of the entity Alias.
 */

public class Alias {

  private String shortName;

  /**
   * Constructor for the Alias.
   * Every movie or TV series will have a unique Alias.
   *
   * @param shortName short name to be used for the Alias
   */

  public Alias(String shortName) {
    this.shortName = shortName;
  }

  /**
   * Getter for the ShortName.
   *
   * @return a String representing the shortName of the Alias
   */
  public String getShortName() {
    return this.shortName;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Alias alias = (Alias) object;

    return Objects.equals(shortName, alias.shortName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(shortName);
  }

  @Override
  public String toString() {
    return "Alias{"
            +
            "shortName='"
            +
            shortName
            +
            '\''
            +
            '}';
  }
}
