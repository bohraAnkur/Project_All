package edu.neu.ccs.cs5004.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * concrete class for the console reader.
 */
public class ConsoleReader implements ConsoleReaderInterface {

  // Public for more robust testing.
  public static final String DIRECTION_PROMPT = "Please select a Direction: \n"
      + "Press 'v' for Vertical\n" + "Press 'h' for Horizontal";

  public static final String ROW_AND_COLUMN_PROMPT = "Please enter a Row (A-J) and a Column(1-10) "
      + "(ex: A5):";

  public static final String PLACEMENT_TYPE_PROMPT = "How would you like to place your ships?: \n"
      + "Press 'm' for Manual\n" + "Press 'r' for random";

  public static final String ATTACK_METHOD_PROMPT = "Please select an attack method: \n"
      + "Press 'm' for Manual\n" + "Press 'r' for Random";

  public static final String GAME_MODE_PROMPT = "Please select a Game Mode: \n"
      + "Press 'd' for Debug\n" + "Press 'g' for Game";


  @Override
  public String promptDirectionInput() {
    String userInput = "";
    do {
      userInput = prompt(DIRECTION_PROMPT);
    } while (!(userInput.equalsIgnoreCase("v")
        || userInput.equalsIgnoreCase("h")));
    return userInput;
  }


  @Override
  public String promptAttackMethod() {
    String userInput = "";
    userInput = prompt(ATTACK_METHOD_PROMPT);
    return userInput;
  }

  @Override
  public String promptForPlacementType() {
    String userInput = "";
    userInput = prompt(PLACEMENT_TYPE_PROMPT);
    return userInput;
  }

  @Override
  public String promptManualLocationInput() {
    String userInput = "";
    userInput = prompt(ROW_AND_COLUMN_PROMPT);
    return userInput;
  }

  @Override
  public String modeSelector() {
    String userInput = "";
    userInput = prompt(GAME_MODE_PROMPT);
    return userInput;
  }

  /**
   * method to prompt for user interface.
   * @param message the message presented upon prompting
   * @return a string with the response to the prompt
   */
  protected String prompt(String message) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String result = "";
    System.out.println(message);
    try {
      result = reader.readLine();
    } catch (IOException exception) {
      try {
        reader.close();
        exception.printStackTrace();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }

  /**
   * prompts the reader to create a fleet.
   *
   * @return an array containing the users fleet specifications
   */

  protected String promptForShipNumber(String message) {
    String userInput = "";
    Boolean isValid;
    do {
      userInput = prompt(message);
      try {
        isValid = true;
        Integer.parseInt(userInput);
      } catch (NumberFormatException exception) {
        isValid = false;
      }
    } while (! isValid);
    return userInput;
  }

  @Override
  public String promptForBattleshipNumber() {
    String userInput = "";
    userInput = promptForShipNumber("Enter the number of Battleships required");
    return userInput;
  }

  @Override
  public String promptForCruiserNumber() {
    String userInput = "";
    userInput = promptForShipNumber("Enter the number of Cruisers required");
    return userInput;
  }

  @Override
  public String promptForSubmarineNumber() {
    String userInput = "";
    userInput = promptForShipNumber("Enter the number of Submarines required");
    return userInput;
  }

  @Override
  public String promptForDestroyerNumber() {
    String userInput = "";
    userInput = promptForShipNumber("Enter the number of Destroyers required");
    return userInput;
  }




}
