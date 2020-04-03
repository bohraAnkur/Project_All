package edu.neu.ccs.cs5004.problem3;

import java.util.Objects;

/**
 * represents a patient.
 */
public class Patient implements Comparable<Patient> {

  private Urgency urgency;
  private Name name;
  private int orderNumber;

  public Patient(Urgency urgency, Name name) {
    this.urgency = urgency;
    this.name = name;
  }

  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  @Override
  public int compareTo(Patient patient) {
    return this.urgency.compareTo(patient.urgency);
  }

  /**
   * getter for property 'urgency'.
   *
   * @return value for urgency
   */
  public Urgency getUrgency() {
    return urgency;
  }

  /**
   * getter for name.
   *
   * @return name
   */
  public Name getValue() {
    return this.name;
  }

  /**
   * Given another patient return the more urgent patient (with higher urgency).
   *
   * @param otherPatient other patient to compare urgency with
   *                     otherPatient is assumed to be not null
   * @return this patient if it is more urgent then the other patient
   */
  public Patient moreUrgentThan(Patient otherPatient) {
    if (this.urgency.compareTo(otherPatient.urgency) > 0) {
      return this;
    } else {
      return otherPatient;
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
    Patient patient = (Patient) obj;
    return getOrderNumber() == patient.getOrderNumber()
        && Objects.equals(getUrgency(), patient.getUrgency())
        && Objects.equals(name, patient.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urgency, name);
  }

  @Override
  public String toString() {
    return "Patient{"
        + "urgency=" + urgency
        + ", name=" + name
        + ", orderNumber=" + orderNumber
        + '}';
  }
}
