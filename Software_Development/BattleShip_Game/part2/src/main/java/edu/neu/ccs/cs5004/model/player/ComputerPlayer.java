package edu.neu.ccs.cs5004.model.player;


import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.Placement;

/**
 * represents the computer as a player.
 */
public class ComputerPlayer extends AbstractPlayer {

  public ComputerPlayer(Placement placement, Attack attack, MapInterface battleMap) {
    super(placement, attack, battleMap);
  }

  @Override
  public void takeTurn(Player enemyPlayer) {
    this.attack.attackEnemy(playerBattleMap, enemyPlayer);
  }

}
