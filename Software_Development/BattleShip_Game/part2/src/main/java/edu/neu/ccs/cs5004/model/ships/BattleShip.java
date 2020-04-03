package edu.neu.ccs.cs5004.model.ships;

/**
 * represents a battleShip ship type.
 */
public class BattleShip extends AbstractShip {

  /**
   * represents the size of a battleship (in cells).
   */
  public static final Integer BATTLESHIP_SIZE = 4;


  /**
   * a constructor for the battleship class.
   */

  public BattleShip() {
    super(BATTLESHIP_SIZE);
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
