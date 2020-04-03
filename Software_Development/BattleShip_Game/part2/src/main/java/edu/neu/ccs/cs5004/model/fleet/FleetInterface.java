package edu.neu.ccs.cs5004.model.fleet;

import edu.neu.ccs.cs5004.model.ships.Ship;

import java.util.ArrayList;


/**
 * represents a fleet of ships.
 */
public interface FleetInterface {

  /**
   * Getter for the fleet of the fleet.
   *
   * @return the fleet of the map.
   */
  ArrayList<Ship> getFleet();

  /**
   * Getter for the size of the fleet.
   *
   * @return an Integer representing the number of ships in the fleet
   */

  Integer getListSize();

  /**
   * Implementation of the property if the fleet contains this ship.
   *
   * @param thisShip thisShip represents the InputSHip
   * @return a Boolean representing true or false if the ship is there inside the fleet or not
   */

  Boolean containsShip(Ship thisShip);

  /**
   * Implementation of the property if the fleet is empty.
   *
   * @return A boolean if the fleet is empty
   */

  Boolean isEmpty();

  /**
   * Implementation of the property getIndex of, returns the position at which the ship is.
   *
   * @param thisShip theShip whom's Index is to be looked upon
   * @return An Integer which represents the index of the position of the list
   */
  Integer getIndexOf(Ship thisShip);

  /**
   * Implementation of the property get ship at a given index from the ship.
   *
   * @param index represents an Integer
   * @return A ship
   */

  Ship getShip(Integer index);

  /**
   * checks if all ships in the fleet have been sunk.
   * @return true if they are all sunk, false otherwise
   */
  Boolean isFleetSunk();
}
