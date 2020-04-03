package edu.neu.ccs.cs5004.model.map;


import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.OpenSeaCell;
import edu.neu.ccs.cs5004.view.ConsolePrinterInterface;

import java.util.Arrays;



/**
 * represents a map.
 */
public abstract class AbstractMap implements MapInterface {

  /**
   * a 2d array of cells.
   */
  protected Cell[][] cellArray;

  /**
   * a constructor for the Abstract map. Initializes all cells to water cells.
   */
  public AbstractMap() {
    this.cellArray = new Cell[Row.ROW_SIZE.ordinal()][Column.COLUMN_SIZE.ordinal()];
    this.setWaterCells();
  }

  /**
   * sets all cells to water cells.
   */
  protected void setWaterCells() {
    for (int i = 0; i < Row.ROW_SIZE.ordinal(); i++) {
      for (int j = 0; j < Column.COLUMN_SIZE.ordinal(); j++) {
        this.cellArray[i][j] = new OpenSeaCell();
      }
    }
  }

  @Override
  public Cell getCell(Row row, Column column) {
    return this.cellArray[row.ordinal()][column.ordinal()];
  }

  @Override
  public void setCell(Row row, Column column, Cell newCell) {
    this.cellArray[row.ordinal()][column.ordinal()] = newCell;
  }

  @Override
  public String getPrettyString(ConsolePrinterInterface printer) {
    return printer.mapToString(this);
  }

  /**
   * checks that two objects are equal.
   * @param obj the object to be compared.
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractMap map = (AbstractMap) obj;

    for (int i = Row.ONE.ordinal(); i < Row.ROW_SIZE.ordinal(); i++) {
      for (int j = Column.A.ordinal(); j < Column.COLUMN_SIZE.ordinal(); j++) {
        if (!(this.getCell(Row.values()[i], Column.values()[j])).equals(map.getCell(Row.values()[i],
            Column.values()[j]))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(cellArray);
  }
}
