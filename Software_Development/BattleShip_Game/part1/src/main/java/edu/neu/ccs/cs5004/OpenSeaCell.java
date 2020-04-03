package edu.neu.ccs.cs5004;

/**
 * Represents the common properties of the OpenSeaCell entity.
 */

public class OpenSeaCell extends WaterCell {
  /**
   * Constructor of the OpenSeaCell Entity, given a boolean wasHit and the sunkState of the.
   * OpenSeaCell entity.
   *
   * @param wasHit    a boolean depicting wether the cell was hit or not
   * @param sunkState sunkState of the OpenSeaCell
   */
  public OpenSeaCell(boolean wasHit, SunkStatus sunkState) {
    super(wasHit, sunkState);
  }


  /**
   * Implementation of the property attackThisCell ,returns an updated cell.
   *
   * @return An updated cell with the updated ship inside the cell
   */

  @Override
  public Cell attackThisCell() {
    return new OpenSeaCell(this.isWasHit(), this.getSunkState());
  }

  /**
   * Implementation of the property attackResult on the cell. What would the result of attack would.
   * be on the cell, In case if it were attacked. Depending on the situations and the type of cells.
   * it returns Hit , Miss or Sunk.
   *
   * @return Attackable: Hit , Miss or Sunk
   */

  @Override
  public AttackResult attackResult() {
    return AttackResult.MISS;
  }

  @Override
  public String toString() {
    return "OpenSeaCell{}";
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
