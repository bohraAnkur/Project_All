package edu.neu.ccs.cs5004.assignment8;

import java.util.Objects;

/**
 * represents an id.
 */

public class Id {
  private Integer idNum;

  /**
   * construct an Id.
   * @param idNum id value
   */
  public Id(Integer idNum) {
    this.idNum = idNum;
  }

  /**
   * getter of id.
   * @return id
   */
  public Integer getId() {
    return idNum;
  }

  @Override
  public String toString() {
    return "Id{"
        + "id=" + idNum
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
    Id id1 = (Id) obj;
    return Objects.equals(getId(), id1.getId());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getId());
  }
}
