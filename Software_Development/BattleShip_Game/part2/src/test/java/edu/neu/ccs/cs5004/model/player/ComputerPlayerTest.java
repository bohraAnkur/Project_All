package edu.neu.ccs.cs5004.model.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.AttackResult;
import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.fakes.FakeAttack;
import edu.neu.ccs.cs5004.fakes.FakeRandom;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.ManualPlacement;
import edu.neu.ccs.cs5004.model.placement.Placement;

public class ComputerPlayerTest {

  public Player getCustomPlayer(MapInterface map, Attack attack , FleetInterface fleet) {
    Placement placement = new ManualPlacement(map, fleet);
    return new ComputerPlayer(placement, attack, map);
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void takeTurn() {
    final int expectedHitRow = Row.FIVE.ordinal();
    final int expectedHitColumn = Column.A.ordinal();
    FakeRandom fakeRandom = new FakeRandom();
    fakeRandom.setFakeRandomOutputSequence(new int[]{expectedHitRow, expectedHitColumn});

    MapInterface map = TestUtils.createBattleMap();
    FleetInterface fleet = TestUtils.createFleetForUtilsBattleMap();
    Attack attack = new FakeAttack(fakeRandom);
    Player player = getCustomPlayer(map, attack, fleet);
    Player enemy = getCustomPlayer(map, attack, fleet);
    player.takeTurn(enemy);

    Assert.assertEquals(map.getCell(Row.values()[expectedHitRow],
        Column.values()[expectedHitColumn]).attackResult(), AttackResult.HIT);
    Assert.assertFalse(fakeRandom.receivedUnexpectedCalls());
  }
}