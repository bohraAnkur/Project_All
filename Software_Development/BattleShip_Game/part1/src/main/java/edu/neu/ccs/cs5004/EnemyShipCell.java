package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * Represent the common properties of the EnemyShipCell Entity.
 */
public class EnemyShipCell extends ShipCell {

  private Boolean belongToSunkShip;

  /**
   * Constructor for the entity AbstractShipCell given a ship ,a sunkState and a wasHit(boolean).
   * and a belongToSunkSHip Boolean returns an EnemyShip Cell.
   *
   * @param ship           the ship to be contained in the AbstractShipCell
   * @param sunkState      the sunkState of the Cell(Sunked or UnSunked)
   * @param wasHit         a boolean which represents if a cell was hit or not hit.
   * @param belongSunkShip it returns a boolean depicting if the given enemyShipCell belongs to
   *                       a sunken ship or not.
   */
  public EnemyShipCell(Ship ship, Boolean wasHit, SunkStatus sunkState, Boolean belongSunkShip)
  {
    super(ship, wasHit, sunkState);
    this.belongToSunkShip = belongSunkShip;
  }

  /**
   * Getter for the property belongToSunkShip or not.
   *
   * @return a boolean depicting if the given enemyShipCell belongs to a sunken ship or not
   */
  public Boolean getBelongToSunkShip() {
    return this.belongToSunkShip;
  }


  /**
   * Implementation of the property attackThisCell ,returns an updated cell.
   *
   * @return An updated cell with the updated ship inside the cell.
   */

  @Override
  public Cell attackThisCell() {
    return new EnemyShipCell(this.getShip(), true,SunkStatus.SUNKED,
        this.getBelongToSunkShip());
  }

  /**
   * Implementation of the property attackResult on the cell. What would the result of attack would.
   * be on the cell, In case if it were attacked. Depending on the situations and the type of cells.
   * it returns Hit , Miss or Sunk.
   *
   * @return Attackable Hit , Miss or Sunk
   */

  @Override
  public AttackResult attackResult() {

    return AttackResult.MISS;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    EnemyShipCell that = (EnemyShipCell) object;
    return Objects.equals(belongToSunkShip, that.belongToSunkShip);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), belongToSunkShip);
  }

  @Override
  public String toString() {
    return "EnemyShipCell{"
        +
        "belongToSunkShip="
        +
        belongToSunkShip
        +
        '}';
  }
}
