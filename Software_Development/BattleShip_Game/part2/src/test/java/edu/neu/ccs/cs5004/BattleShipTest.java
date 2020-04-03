package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.BattleShip;

public class BattleShipTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void constructorTest() {
    BattleShip ship = new BattleShip();
    Assert.assertEquals(BattleShip.BATTLESHIP_SIZE, ship.getSize());
  }

  @Test
  public void equalsTest() {
    // All battleships should be the same.
    BattleShip ship = new BattleShip();
    BattleShip sameShip = new BattleShip();
    BattleShip sameShip2 = new BattleShip();
    BattleShip sameReferenceShip = ship;
    BattleShip differentShip = new BattleShip();

    TestCaseUtils.assertPassesAlwaysEqualsTest(ship, sameShip, sameShip2, sameReferenceShip,
        differentShip);
  }

  @Test
  public void hashCodeTest() {
    BattleShip ship = new BattleShip();
    BattleShip sameShip = new BattleShip();
    BattleShip sameReferenceShip = ship;

    TestCaseUtils.assertPassesHashCodeTest(ship, sameShip, sameReferenceShip);
  }
}