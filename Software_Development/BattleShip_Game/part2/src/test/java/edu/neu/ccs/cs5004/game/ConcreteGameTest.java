package edu.neu.ccs.cs5004.game;

import org.junit.Assert;
import org.junit.Test;

import edu.neu.ccs.cs5004.TestCaseUtils;
import edu.neu.ccs.cs5004.fakes.FakeConsoleReader;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsoleReader;

import static org.junit.Assert.*;

public class ConcreteGameTest {

  private class TestConcreteGame extends ConcreteGame {

    public TestConcreteGame(ConsoleReader consoleReader) {
      super(consoleReader);
    }
  }

  @Test
  public void playGame() {
    FakeConsoleReader fakeReader = new FakeConsoleReader();
    fakeReader.injectPromptResponseSequence(new String[]{"g", "r", "r"});
    Game newGame = new TestConcreteGame(fakeReader);
    newGame.playGame();
    Assert.assertTrue(fakeReader.usedAllFakeResponses());
  }

  @Test
  public void testEquals() {
    ConcreteGame concreteGame = new ConcreteGame();
    ConcreteGame sameConcreteGame = concreteGame;
    ConcreteGame concreteGameTwo = concreteGame;
    ConcreteGame concreteGameThree = concreteGame;
    ConcreteGame anotherConcreteGame = new ConcreteGame();

    TestCaseUtils.assertPassesAlwaysEqualsTest(concreteGame,sameConcreteGame,concreteGameThree,
        concreteGameTwo,anotherConcreteGame);
  }


  @Test
  public  void testHashCode() {
    ConcreteGame concreteGame = new ConcreteGame();
    ConcreteGame sameConcreteGame = concreteGame;
    ConcreteGame anotherConcreteGame = new ConcreteGame();
    Assert.assertEquals(concreteGame.equals(anotherConcreteGame),
        concreteGame.hashCode() == anotherConcreteGame.hashCode());
    Assert.assertEquals(concreteGame.equals(sameConcreteGame),
        concreteGame.hashCode() == sameConcreteGame.hashCode());

  }

}