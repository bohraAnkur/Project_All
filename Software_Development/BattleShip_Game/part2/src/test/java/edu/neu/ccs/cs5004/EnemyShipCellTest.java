package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.cells.EnemyShipCell;

public class EnemyShipCellTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void attackResult() {
    EnemyShipCell enemyShipCell = new EnemyShipCell();
    Assert.assertEquals(AttackResult.HIT, enemyShipCell.attackResult());
  }

  @Test
  public void equalsTest() {
    EnemyShipCell enemyShipCell = new EnemyShipCell();
    EnemyShipCell sameEnemyShipCell = new EnemyShipCell();
    EnemyShipCell sameEnemyShipCell2 = new EnemyShipCell();
    EnemyShipCell differentEnemyShipCell = new EnemyShipCell();
    differentEnemyShipCell.attackThisCell();
    EnemyShipCell sameReferenceEnemyShip = enemyShipCell;
    TestCaseUtils.assertPassesEqualsTest(enemyShipCell, sameEnemyShipCell, sameEnemyShipCell2,
        sameReferenceEnemyShip, differentEnemyShipCell);
  }

  @Test
  public void hashCodeTest() {
    EnemyShipCell enemyShipCell = new EnemyShipCell();
    EnemyShipCell sameEnemyShipCell = new EnemyShipCell();
    EnemyShipCell sameReferenceEnemyShip = enemyShipCell;
    TestCaseUtils.assertPassesHashCodeTest(enemyShipCell, sameEnemyShipCell,
        sameReferenceEnemyShip);
  }

  @Test
  public void toStringTest() {
    EnemyShipCell enemyShipCell = new EnemyShipCell();
    Assert.assertTrue(enemyShipCell.toString().contains(enemyShipCell.isHit()+""));
  }
}