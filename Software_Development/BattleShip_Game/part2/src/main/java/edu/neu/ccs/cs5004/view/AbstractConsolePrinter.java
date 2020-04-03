package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.map.MapInterface;

/**
 * represents a printer.
 */
public abstract class AbstractConsolePrinter implements ConsolePrinterInterface {

  /**
   * A constructor for the AbstractConsolePrinter class.
   */
  public AbstractConsolePrinter() {
  }

  /**
   * Converts the cell type into it's string representation.
   *
   * @param cell the cell which will be converted
   * @return a string representing the cell
   */
  protected abstract String cellTypeToString(Cell cell);

  @Override
  public String mapToString(MapInterface map) {
    StringBuilder mapString = new StringBuilder("");
    mapString.append("\t");

    for (int i = Column.A.ordinal(); i < Column.COLUMN_SIZE.ordinal(); i++) {
      mapString.append(" " + Column.values()[i].toString() + " ");
    }
    mapString.append("\n");

    for (int i = 0; i < Row.ROW_SIZE.ordinal(); i++) {
      mapString.append(" " + (Row.values()[i].ordinal() + 1) + "\t");

      for (int j = Column.A.ordinal(); j < Column.COLUMN_SIZE.ordinal(); j++) {
        mapString.append(cellTypeToString(map.getCell(Row.values()[i], Column.values()[j])));
      }

      mapString.append("\n");
    }
    return mapString.toString();
  }




  /**
   * compares two objects to determine if they are equal.
   *
   * @param obj takes in an object
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    return obj != null && getClass() == obj.getClass();
  }

  /**
   * creates a string containing the objects parameters and values.
   *
   * @return a string
   */
  @Override
  public int hashCode() {
    return 42;
  }

}