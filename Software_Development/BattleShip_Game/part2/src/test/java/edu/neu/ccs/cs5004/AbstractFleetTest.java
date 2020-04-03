package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.fleet.AbstractFleet;
import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.model.ships.Submarine;

public class AbstractFleetTest {

  private class TestAbstractFleet extends AbstractFleet {
    public static final int FLEET_TEST_SIZE = 4;
    public TestAbstractFleet() {
      super();
    }

    protected void initializeFleet() {}

    public TestAbstractFleet fillWithJunkShipsForTesting() {
      this.fleet.add(new BattleShip());
      this.fleet.add(new Cruiser());
      this.fleet.add(new Destroyer());
      this.fleet.add(new Submarine());
      return this;
    }

    public TestAbstractFleet fillWithOneMoreJunkShip() {
      this.fleet.add(new Destroyer());
      return this;
    }

    public TestAbstractFleet fillWithJunkSunkShipsForTesting() {
      this.fleet.clear();
      this.fillWithJunkShipsForTesting();
      for (Ship ship : this.fleet) {
        for (int i = 0; i < ship.getSize(); i++) {
          ship.hitThisShip();
        }
      }
      return this;
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void constructorTest() {
    Integer expectedFleetSize = TestAbstractFleet.FLEET_TEST_SIZE;
    TestAbstractFleet fleet = new TestAbstractFleet();

    Assert.assertTrue(fleet.isEmpty());

    fleet.fillWithJunkShipsForTesting();

    Assert.assertFalse(fleet.isEmpty());

    Assert.assertNotEquals(fleet.getFleet(), null);
    Assert.assertEquals(expectedFleetSize, fleet.getListSize());
    Assert.assertEquals(expectedFleetSize.intValue(), fleet.getFleet().size());

    Assert.assertTrue(fleet.containsShip(new BattleShip()));
    Assert.assertTrue(fleet.containsShip(new Destroyer()));
    Assert.assertTrue(fleet.containsShip(new Cruiser()));
    Assert.assertTrue(fleet.containsShip(new Submarine()));

    Assert.assertTrue(fleet.getIndexOf(new BattleShip()) > -1);
    Assert.assertTrue(fleet.getIndexOf(new Destroyer()) > -1);
    Assert.assertTrue(fleet.getIndexOf(new Cruiser()) > -1);
    Assert.assertTrue(fleet.getIndexOf(new Submarine()) > -1);

    Assert.assertEquals(fleet.getShip(fleet.getIndexOf(new BattleShip())), new BattleShip());
    Assert.assertEquals(fleet.getShip(fleet.getIndexOf(new Destroyer())), new Destroyer());
    Assert.assertEquals(fleet.getShip(fleet.getIndexOf(new Cruiser())), new Cruiser());
    Assert.assertEquals(fleet.getShip(fleet.getIndexOf(new Submarine())), new Submarine());
  }

  @Test
  public void isFleetSunkTest() {
    TestAbstractFleet fleet = new TestAbstractFleet();
    fleet.fillWithJunkShipsForTesting();
    Assert.assertFalse(fleet.isFleetSunk());
    fleet.fillWithJunkSunkShipsForTesting();
    Assert.assertTrue(fleet.isFleetSunk());
  }

  @Test
  public void equalsTest() {
    TestAbstractFleet fleet = new TestAbstractFleet().fillWithJunkShipsForTesting();
    TestAbstractFleet fleetCopy = new TestAbstractFleet().fillWithJunkShipsForTesting();
    TestAbstractFleet fleetCopy2 = new TestAbstractFleet().fillWithJunkShipsForTesting();
    TestAbstractFleet fleetSameReference = fleet;
    TestAbstractFleet fleetDifferent = new TestAbstractFleet().fillWithOneMoreJunkShip();

    TestCaseUtils.assertPassesEqualsTest(fleet, fleetCopy, fleetCopy2, fleetSameReference,
        fleetDifferent);
  }

  @Test
  public void hashCodeTest() {
    TestAbstractFleet fleet = new TestAbstractFleet().fillWithJunkShipsForTesting();
    TestAbstractFleet fleetCopy = new TestAbstractFleet().fillWithJunkShipsForTesting();
    TestAbstractFleet fleetSameReference = fleet;

    TestCaseUtils.assertPassesHashCodeTest(fleet, fleetCopy, fleetSameReference);
  }
}