package edu.neu.ccs.cs5004.model.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.AttackResult;
import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.fakes.FakeConsoleReader;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.attack.ManualAttack;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.ManualPlacement;
import edu.neu.ccs.cs5004.model.placement.Placement;
import edu.neu.ccs.cs5004.view.ConsoleReader;

public class HumanPlayerTest {

  private class FakeAttack extends ManualAttack {
    public FakeAttack(ConsoleReader console) {
      super(console);
    }
    @Override
    public void attackEnemy(MapInterface battleMap, Player enemyPlayer) {
      super.attackEnemy(battleMap, enemyPlayer);
    }
  }

  public Player getCustomPlayer(MapInterface map, Attack attack , FleetInterface fleet) {
    Placement placement = new ManualPlacement(map, fleet);
    return new HumanPlayer(placement, attack, map);
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void takeTurn() {
    final Row expectedHitRow = Row.FIVE;
    final Column expectedHitColumn = Column.A;
    FakeConsoleReader fakeReader = new FakeConsoleReader();
    fakeReader.injectPromptResponseSequence(new String[]{"A5"});

    MapInterface map = TestUtils.createBattleMap();
    FleetInterface fleet = TestUtils.createFleetForUtilsBattleMap();
    Attack attack = new FakeAttack(fakeReader);
    Player player = getCustomPlayer(map, attack, fleet);
    Player enemy = getCustomPlayer(map, attack, fleet);
    player.takeTurn(enemy);

    Assert.assertEquals(map.getCell(Row.values()[expectedHitRow.ordinal()],
        Column.values()[expectedHitColumn.ordinal()]).attackResult(), AttackResult.HIT);
    // Sanity check
    Assert.assertEquals(map.getCell(Row.values()[expectedHitRow.ordinal() - 1],
        Column.values()[expectedHitColumn.ordinal()]).attackResult(), AttackResult.NOT_ATTACKED);
  }
}