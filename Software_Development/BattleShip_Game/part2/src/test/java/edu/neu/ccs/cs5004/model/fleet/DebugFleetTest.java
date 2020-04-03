package edu.neu.ccs.cs5004.model.fleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.model.ships.Submarine;
import edu.neu.ccs.cs5004.view.ConsoleReader;

import static org.junit.Assert.*;

public class DebugFleetTest {

  private class FakeConsoleReader extends ConsoleReader {
    private String fakeResponse;
    public String prompt(String unused_message) {
      return fakeResponse == null ? "" : this.fakeResponse;
    }
    public void injectFakePromptResponse(String fakeResponse) {
      this.fakeResponse = fakeResponse;
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void initializeFleetTest() {
    final int expectedNumberOfEachShip = 5;
    FakeConsoleReader fakeReader = new FakeConsoleReader();
    fakeReader.injectFakePromptResponse(expectedNumberOfEachShip+"");
    DebugFleet fleet = new DebugFleet(fakeReader);

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
    Assert.assertEquals(battleShipCounter, expectedNumberOfEachShip);
    Assert.assertEquals(cruiserCounter, expectedNumberOfEachShip);
    Assert.assertEquals(submarineCounter, expectedNumberOfEachShip);
    Assert.assertEquals(destroyerCounter, expectedNumberOfEachShip);
  }
}