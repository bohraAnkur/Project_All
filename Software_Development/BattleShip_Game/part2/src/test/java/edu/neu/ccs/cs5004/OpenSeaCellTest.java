package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.cells.OpenSeaCell;

public class OpenSeaCellTest {

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
  public void equalsTest() {
    OpenSeaCell openSeaCell = new OpenSeaCell();
    assertPassesEqualsTest(openSeaCell, openSeaCell, openSeaCell, openSeaCell);
  }

  @Test
  public void hashCodeTest() {
    OpenSeaCell openSeaCell = new OpenSeaCell();
    OpenSeaCell sameOpenSeaCell = new OpenSeaCell();
    OpenSeaCell sameReferenceOpenSeaCell = openSeaCell;

    Assert.assertEquals(openSeaCell.equals(sameOpenSeaCell),
        sameOpenSeaCell.hashCode() == openSeaCell.hashCode());
    Assert.assertEquals(openSeaCell.equals(sameReferenceOpenSeaCell),
        openSeaCell.hashCode() == sameReferenceOpenSeaCell.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertTrue(new OpenSeaCell().toString().contains("OpenSeaCell"));
  }
}