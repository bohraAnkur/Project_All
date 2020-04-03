package edu.neu.ccs.cs5004.model.map;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.view.ConsolePrinterInterface;

/**
 * represents a map.
 */
public interface MapInterface {

  /**
   * Gets the cell at a specific location.
   *
   * @param row    the row where the cell is located
   * @param column the column where the cell is located
   * @return the cell at the location
   */
  Cell getCell(Row row, Column column);


  /**
   * Sets a cell at a specified location.
   *
   * @param row     the row where the cell will be located
   * @param column  the column where the cell will be located
   * @param newCell the cell that will be placed
   */
  void setCell(Row row, Column column, Cell newCell);

  /**
   * converts a map into a string.
   *
   * @param printer the printer used for the map
   * @return a string representation of the map
   */
  String getPrettyString(ConsolePrinterInterface printer);
}
