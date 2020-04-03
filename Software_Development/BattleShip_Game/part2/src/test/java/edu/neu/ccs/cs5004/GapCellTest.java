package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.cells.GapCell;

public class GapCellTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void toStringTest() {
    GapCell gapCell = new GapCell();
    Assert.assertTrue(gapCell.toString().contains("GapCell"));
  }
}