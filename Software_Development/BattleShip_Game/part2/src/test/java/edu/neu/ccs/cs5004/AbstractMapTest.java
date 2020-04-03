package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import edu.neu.ccs.cs5004.model.map.AbstractMap;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.model.cells.GapCell;
import edu.neu.ccs.cs5004.model.cells.OpenSeaCell;
import edu.neu.ccs.cs5004.model.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.model.cells.WaterCell;
import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.view.ConsolePrinterInterface;

public class AbstractMapTest {

  private class TestAbstractMap extends AbstractMap {

    public TestAbstractMap() {
      super();
    }

    protected void setWaterCells() {
      for (int i = 0; i < Row.ROW_SIZE.ordinal(); i++) {
        for (int j = 0; j < Column.COLUMN_SIZE.ordinal(); j++) {
          this.cellArray[i][j] = new OpenSeaCell();
        }
      }
    }
  }

  @Before
  public void setUp() {
  }

  public Row r(String rowNum) {
    int num = Integer.parseInt(rowNum) - 1;
    return Row.values()[num];
  }

  public Column c(String colChar) {
    char c = colChar.charAt(0);
    int pos = c - 'A';
    return Column.values()[pos];
  }

  public Cell getRandomCell() {
    Cell[] cells = new Cell[]{new SpecificShipCell(null), new EnemyShipCell(),
        new OpenSeaCell(), new GapCell()};
    return cells[new Random().nextInt(cells.length)];
  }

  public TestAbstractMap createTestAbstractMapFilledWith(Cell cell) {
    TestAbstractMap abstractMap = new TestAbstractMap();
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col+=2) {
        abstractMap.setCell(Row.values()[row], Column.values()[col], cell);
      }
    }
    return abstractMap;
  }

  @Test
  public void setWaterCellsTest() {
    TestAbstractMap abstractMap = new TestAbstractMap();
    abstractMap.setWaterCells();
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        Cell cell = abstractMap.getCell(Row.values()[row], Column.values()[col]);
        Assert.assertTrue(cell instanceof WaterCell);
      }
    }
  }

  @Test
  public void setAndGetCellTest() {
    TestAbstractMap abstractMap = new TestAbstractMap();
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        Cell randomCell = getRandomCell();
        abstractMap.setCell(Row.values()[row], Column.values()[col], randomCell);
        Assert.assertTrue(
            abstractMap.getCell(Row.values()[row], Column.values()[col]).getClass().equals(
            randomCell.getClass()));
      }
    }
  }

  @Test
  public void equalsTest() {
    TestAbstractMap abstractMap = createTestAbstractMapFilledWith(new SpecificShipCell(
        new BattleShip()));
    TestAbstractMap sameAbstractMap = createTestAbstractMapFilledWith(new SpecificShipCell(
        new BattleShip()));
    TestAbstractMap sameAbstractMap2 = createTestAbstractMapFilledWith(new SpecificShipCell(
        new BattleShip()));
    TestAbstractMap abstractMapSameReference = abstractMap;
    TestAbstractMap differentAbstractMap = createTestAbstractMapFilledWith(new GapCell());
    TestCaseUtils.assertPassesEqualsTest(abstractMap, sameAbstractMap, sameAbstractMap2,
        abstractMapSameReference, differentAbstractMap);
  }

  @Test
  public void hashCodeTest() {
    TestAbstractMap abstractMap = createTestAbstractMapFilledWith(new SpecificShipCell(
        new Cruiser()));
    TestAbstractMap sameAbstractMap = createTestAbstractMapFilledWith(new SpecificShipCell(
        new Cruiser()));
    TestAbstractMap abstractMapSameReference = abstractMap;

    TestCaseUtils.assertPassesHashCodeTest(abstractMap, sameAbstractMap, abstractMapSameReference);
  }
}