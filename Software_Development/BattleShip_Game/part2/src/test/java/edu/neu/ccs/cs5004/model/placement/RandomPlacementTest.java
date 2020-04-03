package edu.neu.ccs.cs5004.model.placement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Direction;
import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.model.cells.ShipCell;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.Row;

public class RandomPlacementTest {

  private class FakeRandom extends Random {
    private int fakeRandomOutput;
    public int nextInt(int bounds) {
      if (bounds == Direction.NUM_OF_DIRECTIONS.ordinal()) {
        return Direction.VERTICAL.ordinal();
      } else {
        return this.fakeRandomOutput;
      }
    }
    public void setFakeRandomOutput(int fakeOutput) {
      this.fakeRandomOutput = fakeOutput;
    }
  }
  private class TestFleet extends StandardFleet {
    public TestFleet() {
      super();
      this.fleet = new ArrayList<Ship>();
      this.fleet.add(new Destroyer());
    }
  }
  private class TestRandomPlacement extends RandomPlacement {
    public TestRandomPlacement(MapInterface map, FleetInterface fleet, Random random) {
      super(map, fleet, random);
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void placeFleetOnMapTest() {
    FakeRandom random = new FakeRandom();
    // We should see a ship in D4
    random.setFakeRandomOutput(Row.FOUR.ordinal());

    TestRandomPlacement randomPlacement = new TestRandomPlacement(
        TestUtils.createEmptyMap(), new TestFleet(), random);

    randomPlacement.placeFleetOnMap();
    Assert.assertTrue(randomPlacement.getMap().getCell(Row.FOUR, Column.D) instanceof ShipCell);
  }
}