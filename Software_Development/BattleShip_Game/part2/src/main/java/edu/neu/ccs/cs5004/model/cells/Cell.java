package edu.neu.ccs.cs5004.model.cells;

import edu.neu.ccs.cs5004.AttackResult;
import edu.neu.ccs.cs5004.model.ShipObserver;

/**
 * represents a cell in the game.
 */
public interface Cell extends ShipObserver {


  /**
   * Implementation of the property attackThisCell, updates the cell's wasHit field.
   */
  void attackThisCell();

  /**
   * Implementation of the property attackResult on the cell. What would the result of attack would.
   * be on the cell, In case if it were attacked. Depending on the situations and the type of cells.
   * it returns Hit , Miss or Sunk.
   *
   * @return AttackResult Hit , Miss or Sunk
   */
  AttackResult attackResult();

  /**
   * returns if the cell is sunk or not.
   * @return true if the cell is part of a ship that has been sunk, false otherwise
   */
  Boolean getIsSunk();

  /**
   * asks if the cell has been hit.
   * @return true if the cell was hit, false otherwise
   */
  Boolean isHit();

}
