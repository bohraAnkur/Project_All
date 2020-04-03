package edu.neu.ccs.cs5004.model.ships;


import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.SpecificShipCell;

import java.util.Objects;



/**
 * Represents the common properties of the AbstractShip Entity.
 */

public abstract class AbstractShip implements Ship   {

  private Integer numberOfHitCells;

  private Integer size;

  private Cell[] shipCells;

  /**
   * Constructor for the entity AbstractShip, it takes numberOfHitCells as an Integer and the
   * sunkStatus of the Ship and returns a ship.
   *
   * @param size the size of the Ship Required
   */
  public AbstractShip(Integer size) {
    this.size = size;

    this.numberOfHitCells = 0;

    this.shipCells = new Cell[this.size];

    this.setCellsToShipCells();
  }

  @Override
  public Cell[] getShipCells() {
    return this.shipCells;
  }

  /**
   * sets all cells in ships cell array to Specific ship cells.
   */
  protected void setCellsToShipCells() {
    for (int i = 0; i < this.shipCells.length; i++) {
      this.shipCells[i] = new SpecificShipCell(this);
    }
  }

  /**
   * Getter for the property Size of the Abstract ship entity.
   *
   * @return the size of the AbstractBattleship
   */
  public Integer getSize() {
    return this.size;
  }

  /**
   * Implementation for the property setter for numberOfHitCells.
   *
   * @param numberOfHitCells the new number of Hit cells to be set
   */

  public void setNumberOfHitCells(Integer numberOfHitCells) {

    this.numberOfHitCells = numberOfHitCells;

  }

  /**
   * Getter for the property numberOfHitCells of the AbstractShip Entity.
   *
   * @return the numberOfHitCells as an Integer
   */

  @Override
  public Integer getNumberOfHitCells() {

    return this.numberOfHitCells;

  }

  /**
   * Implementation of the property isSunk for the ship.
   *
   * @return A boolean if the ship is sunk
   */

  @Override
  public Boolean isSunk() {
    if (this.numberOfHitCells >= this.size) {
      // TODO(Sharice): Why not notify when you hit the ship?
      return true;
    }
    return false;
  }

  /**
   * Implementation of the property of hitting any ship, it shall increase the number of hits of.
   * the ship, if the ship hasn't been sunk yet.
   */
  @Override
  public void hitThisShip() {
    if (this.numberOfHitCells < this.getSize()) {
      this.numberOfHitCells++;
      if (isSunk()) {
        notifyCells();
      }
    }
  }

  @Override
  public void notifyCells() {
    for (int i = 0; i < this.shipCells.length; i++) {
      shipCells[i].update();
    }
  }

  /**
   * checks that two objects are equal.
   * @param obj the object to be compared.
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractShip that = (AbstractShip) obj;

    if (!that.getSize().equals(this.getSize())) {
      return false;
    }
    if (!this.getNumberOfHitCells().equals(that.getNumberOfHitCells())) {
      return false;
    }

    // Check that both ships have the same shipCells, regardless of order;
    // To remove circular calls to equals between ShipCell and Ship,
    // in Ship, two cells are equal if they have the same attack result.
    for (int i = 0; i < that.getSize(); i++) {
      if (!this.getShipCells()[i].attackResult().equals(
          that.getShipCells()[i].attackResult())) {
        return false;
      }
    }
    return this.getClass().equals(that.getClass());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getNumberOfHitCells(), size);
    result = 31 * result + Objects.hash(this.numberOfHitCells, this.size);
    return result;
  }
}
