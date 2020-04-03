package edu.neu.ccs.cs5004.model.placement;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Direction;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;

import java.util.Random;



/**
 * allows for a fleet to be placed randomly on a map.
 */
public class RandomPlacement extends AbstractPlacement {

  private Random random;

  /**
   * constructor for randomPlacement.
   * @param map the map
   * @param fleet the fleet
   */
  public RandomPlacement(MapInterface map, FleetInterface fleet) {
    super(map, fleet);
    this.random = new Random();
  }

  // Used for testing only to inject a fake random object.
  protected RandomPlacement(MapInterface map, FleetInterface fleet, Random random) {
    this(map, fleet);
    this.random = random;
  }

  @Override
  public void placeFleetOnMap() {
    for (int i = 0; i < fleet.getFleet().size(); i++) {
      Row rowValue;
      Column columnValue;
      Direction directionValue;

      do {
        rowValue = Row.values()[this.random.nextInt(Row.ROW_SIZE.ordinal())];
        columnValue = Column.values()[this.random.nextInt(Column.COLUMN_SIZE.ordinal())];
        directionValue = Direction.values()[this.random.nextInt(
            Direction.NUM_OF_DIRECTIONS.ordinal())];
      } while (!isValidPlacement(rowValue, columnValue, fleet.getFleet().get(i), directionValue));

      if (directionValue.equals(Direction.VERTICAL)) {
        placeVertical(rowValue, columnValue, i);
      } else {
        placeHorizontal(rowValue, columnValue, i);
      }
    }
  }
}
