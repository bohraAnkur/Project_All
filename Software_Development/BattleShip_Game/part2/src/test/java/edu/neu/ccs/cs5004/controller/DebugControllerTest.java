package edu.neu.ccs.cs5004.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.Column;
import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.Row;
import edu.neu.ccs.cs5004.fakes.FakeConsoleReader;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.attack.ManualAttack;
import edu.neu.ccs.cs5004.model.cells.OpenSeaCell;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.ManualPlacement;
import edu.neu.ccs.cs5004.model.placement.Placement;
import edu.neu.ccs.cs5004.model.player.HumanPlayer;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsoleReader;

public class DebugControllerTest {

  private class FakeAttack extends ManualAttack {
    public FakeAttack(ConsoleReader console) {
      super(console);
    }
    @Override
    public void attackEnemy(MapInterface battleMap, Player enemyPlayer) {
      super.attackEnemy(battleMap, enemyPlayer);
    }
  }

  private class FakePlacement extends ManualPlacement {
    public FakePlacement(MapInterface map, FleetInterface fleet, ConsoleReader reader) {
      super(map, fleet, reader);
    }
  }

  public Player getCustomPlayer(MapInterface map, Attack attack , FleetInterface fleet) {
    String vertical = "v";
    FakeConsoleReader fakeReader = new FakeConsoleReader();
    fakeReader.injectPromptResponseSequence(new String[]{"A5", vertical,
        "G5", vertical, "G7", vertical, "A7", vertical});
    Placement placement = new FakePlacement(map, fleet, fakeReader);
    placement.placeFleetOnMap();
    return new HumanPlayer(placement, attack, map);
  }

  public ArrayList<String> getListOfCellLocations(MapInterface map) {
    ArrayList<String> list = new ArrayList<String>();
    for (int row = TestUtils.r("1").ordinal(); row < Row.ROW_SIZE.ordinal(); row++) {
      for (int col = TestUtils.c("A").ordinal(); col < Column.COLUMN_SIZE.ordinal(); col++) {
        if (!(map.getCell(Row.values()[row], Column.values()[col]).getClass().equals(
            OpenSeaCell.class))) {
          list.add(Column.values()[col].name()+(row+1)+"");
        }
      }
    }
    return list;
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void playGame() {
    FakeConsoleReader fakeReader = new FakeConsoleReader();
    fakeReader.injectPromptResponseSequence(new String[]{"D5", "A1", "G4", "B3"});
    MapInterface map = TestUtils.createEmptyMap();
    FleetInterface fleet = TestUtils.createFleetForUtilsBattleMap();
    Attack attack = new FakeAttack(fakeReader);
    Player player1 = getCustomPlayer(map, attack, fleet);

    // Let player2 win.
    MapInterface map2 = TestUtils.createEmptyMap();
    FakeConsoleReader fakeReader2 = new FakeConsoleReader();
    FleetInterface fleet2 = TestUtils.createFleetForUtilsBattleMap();
    Attack attack2 = new FakeAttack(fakeReader2);
    Player player2 = getCustomPlayer(map2, attack2, fleet2);

    // Find all the occupied cells
    ArrayList<String> winSeqList = getListOfCellLocations(map2);
    String[] winSeq = new String[winSeqList.size()];
    winSeqList.toArray(winSeq);
    fakeReader2.injectPromptResponseSequence(winSeq);

    DebugController controller = new DebugController(player2, player1);
    controller.startGame();
    Assert.assertTrue(controller.isGameOver());
    Assert.assertTrue(fakeReader2.usedAllFakeResponses());
  }
}