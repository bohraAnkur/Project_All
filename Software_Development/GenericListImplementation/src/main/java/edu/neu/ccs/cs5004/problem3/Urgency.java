package edu.neu.ccs.cs5004.problem3;

import java.util.Objects;

/**
 * urgency of the patient.
 */
public class Urgency {

  private Integer value;

  public Urgency(Integer value) {
    this.value = value;
  }

  /**
   * compares two urgency values.
   *
   * @param otherUrgency to compare with (assumed to be not null)
   * @return 1 if this urgency value is bigger than other urgency value
   *     -1 if this urgency value if smaller than other urgency value
   *     0 if both urgency values are equal
   */
  public int compareTo(Urgency otherUrgency) {
    if (this.value > otherUrgency.value) {
      return 1;
    } else if (this.value < otherUrgency.value) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Urgency urgency = (Urgency) obj;
    return Objects.equals(value, urgency.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Urgency{" + "value=" + value + '}';
  }
}
