package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.Cruiser;

public class CruiserTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void constructorTest() {
    Cruiser ship = new Cruiser();
    Assert.assertEquals(Cruiser.CRUISER_SIZE, ship.getSize());
  }

  @Test
  public void equalsTest() {
    // All battleships should be the same.
    Cruiser ship = new Cruiser();
    Cruiser sameShip = new Cruiser();
    Cruiser sameShip2 = new Cruiser();
    Cruiser sameReferenceShip = ship;
    Cruiser differentShip = new Cruiser();

    TestCaseUtils.assertPassesAlwaysEqualsTest(ship, sameShip, sameShip2, sameReferenceShip,
        differentShip);
  }

  @Test
  public void hashCodeTest() {
    Cruiser ship = new Cruiser();
    Cruiser sameShip = new Cruiser();
    Cruiser sameReferenceShip = ship;

    TestCaseUtils.assertPassesHashCodeTest(ship, sameShip, sameReferenceShip);
  }
}