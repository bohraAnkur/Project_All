package edu.neu.ccs.cs5004.problem4;

import java.util.Objects;

/**
 * Represents the common properties of the ReleaseYear.
 */
public class ReleaseYear {

  private Integer yearReleased;

  /**
   * Constructor for the release year.
   *
   * @param releaseYear represents the release year of the Media
   */

  public ReleaseYear(Integer releaseYear) {

    this.yearReleased = releaseYear;

  }

  /**
   * Getter for the release year of the movie.
   *
   * @return the release year of the movie
   */

  public Integer getYearReleased() {
    return this.yearReleased;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ReleaseYear that = (ReleaseYear) object;
    return Objects.equals(yearReleased, that.yearReleased);
  }

  @Override
  public int hashCode() {

    return Objects.hash(yearReleased);
  }

  @Override
  public String toString() {
    return "ReleaseYear{"
            +
            "yearReleased="
            +
            yearReleased
            +
            '}';
  }
}
