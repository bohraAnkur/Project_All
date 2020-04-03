package edu.neu.ccs.cs5004.model.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.TestCaseUtils;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.attack.ManualAttack;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.model.map.BattleMap;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.map.PlayerMap;
import edu.neu.ccs.cs5004.model.placement.ManualPlacement;
import edu.neu.ccs.cs5004.model.placement.Placement;

public class AbstractPlayerTest {

  private class TestAbstractPlayer extends AbstractPlayer {
    public TestAbstractPlayer(Placement placement, Attack attack,
                                  MapInterface playerBattleMap) {
      super(placement, attack, playerBattleMap);
    }

    public void takeTurn(Player enemyPlayer) {
    }

    public Placement getPlacement() {
      return super.getPlacement();
    }

    public Attack getAttack() {
      return super.getAttack();
    }

    public MapInterface getPlayerBattleMap() {
      return super.getPlayerBattleMap();
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  public Player getCustomPlayer(MapInterface map, Attack attack , FleetInterface fleet) {
    Placement placement = new ManualPlacement(map, fleet);
    return new TestAbstractPlayer(placement, attack, map);
  }

  @Test
  public void dataStructureBehaviorTest() {
    MapInterface map = TestUtils.createTestMap();
    FleetInterface fleet = new StandardFleet();
    Placement placement = new ManualPlacement(map, fleet);
    Attack attack = new ManualAttack();
    Player player = new TestAbstractPlayer(placement, attack, map);

    Assert.assertEquals(player.getAttack(), attack);
    Assert.assertTrue(player.getAttack() == attack);
    Assert.assertEquals(player.getPlacement(), placement);
    Assert.assertTrue(player.getPlacement() == placement);
    Assert.assertEquals(player.getPlacement().getMap(), map);
    Assert.assertEquals(player.getPlacement().getFleet(), fleet);
    Assert.assertEquals(player.getPlayerBattleMap(), map);
    Assert.assertTrue(player.getPlayerBattleMap() == map);
  }

  @Test
  public void equalsTest() {
    Attack attack = new ManualAttack();
    Player player = getCustomPlayer(new PlayerMap(), attack, new StandardFleet());
    Player samePlayer = getCustomPlayer(new PlayerMap(), attack, new StandardFleet());
    Player samePlayer2 = getCustomPlayer(new PlayerMap(), attack, new StandardFleet());
    Player playerSameReference = player;
    Player differentPlayer = getCustomPlayer(new BattleMap(), attack, new StandardFleet());

    TestCaseUtils.assertPassesEqualsTest(player, samePlayer, samePlayer2, playerSameReference,
        differentPlayer);
  }

  @Test
  public void hashCodeTest() {
    Attack attack = new ManualAttack();
    Player player = getCustomPlayer(new PlayerMap(), attack, new StandardFleet());
    Player samePlayer = getCustomPlayer(new PlayerMap(), attack, new StandardFleet());
    Player playerSameReference = player;

    TestCaseUtils.assertPassesHashCodeTest(player, samePlayer, playerSameReference);
  }
}