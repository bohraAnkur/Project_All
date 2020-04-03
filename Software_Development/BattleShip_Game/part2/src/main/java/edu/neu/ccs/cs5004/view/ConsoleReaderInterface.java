package edu.neu.ccs.cs5004.view;

/**
 * reader that prompts and receives input from the console.
 */
public interface ConsoleReaderInterface {

  /**
   * prompts for the user's preferred method to place ships.
   * @return a string indicating the preferred method
   */
  String promptForPlacementType();

  /**
   * prompts for direction.
   * @return a string indicating the preferred direction.
   */
  String promptDirectionInput();

  /**
   * prompts for manual location input.
   * @return a string indicating a cell
   */
  String promptManualLocationInput();


  /**
   * prompt to select the mode.
   * @return string indicating the preferred mode
   */
  String modeSelector();

  /**
   * prompt to select the attack method.
   *
   * @return string indicating the preferred mode
   */
  String promptAttackMethod();

  /**
   * prompt for the number of battleships for a fleet.
   * @return string indicating the preferred number
   */
  String promptForBattleshipNumber();

  /**
   * prompt for the number of submarine for a fleet.
   * @return string indicating the preferred number
   */
  String promptForSubmarineNumber();

  /**
   * prompt for the number of cruisers for a fleet.
   * @return string indicating the preferred number
   */
  String promptForCruiserNumber();

  /**
   * prompt for the number of destroyers for a fleet.
   * @return string indicating the preferred number
   */
  String promptForDestroyerNumber();

}
