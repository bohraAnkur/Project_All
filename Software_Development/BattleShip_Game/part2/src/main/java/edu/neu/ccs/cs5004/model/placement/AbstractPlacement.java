package edu.neu.ccs.cs5004.model.placement;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Direction;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.cells.WaterCell;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.ships.Ship;

import java.util.Objects;


/**
 * abstract class for placement.
 */
public abstract class AbstractPlacement implements Placement {


  protected MapInterface map;
  protected FleetInterface fleet;

  /**
   * constructor for the abstract class.
   * @param map the map
   * @param fleet the fleet
   */
  public AbstractPlacement(MapInterface map, FleetInterface fleet) {
    this.map = map;
    this.fleet = fleet;
  }

  @Override
  public MapInterface getMap() {
    return this.map;
  }

  @Override
  public FleetInterface getFleet() {
    return this.fleet;
  }

  /**
   * checks if the intended placement of the ship is valid
   * no adjacent ship cells and cells cannot be off of the board.
   *
   * @param row       the row that the first cell of the ship will be placed in
   * @param column    the column that the first cell of the ship will be placed in
   * @param ship      the ship that will be placed
   * @param direction the direction that the ship will be placed in
   *
   * @return true if ship can be placed in given row and column, false otherwise.
   */

  protected boolean isValidPlacement(Row row, Column column, Ship ship, Direction direction) {

    if (direction == Direction.VERTICAL) {
      return validAtTopAndBottomVertical(row, column, ship)
          && validAtLeftEdgeVertical(row, column, ship)
          && validAtRightEdgeVertical(row, column, ship)
          && !overlapsShip(row, column, ship, direction);
    }
    if (direction == Direction.HORIZONTAL) {
      return validAtLeftAndRightHorizontal(row, column, ship)
          && validAtTopEdgeHorizontal(row, column, ship)
          && validAtBottomEdgeHorizontal(row, column, ship)
          && !overlapsShip(row, column, ship, direction);
    }
    return false;
  }

  /**
   * Checks to see if the ship to be placed is overlapping a different ship.
   *
   * @param row the row that the ship is being placed in
   * @param column the column that the ship is being placed in
   * @param ship the ship that will be placed
   * @param direction the direction that the ship will be placed in
   * @return true id the ship is overlapping another ship, false otherwise
   */

  protected boolean overlapsShip(Row row, Column column, Ship ship, Direction direction) {
    int rowVal = row.ordinal();
    int columnVal = column.ordinal();

    for (int i = 0; i < ship.getSize(); i++) {
      int currRow = direction == Direction.VERTICAL ? rowVal + i : rowVal;
      int currColumn = direction == Direction.HORIZONTAL ? columnVal + i : columnVal;
      if (!hasWaterCellAt(Row.values()[currRow], Column.values()[currColumn])) {
        return true;
      }
    }
    return false;
  }
  /**
   * Checks that the left and right edges for a horizontal placement are valid.
   *
   * @param row the row where the ship will be placed
   * @param column the column where the first cell will be placed
   * @param ship the ship that will be placed
   * @return true if the placement is valid, false otherwise
   */
  protected boolean validAtLeftAndRightHorizontal(Row row, Column column, Ship ship) {
    int colVal = column.ordinal();

    boolean shipLeftAtMapEdge = colVal - 1 == -1;
    boolean shipOutOfBounds = colVal + ship.getSize() - 1 >= Column.COLUMN_SIZE.ordinal();
    boolean shipRightAtMapEdge = !shipOutOfBounds
        && colVal + ship.getSize() == Column.COLUMN_SIZE.ordinal();

    boolean validLeft = shipLeftAtMapEdge
        || (!shipLeftAtMapEdge && hasWaterCellAt(row, Column.values()[colVal - 1]));
    boolean validRight = !shipOutOfBounds && (shipRightAtMapEdge
        || (!shipRightAtMapEdge && hasWaterCellAt(row, Column.values()[colVal + ship.getSize()])));

    return validLeft && validRight;
  }

  /**
   *When vertical placement is being used, checks that the top and bottom cells of the ship can be
   * placed.
   *
   * @param row the row where the first cell of the ship will be placed
   * @param column the column the ship will be placed
   * @param ship the ship that will be placed
   * @return true if there are no rule violations, false otherwise
   */
  protected boolean validAtTopAndBottomVertical(Row row, Column column, Ship ship) {
    int rowVal = row.ordinal();
    boolean shipTopAtMapEdge = rowVal - 1 == -1;
    boolean shipOutOfBounds = rowVal + ship.getSize() - 1 >= Row.ROW_SIZE.ordinal();
    boolean shipBottomAtMapEdge = !shipOutOfBounds
        && rowVal + ship.getSize() == Row.ROW_SIZE.ordinal();

    boolean validTop = shipTopAtMapEdge
        || (!shipTopAtMapEdge && hasWaterCellAt(Row.values()[rowVal - 1], column));
    boolean validBottom = !shipOutOfBounds && (shipBottomAtMapEdge
        || (!shipBottomAtMapEdge && hasWaterCellAt(Row.values()[rowVal + ship.getSize()], column)));

    return validTop && validBottom;
  }

  /**
   * For vertical placement, checks the left edge of the ship for valid placement area.
   *
   * @param row    the row where the ship will be placed
   * @param column the column where the ship will be placed
   * @param ship   the ship to be placed
   * @return true if the ship can be placed, false otherwise
   */
  protected boolean validAtLeftEdgeVertical(Row row, Column column, Ship ship) {
    int rowVal = row.ordinal();
    int colVal = column.ordinal();
    boolean leftOutOfBounds = colVal - 1 < 0;
    if (leftOutOfBounds) {
      return true;
    } else {
      for (int i = 0; i < ship.getSize(); i++) {
        if (!hasWaterCellAt(Row.values()[rowVal + i], Column.values()[colVal - 1])) {
          return false;
        }
      }
      return true;
    }
  }

  /**
   * For vertical placement, checks the right edge of the ship for valid placement area.
   *
   * @param row    the row where the ship will be placed
   * @param column the column where the ship will be placed
   * @param ship   the ship to be placed
   * @return true if the ship can be placed, false otherwise
   */
  protected boolean validAtRightEdgeVertical(Row row, Column column, Ship ship) {
    int rowVal = row.ordinal();
    int colVal = column.ordinal();
    boolean rightOutOfBounds = colVal + 1 >= Column.COLUMN_SIZE.ordinal();
    if (rightOutOfBounds) {
      return true;
    } else {
      for (int i = 0; i < ship.getSize(); i++) {
        if (!hasWaterCellAt(Row.values()[rowVal + i], Column.values()[colVal + 1])) {
          return false;
        }
      }
      return true;
    }
  }


  /**
   * For horizontal placement, checks the top edge of the ship for valid placement area.
   *
   * @param row    the row where the ship will be placed
   * @param column the column where the ship will be placed
   * @param ship   the ship to be placed
   * @return true if the ship can be placed, false otherwise
   */
  protected boolean validAtTopEdgeHorizontal(Row row, Column column, Ship ship) {
    int rowVal = row.ordinal();
    int colVal = column.ordinal();
    boolean topOutOfBounds = rowVal - 1 < 0;
    if (topOutOfBounds) {
      return true;
    } else {
      for (int i = 0; i < ship.getSize(); i++) {
        if (!hasWaterCellAt(Row.values()[rowVal - 1], Column.values()[colVal + i])) {
          return false;
        }
      }
      return true;
    }
  }

  /**
   * For horizontal placement, checks the bottom edge of the ship for valid placement area.
   *
   * @param row    the row where the ship will be placed
   * @param column the column where the ship will be placed
   * @param ship   the ship to be placed
   * @return true if the ship can be placed, false otherwise
   */
  protected boolean validAtBottomEdgeHorizontal(Row row, Column column, Ship ship) {
    int rowVal = row.ordinal();
    int colVal = column.ordinal();
    boolean bottomOutOfBounds = rowVal + 1 >= Row.ROW_SIZE.ordinal();
    if (bottomOutOfBounds) {
      return true;
    } else {
      for (int i = 0; i < ship.getSize(); i++) {
        if (!hasWaterCellAt(Row.values()[rowVal + 1], Column.values()[colVal + i])) {
          return false;
        }
      }
      return true;
    }
  }


  /**
   * looks at a cell to verify if it is a WaterCell or null.
   *
   * @param row    the row of the cell
   * @param column the column of the cell
   * @return true if the cell is a WaterCell or null, false otherwise
   */
  protected boolean hasWaterCellAt(Row row, Column column) {
    return this.map.getCell(row, column) instanceof WaterCell;
  }

  /**
   * places a ship vertically.
   *
   * @param row the row where the first cell will be placed
   * @param column the column where the ship will be placed
   * @param index the index of the ship
   */
  protected void placeVertical(Row row, Column column, int index) {
    for (int i = 0; i < this.fleet.getFleet().get(index).getSize(); i++) {
      this.map.setCell(Row.values()[row.ordinal() + i],
          column, this.fleet.getFleet().get(index).getShipCells()[i]);
    }
  }

  /**
   * places a ship horizontally.
   *
   * @param row the row where the ship will be placed
   * @param column the column where the first cell of the ship will be placed
   * @param index the index that the ship resides in in the fleet.
   */
  protected void placeHorizontal(Row row, Column column, int index) {
    for (int i = 0; i < this.fleet.getFleet().get(index).getSize(); i++) {
      this.map.setCell(row, Column.values()[column.ordinal() + i],
          this.fleet.getFleet().get(index).getShipCells()[i]);
    }
  }

  /**
   * checks that two objects are equal.
   * @param obj the object to be compared
   * @return true if equal, false otherwise
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractPlacement other = (AbstractPlacement) obj;
    return other.getFleet().equals(this.getFleet())
        && other.getMap().equals(this.getMap());
  }

  public int hashCode() {
    return Objects.hash(this.map, this.fleet);
  }
}
