package edu.neu.ccs.cs5004;


/**
 * a class to print the map to the console.
 */
public class ConsolePrinter extends AbstractConsolePrinter{

  /**
   * A constructor for the ConsolePrinter class.
   */
  public ConsolePrinter() {
    super();
  }


  @Override
  public String cellTypeToString(Cell cell) {
    if (cell instanceof WaterCell) {
      return cellToString[CellType.WATER_CELL.ordinal()];
    } else if (cell instanceof ShipCell) {
      return cellToString[CellType.SHIP_CELL.ordinal()];
    } else {
      return cellToString[CellType.ERROR.ordinal()];
    }
  }


  @Override
  public void toConsole(Map map) {
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
    System.out.println(mapString.toString());
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

