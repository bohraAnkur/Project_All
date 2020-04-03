package edu.neu.ccs.cs5004;

public interface Cell {


  /**
   * Implementation of the property attackThisCell ,returns an updated cell.
   *
   * @return An updated cell with the updated ship inside the cell
   */
  Cell attackThisCell();

  /**
   * Implementation of the property attackResult on the cell. What would the result of attack would.
   * be on the cell, In case if it were attacked. Depending on the situations and the type of cells.
   * it returns Hit , Miss or Sunk.
   *
   * @return AttackResult Hit , Miss or Sunk
   */

  AttackResult attackResult();

}
