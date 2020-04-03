package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.AttackResult;
import edu.neu.ccs.cs5004.model.cells.Cell;

/**
 * a console printer for battle maps.
 */
public class BattleMapConsolePrinter extends AbstractConsolePrinter {

  private static final String HIT_CELL = "[+]";
  private static final String MISS_CELL = "[O]";
  private static final String SUNK_CELL = "[X]";
  private static final String NOT_ATTACKED_CELL = "[ ]";

  /**
   * An array with the string representations of cells.
   */
  private final String[] cellToString;

  /**
   * A constructor for the BattleMapConsolePrinter class.
   */
  public BattleMapConsolePrinter() {
    cellToString = new String[]{
        /*Hit*/ HIT_CELL,
        /*Miss*/ MISS_CELL,
        /*Sunk*/ SUNK_CELL,
        /*Not Attacked*/ NOT_ATTACKED_CELL
    };
  }

  /**
   * Converts the cell type into it's string representation.
   *
   * @param cell the cell which will be converted
   * @return a string representing the cell
   */
  @Override
  protected String cellTypeToString(Cell cell) {
    if (cell.attackResult().equals(AttackResult.NOT_ATTACKED)) {
      return cellToString[AttackResult.NOT_ATTACKED.ordinal()];
    } else if (cell.attackResult().equals(AttackResult.SUNK)) {
      return cellToString[AttackResult.SUNK.ordinal()];
    } else if (cell.attackResult().equals(AttackResult.HIT)) {
      return cellToString[AttackResult.HIT.ordinal()];
    } else {
      return cellToString[AttackResult.MISS.ordinal()];
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
