package edu.neu.ccs.cs5004.problem4;

import java.util.Objects;

/**
 * Represents the common entities Of a Title.
 */
public class Title {
  private String titleName;

  /**
   * Constructor For the Title
   *
   * @param title A string representing the Title of a movie.
   */
  public Title(String title) {
    this.titleName = title;
  }

  /**
   * Getter for the TitleName of the title.
   */
  public String getTitleName() {
    return this.titleName;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Title title = (Title) object;
    return Objects.equals(titleName, title.titleName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(titleName);
  }

  @Override
  public String toString() {
    return "Title{"
            +
            "titleName='"
            +
            titleName
            +
            '\''
            +
            '}';
  }
}
