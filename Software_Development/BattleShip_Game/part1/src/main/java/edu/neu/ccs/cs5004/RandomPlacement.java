package edu.neu.ccs.cs5004;

import java.util.Random;

public class RandomPlacement extends AbstractFleetMap {

  public RandomPlacement(MapInterface map, Fleet fleet){
    super(map, fleet);
  }

  @Override
  public void placeFleetOnMap() {
    ConsolePrinter printer = new ConsolePrinter();

    Random random = new Random();


    for (int i = 0; i < fleet.getFleet().size(); i++) {
      Row rowValue;
      Column columnValue;
      Direction directionValue;

      do {
        rowValue = Row.values()[random.nextInt(Row.ROW_SIZE.ordinal())];
        columnValue = Column.values()[random.nextInt(Column.COLUMN_SIZE.ordinal())];
        directionValue = Direction.values()[random.nextInt(Direction.NUM_OF_DIRECTIONS.ordinal())];
      } while (!isValidPlacement(rowValue, columnValue, fleet.getFleet().get(i), directionValue));

      System.out.println(rowValue.toString() + " " + columnValue.toString() + " " +directionValue.toString());

      if (directionValue.equals(Direction.VERTICAL)) {
        placeVertical(rowValue, columnValue, i);
      } else {
        placeHorizontal(rowValue, columnValue, i);
      }
    }
    this.map.prettyPrint(printer);
  }
}
