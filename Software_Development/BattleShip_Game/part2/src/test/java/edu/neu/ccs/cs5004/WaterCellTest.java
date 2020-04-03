package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.cells.WaterCell;

public class WaterCellTest {

  private class TestWaterCell extends WaterCell {
  }

  @Before
  public void setUp() throws Exception {
  }

  public void assertPassesEqualsTest(Object original, Object copyOfOriginal,
                                     Object sameReferenceAsOriginal, Object differentFromOrignal) {
    Assert.assertTrue(original.equals(copyOfOriginal));
    Assert.assertTrue(copyOfOriginal.equals(original));
    Assert.assertTrue(original.equals(sameReferenceAsOriginal));
    Assert.assertTrue(original.equals(original));
    Assert.assertEquals(original.equals(copyOfOriginal) &&
            copyOfOriginal.equals(copyOfOriginal),
        copyOfOriginal.equals(original));
    Assert.assertNotEquals(original, new Object());
    Assert.assertNotEquals(original, differentFromOrignal);
    Assert.assertFalse(original.equals(null));
  }


  @Test
  public void getWasHit() {
    TestWaterCell waterCell = new TestWaterCell();
    Assert.assertFalse(waterCell.isHit());
    Assert.assertEquals(AttackResult.NOT_ATTACKED, waterCell.attackResult());

    waterCell.attackThisCell();
    Assert.assertTrue(waterCell.isHit());
    Assert.assertEquals(AttackResult.MISS, waterCell.attackResult());
  }

  @Test
  public void equalsTest() {
    TestWaterCell waterCell = new TestWaterCell();
    TestWaterCell sameWaterCell = new TestWaterCell();
    TestWaterCell sameReferenceWaterCell = new TestWaterCell();
    TestWaterCell differentWaterCell = new TestWaterCell();
    differentWaterCell.attackThisCell();

    assertPassesEqualsTest(waterCell, sameWaterCell, sameReferenceWaterCell, differentWaterCell);
  }

  @Test
  public void hashCodeTest() {
    TestWaterCell waterCell = new TestWaterCell();
    TestWaterCell sameWaterCell = new TestWaterCell();
    TestWaterCell sameReferenceWaterCell = waterCell;

    Assert.assertEquals(waterCell.equals(sameWaterCell),
        sameWaterCell.hashCode() == waterCell.hashCode());
    Assert.assertEquals(waterCell.equals(sameReferenceWaterCell),
        waterCell.hashCode() == sameReferenceWaterCell.hashCode());
  }
}