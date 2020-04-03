package edu.neu.ccs.cs5004.model.fleet;


import edu.neu.ccs.cs5004.model.ships.BattleShip;
import edu.neu.ccs.cs5004.model.ships.Cruiser;
import edu.neu.ccs.cs5004.model.ships.Destroyer;
import edu.neu.ccs.cs5004.model.ships.Submarine;
import edu.neu.ccs.cs5004.view.ConsoleReader;
import edu.neu.ccs.cs5004.view.ConsoleReaderInterface;

/**
 * a fleet to be used in debug mode.
 */
public class DebugFleet extends AbstractFleet {

  private ConsoleReaderInterface consoleReader;

  /**
   * a constructor for the fleet.
   */
  public DebugFleet() {
    super();
    this.consoleReader = new ConsoleReader();
    this.initializeFleet();
  }

  // Allows for injection of a fake console reader object for testing
  protected DebugFleet(ConsoleReaderInterface consoleReader) {
    this.consoleReader = consoleReader;
    this.initializeFleet();
  }

  /**
   * method which initialized the fleet.
   */
  protected void initializeFleet() {

    int battleshipQuantity = Integer.parseInt(this.consoleReader.promptForBattleshipNumber());
    int cruiserQuantity = Integer.parseInt(this.consoleReader.promptForCruiserNumber());
    int submarineQuantity = Integer.parseInt(this.consoleReader.promptForSubmarineNumber());


    for (int i = 0; i < battleshipQuantity; i++) {
      fleet.add(new BattleShip());
    }
    for (int i = 0; i < cruiserQuantity; i++) {
      fleet.add(new Cruiser());
    }
    for (int i = 0; i < submarineQuantity; i++) {
      fleet.add(new Submarine());
    }

    int destroyerQuantity = Integer.parseInt(this.consoleReader.promptForDestroyerNumber());

    for (int i = 0; i < destroyerQuantity; i++) {
      fleet.add(new Destroyer());
    }
  }

}

