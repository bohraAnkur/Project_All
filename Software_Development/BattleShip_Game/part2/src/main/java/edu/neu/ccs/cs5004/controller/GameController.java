package edu.neu.ccs.cs5004.controller;

import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.BattleMapConsolePrinter;
import edu.neu.ccs.cs5004.view.ConsolePrinterInterface;
import edu.neu.ccs.cs5004.view.LegendPrinter;
import edu.neu.ccs.cs5004.view.PlayerMapConsolePrinter;

/**
 * * represents a controller for the game mode.
 */
public class GameController extends AbstractController {

  public GameController(Player humanPlayer, Player computerPlayer) {
    super(humanPlayer, computerPlayer);
  }

  @Override
  protected void playGame() {
    while (true) {
      System.out.println("Your turn to attack!");
      this.printMaps();
      humanPlayer.takeTurn(computerPlayer);
      if (this.isGameOver()) {
        this.printMaps();
        System.out.println("You Win!");
        break;
      }
      System.out.println("the computer is attacking");
      computerPlayer.takeTurn(humanPlayer);
      if (this.isGameOver()) {
        this.printMaps();
        System.out.println("You lose!");
        break;
      }
    }
  }

  /**
   * prints the maps available for the player in the game mode.
   */
  private void printMaps() {
    ConsolePrinterInterface playerMapPrinter = new PlayerMapConsolePrinter();
    ConsolePrinterInterface battleMapPrinter = new BattleMapConsolePrinter();


    System.out.println("  -------- Player Main Map -------- "
        + "\t\t-------- Player Guess Map --------");
    String playerMapString = humanPlayer.getPlacement().getMap().getPrettyString(playerMapPrinter);
    String battleMapString = humanPlayer.getPlayerBattleMap().getPrettyString(battleMapPrinter);

    String[] mapStrings = new String[3];
    mapStrings[0] = playerMapString;
    mapStrings[1] = battleMapString;
    LegendPrinter legend = new LegendPrinter();
    String legendString = legend.legendToString();
    mapStrings[2] = legendString;
    this.toConsole(mapStrings);
    System.out.println("\n");
  }
}
