package edu.neu.ccs.cs5004;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {

    Map playerMap = new Map();
    Fleet playerFleet = new Fleet();
    ConsolePrinter printer = new ConsolePrinter();
    Ship testShip = BattleShipInterface.createBattleShip();

    FleetMap fleetMap = new ManualPlacement(playerMap, playerFleet);
//    FleetMap fleetMap = new RandomPlacement(playerMap, playerFleet);
//    for (int i = 0; i < 50; i++) {
////      Map playerMap = new Map();
////      Fleet playerFleet = new Fleet();
//
//      FleetMap fleetMap = new RandomPlacement(playerMap, playerFleet);
//      fleetMap.placeFleetOnMap();
//      System.out.println();
//    }
    fleetMap.placeFleetOnMap();
    System.out.println();


    //fleetMap.map.prettyPrint(printer);
    //System.out.println(fleetMap.isValidPlacement(Row.ONE, Column.A, testShip, Direction.VERTICAL));

  }
}
