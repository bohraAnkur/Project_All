package edu.neu.ccs.cs5004;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.attack.ManualAttack;
import edu.neu.ccs.cs5004.model.attack.RandomAttack;
import edu.neu.ccs.cs5004.model.cells.SpecificShipCell;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.model.map.BattleMap;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.map.PlayerMap;
import edu.neu.ccs.cs5004.model.placement.Placement;
import edu.neu.ccs.cs5004.model.placement.RandomPlacement;
import edu.neu.ccs.cs5004.model.player.ComputerPlayer;
import edu.neu.ccs.cs5004.model.player.HumanPlayer;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Ship;

public class TestUtils {

  public static Row r(String rowNum) {
    int num = Integer.parseInt(rowNum) - 1;
    return Row.values()[num];
  }

  public static Column c(String colChar) {
    char c = colChar.charAt(0);
    int pos = c - 'A';
    return Column.values()[pos];
  }

  public static SpecificShipCell getSpecificShipCellWithDestroyer() {
    return new SpecificShipCell(new Destroyer());
  }

  public static SpecificShipCell getSpecificShipCellWithCruiser() {
    return new SpecificShipCell(new Cruiser());
  }

  public static PlayerMap createEmptyMap() {
    return new PlayerMap();
  }

  public static BattleMap createBattleMap() {
    BattleMap map = new BattleMap();
    map.setCell(r("5"), c("A"), getSpecificShipCellWithDestroyer());
    map.setCell(r("5"), c("G"), getSpecificShipCellWithDestroyer());
    map.setCell(r("7"), c("G"), getSpecificShipCellWithDestroyer());
    map.setCell(r("7"), c("A"), getSpecificShipCellWithDestroyer());
    return map;
  }

  public static FleetInterface createFleetForUtilsBattleMap() {
    FleetInterface fleet = new StandardFleet();
    ArrayList<Ship> ships = fleet.getFleet();
    ships.clear();
    ships.add(new Destroyer());
    ships.add(new Destroyer());
    ships.add(new Destroyer());
    ships.add(new Destroyer());
    return fleet;
  }

  public static FleetInterface createFleetOf(int size) {
    FleetInterface fleet = new StandardFleet();
    ArrayList<Ship> ships = fleet.getFleet();
    ships.clear();
    for (int i = 0; i < size; i++) {
      ships.add(new Destroyer());
    }
    return fleet;
  }

  public static PlayerMap createTestMap() {
    PlayerMap map = new PlayerMap();
    for (int col = c("D").ordinal(); col < c("D").ordinal() + 4; col++) {
      map.setCell(
          r("4"), c(Character.toString((char)('A'+col))),
          getSpecificShipCellWithDestroyer());
    }
    for (int col = c("D").ordinal(); col < c("D").ordinal() + 4; col++) {
      map.setCell(
          r("7"), c(Character.toString((char)('A'+col))),
          getSpecificShipCellWithDestroyer());
    }
    map.setCell(r("5"), c("D"), getSpecificShipCellWithDestroyer());
    map.setCell(r("6"), c("D"), getSpecificShipCellWithDestroyer());
    map.setCell(r("5"), c("G"), getSpecificShipCellWithDestroyer());
    map.setCell(r("6"), c("G"), getSpecificShipCellWithDestroyer());
    return map;
  }

  public static HumanPlayer createHumanPlayer() {
    MapInterface map = TestUtils.createBattleMap();
    FleetInterface fleet = new StandardFleet();
    Placement placement = new RandomPlacement(map, fleet);
    Attack attack = new ManualAttack();
    return new HumanPlayer(placement, attack, map);
  }

  public static ComputerPlayer createComputerPlayer() {
    MapInterface map = TestUtils.createBattleMap();
    FleetInterface fleet = new StandardFleet();
    Placement placement = new RandomPlacement(map, fleet);
    Attack attack = new RandomAttack();
    return new ComputerPlayer(placement, attack, map);
  }

}
