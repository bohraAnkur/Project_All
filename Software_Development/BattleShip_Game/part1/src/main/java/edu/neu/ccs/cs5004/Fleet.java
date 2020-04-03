package edu.neu.ccs.cs5004;

import java.util.ArrayList;

public class Fleet implements FleetInterface {
  private Integer zero = Integer.valueOf(0);

  private ArrayList<Ship> fleet;


  public Fleet() {
    this.fleet = new ArrayList<Ship>();

    this.fleet.add(BattleShipInterface.createBattleShip());

    for (int i = 0; i < 2; i++) {
      this.fleet.add(CruiserInterface.createCruiserShip());
    }

    for (int i = 0; i < 3; i++) {
      this.fleet.add(SubmarineInterface.createSubmarine());
    }

    for (int i = 0; i < 4; i++) {

      this.fleet.add(DestroyerInterface.createDestroyerShip());
    }

  }

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
   * Implementation of the property getIndex of, returns the last Index of the occurence of the.
   * ship at which it is.
   *
   * @param thisShip theShip whom's Index is to be looked upon
   * @return An Integer which represents the index of the position of the list
   */
  public Integer getIndexOf(Ship thisShip) {
    return this.fleet.lastIndexOf(thisShip);
  }

  /**
   * Implementation of the property removeShip , given an Index of the ship to be removed,
   * returns a boolean if the ship has been removed.
   *
   * @param index the index which is to be removed
   * @return a Boolean
   */
  public Boolean removeShip(Integer index) {
    return this.fleet.remove(index);
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
}
