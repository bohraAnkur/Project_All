package edu.neu.ccs.cs5004;


public interface BattleShipInterface {

  /**
   * Implementation of the property createBattleShip
   *
   * @return A new Battleship
   */
  static Ship createBattleShip() {
    return new BattleShip();
  }
}
