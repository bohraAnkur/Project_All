package edu.neu.ccs.cs5004.model.cells;


import edu.neu.ccs.cs5004.AttackResult;
import edu.neu.ccs.cs5004.model.ships.Ship;

import java.util.Objects;


/**
 * represents the abstract ship.
 */

public abstract class ShipCell implements Cell {
  protected Ship ship;
  protected Boolean hit;
  protected Boolean isSunk;

  /**
   * constructor for the abstract class.
   * @param ship the cell's ship
   */
  public ShipCell(Ship ship) {
    this.hit = false;
    this.isSunk = false;
    this.ship = ship;
  }

  @Override
  public void attackThisCell() {
    if (this.ship != null) {
      this.ship.hitThisShip();
    }
    this.hit = true;
  }

  @Override
  public Boolean getIsSunk() {
    return this.isSunk;
  }

  /**
   * Getter for the property ship.
   *
   * @return the ship inside the cell.
   */
  protected Ship getShip() {
    return ship;
  }

  /**
   * Getter for the property hit.
   *
   * @return boolean stating the the ship cell was hit or not hit
   */

  @Override
  public Boolean isHit() {
    return this.hit;
  }

  @Override
  public AttackResult attackResult() {
    if (isHit()) {
      if (this.isSunk) {
        return AttackResult.SUNK;
      } else {
        return AttackResult.HIT;
      }
    } else {
      return AttackResult.NOT_ATTACKED;
    }
  }

  @Override
  public void update() {
    this.isSunk = true;
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
        && Objects.equals(hit, shipCell.hit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attackResult(), hit);
  }

  @Override
  public String toString() {
    return "ShipCell{" + "ship=" + ship + ", wasHit=" + hit + '}';
  }
}
