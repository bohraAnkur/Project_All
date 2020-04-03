package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.game.ConcreteGame;
import edu.neu.ccs.cs5004.game.Game;

/**
 * Battleship game.
 */
public class BattleshipGame {

  /**
   * main method which begins the game.
   * @param args input arguments
   */
  public static void main(String[] args) {
    Game game = new ConcreteGame();
    game.playGame();
  }
}
