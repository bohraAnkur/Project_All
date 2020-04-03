package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.cells.SpecificShipCell;

public class SpecificShipCellTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void toStringTest() {
    Assert.assertTrue(new SpecificShipCell(new Cruiser()).toString().contains("SpecificShipCell"));
  }

  @Test
  public void equalsTest() {
    SpecificShipCell specShipCell = new SpecificShipCell(new BattleShip());
    SpecificShipCell sameSpecShipCell = new SpecificShipCell(new BattleShip());
    SpecificShipCell sameSpecShipCell2 = new SpecificShipCell(new BattleShip());
    SpecificShipCell differentSpecShipCell = new SpecificShipCell(new Cruiser());
    SpecificShipCell sameReferenceSpecShipCell = specShipCell;
    TestCaseUtils.assertPassesEqualsTest(specShipCell, sameSpecShipCell, sameSpecShipCell2,
        sameReferenceSpecShipCell, differentSpecShipCell);
  }

  @Test
  public void hashCodeTest() {
    SpecificShipCell specShipCell = new SpecificShipCell(new BattleShip());
    SpecificShipCell sameSpecShipCell = new SpecificShipCell(new BattleShip());
    SpecificShipCell sameReferenceSpecShipCell = specShipCell;

    TestCaseUtils.assertPassesHashCodeTest(specShipCell, sameSpecShipCell,
        sameReferenceSpecShipCell);
  }
}