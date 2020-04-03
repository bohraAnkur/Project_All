package edu.neu.ccs.cs5004.model.placement;

import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;

/**
 * represents a player's placement of a fleet on a map.
 */
public interface Placement {

  /**
   * places all ships within a fleet onto a map.
   */
  void placeFleetOnMap();

  /**
   * getter for the map.
   *
   * @return the map
   */
  MapInterface getMap();

  /**
   * getter for the fleet.
   *
   * @return the fleet
   */
  FleetInterface getFleet();

}
