package edu.neu.ccs.cs5004.model.ships;

/**
 * represents a destroyer ship type.
 */
public class Destroyer extends AbstractShip {
  public static final Integer DESTROYER_SIZE = 1;

  /**
   * a constructor for the destroyer class.
   */
  public Destroyer() {
    super(DESTROYER_SIZE);
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
