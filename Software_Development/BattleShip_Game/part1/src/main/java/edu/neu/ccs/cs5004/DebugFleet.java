package edu.neu.ccs.cs5004;

import java.util.ArrayList;

public class DebugFleet implements FleetInterface {

  Integer[] data = ConsoleReader.DebugFleetReader();

  private ArrayList<Ship> debugFleet;

  public DebugFleet() {
    this.debugFleet = new ArrayList<Ship>();

    int battleshipQuantity = this.data[1];

    int cruiserQuantity = this.data[2];

    int submarineQuantity = this.data[3];

    int destroyerQuantity = this.data[4];

    for (int i = 0; i < battleshipQuantity; i++) {
      debugFleet.add(BattleShipInterface.createBattleShip());
    }

    for (int j = 0; j < cruiserQuantity; j++) {
      debugFleet.add(CruiserInterface.createCruiserShip());
    }

    for (int k = 0; k < submarineQuantity; k++) {
      debugFleet.add(SubmarineInterface.createSubmarine());
    }

    for (int l = 0; l < destroyerQuantity; l++) {
      debugFleet.add(DestroyerInterface.createDestroyerShip());
    }
  }

  /**
   * Getter for the fleet of the fleet.
   *
   * @return the fleet of the map.
   */
  @Override
  public ArrayList<Ship> getFleet() {
    return this.debugFleet;
  }

  /**
   * Getter for the size of the fleet.
   *
   * @return an Integer representing the number of ships in the fleet
   */
  @Override
  public Integer getListSize() {
    return this.debugFleet.size();
  }

  /**
   * Implementation of the property if the fleet contains this ship.
   *
   * @param thisShip thisShip represents the InputSHip
   * @return a Boolean representing true or false if the ship is there inside the fleet or not
   */
  @Override
  public Boolean containsShip(Ship thisShip) {
    return this.debugFleet.contains(thisShip);
  }

  /**
   * Implementation of the property if the fleet is empty.
   *
   * @return A boolean if the fleet is empty
   */
  @Override
  public Boolean isEmpty() {
    return this.debugFleet.isEmpty();
  }

  /**
   * Implementation of the property getIndex of, returns the position at which the ship is.
   *
   * @param thisShip theShip whom's Index is to be looked upon
   * @return An Integer which represents the index of the position of the list
   */
  @Override
  public Integer getIndexOf(Ship thisShip) {
    return this.debugFleet.indexOf(thisShip);
  }

  /**
   * Implementation of the property removeShip , given an Index of the ship to be removed,
   * returns a boolean if the ship has been removed.
   *
   * @param index the index which is to be removed
   * @return a Boolean
   */
  @Override
  public Boolean removeShip(Integer index) {
    return this.debugFleet.remove(index);
  }

  /**
   * Implementation of the property get ship at a given index from the ship.
   *
   * @param index represents an Integer
   * @return A ship
   */
  @Override
  public Ship getShip(Integer index) {
    return this.debugFleet.get(index);
  }
}
