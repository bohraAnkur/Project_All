package edu.neu.ccs.cs5004.model.cells;

import edu.neu.ccs.cs5004.AttackResult;

import java.util.Objects;



public abstract class WaterCell implements Cell {

  private boolean hit;

  private boolean isSunk;

  /**
   * Constructor for the entity WaterCell.

   */
  public WaterCell() {
    this.hit = false;
    this.isSunk = false;
  }


  @Override
  public Boolean isHit() {
    return hit;
  }

  /**
   * Implementation of the property attackThisCell, returns an updated cell.
   */
  @Override
  public void attackThisCell() {
    this.hit = true;
  }

  @Override
  public AttackResult attackResult() {
    if (isHit()) {
      return AttackResult.MISS;
    } else {
      return AttackResult.NOT_ATTACKED;
    }
  }

  @Override
  public void update() { }

  @Override
  public Boolean getIsSunk() {
    return this.isSunk;
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
    return hit == that.hit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hit);
  }
}
