package edu.neu.ccs.cs5004.model.fleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.model.ships.Submarine;

import static org.junit.Assert.*;

public class StandardFleetTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void initializeFleetTest() {
    StandardFleet fleet = new StandardFleet();
    int battleShipCounter = 0;
    int cruiserCounter = 0;
    int submarineCounter = 0;
    int destroyerCounter = 0;
    for (Ship ship : fleet.getFleet()) {
      if (ship.equals(new BattleShip())) {
        battleShipCounter++;
      } else if (ship.equals(new Cruiser())) {
        cruiserCounter++;
      } else if (ship.equals(new Submarine())) {
        submarineCounter++;
      } else if (ship.equals(new Destroyer())) {
        destroyerCounter++;
      }
    }
    Assert.assertEquals(battleShipCounter, 1);
    Assert.assertEquals(cruiserCounter, 2);
    Assert.assertEquals(submarineCounter, 3);
    Assert.assertEquals(destroyerCounter, 4);
  }
}