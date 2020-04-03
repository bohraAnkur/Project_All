package edu.neu.ccs.cs5004.model.ships;

/**
 * represents a cruiser ship type.
 */
public class Cruiser extends AbstractShip {

  /**
   * represents the cruiser's size (in cells).
   */
  public static final Integer CRUISER_SIZE = 3;


  /**
   * a constructor for the cruiser class.
   */
  public Cruiser() {
    super(CRUISER_SIZE);
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
