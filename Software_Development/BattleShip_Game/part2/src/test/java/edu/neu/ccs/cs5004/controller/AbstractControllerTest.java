package edu.neu.ccs.cs5004.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.TestUtils;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.model.ships.Ship;

public class AbstractControllerTest {

  private class TestAbstractController extends AbstractController {
    private boolean playGameIsCalled = false;
    public TestAbstractController(Player p1, Player p2) {
      super(p1, p2);
    }
    @Override
    protected void playGame() {
      this.playGameIsCalled = true;
    }
    public boolean isPlayGameIsCalled() {
      return this.playGameIsCalled;
    }
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void isGameOver() {
    Player p1 = TestUtils.createHumanPlayer();
    Player p2 = TestUtils.createComputerPlayer();
    AbstractController controller = new TestAbstractController(p1, p2);
    Assert.assertFalse(controller.isGameOver());

    ArrayList<Ship> fleet = p1.getPlacement().getFleet().getFleet();
    // Overkill every single ship.
    for (Ship ship : fleet) {
      for (int i = 0; i < 10; i++) {
        ship.hitThisShip();
      }
    }
    Assert.assertTrue(controller.isGameOver());

    // Do test again but have other player lose.

    p1 = TestUtils.createHumanPlayer();
    p2 = TestUtils.createComputerPlayer();
    controller = new TestAbstractController(p1, p2);
    Assert.assertFalse(controller.isGameOver());

    fleet = p2.getPlacement().getFleet().getFleet();
    // Overkill every single ship.
    for (Ship ship : fleet) {
      for (int i = 0; i < 10; i++) {
        ship.hitThisShip();
      }
    }
    Assert.assertTrue(controller.isGameOver());
  }

  @Test
  public void startGame() {
    TestAbstractController controller = new TestAbstractController(TestUtils.createHumanPlayer(),
        TestUtils.createComputerPlayer());
    controller.startGame();
    Assert.assertTrue(controller.isPlayGameIsCalled());
  }
}