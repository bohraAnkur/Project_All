package edu.neu.ccs.cs5004;

import java.util.Objects;

public abstract class WaterCell implements Cell {

  private boolean wasHit;

  private SunkStatus sunkState;

  /**
   * Constructor for the entity AbstractWaterCell, given a Boolean wasHit and a Boolean sunkState.
   *
   * @param wasHit    a boolean was the cell been hit before
   * @param sunkState the sunkState of the cell.
   */
  public WaterCell(boolean wasHit, SunkStatus sunkState) {
    this.wasHit = wasHit;
    this.sunkState = sunkState;
  }

  /**
   * Getter for the property WasHit of the cell, returns a boolean.
   *
   * @return WasHit of the cell as a boolean
   */

  public boolean isWasHit() {
    return wasHit;
  }

  /**
   * Getter for the property sunkStatus of the cell.
   *
   * @return the sunkStatus of the cell
   */

  public SunkStatus getSunkState() {
    return sunkState;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    WaterCell that = (WaterCell) object;
    return wasHit == that.wasHit
        &&
        Objects.equals(sunkState, that.sunkState);
  }

  @Override
  public int hashCode() {

    return Objects.hash(wasHit, sunkState);
  }
}
