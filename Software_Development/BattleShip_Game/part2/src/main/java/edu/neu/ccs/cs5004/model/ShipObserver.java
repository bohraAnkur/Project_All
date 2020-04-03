package edu.neu.ccs.cs5004.model;

/**
 * represents a ship observer which is updated whe notified by the ship.
 */
public interface ShipObserver {

  /**
   * updates attributes of the cell when its ship is sunk.
   */
  void update();
}
