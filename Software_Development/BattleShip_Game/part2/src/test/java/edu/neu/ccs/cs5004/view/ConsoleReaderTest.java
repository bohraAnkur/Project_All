package edu.neu.ccs.cs5004.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.fakes.FakeConsoleReader;

public class ConsoleReaderTest {

  private FakeConsoleReader consoleReader;

  @Before
  public void setUp() throws Exception {
    consoleReader = new FakeConsoleReader();
  }

  public void assertPassesPromptTest(String expectedMessage) {
    Assert.assertTrue(consoleReader.usedAllFakeResponses());
    Assert.assertEquals(consoleReader.getLastPromptMessage(), expectedMessage);
  }

  @Test
  public void promptDirectionInput() {
    final String validInput = "v";
    consoleReader.injectPromptResponseSequence(new String[] {"x", "y", "z", validInput});
    Assert.assertEquals(consoleReader.promptDirectionInput(), validInput);
    assertPassesPromptTest(ConsoleReader.DIRECTION_PROMPT);
  }

  @Test
  public void promptAttackMethod() {
    final String validInput = "v";
    consoleReader.injectPromptResponseSequence(new String[] {validInput});
    Assert.assertEquals(consoleReader.promptAttackMethod(), validInput);
    assertPassesPromptTest(ConsoleReader.ATTACK_METHOD_PROMPT);
  }

  @Test
  public void promptForPlacementType() {
    final String validInput = "v";
    consoleReader.injectPromptResponseSequence(new String[] {validInput});
    Assert.assertEquals(consoleReader.promptForPlacementType(), validInput);
    assertPassesPromptTest(ConsoleReader.PLACEMENT_TYPE_PROMPT);
  }

  @Test
  public void promptManualLocationInput() {
    final String validInput = "v";
    consoleReader.injectPromptResponseSequence(new String[] {validInput});
    Assert.assertEquals(consoleReader.promptManualLocationInput(), validInput);
    assertPassesPromptTest(ConsoleReader.ROW_AND_COLUMN_PROMPT);
  }

  @Test
  public void modeSelector() {
    final String validInput = "v";
    consoleReader.injectPromptResponseSequence(new String[] {validInput});
    Assert.assertEquals(consoleReader.modeSelector(), validInput);
    assertPassesPromptTest(ConsoleReader.GAME_MODE_PROMPT);
  }

  @Test
  public void prompt() {
    final String validInput = "v";
    final String message = "nonsense";
    consoleReader.injectPromptResponseSequence(new String[] {validInput});
    Assert.assertEquals(consoleReader.prompt(message), validInput);
    Assert.assertEquals(consoleReader.getLastPromptMessage(), message);
  }

  @Test
  public void promptForBattleshipNumber() {
    final String validInput = "2";
    consoleReader.injectPromptResponseSequence(new String[] {"v", "x2", validInput});
    Assert.assertEquals(consoleReader.promptForBattleshipNumber(), validInput);
  }

  @Test
  public void promptForCruiserNumber() {
    final String validInput = "2";
    consoleReader.injectPromptResponseSequence(new String[] {"v", "x2", validInput});
    Assert.assertEquals(consoleReader.promptForCruiserNumber(), validInput);
  }

  @Test
  public void promptForSubmarineNumber() {
    final String validInput = "2";
    consoleReader.injectPromptResponseSequence(new String[] {"v", "x2", validInput});
    Assert.assertEquals(consoleReader.promptForSubmarineNumber(), validInput);
  }

  @Test
  public void promptForDestroyerNumber() {
    final String validInput = "2";
    consoleReader.injectPromptResponseSequence(new String[] {"v", "x2", validInput});
    Assert.assertEquals(consoleReader.promptForDestroyerNumber(), validInput);
  }
}