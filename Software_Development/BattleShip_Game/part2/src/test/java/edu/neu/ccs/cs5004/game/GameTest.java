package edu.neu.ccs.cs5004.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.controller.Controller;
import edu.neu.ccs.cs5004.controller.DebugController;
import edu.neu.ccs.cs5004.controller.GameController;
import edu.neu.ccs.cs5004.fakes.FakeConsoleReader;
import edu.neu.ccs.cs5004.game.AbstractGame;
import edu.neu.ccs.cs5004.model.attack.Attack;
import edu.neu.ccs.cs5004.model.attack.ManualAttack;
import edu.neu.ccs.cs5004.model.attack.RandomAttack;
import edu.neu.ccs.cs5004.model.fleet.FleetInterface;
import edu.neu.ccs.cs5004.model.fleet.StandardFleet;
import edu.neu.ccs.cs5004.model.map.MapInterface;
import edu.neu.ccs.cs5004.model.placement.Placement;
import edu.neu.ccs.cs5004.model.placement.RandomPlacement;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsoleReaderInterface;

public class GameTest {

  private AbstractGame game;

  private class TestAbstractGame extends AbstractGame {

    public TestAbstractGame() {
      super();
    }

    public void playGame(){}

    protected Player createPlayer(ConsoleReaderInterface consoleReader, Attack attackType, String gameMode) {
      return super.createPlayer(consoleReader, attackType, gameMode);
    }

    protected Player createComputerPlayer(String gameMode) {
      return super.createComputerPlayer(gameMode);
    }

    protected String getGameMode(ConsoleReaderInterface consoleReader) {
      return super.getGameMode(consoleReader);
    }

    protected Controller setUp(String gameMode, Player newHumanPlayer, Player newComputerPlayer) {
      return super.setUp(gameMode, newHumanPlayer, newComputerPlayer);
    }

    protected FleetInterface getUserFleet(String gameMode) {
      return super.getUserFleet(gameMode);
    }

    protected Attack getAttackType(ConsoleReaderInterface consoleReader) {
      return super.getAttackType(consoleReader);
    }

    protected Placement getPlacementType(ConsoleReaderInterface consoleReader,
                                         MapInterface playerOneMap, FleetInterface userFleet) {
      return super.getPlacementType(consoleReader, playerOneMap, userFleet);
    }
  }
  @Before
  public void setUp() throws Exception {
    game = new TestAbstractGame();
  }

  @Test
  public void createPlayer() {
    Player dummyPlayer = TestUtils.createHumanPlayer();
    FakeConsoleReader fakeConsoleReader = new FakeConsoleReader();
    fakeConsoleReader.injectPromptResponseSequence(new String[]{"r"});
    Player testPlayer = this.game.createPlayer(fakeConsoleReader, dummyPlayer.getAttack(),
        "G");

    Assert.assertEquals(testPlayer.getPlacement().getFleet(),
        dummyPlayer.getPlacement().getFleet());
    Assert.assertNotEquals(testPlayer.getPlacement(), dummyPlayer.getPlacement());
    Assert.assertEquals(testPlayer.getAttack().getClass(), dummyPlayer.getAttack().getClass());

    testPlayer = this.game.createComputerPlayer("G");
    dummyPlayer = TestUtils.createComputerPlayer();
    Assert.assertEquals(testPlayer.getPlacement().getFleet(),
        dummyPlayer.getPlacement().getFleet());
    Assert.assertNotEquals(testPlayer.getPlacement(), dummyPlayer.getPlacement());
    Assert.assertEquals(testPlayer.getAttack().getClass(), dummyPlayer.getAttack().getClass());
  }

  @Test
  public void getGameMode() {
    FakeConsoleReader fakeConsoleReader = new FakeConsoleReader();
    fakeConsoleReader.injectPromptResponseSequence(new String[]{"G"});
    Assert.assertEquals("G", this.game.getGameMode(fakeConsoleReader));
    Assert.assertTrue(fakeConsoleReader.usedAllFakeResponses());

    fakeConsoleReader.injectPromptResponseSequence(new String[]{"1", "P", "d"});
    Assert.assertEquals("D", this.game.getGameMode(fakeConsoleReader));
    Assert.assertTrue(fakeConsoleReader.usedAllFakeResponses());
  }

  @Test
  public void setUpTest() {
    Player p1 = TestUtils.createComputerPlayer();
    Player p2 = TestUtils.createHumanPlayer();
    Assert.assertEquals(new GameController(p1, p2).getClass(),
        this.game.setUp("G", p1, p2).getClass());
    Assert.assertEquals(new DebugController(p1, p2).getClass(),
        this.game.setUp("D", p1, p2).getClass());
  }

  @Test
  public void getUserFleet() {
    Assert.assertEquals(new StandardFleet().getFleet(),
        this.game.getUserFleet("g").getFleet());
  }

  @Test
  public void getAttackType() {
    FakeConsoleReader fakeConsoleReader = new FakeConsoleReader();
    fakeConsoleReader.injectPromptResponseSequence(new String[]{"M"});
    Assert.assertEquals(new ManualAttack().getClass(),
        this.game.getAttackType(fakeConsoleReader).getClass());
    Assert.assertTrue(fakeConsoleReader.usedAllFakeResponses());
    fakeConsoleReader.injectPromptResponseSequence(new String[]{"x", "y", "R"});
    Assert.assertEquals(new RandomAttack().getClass(),
        this.game.getAttackType(fakeConsoleReader).getClass());
    Assert.assertTrue(fakeConsoleReader.usedAllFakeResponses());
  }

  @Test
  public void getPlacementType() {
    FakeConsoleReader fakeConsoleReader = new FakeConsoleReader();
    fakeConsoleReader.injectPromptResponseSequence(new String[]{"R"});
    MapInterface map = TestUtils.createEmptyMap();
    FleetInterface fleet = TestUtils.createFleetOf(1);
    Assert.assertEquals(RandomPlacement.class,
        this.game.getPlacementType(fakeConsoleReader, map, fleet).getClass());
  }
}