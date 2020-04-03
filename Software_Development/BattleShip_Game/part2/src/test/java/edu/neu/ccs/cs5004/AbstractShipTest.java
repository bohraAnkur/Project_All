package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import edu.neu.ccs.cs5004.model.ships.AbstractShip;

public class AbstractShipTest {

  private class TestAbstractShip extends AbstractShip {

    public TestAbstractShip(Integer size) {
      super(size);
    }
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
  public void constructorTest() {
    final int testSize = new Random().nextInt(10000);
    TestAbstractShip abstractShip = new TestAbstractShip(testSize);

    Assert.assertFalse(abstractShip.getShipCells() == null);
    Assert.assertEquals(testSize, abstractShip.getShipCells().length);
    Assert.assertEquals(0, abstractShip.getNumberOfHitCells().intValue());
    Assert.assertFalse(abstractShip.isSunk());
  }

  @Test
  public void setterAndGetterBehaviorTest() {
    final int testSize = new Random().nextInt(10000);
    TestAbstractShip abstractShip = new TestAbstractShip(testSize);

    for (int hitCells = 0; hitCells < 10000; hitCells++) {
      abstractShip.setNumberOfHitCells(hitCells);
      Assert.assertEquals(hitCells, abstractShip.getNumberOfHitCells().intValue());
      Assert.assertEquals(hitCells >= testSize, abstractShip.isSunk());
    }
  }

  @Test
  public void hitThisShip() {
    final int testSize = new Random().nextInt(10000);
    TestAbstractShip abstractShip = new TestAbstractShip(testSize);

    for (int i = 1; i < 10000; i++) {
      abstractShip.hitThisShip();
      int hitCells = i < testSize ? i : testSize;
      Assert.assertEquals(hitCells, abstractShip.getNumberOfHitCells().intValue());
      Assert.assertEquals(hitCells >= testSize, abstractShip.isSunk());
    }
  }

  @Test
  public void equalsTest() {
    final int testSize = new Random().nextInt(10000);
    TestAbstractShip abstractShip = new TestAbstractShip(testSize);
    TestAbstractShip sameAbstractShip = new TestAbstractShip(testSize);
    TestAbstractShip differentAbstractShip = new TestAbstractShip(testSize+1);
    TestAbstractShip sameReferenceAbstractShip = abstractShip;
    assertPassesEqualsTest(abstractShip, sameAbstractShip, sameReferenceAbstractShip,
        differentAbstractShip);
  }

  @Test
  public void hashCodeTest() {
    final int testSize = new Random().nextInt(10000);
    TestAbstractShip abstractShip = new TestAbstractShip(testSize);
    TestAbstractShip sameAbstractShip = new TestAbstractShip(testSize);
    TestAbstractShip sameReferenceAbstractShip = abstractShip;

    TestCaseUtils.assertPassesHashCodeTest(abstractShip, sameAbstractShip,
        sameReferenceAbstractShip);
  }
}