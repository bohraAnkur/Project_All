package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.GapCell;
import edu.neu.ccs.cs5004.model.map.PlayerMap;

public class PlayerMapTest {

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

  public PlayerMap createPlayerMapFilledWith(Cell cell) {
    PlayerMap playerMap = new PlayerMap();
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col += 2) {
        playerMap.setCell(Row.values()[row], Column.values()[col], cell);
      }
    }
    return playerMap;
  }

  @Test
  public void equalsTest() {
    PlayerMap playerMap = createPlayerMapFilledWith(TestUtils.getSpecificShipCellWithCruiser());
    PlayerMap samePlayerMap = createPlayerMapFilledWith(TestUtils.getSpecificShipCellWithCruiser());
    PlayerMap samePlayerMap2 = createPlayerMapFilledWith(
        TestUtils.getSpecificShipCellWithCruiser());
    PlayerMap battleMapSameReference = playerMap;
    PlayerMap differentPlayerMap = createPlayerMapFilledWith(new GapCell());
    TestCaseUtils.assertPassesEqualsTest(playerMap, samePlayerMap, samePlayerMap2,
        battleMapSameReference, differentPlayerMap);
  }

  @Test
  public void hashCodeTest() {
    PlayerMap playerMap = createPlayerMapFilledWith(TestUtils.getSpecificShipCellWithDestroyer());
    PlayerMap samePlayerMap = createPlayerMapFilledWith(
        TestUtils.getSpecificShipCellWithDestroyer());
    PlayerMap playerMapSameReference = playerMap;
    TestCaseUtils.assertPassesHashCodeTest(playerMap, samePlayerMap, playerMapSameReference);
  }
}