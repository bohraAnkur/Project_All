package edu.neu.ccs.cs5004.model.ships;

/**
 * represents a submarine ship type.
 */
public class Submarine extends AbstractShip {

  public static final Integer SUBMARINE_SIZE = 2;

  /**
   * a constructor for the destroyer class.
   */
  public Submarine() {
    super(SUBMARINE_SIZE);
  }

  /**
   * checks that two objects are equal.
   * @param obj the object to be compared.
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
