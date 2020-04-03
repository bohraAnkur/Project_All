package edu.neu.ccs.cs5004.model.attack;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsoleReader;
import edu.neu.ccs.cs5004.view.ConsoleReaderInterface;

/**
 * represents a manual attack.
 */
public class ManualAttack extends AbstractAttack {

  /**
   * a console reader to receive user input.
   */
  private ConsoleReaderInterface consoleReader;

  /**
   * constructor for the manual attack.
   */
  public ManualAttack() {
    super();
    this.consoleReader = new ConsoleReader();
  }

  // Used to inject fake console reader for testing.
  protected ManualAttack(ConsoleReaderInterface consoleReader) {
    this();
    this.consoleReader = consoleReader;
  }

  @Override
  public void attackEnemy(MapInterface battleMap, Player enemyPlayer) {
    String attackLocation = this.consoleReader.promptManualLocationInput().toUpperCase();

    Row rowValue;
    Column columnValue;

    rowValue = Row.values()[Integer.parseInt(attackLocation.substring(1) + "") - 1];
    columnValue = Column.valueOf(attackLocation.charAt(0) + "");

    battleMap.getCell(rowValue, columnValue).attackThisCell();
    enemyPlayer.getPlacement().getMap().getCell(rowValue, columnValue).attackThisCell();
    updateBattleMap(enemyPlayer, battleMap, rowValue, columnValue);

  }
}
