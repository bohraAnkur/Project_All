package edu.neu.ccs.cs5004.game;

import edu.neu.ccs.cs5004.controller.Controller;
import edu.neu.ccs.cs5004.controller.DebugController;
import edu.neu.ccs.cs5004.controller.GameController;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.attack.ManualAttack;
import edu.neu.ccs.cs5004.model.attack.RandomAttack;
import edu.neu.ccs.cs5004.model.fleet.DebugFleet;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.model.map.BattleMap;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.map.PlayerMap;
import edu.neu.ccs.cs5004.model.placement.ManualPlacement;
import edu.neu.ccs.cs5004.model.placement.Placement;
import edu.neu.ccs.cs5004.model.placement.RandomPlacement;
import edu.neu.ccs.cs5004.model.player.ComputerPlayer;
import edu.neu.ccs.cs5004.model.player.HumanPlayer;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsoleReaderInterface;

public abstract class AbstractGame implements Game {

  public AbstractGame() {

  }


  /**
   * creates the human player instance.
   *
   * @param consoleReader a console reader to read user input
   * @param attackType    the attack type that will be used by the player
   * @param gameMode      the game mode
   * @return the human player
   */
  protected Player createPlayer(ConsoleReaderInterface consoleReader,
                             Attack attackType, String gameMode) {
    MapInterface playerOneMap = new PlayerMap();
    MapInterface playerBattleMap = new BattleMap();
    if (gameMode.equalsIgnoreCase("d")) {
      System.out.println("Configure your fleet");
    }
    FleetInterface gameFleet = getUserFleet(gameMode);

    Placement userPlacement = getPlacementType(consoleReader,
        playerOneMap, gameFleet);
    return new HumanPlayer(userPlacement, attackType, playerBattleMap);

  }

  /**
   *creates the computer player instance.
   *
   * @param gameMode the game mode
   * @return the computer player
   */

  protected Player createComputerPlayer(String gameMode) {
    MapInterface computerMap = new PlayerMap();
    MapInterface computerBattleMap = new BattleMap();
    Attack computerAttack = new RandomAttack();
    if (gameMode.equalsIgnoreCase("d")) {
      System.out.println("Configure your opponent's fleet");
    }
    FleetInterface gameFleet = getUserFleet(gameMode);
    Placement computerPlacement = new RandomPlacement(computerMap, gameFleet);
    computerPlacement.placeFleetOnMap();
    return new ComputerPlayer(computerPlacement, computerAttack,
        computerBattleMap);
  }
  /**
   * prompts the user for the game mode.
   *
   * @param consoleReader the reader which takes in the user input from the console
   * @return the input as a string
   */
  protected String getGameMode(ConsoleReaderInterface consoleReader) {
    String gameMode = consoleReader.modeSelector().toUpperCase();
    if (gameMode.equals("G") || gameMode.equals("D")) {
      return gameMode;
    } else {
      return getGameMode(consoleReader);
    }
  }

  /**
   * sets up the controller.
   *
   * @param gameMode          the selected game mode
   * @param newHumanPlayer    the human user
   * @param newComputerPlayer the computer player
   * @return the controller for the game
   */
  protected Controller setUp(String gameMode, Player newHumanPlayer, Player newComputerPlayer) {
    if (gameMode.equals("G")) {
      return new GameController(newHumanPlayer, newComputerPlayer);
    } else {
      return new DebugController(newHumanPlayer, newComputerPlayer);
    }
  }

  /**
   * sets up the user fleet.
   *
   * @param gameMode the mode of the game
   * @return the user's fleet
   */
  protected FleetInterface getUserFleet(String gameMode) {
    if (gameMode.equalsIgnoreCase("G")) {
      return new StandardFleet();
    } else {
      return new DebugFleet();
    }
  }

  /**
   * prompts for the attack type and creates the instance.
   *
   * @param consoleReader the reader which takes in the user input from the console
   * @return the attack type
   */
  protected Attack getAttackType(ConsoleReaderInterface consoleReader) {
    String attackMethod = consoleReader.promptAttackMethod().toUpperCase();
    if (attackMethod.equals("M")) {
      return new ManualAttack();
    } else if (attackMethod.equals("R")) {
      return new RandomAttack();
//    } else if (attackMethod.equals("S")) {
//      return new SmartAttack();
    } else {
      return getAttackType(consoleReader);
    }
  }

  /**
   * prompts for the user's placement preference and creates the placement instance.
   *
   * @param consoleReader the reader which takes in the user input from the console
   * @param playerOneMap  the user's map
   * @param userFleet     the user's fleet
   * @return the player's placement instance
   */
  protected Placement getPlacementType(ConsoleReaderInterface consoleReader,
                                    MapInterface playerOneMap, FleetInterface userFleet) {
    String placementType = consoleReader.promptForPlacementType().toUpperCase();
    Placement placement;
    if (placementType.equals("M")) {
      placement = new ManualPlacement(playerOneMap, userFleet);
    } else if (placementType.equals("R")) {
      placement = new RandomPlacement(playerOneMap, userFleet);
    } else {
      placement = getPlacementType(consoleReader, playerOneMap, userFleet);
    }
    placement.placeFleetOnMap();
    return placement;
  }
}
