package edu.neu.ccs.cs5004.model;

/**
 * represents the ship observer that sends notifications to cells.
 */
public interface ShipObservable {

  /**
   * notifies a ship's cells if the ship was sunk.
   */
  void notifyCells();
}
