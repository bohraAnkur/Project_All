package edu.neu.ccs.cs5004;

/**
 * Represents the common properties of the ship entity.
 */
public interface Ship {
  /**
   * Implementation of the property of hitting any ship, it shall increase the number of hits of.
   * the ship, if the ship hasn't been sunk yet.
   *
   * @return AbstractShip - an updated abstract ship
   */
  Ship hitThisShip();

  /**
   * Implementation of the property isSunk possessed by every ship, shall return a boolean if the.
   * ship has been sunk. i.e- it has been hit as many times as the lives of the ship.
   *
   * @return a Boolean
   */
  Boolean isSunk();

  /**
   * Getter for the property numberOfHitCells of the AbstractShip Entity.
   *
   * @return the numberOfHitCells as an Integer
   */
  Integer getNumberOfHitCells();

  /**
   * Getter for the property Size of the Abstract ship entity.
   *
   * @return the size of the AbstractBattleship
   */
  Integer getSize();


  /**
   * Getter for the ship's cells
   * @return the ships cells
   */
  Cell[] getShipCells();
}
