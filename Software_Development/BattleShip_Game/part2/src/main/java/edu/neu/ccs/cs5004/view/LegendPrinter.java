package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.CellType;
import edu.neu.ccs.cs5004.Row;

/**
 * represents the legend for the map.
 */
public class LegendPrinter {

  private static final String SHIP_CELL = "[S]";
  private static final String SHIP_CELL_DESCRIPTION = "Ship";

  private static final String WATER_CELL = "[ ]";
  private static final String WATER_CELL_DESCRIPTION = "Water";

  private static final String HIT_SHIP_CELL = "[+]";
  private static final String HIT_SHIP_CELL_DESCRIPTION = "Hit Ship";

  private static final String SUNK_SHIP_CELL = "[X]";
  private static final String SUNK_SHIP_CELL_DESCRIPTION = "Sunk Ship";


  /**
   * An array with the string representations of cells.
   */
  protected final String[] cellToString;

  /**
   * an array with the descriptions fo the cell types.
   */
  protected final String[] cellDescription;

  /**
   * constructor for the console printer.
   */
  public LegendPrinter() {
    cellToString = new String[]{
        /* WaterCell*/ WATER_CELL,
        /*Ship*/ SHIP_CELL,
        HIT_SHIP_CELL,
        SUNK_SHIP_CELL
    };

    cellDescription = new String[]{
        WATER_CELL_DESCRIPTION,
        SHIP_CELL_DESCRIPTION,
        HIT_SHIP_CELL_DESCRIPTION,
        SUNK_SHIP_CELL_DESCRIPTION
    };
  }


  /**
   * converts the legend into its string representation.
   * @return a string representing the legend
   */
  public String legendToString() {
    StringBuilder legendString = new StringBuilder("");

    legendString.append("      LEGEND      \n");
    legendString.append("------------------\n");

    for (int i = 0; i < CellType.ERROR.ordinal(); i++) {
      legendString.append(cellToString[i] + "\t\t" + cellDescription[i] + "\n");
    }
    for (int i = 0; i < Row.ROW_SIZE.ordinal() - CellType.ERROR.ordinal() - 1; i++) {
      legendString.append(" \n");
    }
    return legendString.toString();
  }
}
