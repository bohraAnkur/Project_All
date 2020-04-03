package edu.neu.ccs.cs5004.model.cells;

import edu.neu.ccs.cs5004.model.ships.Ship;

/**
 * Represents the common properties of the SpecificShipCell entity.
 */

public class SpecificShipCell extends ShipCell {

  /**
   * Constructor for the entity AbstractShipCell given a ship ,a sunkState and a wasHit(boolean).
   * returns a SpecificShip Cell.
   *
   * @param ship   the ship to be contained in the AbstractShipCell
   */
  public SpecificShipCell(Ship ship) {
    super(ship);
  }



  @Override
  public String toString() {
    return "SpecificShipCell{}";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SpecificShipCell otherSpecCell = (SpecificShipCell) obj;
    return this.getShip().equals(otherSpecCell.getShip());
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
