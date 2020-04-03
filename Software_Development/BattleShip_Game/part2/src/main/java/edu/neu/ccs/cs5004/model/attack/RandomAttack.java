package edu.neu.ccs.cs5004.model.attack;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.player.Player;


import java.util.Random;


/**
 * represents a random attack.
 */
public class RandomAttack extends AbstractAttack {

  /**
   * random number generator.
   */
  private Random random;

  /**
   * constructor for the random attack class.
   */
  public RandomAttack() {
    super();
    this.random = new Random();
  }

  //Used to inject a fake random object for testing.
  protected RandomAttack(Random random) {
    this();
    this.random = random;
  }

  @Override
  public void attackEnemy(MapInterface battleMap, Player enemyPlayer) {
    Row rowValue;
    Column columnValue;




    rowValue = Row.values()[this.random.nextInt(Row.ROW_SIZE.ordinal())];
    columnValue = Column.values()[this.random.nextInt(Column.COLUMN_SIZE.ordinal())];

    battleMap.getCell(rowValue, columnValue).attackThisCell();
    enemyPlayer.getPlacement().getMap().getCell(rowValue, columnValue).attackThisCell();
    updateBattleMap(enemyPlayer, battleMap, rowValue, columnValue);
  }
}
