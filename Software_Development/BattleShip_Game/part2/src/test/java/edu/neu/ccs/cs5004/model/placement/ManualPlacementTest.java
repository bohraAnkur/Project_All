package edu.neu.ccs.cs5004.model.placement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.fakes.FakeConsoleReader;
import edu.neu.ccs.cs5004.model.cells.ShipCell;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.view.ConsoleReader;

public class ManualPlacementTest {

  private class TestFleet extends StandardFleet {
    public TestFleet() {
      super();
      this.fleet = new ArrayList<Ship>();
      this.fleet.add(new Destroyer());
    }
  }
  private class TestManualPlacement extends ManualPlacement {
    public TestManualPlacement(MapInterface map, FleetInterface fleet, ConsoleReader reader) {
      super(map, fleet, reader);
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void placeFleetOnMap() {
    FakeConsoleReader fakeConsoleReader = new FakeConsoleReader();
    fakeConsoleReader.injectPromptResponseSequence(new String[] {"A1", "v",
        "C1", "v", "E1", "h", "A6", "v"});
    TestManualPlacement manualPlacement = new TestManualPlacement(
        TestUtils.createEmptyMap(), TestUtils.createFleetOf(4), fakeConsoleReader);
    manualPlacement.placeFleetOnMap();
    Assert.assertTrue(manualPlacement.getMap().getCell(Row.ONE, Column.A) instanceof ShipCell);
  }
}