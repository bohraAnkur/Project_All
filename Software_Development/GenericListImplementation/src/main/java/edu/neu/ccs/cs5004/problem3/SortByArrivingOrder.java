package edu.neu.ccs.cs5004.problem3;

import java.io.Serializable;
import java.util.Comparator;

/**
 * comparator class.
 */
public class SortByArrivingOrder implements Comparator<Patient>, Serializable {
  @Override
  public int compare(Patient patient1, Patient patient2) {
    return patient2.getOrderNumber() - patient1.getOrderNumber();
  }
}
