package edu.neu.ccs.cs5004.game;

import edu.neu.ccs.cs5004.controller.Controller;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsoleReader;

/**
 * sets up and begins the battleship game.
 */
public class ConcreteGame extends AbstractGame {

  /**
   * method beginning the game.
   */

  private ConsoleReader consoleReader;

  public ConcreteGame() {
    super();
    this.consoleReader = new ConsoleReader();
  }

  // Used to inject fake console reader for testing.
  protected ConcreteGame(ConsoleReader consoleReader) {
    this();
    this.consoleReader = consoleReader;
  }

  @Override
  public void playGame() {

    ConcreteGame newGame = new ConcreteGame();

    String gameMode = newGame.getGameMode(this.consoleReader);
    Attack attackType = newGame.getAttackType(this.consoleReader);


    Player newHumanPlayer = newGame.createPlayer(this.consoleReader,
        attackType, gameMode);

    Player newComputerPlayer = newGame.createComputerPlayer(gameMode);

    Controller battleShipController = newGame.setUp(gameMode, newHumanPlayer, newComputerPlayer);

    battleShipController.startGame();

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    return obj != null && getClass() == obj.getClass();
  }

  @Override

  public int hashCode() {
    return 88;
  }

}
