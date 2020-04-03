package edu.neu.ccs.cs5004.problem3;

import java.util.Objects;

/**
 * represents a name.
 */
public class Name {

  private String first;
  private String last;

  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(first, name.first)
        && Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return "Name{" + "first='" + first + '\'' + ", last='" + last + '\'' + '}';
  }
}

