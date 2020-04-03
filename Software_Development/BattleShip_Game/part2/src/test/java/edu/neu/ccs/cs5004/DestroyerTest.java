package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.Destroyer;

public class DestroyerTest {

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
    Assert.assertEquals(original, differentFromOrignal);
    Assert.assertFalse(original.equals(null));
  }

  @Test
  public void constructorTest() {
    Destroyer ship = new Destroyer();
    Assert.assertEquals(Destroyer.DESTROYER_SIZE, ship.getSize());
  }

  @Test
  public void equalsTest() {
    // All battleships should be the same.
    Destroyer ship = new Destroyer();
    Destroyer sameShip = new Destroyer();
    Destroyer sameReferenceShip = ship;
    Destroyer differentShip = new Destroyer();

    assertPassesEqualsTest(ship, sameShip, sameReferenceShip, differentShip);
  }

  @Test
  public void hashCodeTest() {
    Destroyer ship = new Destroyer();
    Destroyer sameShip = new Destroyer();
    Destroyer sameReferenceShip = ship;

    Assert.assertEquals(ship.equals(sameReferenceShip),
        sameReferenceShip.hashCode() == ship.hashCode());
    Assert.assertEquals(ship.equals(sameReferenceShip),
        ship.hashCode() == sameReferenceShip.hashCode());
  }
}