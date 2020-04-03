package edu.neu.ccs.cs5004.view;


import edu.neu.ccs.cs5004.CellType;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.ShipCell;
import edu.neu.ccs.cs5004.model.cells.WaterCell;

/**
 * a class to print the  player map to the console.
 */
public class PlayerMapConsolePrinter extends AbstractConsolePrinter {

  private static final String SHIP_CELL = "[S]";

  private static final String WATER_CELL = "[ ]";

  private static final String HIT_SHIP_CELL = "[+]";

  private static final String SUNK_SHIP_CELL = "[X]";

  private static final String ERROR_CELL = "[!]";

  /**
   * An array with the string representations of cells.
   */
  protected final String[] cellToString;


  /**
   * A constructor for the PlayerMapConsolePrinter class.
   */
  public PlayerMapConsolePrinter() {
    cellToString = new String[]{
        /* WaterCell*/ WATER_CELL,
      /*Ship*/ SHIP_CELL,
        HIT_SHIP_CELL,
        SUNK_SHIP_CELL,
        /*Error*/ ERROR_CELL
    };
  }

  /**
   * Converts the cell type into it's string representation.
   *
   * @param cell the cell which will be converted
   * @return a string representing the cell
   */
  @Override
  public String cellTypeToString(Cell cell) {
    if (cell instanceof WaterCell) {
      return cellToString[CellType.WATER_CELL.ordinal()];
    } else if (cell instanceof ShipCell) {
      if (cell.getIsSunk()) {
        return cellToString[CellType.SUNK_SHIP_CELL.ordinal()];
      } else if (cell.isHit()) {
        return cellToString[CellType.HIT_SHIP_CELL.ordinal()];
      }
      return cellToString[CellType.SHIP_CELL.ordinal()];
    } else {
      System.err.println("INCORRECT PRINTING");
      return cellToString[CellType.ERROR.ordinal()];
    }
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

