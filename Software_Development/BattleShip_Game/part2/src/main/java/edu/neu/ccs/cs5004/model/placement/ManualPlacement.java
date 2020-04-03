package edu.neu.ccs.cs5004.model.placement;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Direction;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.view.ConsoleReader;
import edu.neu.ccs.cs5004.view.ConsoleReaderInterface;
import edu.neu.ccs.cs5004.view.PlayerMapConsolePrinter;

/**
 * allows a user to indicate placement for each ship in a fleet onto a map.
 */
public class ManualPlacement extends AbstractPlacement {

  private ConsoleReaderInterface reader;

  /**
   * constructor for manual placement.
   * @param map the map
   * @param fleet the fleet
   */
  public ManualPlacement(MapInterface map, FleetInterface fleet) {
    super(map, fleet);
    this.reader = new ConsoleReader();
  }

  // Used for testing to allow injection of a phony console reader.
  protected ManualPlacement(MapInterface map, FleetInterface fleet, ConsoleReader reader) {
    this(map, fleet);
    this.reader = reader;
  }

  @Override
  public void placeFleetOnMap() {
    PlayerMapConsolePrinter printer = new PlayerMapConsolePrinter();
    for (int i = 0; i < fleet.getListSize(); i++) {
      Row rowValue;
      Column columnValue;
      Direction directionValue;

      do {
        String coordinateInput = this.reader.promptManualLocationInput();
        String direction = this.reader.promptDirectionInput();


        rowValue = Row.values()[Integer.parseInt(coordinateInput.substring(1) + "" ) - 1];
        columnValue = Column.valueOf((coordinateInput.charAt(0) + "").toUpperCase());

        if (direction.equalsIgnoreCase("v")) {
          directionValue = Direction.VERTICAL;
        } else {
          directionValue = Direction.HORIZONTAL;
        }
      } while (!isValidPlacement(rowValue, columnValue, fleet.getFleet().get(i), directionValue));

      if (directionValue.equals(Direction.VERTICAL)) {
        placeVertical(rowValue, columnValue, i);
      } else {
        placeHorizontal(rowValue, columnValue, i);
      }
      System.out.println(this.map.getPrettyString(printer));
    }
  }
}
