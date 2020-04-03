package edu.neu.ccs.cs5004.model.attack;



import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.model.cells.Cell;
import edu.neu.ccs.cs5004.model.cells.EnemyShipCell;
import edu.neu.ccs.cs5004.model.cells.ShipCell;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.player.Player;

/**
 * abstract class for the attack.
 */
public abstract class AbstractAttack implements Attack  {
  public abstract void attackEnemy(MapInterface battleMap, Player enemyPlayer);

  /**
   * ipdates the user's battle map to reflect attack.
   * @param enemyPlayer the player that is being attacked
   * @param battleMap the attacker's battleMap
   * @param row the row of the cell that was attacked
   * @param column the column of the cell that was attacked
   */
  protected void updateBattleMap(Player enemyPlayer, MapInterface battleMap, Row row,
                                 Column column) {
    if (enemyPlayer.getPlacement().getMap().getCell(row, column) instanceof ShipCell) {
      Cell newCell = new EnemyShipCell();
      newCell.attackThisCell();
      battleMap.setCell(row, column, newCell);
    }
  }
}
