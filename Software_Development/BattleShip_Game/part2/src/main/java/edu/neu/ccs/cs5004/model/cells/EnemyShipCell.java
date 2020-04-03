package edu.neu.ccs.cs5004.model.cells;


import edu.neu.ccs.cs5004.AttackResult;

/**
 * Represent the common properties of the EnemyShipCell Entity.
 */
public class EnemyShipCell extends ShipCell {

  /**
   * Constructor for the entity enemyShipCell class.
   */
  public EnemyShipCell() {
    super(null);
  }

  /**
   * Implementation of the property attackResult on the cell. What would the result of attack would.
   * be on the cell. Depending on the situations and the type of cells.
   * it returns Hit , Miss or Sunk.
   *
   * @return AttackResult Hit , Miss or Sunk
   */

  @Override
  public AttackResult attackResult() {
    return AttackResult.HIT;
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
