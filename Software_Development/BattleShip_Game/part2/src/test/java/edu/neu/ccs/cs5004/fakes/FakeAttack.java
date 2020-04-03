package edu.neu.ccs.cs5004.fakes;

import java.util.Random;

import edu.neu.ccs.cs5004.model.attack.RandomAttack;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.player.Player;

public class FakeAttack extends RandomAttack {
  public FakeAttack(Random ran) {
    super(ran);
  }
  @Override
  public void attackEnemy(MapInterface battleMap, Player enemyPlayer) {
    super.attackEnemy(battleMap, enemyPlayer);
  }
}
