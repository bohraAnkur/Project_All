package edu.neu.ccs.cs5004;

import java.util.Objects;

public abstract class ShipCell implements Cell {
  private Ship ship;

  private SunkStatus sunkStatus;

  private Boolean wasHit;

  /**
   * Constructor for the entity AbstractShipCell given a ship ,a sunkState and a wasHit(boolean).
   * returns an Abstract Ship Cell.
   *
   * @param ship   the ship to be contained in the AbstractShipCell
   * @param wasHit a boolean which represents if a cell was hit or not hit.
   */
  public ShipCell(Ship ship, Boolean wasHit, SunkStatus sunkStatus) {
    this.ship = ship;
    this.sunkStatus = sunkStatus;
    this.wasHit = wasHit;
  }

  /**
   * Getter for the property ship of the AbstractShipCell Entity.
   *
   * @return the Abstract ship inside the cell
   */

  public Ship getShip() {
    return ship;
  }

  /**
   * Getter for the property wasHit of the AbstractShipCell Entity.
   *
   * @return boolean stating the the ship cell was hit or not hit before.
   */

  public Boolean getWasHit() {
    return wasHit;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ShipCell shipCell = (ShipCell) object;
    return Objects.equals(ship, shipCell.ship)
        &&
        sunkStatus == shipCell.sunkStatus
        &&
        Objects.equals(wasHit, shipCell.wasHit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ship, sunkStatus, wasHit);
  }

  @Override
  public String toString() {
    return "ShipCell{" +
        "ship=" + ship +
        ", sunkStatus=" + sunkStatus +
        ", wasHit=" + wasHit +
        '}';
  }
}
