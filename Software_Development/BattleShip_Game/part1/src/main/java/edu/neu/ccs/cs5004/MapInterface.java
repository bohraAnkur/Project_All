package edu.neu.ccs.cs5004;

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
   * prints a map.
   *
   * @param printer the printer that will be used
   */
  void prettyPrint(ConsolePrinter printer);
}
