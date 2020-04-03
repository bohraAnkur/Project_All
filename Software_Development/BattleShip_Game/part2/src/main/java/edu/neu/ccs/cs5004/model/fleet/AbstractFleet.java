package edu.neu.ccs.cs5004.model.fleet;

import edu.neu.ccs.cs5004.model.ships.Ship;

import java.util.ArrayList;

/**
 * abstract class for the fleet.
 */
public abstract class AbstractFleet implements FleetInterface {

  /**
   * the list of ships representing the fleet.
   */
  protected ArrayList<Ship> fleet;

  /**
   * constructor for the abstract fleet.
   */
  public AbstractFleet() {
    this.fleet = new ArrayList<Ship>();
  }

  protected abstract void initializeFleet();

  /**
   * Getter for the fleet of the fleet.
   *
   * @return the fleet of the map.
   */

  public ArrayList<Ship> getFleet() {
    return this.fleet;
  }

  /**
   * Getter for the size of the fleet.
   *
   * @return an Integer representing the number of ships in the fleet
   */

  public Integer getListSize() {
    return this.fleet.size();
  }

  /**
   * Implementation of the property if the fleet contains this ship.
   *
   * @param thisShip thisShip represents the InputSHip
   * @return a Boolean representing true or false if the ship is there inside the fleet or not
   */

  public Boolean containsShip(Ship thisShip) {
    return this.fleet.contains(thisShip);
  }

  /**
   * Implementation of the property if the fleet is empty.
   *
   * @return A boolean if the fleet is empty
   */

  public Boolean isEmpty() {
    return this.fleet.isEmpty();
  }

  /**
   * Implementation of the property getIndex of, returns the last Index of the occurrence of the.
   * ship at which it is.
   *
   * @param thisShip theShip whom's Index is to be looked upon
   * @return An Integer which represents the index of the position of the list
   */
  public Integer getIndexOf(Ship thisShip) {
    return this.fleet.lastIndexOf(thisShip);
  }

  /**
   * Implementation of the property get ship at a given index from the ship.
   *
   * @param index represents an Integer
   * @return A ship
   */
  public Ship getShip(Integer index) {
    return this.fleet.get(index);

  }

  @Override
  public Boolean isFleetSunk() {
    for (int i = 0; i < this.fleet.size(); i++) {
      if (!this.getShip(i).isSunk()) {
        return false;
      }
    }
    return true;
  }

  /**
   * checks that two objects are equal.
   * @param obj the object to be compared
   * @return true if they are equal, false otherwise
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractFleet other = (AbstractFleet) obj;
    return other.getFleet().equals(this.getFleet());
  }

  public int hashCode() {
    return fleet.hashCode();
  }
}
