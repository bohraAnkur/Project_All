package edu.neu.ccs.cs5004.model.attack;

import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.player.Player;

/**
 * represents the player's attack method.
 */
public interface Attack {

  /**
   * attack's the enemy's map.
   * @param battleMap the player's battleMap
   * @param enemyPlayer the player being attacked
   */
  void attackEnemy(MapInterface battleMap, Player enemyPlayer);
}
