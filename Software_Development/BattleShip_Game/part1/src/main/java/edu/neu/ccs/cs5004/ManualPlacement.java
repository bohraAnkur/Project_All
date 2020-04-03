package edu.neu.ccs.cs5004;

public class ManualPlacement extends AbstractFleetMap {

  public ManualPlacement (MapInterface map, Fleet fleet) {
    super(map, fleet);
  }


  @Override
  public void placeFleetOnMap() {
    ConsoleReaderInterface reader = new ConsoleReader();
    ConsolePrinter printer = new ConsolePrinter();

    for (int i = 0; i < fleet.getFleet().size(); i++) {

      String coordinateInput = reader.promptManualPlacementInput();
      String direction = reader.promptDirectionInput().toUpperCase();

      Row rowValue = Row.values()[Integer.parseInt(coordinateInput.charAt(1) + "") - 1];
      Column columnValue = Column.valueOf(coordinateInput.charAt(0) + "");
      Direction directionValue = Direction.valueOf(direction);

      if (isValidPlacement(rowValue, columnValue, fleet.getFleet().get(i), directionValue)) {
        if (directionValue.equals(Direction.VERTICAL)) {
          placeVertical(rowValue, columnValue, i);
        } else {
          placeHorizontal(rowValue, columnValue, i);
        }
      }
      this.map.prettyPrint(printer);
    }
  }
}
