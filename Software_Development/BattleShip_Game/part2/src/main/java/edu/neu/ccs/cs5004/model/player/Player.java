package edu.neu.ccs.cs5004.model.player;

import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.Placement;

/**
 * represents a player for the game.
 */
public interface Player {

  /**
   * allows the player to attack their opponent.
   * @param enemyPlayer the player's opponent
   */
  void takeTurn(Player enemyPlayer);

  /**
   * getter for the player's placement.
   * @return placement method object
   */
  Placement getPlacement();

  /**
   * getter for the player's attack.
   * @return the player's attack
   */
  Attack getAttack();

  /**
   * getter for the player's battle map.
   * @return The players BattleMap
   */
  MapInterface getPlayerBattleMap();

}
