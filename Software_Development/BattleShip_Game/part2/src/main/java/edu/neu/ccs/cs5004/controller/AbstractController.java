package edu.neu.ccs.cs5004.controller;


import edu.neu.ccs.cs5004.model.player.Player;

/**
 * represents the abstract instance of the controller class.
 */
public abstract class AbstractController implements Controller{

  protected Player humanPlayer;
  protected Player computerPlayer;

  /**
   * a constructor for the abstract controller.
   * @param humanPlayer the human player
   * @param computerPlayer the computer player
   */
  public AbstractController(Player humanPlayer, Player computerPlayer) {
    this.humanPlayer = humanPlayer;
    this.computerPlayer = computerPlayer;
  }

  /**
   * determines if the game has ended.
   * @return true if one player's fleet is sunk, false otherwise
   */
  protected Boolean isGameOver() {
    if (this.humanPlayer.getPlacement().getFleet().isFleetSunk()
        || this.computerPlayer.getPlacement().getFleet().isFleetSunk()) {
      return true;
    }
    return false;
  }

  /**
   * method to begin game play.
   */
  protected abstract void playGame();


  @Override
  public void startGame() {
    this.playGame();
  }


  protected void toConsole(String[] stringsToPrint) {
    String[] mapOneRows = stringsToPrint[0].split("\n");
    String[] mapTwoRows = stringsToPrint[1].split("\n");
    String[] legendRows = stringsToPrint[2].split("\n");

    System.out.println();

    for (int i = 0; i < mapOneRows.length; i++) {
      System.out.println(mapOneRows[i] + "\t\t" + mapTwoRows [i] + "\t\t" + legendRows[i]);
    }
  }
}