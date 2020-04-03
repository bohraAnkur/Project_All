package edu.neu.ccs.cs5004.controller;

import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.BattleMapConsolePrinter;
import edu.neu.ccs.cs5004.view.ConsolePrinterInterface;
import edu.neu.ccs.cs5004.view.LegendPrinter;
import edu.neu.ccs.cs5004.view.PlayerMapConsolePrinter;

/**
 * controller for the debug game mode.
 */
public class DebugController extends AbstractController {

  public DebugController(Player humanPlayer, Player computerPlayer) {
    super(humanPlayer, computerPlayer);
  }

  @Override
  protected void playGame() {
    while (true) {
      this.printMaps();
      System.out.println("Your turn to attack!");
      humanPlayer.takeTurn(computerPlayer);
      if (this.isGameOver()) {
        System.out.println("You Win!");
        break;
      }
      System.out.println("the computer is attacking");
      computerPlayer.takeTurn(humanPlayer);
      if (this.isGameOver()) {
        System.out.println("You lose!");
        break;
      }
    }
  }

  /**
   * prints the maps available for the player in the debug mode.
   */
  private void printMaps() {
    ConsolePrinterInterface playerMapPrinter = new PlayerMapConsolePrinter();
    ConsolePrinterInterface battleMapPrinter = new BattleMapConsolePrinter();


    System.out.println("  -------- Player Main Map -------- "
        + "\t\t-------- Player Guess Map --------");
    String playerMapString = humanPlayer.getPlacement().getMap().getPrettyString(playerMapPrinter);
    String playerBattleMapString
        = humanPlayer.getPlayerBattleMap().getPrettyString(battleMapPrinter);


    String[] playerMapStrings = new String[3];
    playerMapStrings[0] = playerMapString;
    playerMapStrings[1] = playerBattleMapString;
    LegendPrinter legend = new LegendPrinter();
    String legendString = legend.legendToString();
    playerMapStrings[2] = legendString;
    this.toConsole(playerMapStrings);

    System.out.println();

    System.out.println("  -------- Computer Main Map -------- "
        + "\t\t-------- Computer Guess Map --------");
    String computerMapString
        = computerPlayer.getPlacement().getMap().getPrettyString(playerMapPrinter);
    String computerBattleMapString
        = computerPlayer.getPlayerBattleMap().getPrettyString(battleMapPrinter);


    String[] computerMapStrings = new String[3];
    computerMapStrings[0] = computerMapString;
    computerMapStrings[1] = computerBattleMapString;
    computerMapStrings[2] = legendString;
    this.toConsole(computerMapStrings);

    System.out.println("\n");
  }
}
