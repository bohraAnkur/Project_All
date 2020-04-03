package edu.neu.ccs.cs5004;


import java.util.Arrays;

public class Map implements MapInterface{

  /**
   * a 2d array of cells.
   */
  protected Cell[][] cellArray;

  public Map() {
    this.cellArray = new Cell[Row.ROW_SIZE.ordinal()][Column.COLUMN_SIZE.ordinal()];
    this.setWaterCells();
  }

  /**
   * sets all cells to water cells.
   */
  protected void setWaterCells() {
    for (int i = 0; i < Row.ROW_SIZE.ordinal(); i++) {
      for (int j = 0; j < Column.COLUMN_SIZE.ordinal(); j++) {
        this.cellArray[i][j] = new OpenSeaCell(false, SunkStatus.UNSUNKED);
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
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object obj) {
  return true;
  }


  @Override
  public int hashCode() {
    return Arrays.deepHashCode(cellArray);
  }
}

