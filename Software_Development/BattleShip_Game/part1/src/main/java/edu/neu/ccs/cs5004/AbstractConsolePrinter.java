package edu.neu.ccs.cs5004;

import java.util.Arrays;

/**
 * represents a printer.
 */
public abstract class AbstractConsolePrinter implements ConsolePrinterInterface {

  /**
   * An array with the string representations of cells.
   */
  protected final String[] cellToString;


  /**
   * A constructor for the AbstractConsolePrinter class.
   */
  public AbstractConsolePrinter() {
    cellToString = new String[]{
        /* WaterCell*/ "[ ]",
        /*Ship*/ "[s]",
        /*Error*/ "[X]"
    };

  }


  /**
   * Converts the cell type into it's string representation.
   *
   * @param cell the cell which will be converted
   * @return a string representing the cell
   */
  protected abstract String cellTypeToString(Cell cell);


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
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractConsolePrinter that = (AbstractConsolePrinter) obj;
    return Arrays.equals(cellToString, that.cellToString);
  }

  /**
   * creates a string containing the objects parameters and values.
   *
   * @return a string
   */
  @Override
  public int hashCode() {
    return Arrays.hashCode(cellToString);
  }
}