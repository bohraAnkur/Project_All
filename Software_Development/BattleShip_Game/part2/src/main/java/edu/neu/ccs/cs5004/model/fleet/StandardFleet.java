package edu.neu.ccs.cs5004.model.fleet;

import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Submarine;


public class StandardFleet extends AbstractFleet {

  /**
   * a constructor for the standard fleet.
   */
  public StandardFleet() {
    super();
    this.initializeFleet();
  }

  /**
   * method to initialize the fleet.
   */
  protected void initializeFleet() {
    this.fleet.add(new BattleShip());
    for (int i = 0; i < 2; i++) {
      this.fleet.add(new Cruiser());
    }
    for (int i = 0; i < 3; i++) {
      this.fleet.add(new Submarine());
    }
    for (int i = 0; i < 4; i++) {
      this.fleet.add(new Destroyer());
    }
  }
}
