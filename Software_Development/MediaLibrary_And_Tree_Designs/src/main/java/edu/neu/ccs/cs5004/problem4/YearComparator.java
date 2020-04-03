package edu.neu.ccs.cs5004.problem4;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Represents the common properties of the YearComparator Entity.
 */
public class YearComparator implements Comparator<Media>, Serializable {

  @Override
  public int compare(Media mediaA, Media mediaB) {
    return mediaA.getReleaseYear().getYearReleased() - mediaB.getReleaseYear().getYearReleased();
  }
}
