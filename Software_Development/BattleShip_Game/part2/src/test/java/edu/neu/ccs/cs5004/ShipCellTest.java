package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.model.cells.ShipCell;

public class ShipCellTest {

  private class TestShipCell extends ShipCell {
    public TestShipCell(Ship ship) {
      super(ship);
    }
    public Ship getShip() {
      return super.getShip();
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void attackThisCell() {
    TestShipCell shipCell = new TestShipCell(new BattleShip());
    Assert.assertFalse(shipCell.isHit());
    shipCell.attackThisCell();
    Assert.assertTrue(shipCell.isHit());
    shipCell.attackThisCell();
    Assert.assertTrue(shipCell.isHit());
  }

  @Test
  public void getShip() {
    Assert.assertEquals(new TestShipCell(new BattleShip()).getShip(), new BattleShip());
  }

  @Test
  public void attackResult() {
    TestShipCell shipCell = new TestShipCell(new BattleShip());
    Assert.assertEquals(AttackResult.NOT_ATTACKED, shipCell.attackResult());
    shipCell.attackThisCell();
    Assert.assertEquals(AttackResult.HIT, shipCell.attackResult());
    shipCell.attackThisCell();
    Assert.assertEquals(AttackResult.HIT, shipCell.attackResult());
  }

  @Test
  public void equals() {
    TestShipCell shipCell = new TestShipCell(new BattleShip());
    TestShipCell sameShipCell = new TestShipCell(new BattleShip());
    TestShipCell sameShipCell2 = new TestShipCell(new BattleShip());
    TestShipCell differentShipCell = new TestShipCell(new BattleShip());
    differentShipCell.attackThisCell();
    TestShipCell sameReferenceShipCell = shipCell;
    TestCaseUtils.assertPassesEqualsTest(shipCell, sameShipCell, sameShipCell2,
        sameReferenceShipCell, differentShipCell);
  }

  @Test
  public void hashCodeTest() {
    TestShipCell shipCell = new TestShipCell(new BattleShip());
    TestShipCell sameShipCell = new TestShipCell(new BattleShip());
    TestShipCell sameReferenceShipCell = shipCell;
    TestCaseUtils.assertPassesHashCodeTest(shipCell, sameShipCell, sameReferenceShipCell);
  }

  @Test
  public void toStringTest() {
    TestShipCell shipCell = new TestShipCell(new BattleShip());
    Assert.assertTrue(shipCell.toString().contains(shipCell.isHit()+""));
  }
}