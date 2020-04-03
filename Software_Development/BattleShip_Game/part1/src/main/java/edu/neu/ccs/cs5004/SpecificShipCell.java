package edu.neu.ccs.cs5004;

/**
 * Represents the common properties of the SpecificShipCell entity.
 */

public class SpecificShipCell extends ShipCell {

  /**
   * Constructor for the entity AbstractShipCell given a ship ,a sunkState and a wasHit(boolean).
   * returns a SpecificShip Cell.
   *
   * @param ship   the ship to be contained in the AbstractShipCell
   * @param wasHit a boolean which represents if a cell was hit or not hit.
   */

  public SpecificShipCell(Ship ship, Boolean wasHit) {
    super(ship, wasHit, SunkStatus.UNSUNKED);
  }


  /**
   * Implementation of the property attackThisCell ,returns an updated cell.
   *
   * @return An updated cell with the updated ship inside the cell
   */

  @Override
  public SpecificShipCell attackThisCell() {

    return new SpecificShipCell(this.getShip().hitThisShip(), true);
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

    if (this.getShip().hitThisShip().isSunk()) {

      System.out.println("Sunk");
      return AttackResult.SUNK;
    } else {
      System.out.println("HIT");
      return AttackResult.HIT;
    }
  }

  @Override
  public String toString() {
    return "SpecificShipCell{}";
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
