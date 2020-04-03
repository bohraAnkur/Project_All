package edu.neu.ccs.cs5004.model.player;

import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.Placement;

import java.util.Objects;


/**
 * abstract class for the player.
 */
public abstract class AbstractPlayer implements Player {

  protected Placement placement;
  protected Attack attack;
  protected MapInterface playerBattleMap;

  /**
   * a constructor of the AbstractPlayer class.
   *
   * @param placement       the player's fleet map
   * @param attack          the player's attack type
   * @param playerBattleMap the player's battle map
   */
  public AbstractPlayer(Placement placement, Attack attack, MapInterface playerBattleMap) {
    this.placement = placement;
    this.attack = attack;
    this.playerBattleMap = playerBattleMap;
  }

  @Override
  public Placement getPlacement() {
    return this.placement;
  }

  @Override
  public Attack getAttack() {
    return this.attack;
  }

  @Override
  public MapInterface getPlayerBattleMap() {
    return this.playerBattleMap;
  }

  /**
   * checks that two objects are equal.
   *
   * @param obj the object to be compared
   * @return true if equal, false otherwise
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractPlayer otherPlayer = (AbstractPlayer) obj;
    return otherPlayer.getAttack().equals(this.getAttack())
        && otherPlayer.getPlacement().equals(this.getPlacement())
        && otherPlayer.getPlayerBattleMap().equals(this.getPlayerBattleMap());
  }

  public int hashCode() {
    return Objects.hash(this.getAttack(), this.getPlacement(), this.getPlayerBattleMap());
  }

}
