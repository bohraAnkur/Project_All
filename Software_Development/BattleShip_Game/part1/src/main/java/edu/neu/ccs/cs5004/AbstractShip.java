package edu.neu.ccs.cs5004;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the common properties of the AbstractShip Entity.
 */

public abstract class AbstractShip implements Ship   {

  public static Integer ONE = 1;

  private Integer numberOfHitCells;

  private Integer size;

  private Cell[] shipCells;

  /**
   * Constructor for the entity AbstractShip, it takes numberOfHitCells as an Integer and the.
   *
   * sunkStatus of the Ship and returns a ship.
   *
   * @param size the size of the Ship Required
   */
  public AbstractShip(Integer size) {
    this.size = size;

    this.numberOfHitCells = 0;

    this.shipCells = new Cell[this.size];
  }

  public Cell[] getShipCells() { return this.shipCells; }

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
   * @param numberOfHitCells the new number of Hit Cells to be set
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
      return true;
    }
    return false;
  }

  /**
   * Implementation of the property of hitting any ship, it shall increase the number of hits of.
   * the ship, if the ship hasn't been sunk yet.
   *
   * @return AbstractShip - an updated abstract ship
   */
  @Override
  public Ship hitThisShip() {

    if (this.getNumberOfHitCells() < this.getSize() - ONE) {
      this.setNumberOfHitCells(this.getNumberOfHitCells() + ONE);
      return this;
    } else {
      System.out.println("Sunked now");
      this.setNumberOfHitCells(this.getSize());
      return this;
    }
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractShip that = (AbstractShip) obj;
    return Objects.equals(getNumberOfHitCells(), that.getNumberOfHitCells())
        &&
        Objects.equals(size, that.size)
        &&
        Arrays.equals(shipCells, that.shipCells);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getNumberOfHitCells(), size);
    result = 31 * result + Arrays.hashCode(shipCells);
    return result;
  }
}
