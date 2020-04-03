package edu.neu.ccs.cs5004;

public class GapCell extends WaterCell {

  /**
   * Constructor for the property Gap Cell , given a boolean wasHit and a SunkStatus of the GapCell.
   *
   * @param wasHit    a boolean depicting the cell was hit before or not.
   * @param sunkState sunkState of the GapCell.
   */
  public GapCell(boolean wasHit, SunkStatus sunkState) {
    super(wasHit, sunkState);
  }

  /**
   * Implementation of the property attackThisCell ,returns an updated cell.
   *
   * @return An updated cell with the updated ship inside the cell.
   */
  @Override
  public Cell attackThisCell() {
    return new GapCell(this.isWasHit(), this.getSunkState());
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
  public String toString() {
    return "GapCell{}";
  }
}
