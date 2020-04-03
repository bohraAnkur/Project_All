package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.map.BattleMap;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.GapCell;

public class BattleMapTest {

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

  public BattleMap createBattleMapFillWith(Cell cell) {
    BattleMap battleMap = new BattleMap();
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col += 2) {
        battleMap.setCell(Row.values()[row], Column.values()[col], cell);
      }
    }
    return battleMap;
  }

  @Test
  public void equalsTest() {
    BattleMap battleMap = createBattleMapFillWith(TestUtils.getSpecificShipCellWithCruiser());
    BattleMap sameBattleMap = createBattleMapFillWith(TestUtils.getSpecificShipCellWithCruiser());
    BattleMap sameBattleMap2 = createBattleMapFillWith(TestUtils.getSpecificShipCellWithCruiser());
    BattleMap battleMapSameReference = battleMap;
    BattleMap differentBattleMap = createBattleMapFillWith(new GapCell());
    TestCaseUtils.assertPassesEqualsTest(battleMap, sameBattleMap, sameBattleMap2,
        battleMapSameReference, differentBattleMap);
  }

  @Test
  public void hashCodeTest() {
    BattleMap battleMap = createBattleMapFillWith(TestUtils.getSpecificShipCellWithDestroyer());
    BattleMap sameBattleMap = createBattleMapFillWith(TestUtils.getSpecificShipCellWithDestroyer());
    BattleMap battleMapSameReference = battleMap;
    TestCaseUtils.assertPassesHashCodeTest(battleMap, sameBattleMap, battleMapSameReference);
  }
}