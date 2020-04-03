package edu.neu.ccs.cs5004.model.placement;

import org.junit.Assert;
import org.junit.Test;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Direction;
import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.map.PlayerMap;
import edu.neu.ccs.cs5004.model.ships.Ship;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.TestCaseUtils;

public class AbstractPlacementTest {

  private class TestAbstractPlacement extends AbstractPlacement {
    public TestAbstractPlacement(MapInterface map, StandardFleet fleet) {
      super(map, fleet);
    }
    @Override
    public void placeFleetOnMap() {
    }
    protected boolean isValidPlacement(Row row, Column column, Ship ship, Direction direction) {
      return super.isValidPlacement(row, column, ship, direction);
    }

    protected boolean overlapsShip(Row row, Column column, Ship ship, Direction direction) {
      return super.overlapsShip(row, column, ship, direction);
    }

    protected boolean validAtLeftAndRightHorizontal(Row row, Column column, Ship ship) {
      return super.validAtLeftAndRightHorizontal(row, column, ship);
    }

    protected boolean validAtTopAndBottomVertical(Row row, Column column, Ship ship) {
      return super.validAtTopAndBottomVertical(row, column, ship);
    }

    protected boolean validAtLeftEdgeVertical(Row row, Column column, Ship ship) {
      return super.validAtLeftEdgeVertical(row, column, ship);
    }

    protected boolean validAtRightEdgeVertical(Row row, Column column, Ship ship) {
      return super.validAtRightEdgeVertical(row, column, ship);
    }

    protected boolean validAtTopEdgeHorizontal(Row row, Column column, Ship ship) {
      return super.validAtTopEdgeHorizontal(row, column, ship);
    }

    protected boolean validAtBottomEdgeHorizontal(Row row, Column column, Ship ship) {
      return super.validAtBottomEdgeHorizontal(row, column, ship);
    }

    protected boolean hasWaterCellAt(Row row, Column column) {
      return super.hasWaterCellAt(row, column);
    }

    protected void placeVertical(Row row, Column column, int index) {
      super.placeVertical(row, column, index);
    }

    protected void placeHorizontal(Row row, Column column, int index) {
      super.placeHorizontal(row, column, index);
    }
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

  @Test
  public void testIsValidPlacementForBattleship() {
    TestAbstractPlacement fleetMap = new TestAbstractPlacement(TestUtils.createTestMap(),
        new StandardFleet());

    // Placing Battleships horizontally
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        if (row > Row.TWO.ordinal() && row < Row.NINE.ordinal()) {
          Assert.assertFalse(fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
              new BattleShip(), Direction.HORIZONTAL));
        } else if (col > c("G").ordinal()) {
          Assert.assertFalse(fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
              new BattleShip(), Direction.HORIZONTAL));
        } else {
          Assert.assertTrue(fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
              new BattleShip(), Direction.HORIZONTAL));
        }
      }
    }

    // Placing Battleships vertically
    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        if (row > Row.SEVEN.ordinal()) {
          Assert.assertFalse(fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
              new BattleShip(), Direction.VERTICAL));
        } else if (col > c("B").ordinal() && col < c("I").ordinal()) {
          Assert.assertFalse(fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
              new BattleShip(), Direction.VERTICAL));
        } else {
          Assert.assertTrue(fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
              new BattleShip(), Direction.VERTICAL));
        }
      }
    }
  }

  @Test
  public void testPlaceVertical() {
    PlayerMap emptyMap = new PlayerMap();
    TestAbstractPlacement fleetMap = new TestAbstractPlacement(emptyMap, new StandardFleet());
    int battleShipFleetIndex = 0;

    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        if (fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
            new BattleShip(), Direction.VERTICAL)) {
          fleetMap.placeVertical(Row.values()[row], Column.values()[col], battleShipFleetIndex);
          Assert.assertFalse(fleetMap.hasWaterCellAt(Row.values()[row], Column.values()[col]));
        }
      }
    }
  }

  @Test
  public void testPlaceHorizontal() {
    PlayerMap emptyMap = new PlayerMap();
    TestAbstractPlacement fleetMap = new TestAbstractPlacement(emptyMap, new StandardFleet());
    int battleShipFleetIndex = 0;

    for (int row = r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        if (fleetMap.isValidPlacement(Row.values()[row], Column.values()[col],
            new BattleShip(), Direction.HORIZONTAL)) {
          fleetMap.placeHorizontal(Row.values()[row], Column.values()[col], battleShipFleetIndex);
          Assert.assertFalse(fleetMap.hasWaterCellAt(Row.values()[row], Column.values()[col]));
        }
      }
    }
  }

  @Test
  public void equalsTest() {
    TestAbstractPlacement fleet = new TestAbstractPlacement(TestUtils.createEmptyMap(),
        new StandardFleet());
    TestAbstractPlacement copyFleet = new TestAbstractPlacement(TestUtils.createEmptyMap(),
        new StandardFleet());
    TestAbstractPlacement copyFleet2 = new TestAbstractPlacement(TestUtils.createEmptyMap(),
        new StandardFleet());
    TestAbstractPlacement fleetSameReference = fleet;
    TestAbstractPlacement differentFleet = new TestAbstractPlacement(TestUtils.createTestMap(),
        new StandardFleet());
    TestCaseUtils.assertPassesEqualsTest(fleet, copyFleet, copyFleet2, fleetSameReference,
        differentFleet);
  }

  @Test
  public void hashCodeTest() {
    TestAbstractPlacement fleet = new TestAbstractPlacement(TestUtils.createEmptyMap(),
        new StandardFleet());
    TestAbstractPlacement copyFleet = new TestAbstractPlacement(TestUtils.createEmptyMap(),
        new StandardFleet());
    TestAbstractPlacement fleetSameReference = fleet;
    TestCaseUtils.assertPassesHashCodeTest(fleet, copyFleet, fleetSameReference);
  }
}